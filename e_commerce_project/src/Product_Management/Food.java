package Product_Management;

public class Food extends Product{
    //initializer
    public Food(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }

    //loader
    public Food(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
