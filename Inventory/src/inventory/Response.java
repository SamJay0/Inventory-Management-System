package inventory;

import java.util.Scanner;

/**
 * @author SamJay
 */
public class Response {

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
    public void repeatChoice() {
    }

    public void register() {
//        int count = 0;
//        Product[] products = new Product[2];
//        while (count < products.length) {
//            products[count] = new Product();
//            count++;
//        }
//        System.out.println("\t\t\t*******************************\n"
//                + "\t\t\tPRODUCTS REGISTERED FOR SALE\n"
//                + "\t\t\t*******************************");
//        for (int i = 0; i < products.length; i++) {
//            System.out.println("__________\n"
//                    + "Product " + (i + 1) + ":\n"
//                    + "----------");
//            System.out.print(products[i]);
//        }
        int maxProductsTobeRegistered = 2;
        int count = 0;
        while (count < maxProductsTobeRegistered) {
            Product product = new Product();
            count++;
        }

    }

    //buy product
    public static void addToCart() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter productName: ");
        String name=in.nextLine();
        
    }

    //remove product
    public static void removeProduct() {
        System.out.println("remove products");
    }

    //view products
    public static void viewProducts() {
        new DbConnector().getData("Products");

    }

    //check out
    public static void checkOut() {
        System.out.println("checkout");
    }

    //get help
    public static void getHelp() {
        System.out.println("Help");
    }

}
