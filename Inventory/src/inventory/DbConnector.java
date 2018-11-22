
package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author samjay
 */
public class DbConnector {
    private Connection con;
    private ResultSet rslt;
    private Statement st;
    
    public  DbConnector() {
     
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "");
            st=con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e);
            
        }
    }
    public void getData(){
        try{
            String querry="Select * from Products";
            rslt=st.executeQuery(querry);
            System.out.println("\t\t--------------------------------"
                                   + "\n\t\t        PRODUCTS AVAILABLE             "
                                   + "\n\t\t________________________________\n");
            
            System.out.println("Name\tDescription\tPrice\tQuantityAtHand\tMinOrderQuantity");
            while(rslt.next()){
                System.out.println(rslt.getString("Name")+"\t"+rslt.getString("Description")+"\t"+rslt.getInt("Price")+""
                        + "\t\t"+rslt.getInt("QuantityAtHand")+"\t\t"+rslt.getInt("MinOrderQuantity"));
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
            
        }
    }
    public void insertData(){
       
        try {
            String querry="INSERT INTO 'Products' ( Name, Description, Price, QuantityAtHand, MinOrderQuantity) VALUES ( 'Chocolate', 'sweet', '45', '3', '5')";
          st.executeUpdate(querry);
            System.out.println("data inserted successfully");
        } catch (SQLException ex) {
        System.out.println();
        }
        
    }
    public void removeData(){
        
    }
 
}
