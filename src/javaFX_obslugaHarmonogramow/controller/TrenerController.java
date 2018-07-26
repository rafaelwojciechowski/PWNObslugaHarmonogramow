package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javaFX_obslugaHarmonogramow.model.Trener;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrenerController {

    @FXML
    private TextField fxTrenerImie;

    @FXML
    private TextField fxTrenerNazwisko;

    @FXML
    private TextField fxTrenerInicjaly;

    @FXML
    private PasswordField fxTrenerPass;

    @FXML
    private RadioButton fxRBTrener;

    @FXML
    private ToggleGroup a;

    @FXML
    private RadioButton fxRBMentor;

    @FXML
    private Button fxButtonDodaj;

    @FXML
    private Button fxButtonEdytuj;

    @FXML
    private Button fxButtonUsun;

    @FXML
    private Button fxButPrzypiszKategorie;

    @FXML
    private TableView<Trener> fxTabviewTrener;

    @FXML
    private TableColumn<Trener, String> fxColImie;

    @FXML
    private TableColumn<Trener, String> fxColNazwisko;

    @FXML
    private TableColumn<Trener, String> fxColInicjaly;

    @FXML
    private TableColumn<Trener, Integer> fxColTrenerMentor;

    private DaoToMySQL con = new DaoToMySQL();

    private ObservableList<Trener> listaTrenerow;

    @FXML
    void onActionDodaj(ActionEvent event) {

    }

    @FXML
    void onActionEdytuj(ActionEvent event) {

    }

    @FXML
    void onActionUsun(ActionEvent event) {

    }


    @FXML
    void onButDodajTrenera(MouseEvent event) {
        Connection conn = con.getCon();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO fkedupl_pwngr.Trenerzy " +
                    "(imie, nazwisko, inicjaly, haslo, mentor) VALUES (?,?,?,?,?)");
            ps.setString(1,fxTrenerImie.getText());
            ps.setString(2,fxTrenerNazwisko.getText());
            ps.setString(3,fxTrenerInicjaly.getText());
            ps.setString(4,fxTrenerPass.getText());
            if(fxRBMentor.isSelected()){
                ps.setInt(5, 1);
            } else{
                ps.setInt(5, 2);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void onButEdytujTrenera(MouseEvent event) {
        Trener trener = fxTabviewTrener.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE fkedupl_pwngr.Trenerzy SET imie=?, nazwisko=?, inicjaly=?, haslo=?, mentor=? WHERE id=?");
            ps.setString(1,fxTrenerImie.getText());
            ps.setString(2,fxTrenerNazwisko.getText());
            ps.setString(3,fxTrenerInicjaly.getText());
            ps.setString(4,fxTrenerPass.getText());
            if(fxRBMentor.isSelected()){
                ps.setInt(5, 1);
            } else{
                ps.setInt(5, 2);
            }
            ps.setInt(6,trener.getId());
            ps.executeUpdate();
            pokazListe();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszytskie pola przed edycją szkolenia!");
            alert.showAndWait();
        } catch (NullPointerException nulle){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszystkie pola przed edycją szkolenia!");
            alert.showAndWait();
        }
    }

    @FXML
    void onButUsunTrenera(MouseEvent event) {
        Connection conn = con.getCon();
        Trener trener = fxTabviewTrener.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM fkedupl_pwngr.Trenerzy WHERE id=?");
            ps.setInt(1, trener.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void onButPrzypiszKategorie(MouseEvent event) {
        Trener trener = fxTabviewTrener.getSelectionModel().getSelectedItem();
        if (trener == null) {
            new Komunikat("Błąd", "Nie wybrano żadnego kursu. Wybierz kurs, przed przypisaniem kategorii");
        } else {
            PrzypiszKategorieController.setTrener(trener);
            StageController sc = new StageController("przypisz_kategorie", "Przypisz kategorię do trenera");
        }
    }

    @FXML
    void initialize() {
        pokazListe();
    }

    private void pokazListe() {
//        con = new DaoToMySQL();
        try {
            listaTrenerow = FXCollections.observableArrayList(pobierzListeTrenerow(con.getCon()));
            ustawKolumny(listaTrenerow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ustawKolumny(ObservableList<Trener> listaTrenerow) {
        fxTabviewTrener.getItems().clear();
        fxColImie.setCellValueFactory(new PropertyValueFactory<Trener,String>("Imie"));
        fxColNazwisko.setCellValueFactory(new PropertyValueFactory<Trener,String>("Nazwisko"));
        fxColInicjaly.setCellValueFactory(new PropertyValueFactory<Trener,String>("Inicjaly"));
        fxColTrenerMentor.setPrefWidth(150);
        fxColTrenerMentor.setCellValueFactory(new PropertyValueFactory<Trener,Integer>("Mentor"));
        fxTabviewTrener.getItems().addAll(listaTrenerow);
    }

    private List<Trener> pobierzListeTrenerow(Connection con) throws SQLException {
        List<Trener> lista = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Trenerzy");
        int x = 0;
        while (rs.next()){
            x++;
            lista.add(new Trener(rs.getInt("id"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("inicjaly"),
            rs.getString("haslo"),rs.getInt("mentor")));
        }
        return lista;
    }



}
