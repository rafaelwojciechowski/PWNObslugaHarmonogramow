package javaFX_obslugaHarmonogramow.controller;

import javaFX_obslugaHarmonogramow.daoMySQL.DaoToMySQL;
import javaFX_obslugaHarmonogramow.model.DniSzkol;
import javaFX_obslugaHarmonogramow.model.Trener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DniSzkolController {

    public static String nazwaSzkolenia;

    public static LocalDate pierwszyDzienSzkolenia;

    private DaoToMySQL connection = new DaoToMySQL();

    @FXML
    private DatePicker fxDatDzienSzkolenia;

    @FXML
    private CheckBox fxCheckDzienWolny;

    @FXML
    private ComboBox<String> fxComTrener;

    @FXML
    private Label fxLabelDzienSzkoleniaError;

    @FXML
    private Label fxLabelNazwaSzkol;

    @FXML
    private Button fxButDodajDzien;

    @FXML
    private Button fxButEdytujDzien;

    @FXML
    private Button fxButUsunDzien;

    @FXML
    private TableView<DniSzkol> fxTabviewDniSzkolenia;

    @FXML
    private TableColumn<DniSzkol, LocalDate> fxColDzien;

    @FXML
    private TableColumn<DniSzkol, String> fxColWolne;

    @FXML
    private TableColumn<DniSzkol, String> fxColTrener;

    @FXML
    void fxComOnHidingTrener(Event event) {
        buttonDodajSetDisable();
    }

    @FXML
    void fxDatePickerOnHidingDzienSzkol(Event event) {
        buttonDodajSetDisable();
    }

    @FXML
    void fxTableViewOnClicked(MouseEvent event) {
        buttonEdytujUsunSetDisable();
        DniSzkol dniSzkol = fxTabviewDniSzkolenia.getSelectionModel().getSelectedItem();
        fxDatDzienSzkolenia.setValue(dniSzkol.getDzien());
    }

    @FXML
    void fxDatePickerClickedDzienSzkol(MouseEvent event) {
        fxTabviewDniSzkolenia.getSelectionModel().clearSelection();
        buttonEdytujUsunSetDisable();
    }

    @FXML
    void fxDatePickerInputDzienSzkol(InputMethodEvent event) {
        fxTabviewDniSzkolenia.getSelectionModel().clearSelection();
        buttonDodajSetDisable();
    }

    @FXML
    void onButDodajDzien(MouseEvent event) {
        Connection con = connection.getCon();
        Integer wolne;
        if(fxCheckDzienWolny.isSelected()){
            wolne = 1;
        }else{
            wolne = 0;
        }
        try {
            if (fxComTrener.getValue() == null){
                PreparedStatement ps = con.prepareStatement("INSERT INTO fkedupl_pwngr.Dni_szkolenia_trenerzy (dzien, wolne, szkolenia_id, trenerzy_id) SELECT ?, ?, (SELECT id FROM Szkolenia WHERE akronim = ?), ?");
                ps.setDate(1,java.sql.Date.valueOf(fxDatDzienSzkolenia.getValue()));
                ps.setInt(2, wolne);
                ps.setString(3, nazwaSzkolenia);
                ps.setInt(4, 0);
                ps.executeUpdate();
            }else {
                PreparedStatement ps = con.prepareStatement("INSERT INTO fkedupl_pwngr.Dni_szkolenia_trenerzy (dzien, wolne, szkolenia_id, trenerzy_id) SELECT ?, ?, (SELECT id FROM Szkolenia WHERE akronim = ?), (SELECT id FROM Trenerzy WHERE inicjaly = ?)");
                ps.setDate(1,java.sql.Date.valueOf(fxDatDzienSzkolenia.getValue()));
                ps.setInt(2, wolne);
                ps.setString(3, nazwaSzkolenia);
                ps.setString(4, fxComTrener.getValue().toString().substring(0, fxComTrener.getValue().toString().indexOf('-') - 1));
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTableViewDniaSzkol();
        buttonDodajSetDisable();
    }

    @FXML
    void onButEdytujDzien(MouseEvent event) {
        Connection con = connection.getCon();
        DniSzkol dniSzkol = fxTabviewDniSzkolenia.getSelectionModel().getSelectedItem();
        Integer wolne;
        if(fxCheckDzienWolny.isSelected()){
            wolne = 1;
        }else{
            wolne = 0;
        }
        try {
            if (fxComTrener.getValue() == null || fxComTrener.getValue() == "nie dotyczy" || wolne == 1){
                PreparedStatement ps = con.prepareStatement("UPDATE fkedupl_pwngr.Dni_szkolenia_trenerzy SET dzien=?, wolne=?, szkolenia_id=(SELECT id FROM Szkolenia WHERE akronim = ?), trenerzy_id = ? WHERE id = ?");
                ps.setDate(1,java.sql.Date.valueOf(fxDatDzienSzkolenia.getValue()));
                ps.setInt(2, wolne);
                ps.setString(3,nazwaSzkolenia);
                ps.setInt(4, 0);
                ps.setInt(5, dniSzkol.getId());
                ps.executeUpdate();
            }else{
                PreparedStatement ps = con.prepareStatement("UPDATE fkedupl_pwngr.Dni_szkolenia_trenerzy SET dzien=?, wolne=?, szkolenia_id=(SELECT id FROM Szkolenia WHERE akronim = ?), trenerzy_id=(SELECT id FROM Trenerzy WHERE inicjaly = ?) WHERE id = ?");
                ps.setDate(1,java.sql.Date.valueOf(fxDatDzienSzkolenia.getValue()));
                ps.setInt(2, wolne);
                ps.setString(3,nazwaSzkolenia);
                ps.setString(4, fxComTrener.getValue().toString().substring(0, fxComTrener.getValue().toString().indexOf('-') - 1));
                ps.setInt(5, dniSzkol.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxTabviewDniSzkolenia.getSelectionModel().clearSelection();
        populateTableViewDniaSzkol();
        buttonEdytujUsunSetDisable();
        buttonDodajSetDisable();
    }

    @FXML
    void onButUsunDzien(MouseEvent event) {
        Connection con = connection.getCon();
        DniSzkol dniSzkol = fxTabviewDniSzkolenia.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM fkedupl_pwngr.Dni_szkolenia_trenerzy WHERE id=?");
            ps.setInt(1,dniSzkol.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxTabviewDniSzkolenia.getSelectionModel().clearSelection();
        populateTableViewDniaSzkol();
        buttonEdytujUsunSetDisable();
        buttonDodajSetDisable();
    }

    @FXML
    void initialize() {
        populateTableViewDniaSzkol();
        fxLabelNazwaSzkol.setText(nazwaSzkolenia);
        fxDatDzienSzkolenia.setValue(pierwszyDzienSzkolenia);
        fxComTrener.getItems().add("nie dotyczy");
        List comboBoXTrener = new ArrayList();
        for (Trener trener : pokazTrenerow()){
            comboBoXTrener.add(trener.getInicjaly()+ " - " +trener.getImie()+ " " +trener.getNazwisko());
        }
        fxComTrener.getItems().addAll(comboBoXTrener);
        buttonDodajSetDisable();
        buttonEdytujUsunSetDisable();
    }

    public void buttonDodajSetDisable(){
        List<LocalDate> columnDzienData = new ArrayList<>();
        for (DniSzkol dzien : fxTabviewDniSzkolenia.getItems()){
            columnDzienData.add(fxColDzien.getCellObservableValue(dzien).getValue());
        }
        if(fxDatDzienSzkolenia.getValue() == null || columnDzienData.contains(fxDatDzienSzkolenia.getValue())){
            fxButDodajDzien.setDisable(true);
            fxLabelDzienSzkoleniaError.setVisible(true);
        }else{
            fxButDodajDzien.setDisable(false);
            fxLabelDzienSzkoleniaError.setVisible(false);
        }
    }
    public void buttonEdytujUsunSetDisable(){
        if(fxTabviewDniSzkolenia.getSelectionModel().getSelectedItem() == null || fxDatDzienSzkolenia.getValue() == null){
            fxButEdytujDzien.setDisable(true);
            fxButUsunDzien.setDisable(true);
        }else{
            fxButEdytujDzien.setDisable(false);
            fxButUsunDzien.setDisable(false);
        }
    }

    private List<Trener> pokazTrenerow() {
        Connection con = connection.getCon();
        List<Trener> listaTrenerow = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT t.id, t.imie, t.nazwisko, t.inicjaly, t.haslo, t.mentor FROM Trenerzy AS t JOIN Kat_tematyczne_trenerzy AS ktt ON t.id = ktt.trenerzy_id JOIN Kat_tematyczne AS kt ON ktt.kat_tematyczne_id = kt.id JOIN Kat_tematyczne_kursy AS ktk ON kt.id = ktk.kat_tematyczne_id JOIN Kursy AS k ON ktk.kursy_id = k.id JOIN Szkolenia as s ON k.id = s.kursy_id WHERE s.akronim = ?");
            ps.setString(1,nazwaSzkolenia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trener trener = new Trener(rs.getInt("id"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("inicjaly"),rs.getString("haslo"),rs.getInt("mentor"));
                listaTrenerow.add(trener);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listaTrenerow;
    }

    private Trener wybierzTrenera() {
        Connection con = connection.getCon();
        Trener wybranyTrener = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT t.id, t.imie, t.nazwisko, t.inicjaly, t.haslo, t.mentor FROM Trenerzy AS t WHERE t.inicjaly = ?");
            ps.setString(1, fxComTrener.getValue().toString().substring(0, fxComTrener.getValue().toString().indexOf('-') - 1));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                wybranyTrener = new Trener(rs.getInt("id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("inicjaly"), rs.getString("haslo"), rs.getInt("mentor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wybranyTrener;
    }

    private void populateTableViewDniaSzkol() {
        Connection con = connection.getCon();
        ObservableList<DniSzkol> dniSzkolView;
        ArrayList<DniSzkol> dniSzkolLista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT dst.id, dst.dzien, (CASE WHEN dst.wolne = 0 THEN \"nie\" ELSE \"tak\" END) as wolne, sz.akronim, t.inicjaly FROM Dni_szkolenia_trenerzy as dst LEFT JOIN Szkolenia as sz ON dst.szkolenia_id = sz.id LEFT JOIN Trenerzy as t ON dst.trenerzy_id = t.id WHERE sz.akronim = ? ORDER BY dst.dzien ASC");
            ps.setString(1, nazwaSzkolenia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DniSzkol dniSzkol = new DniSzkol(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getString(4), rs.getString(5));
                dniSzkolLista.add(dniSzkol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxTabviewDniSzkolenia.getItems().clear();
        dniSzkolView = FXCollections.observableArrayList(dniSzkolLista);
        fxColDzien.setCellValueFactory(new PropertyValueFactory<DniSzkol, LocalDate>("dzien"));
        fxColWolne.setCellValueFactory(new PropertyValueFactory<DniSzkol, String>("wolne"));
        fxColTrener.setCellValueFactory(new PropertyValueFactory<DniSzkol, String>("trener"));
        fxTabviewDniSzkolenia.getItems().addAll(dniSzkolView);
    }

}