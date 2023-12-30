package Console_UI;

import Login.Customer;
import Order_Processing.OrderHistory;
import Utils.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


class CustomerScreen extends Menu {

    private final Customer customer;

    private final OrderHistory orderHistory;

    CustomerScreen(Customer c, OrderHistory orderH) {
        customer = c;
        orderHistory = orderH;
    }
    @Override
    public boolean start() {
        int query;
        String category;
        displayMenu();
        query = Utils.menuScanner.nextInt();
        while(query != 10) {
            switch (query) {
                case 1:
                    customer.listInventory();
                    break;
                case 2:
                    category = Utils.queryCategories();
                    customer.listInventoryByCategory(category);
                    break;
                case 3:
                    customer.searchByIdAndCategory();
                    break;
                case 4:
                    customer.searchById();
                    break;
                case 5:
                    customer.searchByName();
                    break;
                case 6:
                    customer.searchByNameAndCategory();
                    break;
                case 7:
                    ShoppingCartScreen shoppingCartMenu = new ShoppingCartScreen(customer, orderHistory);
                    shoppingCartMenu.start();
                    break;
                case 8:
                    System.out.println("User | Total paid | Order Date | Shipping Date | Items...");
                    for(String order : orderHistory.getUserOrders(customer.getUserName())) {
                        System.out.println(order);
                    }
                    break;
                case 9:
                    System.out.printf("You have $%.2f in your balance.\n", customer.getBalance());
                    break;
                default:
                    break;
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }

        saveBalance();
        System.out.println("Logging out...");
        return false;
    }

    @Override
    protected void displayMenu() {
        System.out.println("----------------------");
        System.out.println("1. List All Products.");
        System.out.println("2. List Products By Category.");
        System.out.println("3. Search Product By ID And Category.");
        System.out.println("4. Search Product By ID.");
        System.out.println("5. Search Product By Name.");
        System.out.println("6. Search Product By Name And Category.");
        System.out.println("7. Check Shopping Cart.");
        System.out.println("8. Check the status of placed orders.");
        System.out.println("9. Check balance.");
        System.out.println("10. Log Out.");
        System.out.println("----------------------");
    }

    private void saveBalance() {
        Properties userDB = new Properties();
        try {
            FileInputStream input = new FileInputStream("users.properties");
            userDB.load(input);
            userDB.setProperty("balance."+customer.getUserName(), String.valueOf(customer.getBalance()));

            FileOutputStream out = new FileOutputStream("users.properties");
            userDB.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
