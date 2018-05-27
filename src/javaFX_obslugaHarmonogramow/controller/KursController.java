package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.model.Kurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KursController {

    private Connection con;

    private ObservableList<Kurs> kursy;

    private void pokazKursy() {
        List<Kurs> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Kursy;");
            while (rs.next()) {
                list.add(new Kurs(rs.getInt("id"),
                        rs.getString("nazwa"),
                        rs.getInt("ile_dni")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        kursy = FXCollections.observableArrayList(list);
    }

//    private void wyswietlNazwyKursow() {
//        fxNazwaKursu.setCellValueFactory(new PropertyValueFactory<Kurs,String>("nazwa"));
//        fxLiczbaDni.setCellValueFactory(new PropertyValueFactory<Kurs,String>("ile_dni"));
//        NazwaKursu.setItems(kursy);
//    }

}




