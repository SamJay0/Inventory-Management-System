package inventory;

import java.util.Scanner;

/**
 * @author SamJay
 */
public class MyInventory {

    //enterchoice()
    public static void enterChoice() {
        System.out.print("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "\tWelcome to the Simple Inventory Management System\n"
                + "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "Please Select from the following options\n"
                + "\tPress 1 to Register a product for sale\n"
                + "\tPress 2 to Buy a product to the Cart\n"
                + "\tPress 3 to Remove a product from cart\n"
                + "\tPress 4 to View all Available Products\n"
                + "\tPress 5 to Check out\n"
                + "\tPress 6 to Get help\n"
                + "\tPress 7 to Exit"
                + "\nPlease enter your choice: ");
        userChoice();

    }
    
    //options
    public static void userChoice() {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 7) {
            return;
        }
        switch (choice) {
            case 1: {
                register();
                break;
            }
            case 2: {
                buyProduct();
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
            default: {
                System.out.print("invalid choice. Try again: ");
               userChoice();
                break;
            }
        }
    }

    //register product
    public static void register() {
        Product product = new Product();
        System.out.println("\n" + product);
    }

    //buy product
    public static void buyProduct() {
        System.out.println("buy product");
    }

    //remove product
    public static void removeProduct() {
        System.out.println("remove products");
    }

    //view products
    public static void viewProducts() {
        System.out.println("view products");
    }

    //check out
    public static void checkOut() {
        System.out.println("checkout");
    }

    //get help
    public static void getHelp() {
        System.out.println("Help");
    }

    //main method
    public static void main(String[] args) {
        enterChoice();

    }

}
