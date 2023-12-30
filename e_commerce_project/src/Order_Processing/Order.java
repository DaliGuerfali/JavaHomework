package Order_Processing;

import Utils.Utils;

public class Order {

    private final String user, orderID;
    private String placedDate;
    private String shippedDate;
    private final String data;
    private double amountToPay;

    public record OrderData(String data, double amountToPay) {}

    public Order(String userName, String d, double p) {
        user = userName;
        data = d;
        amountToPay = p;
        orderID = Utils.getUniqueID();
    }

    public String getOrderID() {
        return orderID;
    }

    public String getData() {
        return data;
    }

    public String getPlacedDate() {
        return placedDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public String getUser() {
        return user;
    }

    public void setAmountToPay(double amount) {
        amountToPay = amount;
    }

    public void setPlacedDate(String placedDate) {
        this.placedDate = placedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

}
