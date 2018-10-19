package inventory;

import java.util.InputMismatchException;
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

    //non-default contructor
    public Product(String name,String desc,double price,int qtyOnHand,int minOrderQty) {
        this.name=name;
        this.desc=desc;
        this.price=price;
        this.qtyOnHand=qtyOnHand;
        this.minOrderQty=minOrderQty;
    }

    //default constructor
    public Product() {
//        boolean mismatch=false;
        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
       System.out.print("Enter ProductName: ");
        this.name =scan.nextLine();
         System.out.print("Enter Description: ");
        this.desc =scan.nextLine();
         System.out.print("Enter Price: ");
         try{
        this.price = scan.nextDouble();
         }catch(InputMismatchException e){
            System.out.println("price should be in figures!!.Enter price again: ");
            this.price=scan.nextDouble();
         }
         RandomNumberGenerator randomgen=new RandomNumberGenerator();
        //generate qty on hand
        this.qtyOnHand=randomgen.setMaxValue();
        //generate random number for min OrderQuantity
        this.minOrderQty =randomgen.setMinValue();
        System.out.println(toString());
        
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
    
    public int getqtyOnHand(){
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
    public final  String toString() {
        return "\tProductName: " + name + " \n\tDescription: " + desc + " \n\tPrice $" + price
                +"\n\tQuantityOnHand: "+qtyOnHand+ " items \n\tminOrder: " + minOrderQty + " items";
    }
//    public static void main(String[] args){
//        Product product=new Product();
//    }

}
