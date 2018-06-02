package javaFX_obslugaHarmonogramow.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageController {

    public StageController(String fxmlNazwa, String tytul) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/" + fxmlNazwa + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle(tytul);
        stage.setScene(new Scene(root, 770, 550));
        stage.show();
    }

}