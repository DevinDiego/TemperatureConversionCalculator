package sample;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static sample.Alerts.Alert;
import static sample.Calculations.*;
import static sample.InputErrors.*;

public class ButtonActionEvents {

    public static void btnActionCalculate(TextField textFieldValueToConvert, TextField convertedTemp, ComboBox<String> comboBoxFrom, ComboBox<String> comboBoxTo) {

        if (inputIsEmpty(textFieldValueToConvert)) {
            Alert("Please enter a value to convert, try again!");
        } else if (comboFromIsEmpty(comboBoxFrom)) {
            Alert("Please select a temperature scale");
        } else if (comboToIsEmpty(comboBoxTo)) {
            Alert("Please select a temperature scale");
        } else {
            String from = getComboValues(comboBoxFrom);
            String to = getComboValues(comboBoxTo);
            double input = getValueToConvertInput(textFieldValueToConvert);

            if (from.equals("Fahrenheit") && to.equals("Celsius")) {
                double result = fahrenheitToCelsius(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2103"));


            } else if (from.equals("Fahrenheit") && to.equals("Kelvin")) {
                double result = fahrenheitToKelvin(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u212A"));


            } else if (from.equals("Fahrenheit") && to.equals("Rankine")) {
                double result = fahrenheitToRankine(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u0052"));


            } else if (from.equals("Celsius") && to.equals("Fahrenheit")) {
                double result = celsiusToFahrenheit(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2109"));


            } else if (from.equals("Celsius") && to.equals("Kelvin")) {
                double result = celsiusToKelvin(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u212A"));


            } else if (from.equals("Celsius") && to.equals("Rankine")) {
                double result = celsiusToRankine(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u0052"));


            } else if (from.equals("Kelvin") && to.equals("Fahrenheit")) {
                double result = kelvinToFahrenheit(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2109"));


            } else if (from.equals("Kelvin") && to.equals("Celsius")) {
                double result = kelvinToCelsius(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2103"));


            } else if (from.equals("Kelvin") && to.equals("Rankine")) {
                double result = kelvinToRankine(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u0052"));


            } else if (from.equals("Rankine") && to.equals("Fahrenheit")) {
                double result = rankineToFahrenheit(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2109"));


            } else if (from.equals("Rankine") && to.equals("Celsius")) {
                double result = rankineToCelsius(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u2103"));


            } else if (from.equals("Rankine") && to.equals("Kelvin")) {
                double result = rankineToKelvin(input);
                convertedTemp.setText(String.format("%.2f%s", result, " \u212A"));


            } else if (from.equals("Fahrenheit") && to.equals("Fahrenheit")) {
                convertedTemp.setText(String.format("%.2f%s", input, " \u2109"));


            } else if (from.equals("Celsius") && to.equals("Celsius")) {
                convertedTemp.setText(String.format("%.2f%s", input, " \u2103"));


            } else if (from.equals("Kelvin") && to.equals("Kelvin")) {
                convertedTemp.setText(String.format("%.2f%s", input, " \u212A"));


            } else if (from.equals("Rankine") && to.equals("Rankine")) {
                convertedTemp.setText(String.format("%.2f%s", input, " \u0052"));
            }
        }
    }

    public static void btnActionReset(TextField textFieldValueToConvert, TextField convertedTemp,
                                          ComboBox<String> comboBoxFrom, ComboBox<String> comboBoxTo) {
        if (textFieldValueToConvert.getText().isEmpty() && convertedTemp.getText().isEmpty()) {
            Alert("Text Fields are empty, nothing to reset!");
        }
        comboBoxFrom.getSelectionModel().clearSelection();
        comboBoxTo.getSelectionModel().clearSelection();
        textFieldValueToConvert.setText("");
        convertedTemp.setText("");
    }
}
