package com.example.test.object;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
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

        float columnWidth [] = {100f,100f,100f,100f,100f,100f};

        Table table = new Table(columnWidth);

        table.addCell(new Cell().add(new Paragraph("Sartihin Technology")));
        table.addCell(new Cell(2,0).add(new Paragraph("Android Battery Manager")));
        table.addCell(new Cell(3,0).add(new Paragraph("Android Battery Manager")));
        table.addCell(new Cell(3,0).add(new Paragraph("Android Battery Manager")));
        table.addCell(new Cell(0,2).add(new Paragraph("Android Battery Manager")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));
        table.addCell(new Cell().add(new Paragraph("Picasso Library")));

        doc.add(table);
        doc.close();

        //Dział na windowsie
        File file = new File(adres);
        Desktop.getDesktop().open(file);
    }



}
