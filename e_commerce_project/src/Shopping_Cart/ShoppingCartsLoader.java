package Shopping_Cart;

import Inventory_Management.Inventory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public class ShoppingCartsLoader {
    //user -> shoppingCart
    private final HashMap<String, ShoppingCart> carts;
    private final Inventory inventoryRef;
    public ShoppingCartsLoader(Inventory inv) throws IOException {
        //The constructor loads the database of shopping carts
        inventoryRef = inv;
        Properties cartDB = new Properties();
        carts = new HashMap<>();
        try {
            FileInputStream input = new FileInputStream("carts.properties");
            cartDB.load(input);
            //[username]=[cartID]|[totalItems]|[productID],[amount]|[productID],[amount]...

            for(Map.Entry<Object, Object> entry : cartDB.entrySet()) {
                String username = (String) entry.getKey();
                String data = (String) entry.getValue();

                HashMap<String, Integer> cart = new HashMap<>();

                StringTokenizer dataTokenizer = new StringTokenizer(data, "|");
                String cartID = dataTokenizer.nextToken();
                int total = Integer.parseInt(dataTokenizer.nextToken());

                while(dataTokenizer.hasMoreTokens()) {
                    String token = dataTokenizer.nextToken();
                    StringTokenizer entryTokenizer = new StringTokenizer(token, ",");
                    String productID = entryTokenizer.nextToken();
                    int amount = Integer.parseInt(entryTokenizer.nextToken());
                    cart.put(productID, amount);
                }

                carts.put(username, new ShoppingCart(username, cartID, cart, inventoryRef, total));
            }

        } catch(IOException e) {
            if(e instanceof FileNotFoundException)
                (new File("carts.properties")).createNewFile();
            else
                throw e;
        }
    }

    public void saveShoppingCarts() {
        Properties cartDB = new Properties();
        for(Map.Entry<String, ShoppingCart> entry : carts.entrySet()) {
            cartDB.setProperty(entry.getKey(), entry.getValue().getData());
        }

        try(OutputStream out = new FileOutputStream("carts.properties", false)) {
            cartDB.store(out, null);
            System.out.println("Saving Shopping Carts...");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void addShoppingCart(String cartID, String user) {
        carts.put(user, new ShoppingCart(user, cartID, inventoryRef));
    }

    public ShoppingCart getShoppingCart(String user) {
        return carts.get(user);
    }

    public boolean userNotHaveShoppingCart(String user) {
        return !carts.containsKey(user);
    }
}
