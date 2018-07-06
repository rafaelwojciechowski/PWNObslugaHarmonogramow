package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javaFX_obslugaHarmonogramow.model.KategoriaTematyczna;
import javaFX_obslugaHarmonogramow.model.Kurs;
import javaFX_obslugaHarmonogramow.model.Trener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrzypiszKategorieController {

    @FXML
    private Label fxNazwaEtykieta;

    @FXML
    private TextField fxTxtNazwa;

    @FXML
    private Button fxButPrzypisz;

    @FXML
    private Button fxButAnuluj;

    @FXML
    private TableView<KategoriaTematyczna> fxTabviewKategorie;

    @FXML
    private TableColumn<KategoriaTematyczna, String> fxColNazwa;

    private DaoToMySQL con = new DaoToMySQL();

    private static Kurs kurs;

    private static Trener trener;

    public static void setKurs(Kurs k) {
        trener = null;
        kurs = k;
    }

    public static void setTrener(Trener t) {
        trener = t;
        kurs = null;
    }

    @FXML
    void onButAnuluj(MouseEvent event) {
        zamknijOkno();
    }

    @FXML
    void onButPrzypisz(MouseEvent event) {

    }

    @FXML
    void initialize() {
        ustawNaglowek();
        pokazListe();
        fxTabviewKategorie.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }



    private void zamknijOkno() {
        Scene s = fxButAnuluj.getScene();
        if (s != null ) {
            Stage t = (Stage) s.getWindow();
            t.close();
        }
    }

    private void ustawNaglowek() {
        if (kurs != null) {
            fxNazwaEtykieta.setText("Kurs");
            fxTxtNazwa.setText(kurs.getNazwa());
        } else if (trener!= null) {
            fxNazwaEtykieta.setText("Trener");
            fxTxtNazwa.setText(trener.getInicjaly());
        }
    }

    private void pokazListe() {
        try {
            ObservableList<KategoriaTematyczna> listaKursow = FXCollections.observableArrayList(pobierzListeKursow(con.getCon()));
            ustawKolumny(listaKursow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ustawKolumny(ObservableList<KategoriaTematyczna> listaKursow) {
        fxTabviewKategorie.getItems().clear();
        fxColNazwa.setCellValueFactory(new PropertyValueFactory<KategoriaTematyczna,String>("nazwa"));
        fxTabviewKategorie.getItems().addAll(listaKursow);
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
