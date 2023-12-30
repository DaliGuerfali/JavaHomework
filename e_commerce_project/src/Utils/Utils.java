package Utils;

import Product_Management.Catalog;

import java.util.Scanner;

public final class Utils {
    private Utils() {
        //A class of (mostly input related) utilities
    }

    public static Scanner menuScanner = new Scanner(System.in);

    public static String queryProductID() {
        System.out.print("ID: ");
        return menuScanner.next();
    }

    public static int queryStockCount() {
        System.out.print("Stock Count: ");
        return menuScanner.nextInt();
    }

    public static double queryPrice() {
        System.out.print("Price: $");
        return menuScanner.nextDouble();
    }

    public static  String queryDescription() {
        System.out.print("Description: ");
        return menuScanner.nextLine();
    }

    public static String queryName() {
        System.out.print("Name: ");
        return menuScanner.nextLine();
    }


    public static String queryCategories() {
        Catalog[] categories = Catalog.values();
        if(categories.length == 0) {
            System.out.println("No available categories.");
            return "";
        }
        System.out.println("Choose one of the following categories: ");

        for(int i = 1;  i < categories.length + 1; ++i) {
            System.out.printf("%d. %s\n", i, categories[i-1].getValue());
        }

        int index = menuScanner.nextInt() - 1;
        while(index < 0 || index >= categories.length) {
            index = menuScanner.nextInt() - 1;
        }

        return categories[index].getValue();

    }

    public static int queryAmount() {
        System.out.print("Amount to add/subtract: ");
        return menuScanner.nextInt();
    }

    public static String getUniqueID() {
        char [] id = new char[6];
        for(int i = 0; i < id.length; i++) {
            id[i] = (char) (((int) (Math.random()*26) + 'a') - (int) (Math.random()*2)*('a' - 'A'));
        }

        return new String(id);
    }

}
