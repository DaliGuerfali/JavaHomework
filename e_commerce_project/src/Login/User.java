package Login;

import Inventory_Management.Inventory;
import Product_Management.Product;
import Utils.Utils;

import java.util.Optional;

public abstract class User {
    protected String userName;
    private final Inventory inventory;


    public User(String u, Inventory inv) {
        userName = u;
        inventory = inv;
    }
    public String getUserName() {
        return userName;
    }
    public void listInventory() {
        System.out.println(inventory);
    }

    public void listInventoryByCategory(String category) {
        inventory.getSpecificInventory(category).forEach((ID, product) -> {
            System.out.println(product);
        });
    }


    public boolean itemNotExists(String productID, String category) {
        return inventory.itemNotExist(productID, category);
    }
    public boolean itemNotExists(String productID) {
        return inventory.itemNotExist(productID);
    }

    public String getItem(String productID, String category) {
        Optional<Product> product = inventory.getItem(productID, category);
        if(product.isPresent()) {
            return product.get().toString();
        }
        return "";
    }

    public String getItemByID(String productID) {
        Optional<Product> product = inventory.getItemByID(productID);
        if(product.isPresent()) {
            return product.get().toString();
        }
        return "";
    }

    public String getItemByName(String name) {
        StringBuilder builder = new StringBuilder();
        for(Product product : inventory.getItemByName(name)) {
                builder.append(product.toString());
        }
        return builder.toString();
    }

    public String getItemByNameAndCategory(String name, String category) {
        StringBuilder builder = new StringBuilder();
        for(Product product : inventory.getItemByNameAndCategory(name, category)) {
            builder.append(product.toString());
        }
        return builder.toString();
    }

    public void searchByIdAndCategory() {
        String productID = Utils.queryProductID();
        String category = Utils.queryCategories();
        if(itemNotExists(productID, category)) return;
        System.out.println(
                getItem(productID, category)
        );
    }
    public void searchById() {
        String productID = Utils.queryProductID();
        String item = getItemByID(productID);
        if(item.isEmpty()) {
            System.out.println("No item with such ID.");
            return;
        }
        System.out.println(item);
    }

    public void searchByName() {
        Utils.menuScanner.nextLine();
        String name = Utils.queryName();
        String items = getItemByName(name);
        if(items.isEmpty()) {
            System.out.println("No item with such name.");
            return;
        }
        System.out.println(items);
    }

    public void searchByNameAndCategory() {
        Utils.menuScanner.nextLine();
        String name = Utils.queryName();
        String category = Utils.queryCategories();
        String items = getItemByNameAndCategory(name, category);
        if(items.isEmpty()) {
            System.out.println("Could not find results under this category.");
            return;
        }
        System.out.println(items);
    }

}
