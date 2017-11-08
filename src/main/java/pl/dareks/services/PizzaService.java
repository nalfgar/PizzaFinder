package pl.dareks.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.dareks.utils.Config;
import pl.dareks.utils.HttpUtils;

import javax.swing.*;

public class PizzaService {


    public void makeCall(String city, String street) {
            parseJsonData(HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID ));
//       HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID );
    }

    private void parseJsonData(String text) {
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            JSONObject in = results.getJSONObject(i); //
            double rating = in.getDouble("rating");
            String formatedAdress = in.getString("formatted_address");
            String name = in.getString("name");
            if (rating >= Config.MIN_RATING){
                System.out.println(rating + "\t" + formatedAdress + "\t" + name);

            }
        }



    }
}

