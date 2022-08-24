package com.example.test.controller;

import com.example.test.object.Pdf;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainController {

    @FXML
    private TextField data;

    @FXML
    private TextField imie_nazwisko;

    @FXML
    private TextField kod;

    @FXML
    private TextField masa;

    @FXML

    private TextField oswiadczenie;

    @FXML
    private TextField ulica;

    @FXML
    public void initialize(){
        oswiadczenie.setText("/150103/os.fiz");
        data.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        String miesiac_angl = String.valueOf(LocalDate.now().getMonth());
        masa.setText("1100");


    }

    @FXML
    void drukuj() throws Exception {
        Pdf pdf = new Pdf();
        pdf.manipulatePdf();
    }
    @FXML
    public void exit() {
        Platform.exit();

    }
    public String miesiac (String miesiac_ang){

        String miesiac_pl = "";
        switch (miesiac_ang){
            case ("JANUARY"): miesiac_pl = "STYCZEŃ";
                break;
            case ("FEBRUARY"): miesiac_pl = "LUTY";
                break;
            case ("MARCH"): miesiac_pl = "MARZEC";
                break;
            case ("APRIL"): miesiac_pl = "KWIECIEŃ";
                break;
            case ("MAY"): miesiac_pl = "MAJ";
                break;
            case ("JUNE"): miesiac_pl = "CZERWIEC";
                break;
            case ("JULY"): miesiac_pl = "LIPIEC";
                break;
            case ("AUGUST"): miesiac_pl = "SIERPIEŃ";
                break;
            case ("SEPTEMBER"): miesiac_pl = "WRZESIEŃ";
                break;
            case ("OCTOBER"): miesiac_pl = "PAŹDZIERNIK";
                break;
            case ("NOVEMBER"): miesiac_pl = "LISTOPAD";
                break;
            case ("DOCEMBER"): miesiac_pl = "GRUDZIEŃ";
                break;
        }
        return miesiac_pl;
    }
}