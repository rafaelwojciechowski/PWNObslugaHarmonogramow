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

import java.sql.*;
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

    private int id;

    private String kolumna;

    private String tabela;

    private List<KategoriaTematyczna> kategorie = new ArrayList<>();

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
        ObservableList<KategoriaTematyczna> kategorieTematyczne  = fxTabviewKategorie.getSelectionModel().getSelectedItems();
        if (kategorieTematyczne.isEmpty()) {
            new Komunikat("Błąd", "Zaznacz chociaż jedną kategorię przed przypisaniem kategorii");
        } else {
            PreparedStatement ps;
            try {
                ps = con.getCon().prepareStatement("DELETE FROM " + tabela + " WHERE " + kolumna + " = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                for (KategoriaTematyczna kt : kategorieTematyczne) {
                    ps = con.getCon().prepareStatement("INSERT INTO " + tabela + "(" + kolumna + ", kat_tematyczne_id) VALUES(?, ?)");
                    ps.setInt(1, id);
                    ps.setInt(2, kt.getId());
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            zamknijOkno();
        }
    }

    @FXML
    void initialize() {
        dostosujSQL();
        ustawNaglowek();
        pokazListe();
        fxTabviewKategorie.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        zaznaczWybrane();

    }

    private void dostosujSQL(){
        if (kurs != null) {
            id = kurs.getId();
            kolumna = "kursy_id";
            tabela = "Kat_tematyczne_kursy";
        } else if (trener!= null) {
            id = trener.getId();
            kolumna = "trenerzy_id";
            tabela = "Kat_tematyczne_trenerzy";
        }
    }


    private void zaznaczWybrane(){

        List<KategoriaTematyczna> kategorieTematyczne = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement("SELECT kat_tematyczne_id FROM " + tabela + " WHERE " + kolumna + " = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int katTematycznaId;
            while (rs.next()) {
                katTematycznaId = rs.getInt("kat_tematyczne_id");
                KategoriaTematyczna kt = znajdzKategorie(katTematycznaId);
                fxTabviewKategorie.getSelectionModel().select(kt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
        pobierzListeKategorii();
        ustawKolumny();
    }

    private void ustawKolumny() {
        ObservableList<KategoriaTematyczna> listaKategorii = FXCollections.observableArrayList(kategorie);
        fxTabviewKategorie.getItems().clear();
        fxColNazwa.setCellValueFactory(new PropertyValueFactory<KategoriaTematyczna,String>("nazwa"));
        fxTabviewKategorie.getItems().addAll(listaKategorii);
    }

    private void pobierzListeKategorii() {
        Statement st = null;
        try {
            st = con.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from Kat_tematyczne ORDER BY ID DESC");
            while (rs.next()){
                kategorie.add(new KategoriaTematyczna(rs.getInt("id"),rs.getString("Nazwa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private KategoriaTematyczna znajdzKategorie(int id) {
        for (KategoriaTematyczna kt : kategorie) {
            if (kt.getId() == id) {
                return kt;
            }
        }
        return new KategoriaTematyczna();
    }
}
