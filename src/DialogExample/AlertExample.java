/*
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.html
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.AlertType.html
 */
package DialogExample;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertExample extends Application {

    private TextField textFld;
    private Text actionStatus;
    private static final String titleTxt = "JavaFX Dialogs Example";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle(titleTxt);

        // Window label
        Label label = new Label("Alert Dialogs");
        HBox labelHb = new HBox();
        labelHb.getChildren().add(label);

        // Text field
        Label txtLbl = new Label("A Text field:");
        textFld = new TextField();
        textFld.setPromptText("Enter some text and save.");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(txtLbl, textFld);

        // Buttons
        Button infobtn = new Button("Info");
        infobtn.setOnAction(new InfoButtonListener());
        Button warnbtn = new Button("Warning");
        warnbtn.setOnAction(new WarningButtonListener());
        Button errbtn = new Button("Error");
        errbtn.setOnAction(new ErrorButtonListener());
        Button confbtn = new Button("Confirmation");
        confbtn.setOnAction(new ConfirmationButtonListener());
        Button nonebtn = new Button("None");
        nonebtn.setOnAction(new NoneButtonListener());
        HBox buttonHb = new HBox(10);
        buttonHb.getChildren().addAll(infobtn, warnbtn, errbtn, confbtn, nonebtn);

        // Status message text
        actionStatus = new Text();

        // Vbox
        VBox vbox = new VBox(30);
        vbox.getChildren().addAll(labelHb, hbox, buttonHb, actionStatus);

        // Scene
        Scene scene = new Scene(vbox); // w x h
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initial
        actionStatus.setText("An example of Alert Dialogs. Enter some text and save.");
        infobtn.requestFocus();
    }

    private class InfoButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show info alert dialog

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(titleTxt);
            alert.setHeaderText("Information Alert");
            String s = "This is an example of JavaFX 8 Dialogs. This is an Alert Dialog of Alert type - INFORMATION.";
            s += "Alert types are: INFORMATION, CONFIRMATION, ERROR, NONE and WARNING.";
            alert.setContentText(s);
            alert.setResizable(true);

            alert.show();
        }
    }

    private class WarningButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show warning alert dialog

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle(titleTxt);
            alert.setHeaderText("Warning Alert");
            String s = "This is an example of JavaFX 8 Dialogs. This is an Alert Dialog of Alert type - WARNING.";
            s += "Alert types are: INFORMATION, CONFIRMATION, ERROR, NONE and WARNING.";
            alert.setContentText(s);
            alert.setResizable(true);

            alert.show();
        }
    }

    private class ErrorButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show error alert dialog

            String txt = textFld.getText().trim();
            String msg = "Text saved: ";
            boolean valid = true;

            if ((txt.isEmpty()) || (txt.length() < 5)) {
                valid = false;
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(titleTxt);
                String s = "Text should be at least 5 characters long. " + "Enter valid text and save. ";
                alert.setContentText(s);
                alert.showAndWait();
                msg = "Invalid text entered: ";
            }

            actionStatus.setText(msg + txt);

            if (!valid) {

                textFld.requestFocus();
            }
        }
    }

    private class ConfirmationButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show confirm alert dialog

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle(titleTxt);
            String s = "Confirm to clear text in text field ! ";
            alert.setContentText(s);

            Optional<ButtonType> result = alert.showAndWait();

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                textFld.setText("");
                actionStatus.setText("An example of Alert Dialogs. Enter some text and save.");
                textFld.requestFocus();
            }
        }
    }

    private class NoneButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            // Show none alert dialog

            Alert alert = new Alert(AlertType.NONE);
            alert.setTitle(titleTxt);
            alert.setHeaderText("None Alert");
            String s = "This is an example of JavaFX 8 Dialogs. This is an Alert Dialog of Alert type - NONE.";
            s += "Alert types are: INFORMATION, CONFIRMATION, ERROR, NONE and WARNING.";
            alert.setContentText(s);
            alert.setResizable(true);

            alert.show();
        }
    }
}
