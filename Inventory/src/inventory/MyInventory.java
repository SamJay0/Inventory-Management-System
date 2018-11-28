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

//        enterChoice();
//        respond();
        DbConnector connect = new DbConnector();
//        connect.insertData("salad","hot",35,6,2);
//connect.getData();
//connect.deleteData(0);
        connect.getItem("juice");
        boolean startTransaction;
        do {   
            enterChoice();
            respond();
            System.out.print("enter Y to continue and any other letter to exit: ");
            char choice=in.nextLine().toUpperCase().charAt(0);
            startTransaction=(choice=='Y');
            
        } while (startTransaction);

    }

}
