package Product_Management;

public class Toys extends Product{
    //initializer
    public Toys(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }

    //loader
    public Toys(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
