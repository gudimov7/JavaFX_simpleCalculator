package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML

    public void digit(ActionEvent e) {
        String digits = ((Button)e.getSource()).getText();
        CalculatorApplication.printOutputText(digits);
    }
    public void operand(ActionEvent e) {
        CalculatorApplication.getEquation(((Button)e.getSource()).getText());
    }
    public void clean(ActionEvent e) {
        CalculatorApplication.clean();
    }

}
