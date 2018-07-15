package javaFX_obslugaHarmonogramow.controller;

import javafx.scene.control.Alert;

public class Komunikat {

    public Komunikat(String tytul, String tekst) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tytul);
        alert.setContentText(tekst);
        alert.showAndWait();
    }

}
