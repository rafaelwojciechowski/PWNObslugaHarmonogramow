package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javaFX_obslugaHarmonogramow.model.KategoriaTematyczna;
import javaFX_obslugaHarmonogramow.model.Kurs;
import javaFX_obslugaHarmonogramow.model.Szkolenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Szkolenie, String> fxColAkronim;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataOd;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataDo;

    @FXML
    private TableColumn<Szkolenie, String> fxColTypSzkolenia;

    @FXML
    private TableColumn<Szkolenie, Integer> fxColNazwaSzkolenia;

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
    private TableView<KategoriaTematyczna> fxTabViewNazwaKat;

    @FXML
    private TableColumn<KategoriaTematyczna, String> fxColNazwaKat;

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
    private TableView<Kurs> NazwaKursu;

    @FXML
    private TableColumn<Kurs, String> fxNazwaKursu;

    @FXML
    private TableColumn<Kurs, Integer> fxLiczbaDni;

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
    void wczytajKat() {
        KategorieController kc = new KategorieController();
        wyswietlWkolumnach(kc.pokazKategorie());

    }

    private ObservableList<KategoriaTematyczna> daneKategoria;

    private void wyswietlWkolumnach(ArrayList <KategoriaTematyczna> kattem){
        fxColNazwaKat.setCellValueFactory(new PropertyValueFactory<KategoriaTematyczna, String>("nazwa"));
        daneKategoria = FXCollections.observableArrayList(kattem);
        fxTabViewNazwaKat.setItems(daneKategoria);
    }


    @FXML
    void onUsunUzytkownika(ActionEvent event) {

    }

    @FXML
    void wczytajDniSzkolen(ActionEvent event) {

    }

    @FXML
    void wczytajKat(ActionEvent event) {

    }

    @FXML
    void wczytajKursy(ActionEvent event) {
        KursController kurc = new KursController();
    }

    @FXML
    void wczytajSzkolenia(ActionEvent event) {

    }

    @FXML
    void wczytajTrenerzy(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
