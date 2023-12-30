package Product_Management;

public class Healthcare extends Product{
    //initializer
    public Healthcare(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }

    //loader
    public Healthcare(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
