package Shopping_Cart;

import Inventory_Management.Inventory;
import Order_Processing.Order;
import Product_Management.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShoppingCart {
    //productID -> amount
    private final HashMap<String, Integer> cart;
    private final String user, cartID;

    private int total;
    private final Inventory inventoryRef;
    ShoppingCart(String username, String ID, Inventory inventory) {
        //initializer
        cart = new HashMap<>();
        user = username;
        cartID = ID;
        inventoryRef = inventory;
        total = 0;
    }

    ShoppingCart(String username,String ID, HashMap<String, Integer> c,
                 Inventory inventory, int t) {
        //loader
        cart = c;
        user = username;
        cartID = ID;
        inventoryRef = inventory;
        total = t;
    }

    public void addProduct(String productID) {
        Optional<Product> product = inventoryRef.getItemByID(productID);
        if(product.isPresent() && product.get().getStockCount() == 0) {
            System.out.println("This item is out of stock.");
            return;
        }

        if(cart.containsKey(productID)) {
            updateProductAmount(productID, 1);
            return;
        }
        cart.put(productID, 1);
        total++;
    }

    public int getTotal() { return total; }

    public void updateProductAmount(String productID, int amount) {
        Optional<Product> product = inventoryRef.getItemByID(productID);
        if(product.isPresent() && cart.get(productID) + amount > product.get().getStockCount()) {
            System.out.printf("You can't have more than %d of this item. Please try again.\n", product.get().getStockCount());
            return;
        }

        if(!cart.containsKey(productID)) {
            addProduct(productID);
            return;
        }
        if(cart.get(productID) + amount <= 0) {
            removeProduct(productID);
            return;
        }

        cart.replace(productID, cart.get(productID) + amount);
        total += amount;
    }

    public void removeProduct(String productID) {
        total -= cart.get(productID);
        cart.remove(productID);
    }

    public String getUser() { return user; }
    public String getCartID() { return cartID; }
    public String getData() {
        StringBuilder builder = new StringBuilder();
        builder.append(cartID)
                .append("|")
                .append(total)
                .append("|");

        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("|");
        }
        return builder.toString();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(total == 0) {
            return "You have no items in your cart.\n";
        }
        double totalPrice = 0;
        builder.append(String.format("You have %d items in your cart\n", total));
        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            Optional<Product> product = inventoryRef.getItemByID(entry.getKey());
            if(product.isPresent()) {
                builder.append(String.format("%s | $%.2f | x%d\n",
                        product.get().getName(),
                        product.get().getPrice(),
                        entry.getValue()
                ));
                totalPrice += product.get().getPrice() * entry.getValue();
            }
        }
        builder.append(String.format("Total price: $%.2f\n",totalPrice));
        return builder.toString();
    }

    //This returns the order data required for order processing
    public Order.OrderData getOrderData() {
        StringBuilder builder = new StringBuilder();
        double totalPrice = 0;
        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            Optional<Product> product = inventoryRef.getItemByID(entry.getKey());
            if(product.isPresent()) {
                builder.append(String.format("%s / $%.2f / x%d \\",
                        product.get().getName(),
                        product.get().getPrice(),
                        entry.getValue()
                ));
                totalPrice += product.get().getPrice() * entry.getValue();
            }
        }
        return new Order.OrderData(builder.toString(), totalPrice);
    }

    public void updateInventoryPostOrder() {
        for(Map.Entry<String, Integer> entry: cart.entrySet()) {
            Optional<Product> product = inventoryRef.getItemByID(entry.getKey());
            product.ifPresent(value -> value.setStockCount(value.getStockCount() - entry.getValue()));
        }
        cart.clear();
        total = 0;
    }
}
