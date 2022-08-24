package com.example.test.object;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

import java.io.File;

public class Pdf {

    //public String adres = "/home/lukasz/test.pdf";
    public String adres = "/test.pdf";


    public void manipulatePdf() throws Exception {

        PdfWriter writer = new PdfWriter(adres);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();

        for (int i = 0; i < 16; i++) {
            table.addCell("hi");
        }
        doc.add(table);
        doc.close();

        //Dział na windowsie
        File file = new File(adres);
        Desktop.getDesktop().open(file);
    }



}
