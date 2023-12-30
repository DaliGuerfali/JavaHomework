package Console_UI;

import Login.Admin;
import Utils.Utils;


class ProductUpdateScreen extends Menu {
    
    private final Admin admin;
    private final String productID, category;
    
    ProductUpdateScreen(String ID, String c, Admin a) {
        admin = a;
        productID = ID;
        category = c;
    }
    @Override
    protected void displayMenu() {
        System.out.println("-------------------");
        System.out.println("1. Update Name.");
        System.out.println("2. Update Description.");
        System.out.println("3. Update Price.");
        System.out.println("4. Update Stock Count.");
        System.out.println("5. Quit.");
        System.out.println("-------------------");
    }

    @Override
    protected boolean start() {
        displayMenu();
        int query = Utils.menuScanner.nextInt();
        while(query != 5) {
            Utils.menuScanner.nextLine();
            switch (query) {
                case 1:
                    String newName = Utils.queryName();
                    if(newName.isEmpty()) {
                        System.out.println("Cancelling name update.");
                    }
                    admin.updateName(productID, category, newName);
                    System.out.println("Item updated successfully.");
                    break;
                case 2:
                    String newDesc = Utils.queryDescription();
                    if(newDesc.isEmpty()) {
                        System.out.println("Cancelling description update.");
                    }
                    admin.updateDescription(productID, category, newDesc);
                    System.out.println("Item updated successfully.");
                    break;
                case 3:
                    double newPrice = Utils.queryPrice();
                    admin.updatePrice(productID, category, newPrice);
                    System.out.println("Item updated successfully.");
                    break;
                case 4:
                    int newStockCount = Utils.queryStockCount();
                    admin.updateStock(productID, category, newStockCount);
                    System.out.println("Item updated successfully.");
                    break;
                default:
                    break;
            }
            displayMenu();
            query = Utils.menuScanner.nextInt();
        }
        System.out.println("Quitting update menu...");
        return false;
    }


}
