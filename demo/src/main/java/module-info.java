module org.fxinput.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires jinput;

    opens org.fxinput.demo to javafx.fxml;
    exports org.fxinput.demo;
}