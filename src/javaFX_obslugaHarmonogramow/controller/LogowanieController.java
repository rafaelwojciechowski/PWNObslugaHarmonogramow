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
            // spróbuj przepisać tego selecta tak aby od razu sprawdzał czy istnieje rekord o podanych inicjałach i haśle
            // select w tej formie nie zwróci żadnych rekordów, jeżeli nie istnieje rekord o podanych inicjałach
            // spróbuj zmodyfikować tego selecta, aby zawsze zwracał rekord niezależnie od tego czy inicjały istnieją - podpowiedź: skorzystaj z count(1)
            PreparedStatement st = dao.getCon().prepareStatement("select inicjaly,haslo from trenerzy where inicjaly = ?");
            st.setString(1,fxTxtLogowanie.getText());
            st.execute();
            ResultSet rs = st.getResultSet();
            // wyrzucany jest błąd, bo najpierw trzeba pobrać rekord ( rs.next() )
            // jeżeli wstawisz tą komendę w if'a to dodatkowo będziesz sprawdzał czy zaczytał się rekord
            if(rs.getString("haslo").equals(fxTxtHaslo.getText())) System.out.println("glowne okno programu");
            else System.out.println("niepoprawne dane");
    }
    }

