package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author samjay
 */
public class DbConnector {

    private Connection con = null;
    private PreparedStatement prst = null;
    private ResultSet rslt;
    private Statement st;

    public DbConnector() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);

        }
    }

    public void getData(String table) {
        try {
            String querry = "Select * from " + table;
            rslt = st.executeQuery(querry);
            System.out.println("\t\t--------------------------------"
                    + "\n\t\t        PRODUCTS AVAILABLE             "
                    + "\n\t\t________________________________\n");

//            System.out.println("Name\tDescription\tPrice\tQuantityAtHand\tMinOrderQuantity");
            int count = 1;
            while (rslt.next()) {
                System.out.println("++++++++++\n"
                        + "PRODUCT " + count + "\n"
                        + "++++++++++");
                System.out.println("\tName: " + rslt.getString("Name") + "\n\tDescription: " + rslt.getString("Description") + "\n\tPrice: " + rslt.getInt("Price") + ""
                        + "\n\tQuantityAtHand: " + rslt.getInt("QuantityAtHand") + "\n\tMinOrderQuantity: " + rslt.getInt("MinOrderQuantity") + "\n");
                count++;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
    }

    public void insertData(String table, String name, String description, double price, int quantityAtHand, int minOrderQuantity) {

        try {
            String querry = "Insert into Products  values ( ?,?,?,?,?,?)";
            prst = con.prepareStatement(querry);
            prst.setInt(1, 0);
            prst.setString(2, name);
            prst.setString(3, description);
            prst.setDouble(4, price);
            prst.setInt(5, quantityAtHand);
            prst.setInt(6, minOrderQuantity);

            prst.executeUpdate();
            con.close();
            System.out.println("data inserted successfully");
        } catch (SQLException ex) {
            System.out.println("problem encountered");
        }

    }

    public void deleteData(String table, int name) {
        try {
            String querry = "delete from Products where ID=" + name;
            st.executeUpdate(querry);
            JOptionPane.showMessageDialog(null, "deletion successful");
        } catch (SQLException e) {

        }

    }

    public void getItem(String item) {
        try {
            String querry="select * from Products where name="+item;
            rslt=st.executeQuery(querry);
            System.out.println("good");
        } catch (Exception e) {
            System.out.println("ni ufala");
        }
    }

}
