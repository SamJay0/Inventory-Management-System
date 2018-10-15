package inventory;

import java.util.Arrays;

/**
 * @author SamJay
 */
public class SalesTransaction {

    //class variables
    int saleCode;
    Product[] items;
    double totalCost;

    // default constructor
    public SalesTransaction() {

    }

    //non default constructor;
    public SalesTransaction(int saleCode, Product[] items, double totalCost) {
        this.saleCode = saleCode;
        this.items = items;
        this.totalCost = totalCost;
    }

    /*
    *getters
     */
    //get Sale code
    public int getSaleCode() {
        return saleCode;
    }

    //get items
    public Product[] getItems() {
        return items;
    }

    //get total Cost
    public double gettotalCost() {
        return totalCost;
    }

    /*
    *setters
     */
    //set SaleCode
    public void setSaleCode(int salesCode) {
        // should be generated randomly
        this.saleCode = salesCode;
    }

    //set items
    public void setItems(Product[] items) {
        this.items = items;
    }

    //set cost
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    //display
    @Override
    public String toString() {
        return "Code: " + saleCode + "Products: " + Arrays.toString(items) + "totalCost: " + totalCost;
    }

}
