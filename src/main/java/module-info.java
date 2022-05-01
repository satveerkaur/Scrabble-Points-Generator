module assignment3.scrabblepointsgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens assignment3 to javafx.fxml;
    exports assignment3;
}