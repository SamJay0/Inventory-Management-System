package inventory;

/**
 * @author SamJay
 */
public class Sale {

    ProductList prodList;
    SalesTransaction transaction;

    //default constructor
    public Sale() {
    }

    //non-default
    public Sale(ProductList prodList, SalesTransaction transaction) {
        this.prodList = prodList;
        this.transaction = transaction;
    }

    /*
    *setters
     */
    public void setProdList(ProductList prodList) {
        this.prodList = prodList;
    }

    public void setTransaction(SalesTransaction transaction) {
        this.transaction = transaction;
    }

    /*
    *getters
     */
    public ProductList getProdList() {
        return prodList;
    }

    public SalesTransaction getTransaction() {
        return transaction;
    }

    //display
    @Override
    public String toString() {
        return "";
    }

}
