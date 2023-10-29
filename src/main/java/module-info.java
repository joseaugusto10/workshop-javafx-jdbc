module com.example.workshopjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens application to javafx.fxml;
    exports application;
    opens control to javafx.fxml;
    exports control;

}