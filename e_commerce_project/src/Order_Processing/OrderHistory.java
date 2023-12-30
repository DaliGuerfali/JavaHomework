package Order_Processing;



import java.io.*;
import java.util.*;

public class OrderHistory {
    //[orderID]=[user]|[amountToPay]|[placedDate]|[shippedDate]|[productName] / [price] / [amount]\[productName]/[price]/[amount]\...
    private final Properties ordersDB;
    public OrderHistory() throws IOException {
        //The constructor loads the database of orders
        ordersDB = new Properties();
        try {
            FileInputStream input = new FileInputStream("orders.properties");
            ordersDB.load(input);
        } catch(IOException e) {
            if(e instanceof FileNotFoundException)
                (new File("orders.properties")).createNewFile();
            else
                throw e;
        }
    }

    public void saveOrders() {
        try(OutputStream out = new FileOutputStream("orders.properties", false)) {
            ordersDB.store(out, null);
            System.out.println("Saving Orders...");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void placeOrder(Order order) {
        String res = order.getUser() +
                "|" +
                order.getAmountToPay() +
                "|" +
                order.getPlacedDate() +
                "|" +
                order.getShippedDate() +
                "|" +
                order.getData();
        ordersDB.setProperty(order.getOrderID(), res);
    }

    public Vector<String> getUserOrders(String userName) {
        Vector<String> vect = new Vector<>();
        for(Map.Entry<Object, Object> entry : ordersDB.entrySet()) {
             String data = (String) entry.getValue();
            String user = data.substring(0, data.indexOf("|"));
            if(user.equals(userName)) {
                vect.add(data);
            }
        }
        return vect;
    }

    public Properties getAllOrders() {
        return ordersDB;
    }

}
