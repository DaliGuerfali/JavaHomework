package Product_Management;

import Utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class Product {
    protected String category;
    protected String name, description, productID;
    protected int stockCount;
    protected double price;
    public String getName() { return name; }
    public String getProductID() { return productID; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public int getStockCount() { return stockCount; }
    public double getPrice() { return  price; }
    public void setName(String n) { name = n; }
    public void setStockCount(int s) { stockCount = s; }
    public void setPrice(double p) { price = p; }
    public void setDescription(String desc) { description = desc; }


    //[ID]=[name] [description] [price] [stockCount]
    //This is the static method that loads the sub-inventories
    public static HashMap<String, Product> loadDb(String category)
    throws IOException
    {
        Properties db = new Properties();
        ProductFactory factory = new ProductFactory();
        HashMap<String, Product> products = new HashMap<>();
        System.out.printf("Loading %s Inventory...\n", category);
        try {
            FileInputStream input = new FileInputStream(category + ".properties");
            db.load(input);

            db.forEach((key, val) -> {
                String productID = (String) key;
                String v = (String) val;
                StringTokenizer tokenizer = new StringTokenizer(v, "|");
                String name = tokenizer.nextToken();
                String description = tokenizer.nextToken();
                double price = Double.parseDouble(tokenizer.nextToken());
                int stockCount = Integer.parseInt(tokenizer.nextToken());
                products.put(productID, factory.loadProduct(productID, category,
                        name, description, price, stockCount));
            });

        } catch (IOException e) {
            if (e instanceof FileNotFoundException)
                (new File(category+".properties")).createNewFile();
            else throw e;
        }
        return products;
    }


    public Product(String c, String n, String desc, double p, int s) {
        //initializer
        category = c;
        name = n;
        description = desc;
        price = p;
        stockCount = s;
        productID = Utils.getUniqueID();
    }

    public Product(String ID, String c, String n, String desc, double p, int s) {
        //loader
        productID = ID;
        category = c;
        name = n;
        description = desc;
        price = p;
        stockCount = s;
    }


    @Override
    public String toString() {
        String res  = String.format(
          "---------------------\n" +
                  "ID: %s\nName: %s\nDescription: %s\nPrice: $%.2f\n",
                productID, name, description, price
        );
        if(stockCount == 0) {
            res += "Out of Stock\n---------------------\n";
        } else {
            res += String.format("In Stock: %d items remaining.\n---------------------\n", stockCount);
        }

        return res;
    }
}
