package Product_Management;

public class Electronics extends Product{

    //initializer
    public Electronics(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }

    //loader
    public Electronics(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
