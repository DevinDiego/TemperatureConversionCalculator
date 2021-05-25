package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Calculations {

    public static double fahrenheitToCelsius(double input) {
        return (input - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double input) {
        return (input - 32) * 5 / 9 + 273.15;
    }

    public static double fahrenheitToRankine(double input) {
        return (input + 459.67);
    }

    public static double celsiusToFahrenheit(double input) {
        return (input * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double input) {
        return input + 273.15;
    }

    public static double celsiusToRankine(double input) {
        return input * 9 / 5 + 491.67;
    }

    public static double kelvinToFahrenheit(double input) {
        return (input - 273.15) * 9 / 5 + 32;
    }

    public static double kelvinToCelsius(double input) {
        return input - 273.15;
    }

    public static double kelvinToRankine(double input) {
        return input * 1.8;
    }

    public static double rankineToFahrenheit(double input) {
        return input - 459.67;
    }

    public static double rankineToCelsius(double input) {
        return (1 - 491.67) * 5 / 9;
    }

    public static double rankineToKelvin(double input) {
        return input * 5 / 9;
    }

    public static String getComboValues(ComboBox<String> comboBox) {
        return comboBox.getSelectionModel().getSelectedItem();
    }

    public static double getValueToConvertInput(TextField textField) {
        return Double.parseDouble(textField.getText());
    }
}
