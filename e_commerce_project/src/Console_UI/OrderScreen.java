package Console_UI;

import Login.Customer;
import Order_Processing.Order;
import Order_Processing.OrderHistory;
import Utils.Utils;

import java.time.LocalDate;
import java.util.Objects;

 class OrderScreen extends Menu {

    private Order order;
    private OrderHistory orderHistory;
    private Customer customer;
    OrderScreen(Order o, OrderHistory orderH, Customer c) {
        order = o;
        orderHistory = orderH;
        customer = c;
    }

    private enum Shipping {
        STANDARD(new ShippingOption( "Standard -> $7: Arrives in 10 days.", 7, 10)),
        EXPEDITED(new ShippingOption("Expedited -> $15: Arrives in 3 days.", 15, 3)),
        NEXT_DAY(new ShippingOption("Next-Day -> $20: Arrives in 1 day.", 20, 1));

        private final ShippingOption value;

        Shipping(ShippingOption value) {
            this.value = value;
        }

        public String getDesc() {
            return value.desc;
        }
        public double getValue() { return value.price; }
        public long getDays() { return value.days; }


        private record ShippingOption(String desc, double price, long days) {}


    }

    private enum Discounts {
        TEN(new DiscountCode("PAOENFU", 0.9)),
        TWENTY(new DiscountCode("MDLSHFH", 0.8)),
        FIFTY(new DiscountCode("BVJSNFK", 0.5));

        private final DiscountCode value;

        Discounts(DiscountCode value) {
            this.value = value;
        }

        public String getValue() {
            return value.code;
        }
        public double getDiscount() { return value.discount; }

         private record DiscountCode(String code, double discount) {}
    }


    @Override
    protected boolean start() {
        int query;
        Shipping shipping = null;
        Discounts discount = null;
        displayMenu();
        query = Utils.menuScanner.nextInt();
        while (query != 4) {
            switch (query) {
                case 1:
                    shipping = queryShipping();
                    break;
                case 2:
                    if(discount != null) {
                        System.out.println("You have already used a discount code.");
                        break;
                    }
                    discount = queryDiscount();
                    break;
                case 3:
                    if(shipping == null) {
                        System.out.println("Please choose a shipping option first.");
                        break;
                    }

                    order.setAmountToPay(order.getAmountToPay() + shipping.getValue());
                    order.setPlacedDate(LocalDate.now().toString());
                    order.setShippedDate(LocalDate.now().plusDays(shipping.getDays()).toString());

                    if(discount != null) {
                        order.setAmountToPay(order.getAmountToPay()*discount.getDiscount());
                    }
                    PaymentScreen paymentMenu = new PaymentScreen(order, orderHistory, customer);
                    if(paymentMenu.start()) {
                        //if the payment succeeds we go back to the main menu
                        return true;
                    }
                    break;
                default:
                    break;
            }

            displayMenu();
            query = Utils.menuScanner.nextInt();
        }

        System.out.println("Quitting order screen.");
        return false;
    }
    @Override
    protected void displayMenu() {
        System.out.println("----------------------");
        System.out.println("1. Choose shipping option.");
        System.out.println("2. Enter discount code.");
        System.out.println("3. Proceed to payment.");
        System.out.println("4. Cancel order.");
        System.out.println("----------------------");
    }

     private Shipping queryShipping() {
        Shipping[] shippings = Shipping.values();
        System.out.println("Choose one of the following shipping options: ");

        for (int i = 1; i < shippings.length + 1; ++i) {
            System.out.printf("%d. %s\n", i, shippings[i-1].getDesc());
        }

        int index = Utils.menuScanner.nextInt() - 1;
        while (index < 0 || index >= shippings.length) {
            index = Utils.menuScanner.nextInt() - 1;
        }

        return shippings[index];
    }

     private Discounts queryDiscount() {
        Discounts[] codes = Discounts.values();
        Utils.menuScanner.nextLine();
        System.out.print("Code: ");
        String input = Utils.menuScanner.nextLine();

        for (Discounts code : codes) {
            if (Objects.equals(code.getValue(), input)) {
                System.out.printf("You have a %d%% discount.\n", (int) code.getDiscount()*100);
                return code;
            }
        }

        System.out.println("Invalid code.");
        return null;
    }

}