package Console_UI;

import Login.Customer;
import Order_Processing.Order;
import Order_Processing.OrderHistory;
import Utils.Utils;

class PaymentScreen extends Menu {

    private final Order order;
    private final OrderHistory orderHistory;

    private final Customer customer;
    PaymentScreen(Order o, OrderHistory orderH, Customer c) {
        order = o;
        orderHistory = orderH;
        customer = c;
    }

    @Override
    protected void displayMenu() {
        System.out.println("----------------------");
        System.out.println("1. Provide payment credentials");
        System.out.println("2. Go back.");
        System.out.println("----------------------");
    }

    @Override
    protected boolean start() {
        int query;
        displayMenu();
        query = Utils.menuScanner.nextInt();
        while(query != 2) {
            if (query == 1) {
                Utils.menuScanner.nextLine();
                System.out.print("Credit card number: ");
                Utils.menuScanner.nextLine();
                System.out.print("Verification code: ");
                Utils.menuScanner.nextLine();

                if (customer.getBalance() >= order.getAmountToPay()) {
                    //if the transaction is successful we go back to the main menu
                    System.out.println("Transaction successful.");
                    orderHistory.placeOrder(order);
                    customer.setBalance(customer.getBalance() - order.getAmountToPay());
                    return true;
                }
                System.out.printf("You have $%.2f. Please refill your balance.\n", customer.getBalance());
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }

        System.out.println("Going back...");
        return false;
    }
}
