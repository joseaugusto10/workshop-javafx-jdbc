module com.example.workshopjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.sql; // Adicione esta linha para requerer o módulo java.sql
    opens application to javafx.fxml;
    exports application;
    opens control to javafx.fxml;
    exports control;
    opens model.entities to javafx.base;
    exports model.entities;



}