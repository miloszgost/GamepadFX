package org.fxinput.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FxController {
    //@FXML
    //private Label welcomeText;

    @FXML
    private VBox MainApp;
        @FXML
        private VBox AppPadButtons;
            @FXML
            private Label   PadButtonsLabel;
        @FXML
        private VBox AppPadGyro;
            @FXML
            private Label   PadGyroLabel;
        @FXML
        private VBox AppConsole;
            @FXML
            private ToolBar  ConsoleToolBar;
            @FXML
            private TextArea ConsoleOutput;

    @FXML
    protected void onToolBarButtonClick() {
        PadButtonsLabel.setText("Welcome to JavaFX Application!");
        PadGyroLabel.setText("Welcome to JavaFX Application!");
        String consoleState = ConsoleOutput.getText();
        ConsoleOutput.setText(consoleState + "\nPressed button!");
    }
}