package inventory;


/**
 * @author SamJay
 */
public class MyInventory {

    //enterchoice()
    public static void enterChoice() {
      UserOptions options=new UserOptions();
      options.printChoices();
    }
    //response
    public static void respond(){
      Response response=new Response();
      response.respondToUserChoice();
    }
    //main method
    public static void main(String[] args) {
        enterChoice();
        respond();

    }

}
