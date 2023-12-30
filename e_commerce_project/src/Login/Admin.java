package Login;

import Inventory_Management.Inventory;
import Product_Management.Product;

import java.util.Map;
import java.util.Properties;

public class Admin extends User{

    private final Inventory inventory;
    private final Properties userDB;

    public Admin(String u, Inventory inv, Properties uDB) {
        super(u, inv);
        inventory = inv;
        userDB = uDB;
    }

    public Product addProduct(Product newProduct) {
        return inventory.addProduct(newProduct);
    }

    public void removeProduct(String productID, String category) {
        inventory.removeProduct(productID, category);
    }
    public void updateName(String productID, String category, String newName) {
        inventory.updateProductName(productID, category, newName);
    }

    public void updateDescription(String productID, String category, String desc) {
        inventory.updateProductDescription(productID, category, desc);
    }
    public void updatePrice(String productID, String category, double newPrice) {
        inventory.updateProductPrice(productID, category, newPrice);
    }

    public void updateStock(String productID, String category, int newStockCount) {
        inventory.updateProductStock(productID, category, newStockCount);
    }

    public void listAllUsers() {
        for(Map.Entry<Object, Object> entry : userDB.entrySet()) {
            String key = (String) entry.getKey();
            if(key.startsWith("user.")) {
                System.out.println(key.substring(key.indexOf(".") + 1));
            }
        }
    }

}
