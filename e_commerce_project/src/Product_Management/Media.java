package Product_Management;

public class Media extends Product{
    //initializer
    public Media(String c, String n, String desc, double p, int s) {
        super(c, n, desc, p, s);
    }

    //loader
    public Media(String ID, String c, String n, String desc, double p, int s) {
        super(ID, c, n, desc, p, s);
    }
}
