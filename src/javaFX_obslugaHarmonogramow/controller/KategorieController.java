package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javaFX_obslugaHarmonogramow.model.KategoriaTematyczna;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class KategorieController {

    public KategorieController() {
    }

    DaoToMySQL dao = new DaoToMySQL();



    public ArrayList<KategoriaTematyczna> pokazKategorie() {
        ArrayList<KategoriaTematyczna> list = new ArrayList<>();
        try {
            Statement st = dao.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from Kat_tematyczne");
            while(rs.next()){
                list.add(new KategoriaTematyczna(rs.getInt("id"),rs.getString("nazwa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }



}


