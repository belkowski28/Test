module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires barcodes;
    requires commons;
    requires font.asian;
    requires forms;
    requires hyph;
    requires io;
    requires layout;
    requires pdfa;
    requires java.datatransfer;
    requires java.desktop;



    opens com.example.test to javafx.fxml;
    exports com.example.test;
    exports com.example.test.controller;
    opens com.example.test.controller to javafx.fxml;
}