import Console_UI.MainMenu;
import Inventory_Management.Inventory;
import Order_Processing.OrderHistory;
import Shopping_Cart.ShoppingCartsLoader;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        try {
            Inventory inventory = new Inventory();
            ShoppingCartsLoader cartInventory = new ShoppingCartsLoader(inventory);
            OrderHistory orderHistory = new OrderHistory();
            MainMenu menu = new MainMenu(inventory, cartInventory, orderHistory);
            menu.start();
            inventory.saveInventory();
            cartInventory.saveShoppingCarts();
            orderHistory.saveOrders();
            System.out.println("Quitting app...");
        } catch(IOException e) {
            System.out.println("Something went wrong. Could not load the application.");
            e.printStackTrace();
        }
    }


}