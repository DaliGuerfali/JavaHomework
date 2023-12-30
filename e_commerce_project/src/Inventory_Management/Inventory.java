package Inventory_Management;

import Product_Management.Catalog;
import Product_Management.Product;

import java.io.*;
import java.util.*;

public class Inventory {
    //category -> productID -> product
    private final HashMap<String,  HashMap<String, Product>> inventory;

    public Inventory() throws IOException {
        //the constructor loads the sub-inventories and groups them in a map by category
        Catalog[] categories = Catalog.values();
        inventory = new HashMap<>();

        for (Catalog category : categories) {
            inventory.put(category.getValue(), Product.loadDb(category.getValue()));
        }
    }

    public void saveInventory() {
        inventory.forEach((category, map) -> {
            //[ID]=[name]|[description]|[price]|[stock_count]
            Properties categoryDB = new Properties();
            map.forEach((productID, product) -> {
                String entry = product.getName() + "|" +
                        product.getDescription() + "|" +
                        product.getPrice() + "|" +
                        product.getStockCount();
                categoryDB.setProperty(productID, entry);
            });

            try(OutputStream out = new FileOutputStream(category + ".properties", false)) {
                categoryDB.store(out, null);
                    System.out.printf("Saving %s Inventory...\n", category);
            } catch(IOException e) {
                e.printStackTrace();
            }
        });
    }

    public HashMap<String, Product> getSpecificInventory(String category) {
        return inventory.get(category);
    }


    public Product addProduct(Product product) {
         inventory.get(product.getCategory())
                .put(product.getProductID(), product);
        return product;
    }

    public void removeProduct(String productID, String category) {
        if(itemNotExist(productID, category)) return;
        inventory.get(category).remove(productID);
    }
    public void updateProductName(String productID, String category, String newName) {
        if(itemNotExist(productID, category)) return;
        inventory.get(category).get(productID).setName(newName);
    }
    public void updateProductDescription(String productID, String category, String desc) {
        if(itemNotExist(productID, category)) return;
        inventory.get(category).get(productID).setDescription(desc);
    }
    public void updateProductPrice(String productID, String category, double newPrice) {
        if(itemNotExist(productID, category)) return;
        inventory.get(category).get(productID).setPrice(newPrice);
    }
    public void updateProductStock(String productID, String category, int newStockCount) {
        if(itemNotExist(productID, category)) return;
        inventory.get(category).get(productID).setStockCount(newStockCount);
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        inventory.forEach((category, map) ->
                map.forEach((id, product) ->
                        string.append(product.toString())));

        return string.toString();
    }

    public boolean itemNotExist(String productID, String category) {
        if(!inventory.containsKey(category)) {
            System.out.println("No such category.");
            return true;
        }
        if(!inventory.get(category).containsKey(productID)) {
            System.out.println("No item with such ID");
            return true;
        }

        return false;
    }

    public boolean itemNotExist(String productID) {
        for(Map.Entry<String, HashMap<String, Product>> entry : inventory.entrySet()) {
            for(Map.Entry<String, Product> entry2 : entry.getValue().entrySet()) {
                if(Objects.equals(entry2.getKey(), productID)) return false;
            }
        }
        return true;
    }


    public Optional<Product> getItem(String productID, String category) {
        if(itemNotExist(productID, category)) return Optional.empty();
        return Optional.of(inventory.get(category).get(productID));
    }

    public Optional<Product> getItemByID(String productID) {
        for(Map.Entry<String, HashMap<String, Product>> entry : inventory.entrySet()) {
            for(Map.Entry<String, Product> entry2 : entry.getValue().entrySet()) {
                if(Objects.equals(entry2.getKey(), productID)) return Optional.of(entry2.getValue());
            }
        }
        return Optional.empty();
    }

    public Vector<Product> getItemByName(String name) {
        Vector<Product> vect = new Vector<>();
        for(Map.Entry<String, HashMap<String, Product>> entry : inventory.entrySet()) {
            for(Map.Entry<String, Product> entry2 : entry.getValue().entrySet()) {
                if(entry2.getValue().getName().toLowerCase().contains(name.toLowerCase())) vect.add(entry2.getValue());
            }
        }
        return vect;
    }

    public Vector<Product> getItemByNameAndCategory(String name, String category) {
        Vector<Product> vect = new Vector<>();
        for(Map.Entry<String, Product> entry : inventory.get(category).entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(name.toLowerCase())) vect.add(entry.getValue());
        }
        return vect;
    }

}
