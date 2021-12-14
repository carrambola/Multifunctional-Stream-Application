module com.example.kurwailemozna {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires okhttp3;
    requires org.json;
    requires org.jsoup;


    opens com.example.kurwailemozna to javafx.fxml;
    exports com.example.kurwailemozna;
}