package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fxTxtAkronim;

    @FXML
    private DatePicker fxDatDataOd;

    @FXML
    private DatePicker fxDatDataDo;

    @FXML
    private ComboBox<?> fxComTypSzkolenia;

    @FXML
    private ComboBox<?> fxComRodzajKursu;

    @FXML
    private Button fxButDodajSzkolenie;

    @FXML
    private Button fxButEdytujSzkolenie;

    @FXML
    private Button fxButUsunSzkolenie;

    @FXML
    private Button fxButSlownikDniSzkolen;

    @FXML
    private TableView<?> fxTabViewSzkolenia;

    @FXML
    private TableColumn<?, ?> fxColAkronim;

    @FXML
    private TableColumn<?, ?> fxColDataOd;

    @FXML
    private TableColumn<?, ?> fxColDataDo;

    @FXML
    private TableColumn<?, ?> fxColTypSzkolenia;

    @FXML
    private TableColumn<?, ?> fxColNazwaSzkolenia;

    @FXML
    private ComboBox<?> fxComDzienSzkolenia;

    @FXML
    private ComboBox<?> fxComInicjaly;

    @FXML
    private ComboBox<?> fxComAkronimSzkolenia;

    @FXML
    private CheckBox fxCheCzyDzienWolny;

    @FXML
    private Button fxDodajDzienSzkolenia;

    @FXML
    private Button fxEdytujDzienSzkolenia;

    @FXML
    private Button fxUsunDzienSzkolenia;

    @FXML
    private TextField fxImieUzytkownika;

    @FXML
    private ComboBox<?> fxComMentorTrener;

    @FXML
    private TextField fxNazwiskoUzytkownika;

    @FXML
    private TextField fxHaslo;

    @FXML
    private Button fxDodajUzytkownika;

    @FXML
    private Button fxEdytujUzytkownika;

    @FXML
    private Button fxUsunUzytkownika;

    @FXML
    private Button fxPrzypiszKat;

    @FXML
    private TableView<?> fxTableMentorTrener;

    @FXML
    private TableColumn<?, ?> fxImie;

    @FXML
    private TableColumn<?, ?> fxNazwisko;

    @FXML
    private TableColumn<?, ?> fxMentorTrener;

    @FXML
    private TableColumn<?, ?> fxKategoria;

    @FXML
    private TextField fxTxtNazwaKat;

    @FXML
    private HBox fxKategorie;

    @FXML
    private Button fxButDodajKat1;

    @FXML
    private Button fxButEdytujKat1;

    @FXML
    private Button fxButUsunKat1;

    @FXML
    private TableView<?> fxTabViewNazwaKat;

    @FXML
    private TableColumn<?, ?> fxColNazwaKat;

    @FXML
    private TextField fxTxtNazwaKursu;

    @FXML
    private TextField fxLTxticzbaDni;

    @FXML
    private Button fxDodajKurs;

    @FXML
    private Button fxEdytujKurs;

    @FXML
    private Button fxUsunKurs;

    @FXML
    private TableView<?> NazwaKursu;

    @FXML
    private TableColumn<?, ?> fxNazwaKursu;

    @FXML
    private TableColumn<?, ?> fxLiczbaDni;

    @FXML
    void onButDodajKat2(ActionEvent event) {

    }

    @FXML
    void onButDodajSzkolenie(ActionEvent event) {

    }

    @FXML
    void onButEdytujKat2(ActionEvent event) {

    }

    @FXML
    void onButEdytujSzkolenie(ActionEvent event) {

    }

    @FXML
    void onButSlownikDniSzkolen(ActionEvent event) {

    }

    @FXML
    void onButUsunKat2(ActionEvent event) {

    }

    @FXML
    void onButUsunSzkolenie(ActionEvent event) {

    }

    @FXML
    void onCheCzyDzienWolny(ActionEvent event) {

    }

    @FXML
    void onComAkronimSzkolenia(ActionEvent event) {

    }

    @FXML
    void onComDzienSzkolenia(ActionEvent event) {

    }

    @FXML
    void onComInicjaly(ActionEvent event) {

    }

    @FXML
    void onComMentorTrener(ActionEvent event) {

    }

    @FXML
    void onDodajDzienSzkolenia(ActionEvent event) {

    }

    @FXML
    void onDodajKurs(ActionEvent event) {

    }

    @FXML
    void onDodajUzytkownika(ActionEvent event) {

    }

    @FXML
    void onEdytujDzienSzkolenia(ActionEvent event) {

    }

    @FXML
    void onEdytujKurs(ActionEvent event) {

    }

    @FXML
    void onEdytujUzytkownika(ActionEvent event) {

    }

    @FXML
    void onHaslo(ActionEvent event) {

    }

    @FXML
    void onImieUzytkownika(ActionEvent event) {

    }

    @FXML
    void onNazwiskoUzytkownika(ActionEvent event) {

    }

    @FXML
    void onPrzypiszKat(ActionEvent event) {

    }

    @FXML
    void onUsunDzienSzkolenia(ActionEvent event) {

    }

    @FXML
    void onUsunKurs(ActionEvent event) {

    }

    @FXML
    void onUsunUzytkownika(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert fxTxtAkronim != null : "fx:id=\"fxTxtAkronim\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxDatDataOd != null : "fx:id=\"fxDatDataOd\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxDatDataDo != null : "fx:id=\"fxDatDataDo\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComTypSzkolenia != null : "fx:id=\"fxComTypSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComRodzajKursu != null : "fx:id=\"fxComRodzajKursu\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButDodajSzkolenie != null : "fx:id=\"fxButDodajSzkolenie\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButEdytujSzkolenie != null : "fx:id=\"fxButEdytujSzkolenie\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButUsunSzkolenie != null : "fx:id=\"fxButUsunSzkolenie\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButSlownikDniSzkolen != null : "fx:id=\"fxButSlownikDniSzkolen\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxTabViewSzkolenia != null : "fx:id=\"fxTabViewSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColAkronim != null : "fx:id=\"fxColAkronim\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColDataOd != null : "fx:id=\"fxColDataOd\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColDataDo != null : "fx:id=\"fxColDataDo\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColTypSzkolenia != null : "fx:id=\"fxColTypSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColNazwaSzkolenia != null : "fx:id=\"fxColNazwaSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComDzienSzkolenia != null : "fx:id=\"fxComDzienSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComInicjaly != null : "fx:id=\"fxComInicjaly\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComAkronimSzkolenia != null : "fx:id=\"fxComAkronimSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxCheCzyDzienWolny != null : "fx:id=\"fxCheCzyDzienWolny\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxDodajDzienSzkolenia != null : "fx:id=\"fxDodajDzienSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxEdytujDzienSzkolenia != null : "fx:id=\"fxEdytujDzienSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxUsunDzienSzkolenia != null : "fx:id=\"fxUsunDzienSzkolenia\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxImieUzytkownika != null : "fx:id=\"fxImieUzytkownika\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxComMentorTrener != null : "fx:id=\"fxComMentorTrener\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxNazwiskoUzytkownika != null : "fx:id=\"fxNazwiskoUzytkownika\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxHaslo != null : "fx:id=\"fxHaslo\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxDodajUzytkownika != null : "fx:id=\"fxDodajUzytkownika\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxEdytujUzytkownika != null : "fx:id=\"fxEdytujUzytkownika\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxUsunUzytkownika != null : "fx:id=\"fxUsunUzytkownika\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxPrzypiszKat != null : "fx:id=\"fxPrzypiszKat\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxTableMentorTrener != null : "fx:id=\"fxTableMentorTrener\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxImie != null : "fx:id=\"fxImie\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxNazwisko != null : "fx:id=\"fxNazwisko\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxMentorTrener != null : "fx:id=\"fxMentorTrener\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxKategoria != null : "fx:id=\"fxKategoria\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxTxtNazwaKat != null : "fx:id=\"fxTxtNazwaKat\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxKategorie != null : "fx:id=\"fxKategorie\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButDodajKat1 != null : "fx:id=\"fxButDodajKat1\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButEdytujKat1 != null : "fx:id=\"fxButEdytujKat1\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxButUsunKat1 != null : "fx:id=\"fxButUsunKat1\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxTabViewNazwaKat != null : "fx:id=\"fxTabViewNazwaKat\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxColNazwaKat != null : "fx:id=\"fxColNazwaKat\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxTxtNazwaKursu != null : "fx:id=\"fxTxtNazwaKursu\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxLTxticzbaDni != null : "fx:id=\"fxLTxticzbaDni\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxDodajKurs != null : "fx:id=\"fxDodajKurs\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxEdytujKurs != null : "fx:id=\"fxEdytujKurs\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxUsunKurs != null : "fx:id=\"fxUsunKurs\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert NazwaKursu != null : "fx:id=\"NazwaKursu\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxNazwaKursu != null : "fx:id=\"fxNazwaKursu\" was not injected: check your FXML file 'menu_glowne.fxml'.";
        assert fxLiczbaDni != null : "fx:id=\"fxLiczbaDni\" was not injected: check your FXML file 'menu_glowne.fxml'.";

    }
}
