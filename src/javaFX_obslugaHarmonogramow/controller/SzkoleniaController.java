package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javaFX_obslugaHarmonogramow.model.Szkolenie;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class SzkoleniaController {
    private DaoToMySQL connection = new DaoToMySQL();

    public void pokazSzkolenia(){
        ObservableList<Szkolenie> szkolenieView;
        Connection con = connection.getCon();
        ArrayList<Szkolenie> szkolenieLista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fkedupl_pwngr.Szkolenia");
            while (rs.next()){
                szkolenieLista.add(new Szkolenie(rs.getInt("id"),rs.getString("akronim"),rs.getDate("data_od"),rs.getDate("data_do"),rs.getString("typ_szkolen"),rs.getInt("Kursy_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        szkolenieView = FXCollections.observableArrayList(szkolenieLista);

    }
    private void wyswietlSzkolenie(){
        fxColAkronim.setCellValueFactory(new Property<Szkolenie, String>("akronim"));
        fxColDataOd.setCellValueFactory(new Property<Szkolenie, String>("data_od"));
        fxColDataDo.setCellValueFactory(new Property<Szkolenie, String>("data_do"));
        fxColTypSzkolenia.setCellValueFactory(new Property<Szkolenie, String>("typ_szkolen"));
        fxColNazwaSzkolenia.setCellValueFactory(new Property<Szkolenie, String>("Kursy_id"));
        fxTabViewSzkolenia.setItems(szkolenieView);
    }



}
