
public class RegularUser extends User {
    public RegularUser(String name, int id) {
        super(name, id);
    }

    public int getMaxBooks() {
        return 3;
    }
}
