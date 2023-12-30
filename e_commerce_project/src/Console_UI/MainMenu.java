package Console_UI;

import Inventory_Management.Inventory;
import Login.Admin;
import Login.AuthService;
import Login.Customer;
import Login.User;
import Order_Processing.OrderHistory;
import Shopping_Cart.ShoppingCartsLoader;
import Utils.Utils;

import java.io.IOException;
import java.util.Optional;

public class MainMenu extends Menu {
    private final AuthService authService;
    private final ShoppingCartsLoader cartInventory;
    private final OrderHistory orderHistory;
    private record Credentials(String username, String password) {};

    public MainMenu(Inventory inventory, ShoppingCartsLoader cI, OrderHistory orderH) throws IOException {
        authService = new AuthService(inventory);
        cartInventory = cI;
        orderHistory = orderH;
    }
    @Override
    protected void displayMenu() {
        System.out.println("----------------------");
        System.out.println("1. Login.");
        System.out.println("2. Register.");
        System.out.println("3. Quit.");
        System.out.println("----------------------");
    }

    @Override
    public boolean start() {
        int query;
        displayMenu();
        query = Utils.menuScanner.nextInt();
        while(query != 3) {
            switch (query) {
                case 1:
                    startLogin();
                    break;
                case 2:
                    startRegister();
                    break;
                default:
                    break;
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }
        return false;
    }


    private void startLogin() {
        Credentials creds = getCredentials();
        Optional<User> user = authService.handleLogin(creds.username, creds.password, cartInventory);
        if(user.isPresent()) {
            if(user.get() instanceof Customer) {
                CustomerScreen customerScreen = new CustomerScreen((Customer) user.get(), orderHistory);
                customerScreen.start();
            } else {
                AdminScreen adminScreen = new AdminScreen((Admin) user.get(), orderHistory);
                adminScreen.start();
            }
        }
    }


    private void startRegister() {
        Credentials creds = getCredentials();
        try {
            Customer customer = authService.handleSignup(creds.username, creds.password, cartInventory);
            CustomerScreen customerScreen = new CustomerScreen(customer, orderHistory);
            customerScreen.start();
        } catch(Exception e) {
            if(e instanceof IllegalAccessException) {
                System.out.printf("%s already exists. Please choose another username.\n", creds.username);
            } else {
                System.out.println("Something went wrong. Could not create user account.");
            }
        }
    }

    private Credentials getCredentials() {
        System.out.print("Username: ");
        String username = Utils.menuScanner.next();
        System.out.print("Password: ");
        String password = Utils.menuScanner.next();
        return new Credentials(username, password);
    }
}

