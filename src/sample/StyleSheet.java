package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StyleSheet {

    public static void utilityLabelTextField(Label label, TextField textField) {
        label.setFont(Font.font("Sans Serif", FontWeight.BOLD, 16));
        textField.setPrefWidth(350);
        textField.setAlignment(Pos.CENTER);
        textField.setPadding(new Insets(7));
    }

    public static void utilityLabelComboBox(Label label, ComboBox<String> comboBox) {
        label.setFont(Font.font("Sans Serif", FontWeight.BOLD, 16));
        comboBox.setPrefWidth(350);
        comboBox.setPadding(new Insets(4));
    }

    public static void utilityButtons(Button button) {
        button.setFont(Font.font("Sans Serif", FontWeight.BOLD, 15));
        button.setPrefWidth(175);

    }

    public static void utilityHBox(HBox hBox) {
        hBox.setAlignment(Pos.CENTER);
    }
}
