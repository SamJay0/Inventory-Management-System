package inventory;

/**
 * @author SamJay
 */
public class UserOptions {

    public UserOptions() {
    }

    public void printChoices() {
        //enterchoice()
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
    }
}
