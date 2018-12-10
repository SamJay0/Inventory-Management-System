package inventory;

import java.util.Scanner;

/**
 * @author SamJay
 */
public class MyInventory {
   
    private static Scanner in=new Scanner(System.in);

    //enterchoice()
    public static void enterChoice() {
        UserOptions options = new UserOptions();
        options.printChoices();
    }

    //response
    public static void respond() {
        Response response = new Response();
        response.respondToUserChoice();
    }

    //main method
    public static void main(String[] args) {
System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "\tWelcome to the Simple Inventory Management System\n"
                + "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "\nPlease Select from the following options\n");
        boolean startTransaction;
        do {   
            enterChoice();
            respond();
            System.out.print("want to Quit? \"Y/N\":  ");
            char choice=in.nextLine().toUpperCase().charAt(0);
            System.out.println();
            startTransaction=(choice=='N');
            
        } while (startTransaction);
//connect.deleteAllData("Product");

    }

}
