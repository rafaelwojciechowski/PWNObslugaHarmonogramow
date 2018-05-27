package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class LogowanieController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;

    @FXML
    private Button fxButZaloguj;

    @FXML
    void onButZaloguj(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert fxTxtLogowanie != null : "fx:id=\"fxTxtLogowanie\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert fxTxtHaslo != null : "fx:id=\"fxTxtHaslo\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert fxButZaloguj != null : "fx:id=\"fxButZaloguj\" was not injected: check your FXML file 'logowanie.fxml'.";

    }
}
