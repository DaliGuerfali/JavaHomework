package Console_UI;


import Login.Admin;
import Order_Processing.OrderHistory;
import Product_Management.ProductFactory;
import Utils.Utils;

import java.util.Map;
class AdminScreen extends Menu {

    private final Admin admin;

    private final OrderHistory orderHistory;


    AdminScreen(Admin a, OrderHistory orderH) {
        admin = a;
        orderHistory = orderH;
    }
    @Override
    public boolean start() {
        int query;
        displayMenu();
        String category;
        query = Utils.menuScanner.nextInt();
        while(query != 12) {
            switch (query) {
                case 1:
                    admin.listInventory();
                    break;
                case 2:
                    category = Utils.queryCategories();
                    admin.listInventoryByCategory(category);
                    break;
                case 3:
                    admin.searchByIdAndCategory();
                    break;
                case 4:
                    admin.searchById();
                    break;
                case 5:
                    admin.searchByName();
                    break;
                case 6:
                    admin.searchByNameAndCategory();
                    break;
                case 7:
                    addProduct();
                    break;
                case 8:
                    updateProduct();
                    break;
                case 9:
                    removeProduct();
                    break;
                case 10:
                    admin.listAllUsers();
                    break;
                case 11:
                    viewOrders();
                    break;
                default:
                    break;
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }
        System.out.println("Logging out...");
        return false;
    }

    @Override
    protected void displayMenu() {
        System.out.println("----------------------");
        System.out.println("1. List all products.");
        System.out.println("2. List products by category.");
        System.out.println("3. Search Product By ID and Category.");
        System.out.println("4. Search Product By ID.");
        System.out.println("5. Search Product By Name.");
        System.out.println("6. Search Product By Name And Category");
        System.out.println("7. Add new product.");
        System.out.println("8. Update existing product.");
        System.out.println("9. Remove existing product.");
        System.out.println("10. View all users registered.");
        System.out.println("11. View the order history.");
        System.out.println("12. Log Out.");
        System.out.println("----------------------");
    }


    private void addProduct() {
        String category = Utils.queryCategories();
        Utils.menuScanner.nextLine();
        String name = Utils.queryName();
        String description = Utils.queryDescription();
        double price = Utils.queryPrice();
        int stockCount = Utils.queryStockCount();
        ProductFactory factory = new ProductFactory();
        System.out.println(
                admin.addProduct(factory.createNewProduct(category,
                        name, description, price, stockCount))
        );
        System.out.println("Item added successfully.");
    }

    private void updateProduct() {
        String productID = Utils.queryProductID();
        String category = Utils.queryCategories();
        if(admin.itemNotExists(productID, category)) return;
        ProductUpdateScreen updateMenu = new ProductUpdateScreen(productID, category, admin);
        updateMenu.start();
    }

    private void removeProduct() {
        String productID = Utils.queryProductID();
        String category = Utils.queryCategories();
        if(admin.itemNotExists(productID, category)) return;
        admin.removeProduct(productID,category);
        System.out.println("Item removed successfully.");
    }

    private void viewOrders() {
        System.out.println("User | Total paid | Order Date | Shipping Date | Items...");
        for(Map.Entry<Object, Object> entry : orderHistory.getAllOrders().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
