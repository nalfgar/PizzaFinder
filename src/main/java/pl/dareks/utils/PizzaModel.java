package pl.dareks.utils;

public class PizzaModel {
    private String name;
    private String formatted_address;
    private float rating;

    public PizzaModel(String name, String formatted_address, float rating) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PizzaModel that = (PizzaModel) o;

        if (Float.compare(that.rating, rating) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return formatted_address != null ? formatted_address.equals(that.formatted_address) : that.formatted_address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (formatted_address != null ? formatted_address.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PizzaModel{" +
                "name='" + name + '\'' +
                ", formatted_address='" + formatted_address + '\'' +
                ", rating=" + rating +
                '}';
    }
}
