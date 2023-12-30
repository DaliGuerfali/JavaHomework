
public class PremiumUser extends User {
    public PremiumUser(String name, int id) {
        super(name, id);
    }

    public int getMaxBooks() {
        return 10;
    }
}
