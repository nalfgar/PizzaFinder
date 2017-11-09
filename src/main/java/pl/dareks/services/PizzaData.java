package pl.dareks.services;

public class PizzaData {
    private String name;
    private String formatted_address;
    private float rating;
    private String city;


    public PizzaData() {
        this.name = name;
        this.formatted_address = formatted_address;
        this.rating = rating;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}



