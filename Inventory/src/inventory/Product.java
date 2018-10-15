package inventory;

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
    ;int minOrderQty;

    //default contructor
//    public Product() {
//    }

    //non-default constructor
    public Product() {
        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
       System.out.print("Enter ProductName: ");
        this.name =scan.nextLine();
         System.out.print("Enter Description: ");
        this.desc =scan.nextLine();
         System.out.print("Enter Price: ");
        this.price = scan.nextDouble();
        //generate random number for min OrderQuantity
        this.minOrderQty =Math.abs((rand.nextInt()%5)+1);
    }

    /*
    *setters
     */
    //set productName
    public void setName(String name) {
        this.name = name;
    }

    //set description
    public void setDesc(String desc) {
        this.desc = desc;
    }

    //sePrice
    public void setPrice(double price) {
        this.price = price;
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
    public String toString() {
        return "\tProductName: " + name + " \n\tDescription: " + desc + " \n\tPrice $" + price
                + " \n\tminOrder: " + minOrderQty + " items";
    }

}
