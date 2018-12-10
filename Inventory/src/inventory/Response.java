package inventory;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author SamJay
 */
public class Response {

    private static Scanner in = new Scanner(System.in);

    public Response() {

    }

    public void respondToUserChoice() {
        Scanner in = new Scanner(System.in);
        try {
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    register();
                    break;
                }
                case 2: {
                    addToCart();
                    break;
                }
                case 3: {
                    removeProduct();
                    break;
                }
                case 4: {
                    viewProducts();
                    break;
                }
                case 5: {
                    checkOut();
                    break;
                }
                case 6: {
                    getHelp();
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    clearData();
                    break;
                }
                default: {
                    System.out.print("invalid choice. Try again: ");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("invalid input");

        }
    }

    //register product
    public void register() {
        int maxProductsTobeRegistered = 5;
        System.out.print("enter number of products you want to register for sale:");
        int numberOfProductsToRegister = in.nextInt();
        if (numberOfProductsToRegister > maxProductsTobeRegistered) {
            JOptionPane.showMessageDialog(null, "Sorry! Only a maximum of 5 products can be registered");
            return;
        } if(numberOfProductsToRegister<1){
             JOptionPane.showMessageDialog(null, "should be atleast 1");
            
        }
            int count = 0;
            while (count < numberOfProductsToRegister) {
                Product product = new Product();
                count++;
            
        }

    }

    //buy product
    public static void addToCart() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter productName: ");
        String name = in.nextLine();
        new DbConnector().addToCart(name);

    }

    //remove product
    public static void removeProduct() {
        System.out.println("enter item to delete: ");
        String item = in.nextLine();
        new DbConnector().deleteItem("Cart", item);
    }

    //view products
    public static void viewProducts() {
        System.out.println("\t\t--------------------------------"
                + "\n\t\t        PRODUCTS AVAILABLE             "
                + "\n\t\t________________________________\n");
        new DbConnector().getData("Products");

    }

    //check out
    public static void checkOut() {
        System.out.println("\t\t--------------------------------"
                + "\n\t\t        PRODUCTS BOUGHT            "
                + "\n\t\t________________________________\n");
        new DbConnector().getData("Cart");
        new DbConnector().deleteAllData("Cart");
    }

    //get help
    public static void getHelp() {
        JOptionPane.showMessageDialog(null, "Call 0798114462");
    }

    public static void clearData() {
        new DbConnector().deleteAllData("Products");
    }

}
