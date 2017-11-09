package pl.dareks.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.dareks.services.PizzaData;
import pl.dareks.services.PizzaObserver;
import pl.dareks.services.PizzaService;
import pl.dareks.utils.PizzaModel;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, PizzaObserver {
    @FXML
    Button buttonSzukaj;
    @FXML
    Label label1;
    @FXML
    TextField textFieldMiasto;
    @FXML
    ListView listMenu;
    @FXML
    TextArea textAreaShow;
    @FXML
    TextField textFieldStreet;


    private PizzaService pizzaService = PizzaService.getService();


    private void showPizza() {
        pizzaService.makeCall(textFieldMiasto.getText(),textFieldStreet.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonSzukaj.setOnMouseClicked(e->showPizza());
      pizzaService.registerObserver(this);
    }

    @Override
    public void onPizzaUpdate(PizzaData data) {
        Platform.runLater(()->textAreaShow.setText(data.getName()+"\n"+data.getFormatted_address()+"\n"+data.getRating()));
        //Platform.runLater(()->textFieldShow.setText(data.getName()+data.getFormatted_address()+data.getRating()));


    }
}
