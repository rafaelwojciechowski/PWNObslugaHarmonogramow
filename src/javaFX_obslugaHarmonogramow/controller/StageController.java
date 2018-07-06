package javaFX_obslugaHarmonogramow.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StageController extends Parent {
    private static Map<String,Stage> listaStage = new HashMap<>();

    public StageController(String fxmlNazwa, String tytul) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/" + fxmlNazwa + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        listaStage.put(fxmlNazwa,stage);
        stage.setTitle(tytul);
        stage.getIcons().add(new Image(StageController.class.getResourceAsStream( "../view/calendar_icon.png" )));
        stage.setScene(new Scene(root, 770, 550));
        stage.show();
    }

    public static Map<String, Stage> getListaStage() {
        return listaStage;
    }

//    @Override
//    public Node getStyleableNode() {
//        return null;
//    }
}