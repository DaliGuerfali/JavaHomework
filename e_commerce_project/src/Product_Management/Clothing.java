package Product_Management;

public class Clothing extends Product{

    //initializer
    public Clothing(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }


    //loader
    public Clothing(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
