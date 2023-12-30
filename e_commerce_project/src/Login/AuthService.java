package Login;

import Inventory_Management.Inventory;
import Shopping_Cart.ShoppingCartsLoader;

import java.io.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class AuthService {

    private final Properties userDB;
    private Inventory inventory;

    public AuthService(Inventory inv) throws IOException {
        //The constructor loads the database of user credentials
        userDB = new Properties();
        try {
            FileInputStream input = new FileInputStream("users.properties");
            userDB.load(input);
            inventory = inv;
        } catch(IOException e) {
            if(e instanceof FileNotFoundException)
                (new File("users.properties")).createNewFile();
             else
                throw e;
        }
    }


    public Optional<User> handleLogin(String username, String password, ShoppingCartsLoader cartInventory){
        String prefixUser = String.format("user.%s", username);
        if(!userDB.containsKey(prefixUser) || !Objects.equals(userDB.getProperty(prefixUser), password)) {
            System.out.println("The username or password may be wrong. Please try again.");
            return Optional.empty();
        }
        String prefixAdmin = String.format("admin.%s", username);
        String prefixBalance = String.format("balance.%s",username);
        System.out.printf("Welcome Back %s!\n", username);
        if(!userDB.containsKey(prefixAdmin)) {
            return Optional.of(new Customer(username, inventory, cartInventory, Double.parseDouble(userDB.getProperty(prefixBalance))));
        }
        return Optional.of(new Admin(username, inventory, userDB));
    }

    public Customer handleSignup(String username, String password, ShoppingCartsLoader cartInventory)
    throws IOException, IllegalAccessException {
        String prefixUser = String.format("user.%s", username);
        String prefixBalance = String.format("balance.%s", username);
        if(userDB.containsKey(prefixUser)) {
            throw new IllegalAccessException();
        }

        userDB.setProperty(prefixUser, password);
        userDB.setProperty(prefixBalance, "1000");

        try(OutputStream output = new FileOutputStream("users.properties", false)) {
            userDB.store(output, null);
            System.out.println("User account created successfully.");
            output.close();
            return new Customer(username, inventory, cartInventory, 1000);
        } catch(IOException e) {
            userDB.remove(prefixUser);
            throw e;
        }
    }



}
