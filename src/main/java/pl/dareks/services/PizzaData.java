package pl.dareks.services;

public class PizzaData {
    private String name;
    private String formatted_address;
    private float rating;

    public PizzaData(String name, String formatted_address, float rating) {
        this.name = name;
        this.formatted_address = formatted_address;
        this.rating = rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PizzaData pizzaData = (PizzaData) o;

        if (Float.compare(pizzaData.rating, rating) != 0) return false;
        if (name != null ? !name.equals(pizzaData.name) : pizzaData.name != null) return false;
        return formatted_address != null ? formatted_address.equals(pizzaData.formatted_address) : pizzaData.formatted_address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (formatted_address != null ? formatted_address.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PizzaData{" +
                "name='" + name + '\'' +
                ", formatted_address='" + formatted_address + '\'' +
                ", rating=" + rating +
                '}';
    }
}