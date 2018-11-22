package inventory;


/**
 * @author SamJay
 */
public class ProductList {

    Product[] listOfProducts;

    //default constructor
    public ProductList() {

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


}
