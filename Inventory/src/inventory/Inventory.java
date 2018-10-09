package inventory;
/**
 * @author SamJay
 */
public class Inventory {
    
    //user choice
    public static void enterChoice(){
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "\tWelcome to the Simple Inventory Management System\n"
                + "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"
                + "Please Select from the following options\n"
                + "Press 1 to Register a product for sale\n"
                + "Press 2 to Buy a product to the Cart\n"
                + "Press 4 to view all Available Products\n"
                + "Press 5 to check out\n"
                + "Press 7 to exit");
    }

    public static void main(String[] args) {
        enterChoice();
        
    }

}
