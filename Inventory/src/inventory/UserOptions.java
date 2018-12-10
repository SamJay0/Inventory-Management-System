package inventory;

/**
 * @author SamJay
 */
public class UserOptions {

    public UserOptions() {
    }

    public void printChoices() {
        //enterchoice()
        System.out.print(
                    "\tPress 1 to Register a product for sale\n"
                + "\tPress 2 to Add  product to the Cart\n"
                + "\tPress 3 to Remove a product from cart\n"
                + "\tPress 4 to View all Available Products\n"
                + "\tPress 5 to Check out\n"
                + "\tPress 6 to Get help\n"
                + "\tPress 8 to Clear prodList\n"
                + "\tPress 9 to update product\n"
                + "\tPress 7 to Exit\n"
                + "\nPlease enter your choice: ");
    }
}
