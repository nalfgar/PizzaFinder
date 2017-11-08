package pl.dareks.services;

import pl.dareks.utils.Config;
import pl.dareks.utils.HttpUtils;

import java.util.concurrent.ExecutorService;

public class PizzaService {

    public void makeCall(String city, String street) {
//            parseJsonData(HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID );
       HttpUtils.makeHttpRequest(Config.API_URL + city +"+" + street + Config.API_ID );


    }
}
