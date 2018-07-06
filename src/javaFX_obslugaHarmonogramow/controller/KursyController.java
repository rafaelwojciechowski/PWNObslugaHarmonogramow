package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javaFX_obslugaHarmonogramow.model.Kurs;

public class KursyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fxTxtNazwa;

    @FXML
    private Slider fxLiczbaDniSlider;

    @FXML
    private Button fxButDodajKurs;

    @FXML
    private Button fxButEdytujKurs;

    @FXML
    private Button fxButUsunKurs;

    @FXML
    private Button fxButPrzypiszKategorie;

    @FXML
    private Label fxLiczbaDniEtykieta;

    @FXML
    private TableView<Kurs> fxTabviewKursy;

    @FXML
    private TableColumn<Kurs, String> fxColNazwa;

    @FXML
    private TableColumn<Kurs, Integer> fxColLiczbaDni;

    private DaoToMySQL con = new DaoToMySQL();

    @FXML
    void onLiczbaDniZmianaWartosci(DragEvent event) {
        System.out.println(fxLiczbaDniSlider.getValue());
//        fxLiczbaDniEtykieta.setText("Liczba dni: " + fxLiczbaDniSlider.getValue());
    }


    @FXML
    void onButDodajKurs(MouseEvent event) {
        Connection conn = con.getCon();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO fkedupl_pwngr.Kursy " +
                    "(nazwa, ile_dni) VALUES (?,?)");
            ps.setString(1,fxTxtNazwa.getText());
            ps.setInt(2,(int)fxLiczbaDniSlider.getValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void onButEdytujKurs(MouseEvent event) {
        Kurs kurs = fxTabviewKursy.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE fkedupl_pwngr.Kursy SET nazwa=?, ile_dni=? WHERE id=?");
            ps.setString(1,fxTxtNazwa.getText());
            ps.setInt(2,(int)fxLiczbaDniSlider.getValue());
            ps.setInt(3,kurs.getId());
            ps.executeUpdate();
            pokazListe();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszytskie pola przed edycją kursu!");
            alert.showAndWait();
        } catch (NullPointerException nulle){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszystkie pola przed edycją kursu!");
            alert.showAndWait();
        }
    }

    @FXML
    void onButUsunKurs(MouseEvent event) {
        Connection conn = con.getCon();
        Kurs kurs = fxTabviewKursy.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM fkedupl_pwngr.Kursy WHERE id=?");
            ps.setInt(1, kurs.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void onButPrzypiszKategorie(MouseEvent event) {
        Kurs kurs = fxTabviewKursy.getSelectionModel().getSelectedItem();
        if (kurs == null) {
            pokazAlert("Błąd", "Nie wybrano żadnego kursu. Wybierz kurs, przed przypisaniem kategorii");
        } else {
            PrzypiszKategorieController.setKurs(kurs);
            StageController sc = new StageController("przypisz_kategorie", "Przypisz kategorię do kursu");
        }
    }

    @FXML
    void initialize() {

        fxLiczbaDniSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0,
                                Number arg1, Number arg2) {
                fxLiczbaDniEtykieta.setText(String.format("%3.0f", arg2)); //new value
            }

        });

        pokazListe();
    }

    private void pokazListe() {
//        con = new DaoToMySQL();
        try {
            ObservableList<Kurs> listaKursow = FXCollections.observableArrayList(pobierzListeKursow(con.getCon()));
            ustawKolumny(listaKursow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ustawKolumny(ObservableList<Kurs> listaKursow) {
        fxTabviewKursy.getItems().clear();
        fxColNazwa.setCellValueFactory(new PropertyValueFactory<Kurs,String>("nazwa"));
        fxColLiczbaDni.setCellValueFactory(new PropertyValueFactory<Kurs,Integer>("ile_dni"));
        fxTabviewKursy.getItems().addAll(listaKursow);
    }

    private List<Kurs> pobierzListeKursow(Connection con) throws SQLException {
        List<Kurs> lista = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Kursy ORDER BY ID DESC");
        int x = 0;
        while (rs.next()){
            x++;
            lista.add(new Kurs(rs.getInt("id"),rs.getString("Nazwa"),rs.getInt("ile_dni")));
        }
        return lista;
    }

    private void pokazAlert(String tytul, String tekst) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tytul);
        alert.setContentText(tekst);
        alert.showAndWait();
    }

}
