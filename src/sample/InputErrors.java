package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class InputErrors {

    public static boolean inputIsEmpty(TextField textField) {
        return textField.getText().isEmpty();
    }

    public static boolean comboFromIsEmpty(ComboBox<String> comboBox) {
        return comboBox.getSelectionModel().isEmpty();
    }

    public static boolean comboToIsEmpty(ComboBox<String> comboBox) {
        return comboBox.getSelectionModel().isEmpty();
    }
}
