package javaFX_obslugaHarmonogramow;

import javaFX_obslugaHarmonogramow.controller.StageController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        StageController sc = new StageController("logowanie", "Logowanie");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
