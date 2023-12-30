package Login;

import Inventory_Management.Inventory;
import Order_Processing.Order;
import Shopping_Cart.ShoppingCart;
import Shopping_Cart.ShoppingCartsLoader;
import Utils.Utils;

public class Customer extends User{

    private final String cartID;
    private final ShoppingCartsLoader loaderRef;

    private double balance;

    public Customer(String u, Inventory inv, ShoppingCartsLoader loader, double b) {
        super(u, inv);
        loaderRef = loader;
        balance = b;

        if(loaderRef.userNotHaveShoppingCart(userName)) {
            cartID = Utils.getUniqueID();
            loaderRef.addShoppingCart(cartID, userName);
        } else {
            cartID = loaderRef.getShoppingCart(userName).getCartID();
        }

    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addCartProduct(String productID) {
        getShoppingCart().addProduct(productID);
    }

    public void updateCartProductAmount(String productID, int amount) {
        getShoppingCart().updateProductAmount(productID, amount);
    }

    public void removeCartProduct(String productID) {
        getShoppingCart().removeProduct(productID);
    }

    public String getShoppingCartData() {
        return getShoppingCart().toString();
    }

    //This creates the order data needed to start the order processing
    public Order.OrderData getOrderData() {
        return getShoppingCart().getOrderData();
    }

    public ShoppingCart getShoppingCart() {
        return loaderRef.getShoppingCart(userName);
    }

}
