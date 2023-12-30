package Console_UI;

import Login.Customer;
import Order_Processing.Order;
import Order_Processing.OrderHistory;
import Utils.Utils;


class ShoppingCartScreen extends Menu {
    private final Customer customer;

    private final OrderHistory orderHistory;
    ShoppingCartScreen(Customer c, OrderHistory orderH) {
        customer = c;
        orderHistory = orderH;
    }

    @Override
    protected void displayMenu() {
        System.out.println("--------------------------");
        System.out.println("1. View shopping cart.");
        System.out.println("2. Add Product to Shopping Cart.");
        System.out.println("3. Update Product Amount In Shopping Cart.");
        System.out.println("4. Remove Product From Shopping Cart.");
        System.out.println("5. Place an order.");
        System.out.println("6. Quit Shopping cart.");
        System.out.println("--------------------------");
    }

    @Override
    protected boolean start() {
        int query, amount;
        String productID;
        displayMenu();
        query = Utils.menuScanner.nextInt();
        while(query != 6) {
            switch (query) {
                case 1:
                    System.out.println(customer.getShoppingCartData());
                    break;
                case 2:
                    productID = Utils.queryProductID();
                    if(customer.itemNotExists(productID)) {
                        System.out.println("No such item ID.");
                        break;
                    }
                    customer.addCartProduct(productID);
                    System.out.println("Item added successfully to shopping cart.");
                    break;
                case 3:
                    productID = Utils.queryProductID();
                    amount = Utils.queryAmount();
                    if(customer.itemNotExists(productID)) {
                        System.out.println("No such item ID.");
                        break;
                    }
                    customer.updateCartProductAmount(productID, amount);
                    System.out.println("Item updated successfully.");
                    break;
                case 4:
                    productID = Utils.queryProductID();
                    if(customer.itemNotExists(productID)) {
                        System.out.println("No such item ID.");
                        break;
                    }
                    customer.removeCartProduct(productID);
                    System.out.println("Removed item successfully.");
                    break;
                case 5:
                    if(customer.getShoppingCart().getTotal() == 0) {
                        System.out.println("Please add products to your cart to be able to place an order.");
                        break;
                    }
                    Order.OrderData orderData = customer.getOrderData();
                    Order orderToPlace = new Order(
                            customer.getUserName(),
                            orderData.data(),
                            orderData.amountToPay()
                            );

                    OrderScreen orderMenu = new OrderScreen(orderToPlace, orderHistory, customer);
                    if(orderMenu.start()) {
                        //if the order is placed, we go back to the main menu
                        customer.getShoppingCart().updateInventoryPostOrder();
                        return true;
                    }
                    break;
                default:
                    break;
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }
        System.out.println("Quitting shopping cart...");
        return false;
    }
}
