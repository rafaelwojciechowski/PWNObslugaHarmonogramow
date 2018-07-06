package javaFX_obslugaHarmonogramow.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuGlowneController {

    @FXML
    private Button fxMGSzkolenia;

    @FXML
    private Button fxMGTrenerzy;

    @FXML
    private Button fxMGKategorie;

    @FXML
    private Button fxMGKursy;

    @FXML
    private Button fxMGWyloguj;

    @FXML
    void onMGKategorie(ActionEvent event) {
        otworzNoweOkno("Kategorie", "Kategorie");
    }

    @FXML
    void onMGKursy(ActionEvent event) {
        otworzNoweOkno("Kursy", "Kursy");
    }

    @FXML
    void onMGSzkolenia(ActionEvent event) {

        otworzNoweOkno("szkolenia", "Szkolenia");
    }

    @FXML
    void onMGTerenerzy(ActionEvent event) {
        otworzNoweOkno("trenerzy", "Trenerzy");
    }

    @FXML
    void onMGWyloguj(ActionEvent event) {
        for (Stage s : StageController.getListaStage().values()) {
            s.close();
        }
        otworzNoweOkno("logowanie", "Logowanie");
    }

    @FXML
    void initialize() {
        assert fxMGSzkolenia != null : "fx:id=\"fxMGSzkolenia\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGTrenerzy != null : "fx:id=\"fxMGTrenerzy\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGKategorie != null : "fx:id=\"fxMGKategorie\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGKursy != null : "fx:id=\"fxMGKursy\" was not injected: check your FXML file 'menuGlowne.fxml'.";

        fxMGKategorie.setVisible(widoczny);
        fxMGTrenerzy.setVisible(widoczny);
        fxMGKursy.setVisible(widoczny);

//        fxMGKategorie.setDisable(false);
//        fxMGTrenerzy.setDisable(false);
//        fxMGKursy.setDisable(false);

    }

    private static boolean widoczny;


    public static void ukryjPrzyciski() {
       widoczny = false;
    }

    public static void pokazPrzyciski() {
        widoczny = true;
    }

    public void otworzNoweOkno(String fxmlNazwa, String tytul) {
        StageController sc = new StageController(fxmlNazwa, tytul);
    }

    public void zamknijOkno() {
        Scene s = fxMGWyloguj.getScene();
        if (s != null ) {
            Stage t = (Stage) s.getWindow();
            t.close();
        }
    }

}
