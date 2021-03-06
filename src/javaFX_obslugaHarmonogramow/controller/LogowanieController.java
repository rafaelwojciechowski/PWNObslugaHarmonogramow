package javaFX_obslugaHarmonogramow.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javaFX_obslugaHarmonogramow.controller.MenuGlowneController.pokazPrzyciski;
import static javaFX_obslugaHarmonogramow.controller.MenuGlowneController.ukryjPrzyciski;

public class LogowanieController {

    private Stage stageLogowanie;

    @FXML
    private TextField fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;

    @FXML
    private Button fxButZaloguj;

    @FXML
    private Pane fxPaneLog;

    @FXML
    private Label fxTxtLoginError;

    @FXML
    void onEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER ) {
            try {
                zaloguj();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onButZaloguj(ActionEvent event) {
        try {
            zaloguj();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void zaloguj() throws SQLException {
        DaoToMySQL dao = new DaoToMySQL();
        PreparedStatement st = dao.getCon().prepareStatement("SELECT mentor FROM Trenerzy WHERE inicjaly = ? AND haslo = ?");
        st.setString(1,fxTxtLogowanie.getText());
        st.setString(2, fxTxtHaslo.getText());
        st.execute();
        ResultSet rs = st.getResultSet();
        if (rs.next()) {
            Stage s = (Stage)fxButZaloguj.getScene().getWindow();
            s.close();
            // Jeżeli Trenerzy.mentor == 1 oznacza trenera (bez uprawnień), to dodaj ukryj przyciski
            if (rs.getInt(1) == 1) {
                pokazPrzyciski();
            } else {
                ukryjPrzyciski();
            }
            StageController sc = new StageController("menuGlowne", "Menu główne");
        } else {
            fxTxtLoginError.setVisible(true);
            SzkoleniaController alert = new SzkoleniaController();
            alert.pokazAlert("ERROR","błędny login lub hasło, spróbuj jeszcze raz");
            //System.out.println("Błędna para login/hasło");
        }
    }

    }

