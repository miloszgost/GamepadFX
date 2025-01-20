package org.fxinput.demo;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class FxController {

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
            private HBox    PadGyroCircles;
                @FXML
                private Circle  LeftStick;
                @FXML
                private Circle Gyroscope;
                @FXML
                private Circle RightStick;

        @FXML
        private VBox AppConsole;
            @FXML
            private ToolBar  ConsoleToolBar;
                @FXML
                private Button  FindController;
            @FXML
            private TextArea ConsoleOutput;

    @FXML
    protected void onToolBarButtonClick() {
        PadButtonsLabel.setText("Welcome to JavaFX Application!");
        PadGyroLabel.setText("Welcome to JavaFX Application!");
        String consoleState = ConsoleOutput.getText();
        ConsoleOutput.setText(consoleState + "\nPressed button!");

    }
    @FXML
    protected void onFindControllerClick() {
        ReadAllEvents jInput = new ReadAllEvents(ConsoleOutput);
        Thread backThread = new Thread(jInput);
        backThread.setDaemon(true);
        backThread.start();
    }

}