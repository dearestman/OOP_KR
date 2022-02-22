module com.company.new_oop {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens com.company.new_oop to javafx.fxml;
    exports com.company.new_oop;
}