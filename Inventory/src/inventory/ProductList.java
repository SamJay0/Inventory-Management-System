package inventory;


/**
 * @author SamJay
 */
public class ProductList {

    Product[] listOfProducts;

    //default constructor
    public ProductList() {

    }

    public void createListOfProductsRegistered(Product[] products) {

        listOfProducts = products;

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

//    public static void main(String[] args) {
//        ProductList list = new ProductList();
//        list.createListOfProductsRegistered();
//        for (int i = 0; i < 2; i++) {
//            System.out.println(list.listOfProducts[i].toString());
//        }

//    }

}
