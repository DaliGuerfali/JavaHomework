package Product_Management;

public class ProductFactory {

    Product loadProduct(String ID,String category, String name, String desc, double price, int stockCount)
    throws InstantiationError
    {
        return switch (category) {
            case "Clothing" -> new Clothing(ID, category, name, desc, price, stockCount);
            case "Electronics" -> new Electronics(ID, category, name, desc, price, stockCount);
            case "Food" -> new Food(ID, category,  name, desc, price, stockCount);
            case "Healthcare" -> new Healthcare(ID, category, name, desc, price, stockCount);
            case "Media" -> new Media(ID, category, name, desc, price, stockCount);
            case "Toys" -> new Toys(ID, category, name, desc, price, stockCount);
            default -> throw new InstantiationError();
        };
    }
    public Product createNewProduct(String category, String name, String desc, double price, int stockCount)
    throws InstantiationError
    {
        return switch (category) {
            case "Clothing" -> new Clothing(category, name, desc, price, stockCount);
            case "Electronics" -> new Electronics(category, name, desc, price, stockCount);
            case "Food" -> new Food(category, name, desc, price, stockCount);
            case "Healthcare" -> new Healthcare(category, name, desc, price, stockCount);
            case "Media" -> new Media(category, name, desc, price, stockCount);
            case "Toys" -> new Toys(category, name, desc, price, stockCount);
            default -> throw new InstantiationError();
        };
    }

}
