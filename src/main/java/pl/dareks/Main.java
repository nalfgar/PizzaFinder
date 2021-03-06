package pl.dareks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.dareks.services.PizzaService;
import pl.dareks.utils.HttpUtils;

public class Main extends Application {
    PizzaService pizzaService = new PizzaService();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
