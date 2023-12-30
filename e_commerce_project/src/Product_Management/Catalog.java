package Product_Management;

public enum Catalog {
    Clothing("Clothing"),
    Electronics("Electronics"),
    Food("Food"),
    Healthcare("Healthcare"),
    Media("Media"),
    Toys("Toys");

    private final String value;

    Catalog(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
