package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javaFX_obslugaHarmonogramow.model.Szkolenie;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.sql.*;
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
    @FXML
    void onButDodajSzkolenie(ActionEvent event) {
        DaoToMySQL connection = new DaoToMySQL();
        Connection con = connection.getCon();
        try {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("INSERT INTO fkedupl_pwngr.Szkolenia (akronim, data_od, data_do, typ_szkolen, Kursy_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,fxTxtAkronim.getText());
            ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
            ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()));
            ps.setString(5, String.valueOf(fxComRodzajKursu.getValue()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onButEdytujSzkolenie(ActionEvent event) {
        DaoToMySQL connection = new DaoToMySQL();
        Connection con = connection.getCon();
        String selectedIndex = String.valueOf(fxTabViewSzkolenia.getSelectionModel().getSelectedItem());
        try {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("UPDATE fkedupl_pwngr.Szkolenia SET akronim=?, data_od=?, data_do=?, typ_szkolen=?, Kursy_id=? WHERE id=?");
            ps.setString(1,fxTxtAkronim.getText());
            ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
            ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()));
            ps.setString(5, String.valueOf(fxComRodzajKursu.getValue()));
            ps.setString(6, selectedIndex);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onButUsunSzkolenie(ActionEvent event) {
        DaoToMySQL connection = new DaoToMySQL();
        Connection con = connection.getCon();
        String selectedIndex = String.valueOf(fxTabViewSzkolenia.getSelectionModel().getSelectedItem());
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM fkedupl_pwngr.Szkolenia WHERE akronim=?");
            ps.setString(1,selectedIndex);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
