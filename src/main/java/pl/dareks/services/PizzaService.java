package pl.dareks.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.dareks.utils.Config;
import pl.dareks.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {

    private List<PizzaData> pizzaDataList = new ArrayList<PizzaData>();
    private static PizzaService ourInstance = new PizzaService();
    private List<PizzaObserver> observers;
    public static PizzaService getService() {
        return ourInstance;
    }
    //private ExecutorService executorService = Executors.newSingleThreadExecutor();


    public PizzaService() {
        observers= new ArrayList<>();
    }

    public void registerObserver(PizzaObserver observer)   {
        observers.add(observer);
    }

    private void notifyObservers(PizzaData data) {
        for (PizzaObserver observer : observers) {
            observer.onPizzaUpdate(data);
        }
    }
    public void makeCall(String city, String street) {
        //executorService.execute(()->{
            parseJsonData(HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID ));
      // HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID );
        //});
    }

    private void parseJsonData(String text) {
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            JSONObject in = results.getJSONObject(i); //
            double rating = in.getDouble("rating");
            String formated_address = in.getString("formatted_address");
            String name = in.getString("name");
            if (rating >= Config.MIN_RATING){
                System.out.println(rating + "\t" + formated_address + "\t" + name);

            }
            PizzaData data= new PizzaData();
            data.setName(name);
            data.setRating((float) rating);

            data.setFormatted_address(formated_address);
            notifyObservers(data);
        }



    }
}

