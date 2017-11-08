package pl.dareks.services;

public class PizzaData {
    private String city;
    private String street;
    private int radius;
    private String name;
    private float opinion;

    public PizzaData(String city, String street, int radius, String name, float opinion) {
        this.city = city;
        this.street = street;
        this.radius = radius;
        this.name = name;
        this.opinion = opinion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOpinion() {
        return opinion;
    }

    public void setOpinion(float opinion) {
        this.opinion = opinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PizzaData pizzaData = (PizzaData) o;

        if (radius != pizzaData.radius) return false;
        if (Float.compare(pizzaData.opinion, opinion) != 0) return false;
        if (city != null ? !city.equals(pizzaData.city) : pizzaData.city != null) return false;
        if (street != null ? !street.equals(pizzaData.street) : pizzaData.street != null) return false;
        return name != null ? name.equals(pizzaData.name) : pizzaData.name == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + radius;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (opinion != +0.0f ? Float.floatToIntBits(opinion) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PizzaData{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", radius=" + radius +
                ", name='" + name + '\'' +
                ", opinion=" + opinion +
                '}';
    }
}
