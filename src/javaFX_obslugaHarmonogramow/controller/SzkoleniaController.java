package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javafx.event.Event;
import javaFX_obslugaHarmonogramow.model.Szkolenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import static java.time.temporal.ChronoUnit.DAYS;

public class SzkoleniaController {

    private DaoToMySQL connection = new DaoToMySQL();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Szkolenie> fxTabviewSzkolenia;

    @FXML
    private TableColumn<Szkolenie, String> fxColNazwaSzkolenia;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataOd;

    @FXML
    private Button fxButDodajSzkolenie;

    @FXML
    private Button fxButUsunSzkolenie;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataDo;

    @FXML
    private DatePicker fxDatDataDo;

    @FXML
    private Button fxButEdytujSzkolenie;

    @FXML
    private DatePicker fxDatDataOd;

    @FXML
    private TableColumn<Szkolenie, String> fxColTypSzkolenia;

    @FXML
    private TableColumn<Szkolenie, String> fxColAkronim;

    @FXML
    private TextField fxTxtAkronim;

    @FXML
    private Label fxLabelDataOdError;

    @FXML
    private Label fxLabelDataDoError;

    @FXML
    private ComboBox<String> fxComNazwaKursu;

    @FXML
    private ComboBox<String> fxComTypSzkolenia;

    @FXML
    void fxNazwaSzkolenieOnHiding(Event event) {
        buttonSetDisable();
    }

    @FXML
    void fxDatePicekerOnHidingDataDo(Event event) {
        buttonSetDisable();
    }

    @FXML
    void fxDatePicekerOnHidingDataOd(Event event) {
        buttonSetDisable();
    }

    @FXML
    private Button fxButSlownikSzkolen;

    @FXML
    void onButDodajSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO fkedupl_pwngr.Szkolenia (akronim, data_od, data_do, typ_szkolen, Kursy_id) select ?, ?, ?, ?, id from Kursy where nazwa = ?;");
            ps.setString(1,fxTxtAkronim.getText());
            ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
            ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()).replace("Dzienne", "d").replace("Weekendowe", "w"));
            ps.setString(5, String.valueOf(fxComNazwaKursu.getValue()));
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            pokazAlert("ERROR", "Podany przez Ciebie akronim już jest w użyciu. Podaj inny akronim przed kontynuacją");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populaTetableView();
    }

    @FXML
    void onButEdytujSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        Szkolenie szkolenie = fxTabviewSzkolenia.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE fkedupl_pwngr.Szkolenia SET akronim=?, data_od=?, data_do=?, typ_szkolen=?, Kursy_id=(select id from Kursy where nazwa = ?) WHERE id=?;");
            ps.setString(1,fxTxtAkronim.getText());
            try {
                ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
                ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            } catch (NullPointerException nulle){
                pokazAlert("ERROR", "Wypełnij wszystkie pola przed edycją szkolenia!");
            }
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()).replace("Dzienne", "d").replace("Weekendowe", "w"));
            ps.setString(5, String.valueOf(fxComNazwaKursu.getValue()));
            ps.setInt(6, szkolenie.getId());
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            pokazAlert("ERROR", "Podany przez Ciebie akronim już jest w użyciu. Podaj inny akronim przed kontynuacją");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populaTetableView();
    }

    @FXML
    void onButUsunSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        Szkolenie szkolenie = fxTabviewSzkolenia.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM fkedupl_pwngr.Szkolenia WHERE id=?");
            ps.setInt(1,szkolenie.getId());
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM fkedupl_pwngr.Dni_szkolenia_trenerzy WHERE szkolenia_id=?");
            ps.setInt(1,szkolenie.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populaTetableView();
    }

    @FXML
    void initialize() {
        populaTetableView();
        fxComTypSzkolenia.getItems().addAll("Dzienne","Weekendowe");

        ObservableList<String> nazwa;
        ArrayList<String> nazwaSzkolen = new ArrayList<>();
        Connection con = connection.getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nazwa FROM Kursy GROUP BY nazwa;");
            while (rs.next()){
                nazwaSzkolen.add(rs.getString("nazwa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nazwa = FXCollections.observableArrayList(nazwaSzkolen);
        fxComNazwaKursu.getItems().addAll(nazwa);
        buttonSetDisable();
    }



    private void populaTetableView() {
        ObservableList<Szkolenie> szkolenieView;
        Connection con = connection.getCon();
        ArrayList<Szkolenie> szkolenieLista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT sz.ID, sz.akronim, sz.data_od, sz.data_do, sz.typ_szkolen, k.nazwa FROM Szkolenia as sz LEFT JOIN Kursy as k on sz.Kursy_id = k.id ORDER BY sz.ID DESC;");
            while (rs.next()){
                Szkolenie szkolenie = new Szkolenie();
                int id = rs.getInt("id");
                String akronim = rs.getString("akronim");
                Date data_od = rs.getDate("data_od");
                Date data_do = rs.getDate("data_do");
                String typ_szkolen = rs.getString("typ_szkolen").replace("d", "Dzienne").replace("w", "Weekendowe");
                String nazwa = rs.getString("nazwa");
                szkolenie.setId(id);
                szkolenie.setAkronim(akronim);
                szkolenie.setData_od(data_od);
                szkolenie.setData_do(data_do);
                szkolenie.setTyp_szkolen(typ_szkolen);
                szkolenie.setNazwa(nazwa);
                szkolenieLista.add(szkolenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxTabviewSzkolenia.getItems().clear();
        szkolenieView = FXCollections.observableArrayList(szkolenieLista);
        fxColAkronim.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("akronim"));
        fxColDataOd.setCellValueFactory(new PropertyValueFactory<Szkolenie, Date>("data_od"));
        fxColDataDo.setCellValueFactory(new PropertyValueFactory<Szkolenie, Date>("data_do"));
        fxColTypSzkolenia.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("typ_szkolen"));
        fxColNazwaSzkolenia.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("nazwa"));
        fxTabviewSzkolenia.getItems().addAll(szkolenieView);
    }

    public void pokazAlert(String tytul, String tekst) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tytul);
        alert.setContentText(tekst);
        alert.showAndWait();
    }

    private void buttonSetDisable() {
        Connection con = connection.getCon();
        if (fxDatDataOd.getValue() != null && fxDatDataDo.getValue() != null){
            int kursLiczbaDni = 999999999;
            long diff = DAYS.between(fxDatDataOd.getValue(),fxDatDataDo.getValue());
//            System.out.println(diff);
//            System.out.println(kursLiczbaDni);
            try {
                PreparedStatement ps = con.prepareStatement("SELECT ile_dni FROM fkedupl_pwngr.Kursy WHERE nazwa=?");
                if (fxComNazwaKursu.getValue() != null){
                    ps.setString(1, fxComNazwaKursu.getValue());
                }else{
                    ps.setString(1, "");
                }
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    kursLiczbaDni = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            System.out.println(kursLiczbaDni);
            if(fxDatDataOd.getValue().isBefore(fxDatDataDo.getValue()) && kursLiczbaDni<=diff){
                fxButEdytujSzkolenie.setDisable(false);
                fxButDodajSzkolenie.setDisable(false);
                fxLabelDataOdError.setVisible(false);
                fxLabelDataDoError.setVisible(false);
            }
            else {
                fxButEdytujSzkolenie.setDisable(true);
                fxButDodajSzkolenie.setDisable(true);
                if(!fxDatDataOd.getValue().isBefore(fxDatDataDo.getValue())) {
                    fxLabelDataOdError.setVisible(true);
                }else{
                    fxLabelDataDoError.setVisible(true);
                }
            }
        }else{
            fxButEdytujSzkolenie.setDisable(true);
            fxButDodajSzkolenie.setDisable(true);
        }
    }

}


