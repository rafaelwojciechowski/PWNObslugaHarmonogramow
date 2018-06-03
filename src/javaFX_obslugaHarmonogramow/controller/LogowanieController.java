package javaFX_obslugaHarmonogramow.controller;

import java.io.File;
import java.net.URL;
import java.sql.*;

import javaFX_obslugaHarmonogramow.model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class  LogowanieController {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs =null;


    @FXML
    private TextField fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;



    @FXML

    public void onButZaloguj(ActionEvent event) throws SQLException {
            conn=LoginModel.ConnectDB();

        String sql = "select count(*) from Trenerzy where inicjaly = ? and haslo = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, fxTxtLogowanie.getText());
            ps.setString(2, fxTxtHaslo.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
            StageController sc = new StageController("menuGlowne", "Menu główne");
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("Error");
                error.setContentText("Błędny login lub hasło");
                error.setTitle("Błąd logowania");
                error.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}







