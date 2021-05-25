package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static sample.ButtonActionEvents.*;
import static sample.StyleSheet.*;

public class TemperatureConversionCalculator extends Application {

    //********************** VALUE TO CONVERT ********************************

    private static final Label VALUE_TO_CONVERT = new Label("Value to Convert:");
    private static final TextField VALUE_TO_CONVERT_TF = new TextField();


    //************************* FROM FIELD ***********************************

    private static final Label FROM = new Label("From:");
    private static final ComboBox<String> COMBO_BOX_FROM = new ComboBox<>();


    //************************ TO FIELD **************************************

    private static final Label TO = new Label("To:");
    private static final ComboBox<String> COMBO_BOX_TO = new ComboBox<>();


    //************************ BUTTONS **************************************

    private static final Button BUTTON_RESET = new Button("Reset");
    private static final Button BUTTON_CALCULATE = new Button("Calculate");


    //************************* SEPARATOR ***********************************

    private static final Separator SEPARATOR = new Separator(Orientation.HORIZONTAL);


    //************************** CONVERTED TEMPERATURE ************************************

    private static final Label CONVERTED_TEMPERATURE = new Label("Converted Temperature:");
    private static final TextField CONVERTED_TEMPERATURE_TF = new TextField();



    @Override
    public void start(Stage primaryStage) {

        //************************* IMAGE ************************************

        Image image = null;
        try {
            image = new Image(new FileInputStream("C:\\Users\\Devin\\IdeaProjects\\TemperatureConversionCSC440\\src" +
                    "\\Icon\\thermometer.png"));
        } catch (FileNotFoundException e) {
            System.out.println("Image file not found!" + e.getMessage());
        }

        ImageView thermometer = new ImageView(image);
        thermometer.setFitHeight(125);
        thermometer.setFitWidth(125);


        //************************ UTILITIES | STYLESHEET ********************************************

        utilityLabelTextField(VALUE_TO_CONVERT, VALUE_TO_CONVERT_TF);
        utilityLabelComboBox(FROM, COMBO_BOX_FROM);
        utilityLabelComboBox(TO, COMBO_BOX_TO);
        utilityButtons(BUTTON_RESET);
        utilityButtons(BUTTON_CALCULATE);
        utilityLabelTextField(CONVERTED_TEMPERATURE, CONVERTED_TEMPERATURE_TF);


        //**************** OPTIONS FOR COMBO BOXES *******************************************


        ObservableList<String> optionsFrom = FXCollections.observableArrayList(
                "Fahrenheit",
                "Celsius",
                "Kelvin",
                "Rankine"
        );

        ObservableList<String> optionsTo = FXCollections.observableArrayList(
                "Fahrenheit",
                "Celsius",
                "Kelvin",
                "Rankine"
        );


        //****************** ADD OPTIONS TO COMBO BOXES ************************************


        COMBO_BOX_FROM.getItems().addAll(optionsFrom);
        COMBO_BOX_FROM.setPromptText("Select a temperature scale");
        COMBO_BOX_TO.getItems().addAll(optionsTo);
        COMBO_BOX_TO.setPromptText("Select a temperature scale");



        //********************** ADD TO GRID PANE ****************************************

        GridPane gridPane = new GridPane();
        GridPane.setHalignment(FROM, HPos.RIGHT);
        GridPane.setHalignment(TO, HPos.RIGHT);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(VALUE_TO_CONVERT, 0, 0);
        gridPane.add(VALUE_TO_CONVERT_TF, 1, 0);
        gridPane.add(FROM, 0, 1);
        gridPane.add(COMBO_BOX_FROM, 1, 1);
        gridPane.add(TO, 0, 2);
        gridPane.add(COMBO_BOX_TO, 1, 2);


        //************** HBOX FOR BUTTONS ******************************************

        HBox buttonsHBox = new HBox(BUTTON_RESET, BUTTON_CALCULATE);
        buttonsHBox.setAlignment(Pos.TOP_CENTER);
        buttonsHBox.setSpacing(40);


        //******************* SEPARATOR TO FIT SCREEN WIDTH ******************************

        SEPARATOR.setPrefWidth(600);


        //**************** HBOX CONVERTED TEMPERATURE | IMAGE ****************************

        HBox separator = new HBox(SEPARATOR);
        utilityHBox(separator);
        HBox convertedTemperature = new HBox(CONVERTED_TEMPERATURE, CONVERTED_TEMPERATURE_TF);
        utilityHBox(convertedTemperature);
        convertedTemperature.setSpacing(10);
        HBox forIcon = new HBox(thermometer);
        utilityHBox(forIcon);


        //***************** PUT HBOX IN VBOX ******************************************

        VBox vBox = new VBox(separator, convertedTemperature, forIcon);
        VBox.setMargin(forIcon, new Insets(30, 0, 10, 0));
        VBox.setMargin(separator, new Insets(0, 0, 10, 0));


        //***************** BORDERPANE *************************************

        BorderPane borderPane = new BorderPane();
        BorderPane.setMargin(gridPane, new Insets(5, 0, 55, 0));
        BorderPane.setAlignment(vBox, Pos.TOP_CENTER);
        borderPane.setTop(gridPane);
        borderPane.setCenter(buttonsHBox);
        borderPane.setBottom(vBox);


        //*********************** PRIMARY STAGE *********************************

        primaryStage.setTitle("Temperature Conversion Calculator");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 600, 425));
        primaryStage.show();


        //**************** Button action events *********************************

        BUTTON_RESET.setOnAction(actionEvent -> btnActionReset(VALUE_TO_CONVERT_TF, CONVERTED_TEMPERATURE_TF, COMBO_BOX_FROM,
                COMBO_BOX_TO));

        BUTTON_CALCULATE.setOnAction(actionEvent -> btnActionCalculate(VALUE_TO_CONVERT_TF, CONVERTED_TEMPERATURE_TF,
                COMBO_BOX_FROM, COMBO_BOX_TO));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
