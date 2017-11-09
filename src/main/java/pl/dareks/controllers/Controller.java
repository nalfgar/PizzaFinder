package pl.dareks.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pl.dareks.services.PizzaData;
import pl.dareks.services.PizzaService;
import pl.dareks.utils.PizzaModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    Button button1;
    @FXML
    Label label1;
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    @FXML
    TextField textField3;


    private PizzaService pizzaService = PizzaService.getService();


    private void showPizza() {
        pizzaService.makeCall(textField1.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button1.setOnMouseClicked(e->showPizza());

    }
}
