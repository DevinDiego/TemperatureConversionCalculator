package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerts {

    public static void Alert(String info) {
        Alert dialog = new Alert(Alert.AlertType.WARNING);
        dialog.setContentText("Press OK button to exit...");
        dialog.setHeaderText(info);
        dialog.getButtonTypes().setAll(ButtonType.OK);
        dialog.showAndWait();
    }
}
