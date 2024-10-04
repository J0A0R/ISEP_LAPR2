module app{
        requires javafx.fxml;
        requires javafx.controls;
        requires AuthLib;
    requires commons.lang3;
    requires java.logging;
    requires opencsv;

    opens app.ui.gui to javafx.fxml;
    exports app.ui.gui;
}