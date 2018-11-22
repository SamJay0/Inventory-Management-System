package inventory;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author SamJay
 */
public class Product {

    String name;
    String desc;
    double price;
    int qtyOnHand;
    int minOrderQty;
    private Scanner in = new Scanner(System.in);

    //non-default constructor
    public Product(String name, String desc, double price, int qtyOnHand, int minOrderQty) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.minOrderQty = minOrderQty;
    }

    //default constructor
    public Product() {
//        boolean mismatch=false;
        Scanner scan = new Scanner(System.in);
        this.name = setName();
        this.desc = setDesc();
        try {
            this.price =setPrice();
        } catch (InputMismatchException e) {
            System.out.println("\t oops!check price!");
        }
        RandomNumberGenerator randomgen = new RandomNumberGenerator();
        //generate qty on hand
        this.qtyOnHand = randomgen.setMaxValue();
        //generate random number for min OrderQuantity
        this.minOrderQty = randomgen.setMinValue();
        System.out.println();
    }

    /*
     *setters
     */
    //set productName
    public String setName() {
        System.out.print("Enter productName: ");
        return in.nextLine();
    }

    //set description
    public String setDesc() {
        System.out.print("Enter product Description: ");
        return in.nextLine();
    }

    //sePrice
    public int setPrice() {
        System.out.print("Enter price: ");
        return in.nextInt();
    }

    /*
     *getters
     */
    //get productName
    public String getName() {
        return name;
    }

    public int getqtyOnHand() {
        return qtyOnHand;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    public final String toString() {
        DecimalFormat format = new DecimalFormat("#0.00");
        return "\tProductName: " + name + " \n\tDescription: " + desc + " \n\tPrice $" + format.format(price)
                + "\n\tQuantityOnHand: " + qtyOnHand + " items \n\tminOrder: " + minOrderQty + " items\n";
    }

}
