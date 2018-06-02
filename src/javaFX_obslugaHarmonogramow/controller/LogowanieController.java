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
            // Poprawka - trzeba w tym miejscu sprawdzić czy dany trener jest trenerem czy też powinien mieć wyższe uprawnienia (kolumna Trenerzy.mentor)
            // Jeżeli jest tylko trenerem to trzeba odpalić poniższą metodę statyczną:
            // MenuGlowneController.ukryjPrzyciski();
            // Jeżeli jest mentorem lub wklepywaczem to trzeba użyć poniższej metody statycznej:
            // MenuGlowneController.pokazPrzyciski();
            PreparedStatement st = dao.getCon().prepareStatement("select inicjaly,haslo from trenerzy where inicjaly = ?");
            st.setString(1,fxTxtLogowanie.getText());
            st.execute();
            ResultSet rs = st.getResultSet();
            // wyrzucany jest błąd, bo najpierw trzeba pobrać rekord ( rs.next() )
            // jeżeli wstawisz tą komendę w if'a to dodatkowo będziesz sprawdzał czy zaczytał się rekord
            if(rs.getString("haslo").equals(fxTxtHaslo.getText())) System.out.println("glowne okno programu");
            else System.out.println("niepoprawne dane");



            // Po zalgowaniu proponuję zamknąc to okno i otworzyć Menu główne przez
            // StageController sc = new StageController("menuGlowne", "Menu główne");
    }
    }

