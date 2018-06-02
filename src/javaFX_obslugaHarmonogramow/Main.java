package javaFX_obslugaHarmonogramow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Proponuję skorzystać z poniższego zamiast całej zawartości tej metody:
        // StageController sc = new StageController("logowanie", "Logowanie");

        Parent root = FXMLLoader.load(getClass().getResource("view/logowanie.fxml"));
        primaryStage.setTitle("Michał LOL");
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
