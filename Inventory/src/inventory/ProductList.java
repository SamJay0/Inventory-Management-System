package inventory;

import java.util.Map;

/**
 * @author SamJay
 */
public class ProductList {

    Product[] listOfProducts;
    Map<String,Product>listOfProductss;

    //default constructor
    public ProductList() {
        
    }
    public  void createListOfProductsRegistered(){
        int count=0;
        for(int i=0;i<5;i++){
         listOfProducts[i]=new Product();
        System.out.println(listOfProducts[i].toString());
        }
        
        
    }

    //non-default constructor
    public ProductList(Product[] listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    /*
    *setters
     */
    public void setListOfProducts(Product[] listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    /*
    *getters
     */
    public Product[] getListOfProducts() {
        return listOfProducts;
    }

    //display
    @Override
    public String toString() {
        return "";
    }
    public static void main(String[] args){
        ProductList list=new ProductList();
        list.createListOfProductsRegistered();
        
    }

}
