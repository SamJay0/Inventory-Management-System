package inventory;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
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

    //non-default contructor
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
        Random rand = new Random();
        System.out.print("Enter ProductName: ");
        this.name = scan.nextLine();
        System.out.print("Enter Description: ");
        this.desc = scan.nextLine();
        System.out.print("Enter Price: ");
        try {
            this.price = scan.nextDouble();
        } catch (InputMismatchException e) {
//            System.out.println("price should be in figures!!. ");
            return;
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
        System.out.println("Enter productName: ");
        return in.nextLine();
    }

    //set description
    public String setDesc() {
        System.out.println("Enter productName: ");
        return in.nextLine();
    }

    //sePrice
    public int setPrice(double price) {
        System.out.println("Enter productName: ");
        return in.nextInt();
    }

    //set minQty to order
    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
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

//    ///display
//    public void display(){
//        Product product=new Product();
//        System.out.println("ProductName: "+name+" \ndescription: "+desc
//                +" \nprice: $"+price+" \nminOrder: "+minOrderQty+" items");
//    }
    @Override
    public final String toString() {
        return "\tProductName: " + name + " \n\tDescription: " + desc + " \n\tPrice $" + price
                + "\n\tQuantityOnHand: " + qtyOnHand + " items \n\tminOrder: " + minOrderQty + " items\n";
    }

//    public static void main(String[] args) {
//        Map<Integer, Product> listOfProductss = new HashMap<>();
//        for (int i = 0; i < 2; i++) {
//            Product product = new Product();
////             System.out.println(product.name);
//            listOfProductss.put(i, product);
//        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println(listOfProductss.get(i).toString());
//        }
//
//    }

}
