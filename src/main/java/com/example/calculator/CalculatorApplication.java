package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class CalculatorApplication extends Application {
    private static float a,b;
    private static char op;
    private FXMLLoader fXMLLoader;
    private Parent root;
    private Scene scene;
    private AnchorPane outputPane;
    private GridPane operandPane;
    private GridPane digitsPane;
    private static TextField outputField;

    @Override
    public void start(Stage stage) throws IOException  {
        fXMLLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator_layout.fxml"));

        root = fXMLLoader.load();
        outputPane = (AnchorPane) root.lookup("#pane_output");
        outputField = (TextField) root.lookup("#textArea_outputField");
        outputField.setText("0");
        operandPane = (GridPane) root.lookup("#pane_operands");
        digitsPane = (GridPane) root.lookup("#pane_digits");
        scene = new Scene(root);

        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)  {
        launch();
    }

    public static void printOutputText(String text) {
        if (outputField.getText().equals("0") || op == '=')
            outputField.setText("");
        outputField.appendText(text);
    }
    public static void getEquation(String operand) {
        switch (operand.charAt(0)) {
            case '+': case '-': case 'x': case '/':
                a = (outputField.getText().equals(""))? 0f : Float.parseFloat(outputField.getText());
                outputField.setText("0");
                op = operand.charAt(0);
                break;
            case '=':
                b = (outputField.getText().equals(""))? 0f : Float.parseFloat(outputField.getText());
                float sum = calculate(a,op,b);
                outputField.setText(sumFormat(sum));
                break;
        }
    }
    public static void clean() {
        a = b = 0;
        outputField.setText("0");
    }
    private static float calculate(float a, char op, float b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a-b;
            case 'x': return a*b;
            case '/': return (b != 0) ? a/b : Float.NaN;
            default: return 0;
        }
    }
    private static String sumFormat(float num) {
        String str = String.valueOf(num);
        return str.replaceAll("\\.0*$","");
    }




}