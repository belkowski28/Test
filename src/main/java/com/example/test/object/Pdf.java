package com.example.test.object;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pdf {

    private String lokalizacja = "/home/lukasz/";



    private String nazwapliku;
    //public String lokalizacja = "/test.pdf";
    public static final String FONT_BOLD = "src/main/resources/FONTS/LinuxLibertineBold.ttf";
    public static final String FONT = "src/main/resources/FONTS/LinuxLibertine.ttf";

    public void setNazwapliku(String nazwapliku) {
        this.nazwapliku = nazwapliku.replace("/","");
    }


    public void setImie_nazwisko(String imie_nazwisko) {
        this.imie_nazwisko = imie_nazwisko;
    }

    public void setNr_dokumentu(String nr_dokumentu) {
        this.nr_dokumentu = nr_dokumentu;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String imie_nazwisko = "";
    private String nr_dokumentu = "";
    private String rok = "";
    private String ulica = "";
    private String kodpocztowy = "";
    private String masa = "";
    private String data = "";

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    private String miesiac = "";

    PdfFont boldFont = PdfFontFactory.createFont(FONT_BOLD, PdfEncodings.CP1250);
    PdfFont Font = PdfFontFactory.createFont(FONT, PdfEncodings.CP1250);

    public Pdf() throws IOException {
    }

    public void manipulatePdf() throws Exception {

        PdfWriter writer = new PdfWriter(lokalizacja+nazwapliku+".pdf");
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(new float[]{55,25,20}));
        table.setWidth(UnitValue.createPercentValue(100));
        table.setFixedLayout();
        table.addCell(new Cell(1,1).add(new Paragraph("OŚWIADCZENIE \nPRZEKAZANIA ODPADU")).setTextAlignment(TextAlignment.CENTER).setFontSize(10).setBackgroundColor(Color.convertRgbToCmyk(new DeviceRgb(96,96,96)))).setFont(boldFont);
        table.addCell(new Cell(1,1).add(new Paragraph("Nr").setFontSize(8).setTextAlignment(TextAlignment.CENTER)).add(new Paragraph(nr_dokumentu).setFontSize(13).setBold().setTextAlignment(TextAlignment.CENTER)));
        table.addCell(new Cell(1,1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("Rok kalendarzowy").setFontSize(8)).add(new Paragraph(rok).setFontSize(13).setBold()));
        table.addCell(new Cell(2,1).add(new Paragraph("\tPosiadacz odpadów, który przekazuje odpad\n").setFontSize(8)).add(new Paragraph("Grzadziel Investment S.K.\nAleja Kazimierza Wielkiego 10\n87-800 Włocławek\nBDO:000125259\n8883013783/340471029\n...........................\nNIP/REGON").setMarginLeft(10f).setFontSize(10)));
        table.addCell(new Cell(1,2).add(new Paragraph("Przyjmuje odpad").setFontSize(8)).add(new Paragraph(imie_nazwisko)));
        table.addCell(new Cell(1,2).add(new Paragraph("Adres \n").setFontSize(8)).add(new Paragraph(ulica)).add(new Paragraph(kodpocztowy)));
        table.addCell(new Cell(1,3).add(new Paragraph("Do wykorzystania jako paliwo, do wykonywania drobnych nnapraw i konserwacji lub wykorzystania ich funkcji").setFontSize(8)));
        table.addCell(new Cell(1,1).setBackgroundColor(Color.convertRgbToCmyk(new DeviceRgb(96,96,96))).add(new Paragraph("Kod odpadu").setFontSize(8)).add(new Paragraph("15 01 03").setFontSize(10).setBold().setTextAlignment(TextAlignment.CENTER)));
        table.addCell(new Cell(1,2).setBackgroundColor(Color.convertRgbToCmyk(new DeviceRgb(96,96,96))).add(new Paragraph("Rodzaj odpadu").setFontSize(8)).add(new Paragraph("Opakowanie z drewna").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBold()));
        table.addCell(new Cell(1,1).add(new Paragraph("miesiac").setFontSize(8)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell(1,2).add(new Paragraph("Masa przekazanych odpadów\n [kg]").setTextAlignment(TextAlignment.CENTER).setFontSize(8)));
        table.addCell(new Cell(1,1).add(new Paragraph(miesiac).setBold().setFontSize(8)).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell(1,2).add(new Paragraph(masa).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(8)));
        table.addCell(new Cell(4,1).add(new Paragraph("Potwierdzam przekazanie odpadu \n\n\n").setFontSize(8)).add(new Paragraph("data i podpis " + data).setFontSize(8)));
        table.addCell(new Cell(4,2).add(new Paragraph("Potwierdzam przyjecie odpadu \n\n\n").setFontSize(8)).add(new Paragraph("data i podpis " + data).setFontSize(8)));

        Paragraph kreski = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");

        doc.add(table);
        doc.add(kreski);
        doc.add(table);
        System.out.println(masa);

        doc.close();

        //Dział na windowsie
        //File file = new File(adres);
        //Desktop.getDesktop().open(file);
    }



}
