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
import javaFX_obslugaHarmonogramow.model.KategoriaTematyczna;
import javaFX_obslugaHarmonogramow.model.Kurs;

public class KategorieController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fxTxtNazwa;

    @FXML
    private Button fxButDodajKurs;

    @FXML
    private Button fxButEdytujKurs;

    @FXML
    private Button fxButUsunKurs;

    @FXML
    private TableView<KategoriaTematyczna> fxTabviewKat;

    @FXML
    private TableColumn<KategoriaTematyczna, String> fxColNazwa;

    private DaoToMySQL con = new DaoToMySQL();

    @FXML
    void onButDodajKurs(MouseEvent event) {
        Connection conn = con.getCon();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO fkedupl_pwngr.Kat_tematyczne " +
                    "(nazwa) VALUES (?)");
            ps.setString(1,fxTxtNazwa.getText());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void onButEdytujKurs(MouseEvent event) {
        KategoriaTematyczna kat = fxTabviewKat.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE fkedupl_pwngr.Kat_tematyczne SET nazwa=? WHERE id=?");
            ps.setString(1,fxTxtNazwa.getText());
            ps.setInt(2,kat.getId());
            ps.executeUpdate();
            pokazListe();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszytskie pola przed edycją kategorii!");
            alert.showAndWait();
        } catch (NullPointerException nulle){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszystkie pola przed edycją kategorii!");
            alert.showAndWait();
        }
    }

    @FXML
    void onButUsunKurs(MouseEvent event) {
        Connection conn = con.getCon();
        KategoriaTematyczna kat = fxTabviewKat.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM fkedupl_pwngr.Kat_tematyczne WHERE id=?");
            ps.setInt(1, kat.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pokazListe();
    }

    @FXML
    void initialize() {

        pokazListe();
    }

    private void pokazListe() {
//        con = new DaoToMySQL();
        try {
            ObservableList<KategoriaTematyczna> listaKursow = FXCollections.observableArrayList(pobierzListeKursow(con.getCon()));
            ustawKolumny(listaKursow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ustawKolumny(ObservableList<KategoriaTematyczna> listaKursow) {
        fxTabviewKat.getItems().clear();
        fxColNazwa.setCellValueFactory(new PropertyValueFactory<KategoriaTematyczna,String>("nazwa"));
        fxTabviewKat.getItems().addAll(listaKursow);
    }

    private List<KategoriaTematyczna> pobierzListeKursow(Connection con) throws SQLException {
        List<KategoriaTematyczna> lista = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Kat_tematyczne ORDER BY ID DESC");
        int x = 0;
        while (rs.next()){
            x++;
            lista.add(new KategoriaTematyczna(rs.getInt("id"),rs.getString("Nazwa")));
        }
        return lista;
    }


}

