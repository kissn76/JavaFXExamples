package TooltipExample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;

public class TooltipDemo extends Application {

    @Override
    public void start(Stage stage) {

        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(5));

        // User Name
        root.add(new Label("User Name"), 0, 0);
        TextField field_userName = new TextField();
        root.add(field_userName, 1, 0);

        Tooltip tooltip_userName = new Tooltip("Enter user name");
        field_userName.setTooltip(tooltip_userName);

        // Password
        root.add(new Label("Password"), 0, 1);
        PasswordField field_password = new PasswordField();

        Tooltip tooltip_password = new Tooltip("Enter Password");
        field_password.setTooltip(tooltip_password);

        root.add(field_password, 1, 1);

        // Create a Button
        Button button_login = new Button("Submit");
        Tooltip tooltip_login = new Tooltip("Login to Application");

        // Set Location to display tooltip.
        tooltip_login.setAnchorLocation(AnchorLocation.WINDOW_BOTTOM_LEFT);
        button_login.setTooltip(tooltip_login);

        root.add(button_login, 1, 2);

        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Tooltip Demo (o7planning.org)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
