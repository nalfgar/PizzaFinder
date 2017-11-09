package pl.dareks.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable, PizzaObserver {
    @FXML
    Button buttonSzukaj;
    @FXML
    Label label1;
    @FXML
    TextField textFieldMiasto;
    @FXML
    ListView<String> listMenu;
    @FXML
    TextArea textAreaShow;
    @FXML
    TextField textFieldStreet;

    private List<String> restaurantType;
    private PizzaService pizzaService = PizzaService.getService();


    private void showPizza() {
        pizzaService.makeCall(textFieldMiasto.getText(),textFieldStreet.getText(), restaurantType.get(listMenu.getSelectionModel().getSelectedIndex()));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        restaurantType = new ArrayList<>();
        restaurantType.add("Pizza");
        restaurantType.add("Cafeteria");
        restaurantType.add("Reataurant");
        buttonSzukaj.setOnMouseClicked(e->showPizza());
      pizzaService.registerObserver(this);

        ObservableList<String> names = FXCollections.observableArrayList(restaurantType);
        listMenu.setItems(names);
    }

    @Override
    public void onPizzaUpdate(PizzaData data) {
        Platform.runLater(()->textAreaShow.setText(data.getName()+"\n"+data.getFormatted_address()+"\n"+data.getRating()));
        //Platform.runLater(()->textFieldShow.setText(data.getName()+data.getFormatted_address()+data.getRating()));


//        ListView<String> li = new ListView<String>(names);

    }
}
