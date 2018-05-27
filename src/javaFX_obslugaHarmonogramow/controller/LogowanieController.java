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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class LogowanieController {


    @FXML
    private TextArea fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;

    @FXML
    private Button fxButZaloguj;

    @FXML
    void onButZaloguj(ActionEvent event) throws SQLException {
        DaoToMySQL dao = new DaoToMySQL();
            PreparedStatement st = dao.getCon().prepareStatement("select inicjaly,haslo from trenerzy where inicjaly = ?");
            st.setString(1,fxTxtLogowanie.getText());
            st.execute();
            ResultSet rs = st.getResultSet();
            if(rs.getString("haslo").equals(fxTxtHaslo.getText())) System.out.println("glowne okno programu");
            else System.out.println("niepoprawne dane");
    }
    }

