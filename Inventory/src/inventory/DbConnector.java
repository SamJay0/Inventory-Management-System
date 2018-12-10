package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author samjay
 */
//create connection on class instantiation
public class DbConnector {

    private Connection con = null;
    private PreparedStatement prst = null;
    private ResultSet rslt;
    private Statement st;
    private String querry;


    private Scanner in = new Scanner(System.in);

    public DbConnector() {

        try {
          
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);

        }
    }

    //get data from database
    public void getData(String table) {
        try {
            querry = "Select * from " + table;
            rslt = st.executeQuery(querry);

//            System.out.println("Name\tDescription\tPrice\tQuantityAtHand\tMinOrderQuantity");
            int count = 0;
            double totalCost = 0;
            while (rslt.next()) {
                System.out.println("++++++++++\n"
                        + "PRODUCT " + (count + 1) + "\n"
                        + "++++++++++");
                if (table.equals("Products")) {
                    System.out.println("\tName: " + rslt.getString("Name") + "\n\tDescription: " + rslt.getString("Description") + "\n\tPrice: " + rslt.getInt("Price") + ""
                            + "\n\tQuantityAtHand: " + rslt.getInt("QuantityAtHand") + "\n\tMinOrderQuantity: " + rslt.getInt("MinOrderQuantity") + "\n");
                } else {
                    System.out.println("\tName: " + rslt.getString("Name") + "\n\tDescription: " + rslt.getString("Description") + "\n\tPrice: " + rslt.getInt("Price") + ""
                            + "\n\tQuantityBought: " + rslt.getInt("QuantityBought") + "\n\tTotal: " + rslt.getDouble("Total") + "\n");
                    totalCost += rslt.getDouble("Total");

                }
                count++;

            }
            if (table.equals("Cart") && totalCost < 0) {
                System.out.println("TotalCost: ksh" + totalCost);
            }

            double pay, balance;

            if (totalCost > 0) {
                System.out.print("Pay ksh." + totalCost);
                System.out.print("Enter amount to pay: ");
                pay = in.nextDouble();
                balance = totalCost - pay;
                if (pay >= totalCost) {
                    System.out.println();
                    JOptionPane.showMessageDialog(null, "Your payment of " + pay + " has been received.Balance" + balance);

                } else {
                    System.out.println("the amount you paid is less");
                    return;
                }
            }
            if (count == 0) {
                System.out.println("\t**** No produtcs yet****\n");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);

        } finally {
            try {
                rslt.close();
            } catch (Exception e) {
            }
        }
    }

    //insert data into database
    public void insertDataToProducts(String name, String description, double price, int quantityAtHand, int minOrderQuantity) {

        try {
            querry = "Insert into Products values ( ?,?,?,?,?,?)";
            prst = con.prepareStatement(querry);
            prst.setInt(1, 0);
            prst.setString(2, name);
            prst.setString(3, description);
            prst.setDouble(4, price);
            prst.setInt(5, quantityAtHand);
            prst.setInt(6, minOrderQuantity);

            prst.executeUpdate();
            JOptionPane.showMessageDialog(null, name + " added to Products");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, name + " could be existing already ");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }

    public void insertDataToCart(String name, String description, double price, int quantityOrdered, double total) {

        try {
            querry = "Insert into Cart  values ( ?,?,?,?,?,?)";
            prst = con.prepareStatement(querry);
            prst.setInt(1, 0);
            prst.setString(2, name);
            prst.setString(3, description);
            prst.setDouble(4, price);
            prst.setInt(5, quantityOrdered);
            prst.setDouble(6, total);

            prst.executeUpdate();
            JOptionPane.showMessageDialog(null, name + " added to Cart");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, name + " could be existing already ");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }

    }

    public void deleteAllData(String table) {
        try {
            querry = "delete  from " + table;
            st.executeUpdate(querry);
            if (table.equals("Cart")) {
//                JOptionPane.showMessageDialog(null, "check out succefull");
            } else {
                JOptionPane.showMessageDialog(null, "All data from  " + table + " cleared");
            }

        } catch (SQLException e) {
            System.out.println("Error" + e);

        }

    }

    //delete single item from database
    public void deleteItem(String table, String name) {
        try {
            querry = "delete from " + table + "  where name=" + "\"" + name + "\"";
            st.executeUpdate(querry);
            JOptionPane.showMessageDialog(null, "deletion successful");
        } catch (Exception e) {
            System.out.println("Error: " + e);

        }

    }

    //get an item from database
    public void addToCart(String item) {
        String name, description;
        double price, total;
        int minOrderQuantity, quantityAtHand, quantityOrdered;
        System.out.print("enter quantity: ");
        quantityOrdered = in.nextInt();
        try {
            querry = "select * from  Products where name=" + "\"" + item + "\"";
            rslt = st.executeQuery(querry);
            while (rslt.next()) {
                name = rslt.getString("Name");
                description = rslt.getString("Description");
                price = rslt.getDouble("Price");
                quantityAtHand = rslt.getInt("QuantityAtHand");
                minOrderQuantity = rslt.getInt("MinOrderQuantity");
                //check 
                if (minOrderQuantity <= quantityAtHand && quantityAtHand >= quantityOrdered) {
                    total = quantityOrdered * price;
                    
                    //add to cart
                    insertDataToCart(name, description, price, quantityOrdered, total);
                    
                    //update quantity
//                    updateQuantity(name, quantityAtHand, quantityOrdered);
                    
                } else {
                    if (minOrderQuantity < quantityAtHand) {
                        JOptionPane.showMessageDialog(null, "Quantity at Hand is less than the minimum order quantity");
                    }
                    if (quantityOrdered > quantityAtHand) {
                        JOptionPane.showMessageDialog(null, "Oops! Only  " + quantityAtHand + " left.");
                    }
                    if (quantityOrdered<minOrderQuantity) {
                        JOptionPane.showMessageDialog(null,  minOrderQuantity + " is the minimum Order Quantity");
                    }
                    return;
                }

            }
        } catch (Exception e) {
//            System.out.println("Error: " + e);
        } finally {
            try {
                rslt.close();
            } catch (Exception e) {
            }
        }
    }

    private void KeepIdToDate(String table) {
        try {
            querry = "Select * from " + table;
            rslt = st.executeQuery(querry);
            int count = 1;
            while (rslt.next()) {
                int id = rslt.getInt("ID");
                System.out.println(id);
                updateID(id, count);
                count++;
            }
            JOptionPane.showMessageDialog(null, "Ids updated");

        } catch (Exception e) {
            System.out.println("Error " + e);
        } finally {
            try {
                rslt.close();

            } catch (Exception e) {
            }
        }

    }

    public void updateID(int oldID, int newID) {
        try {
            querry = "update Products set ID=" + newID + " where ID=" + oldID;
            st.executeUpdate(querry);
            JOptionPane.showMessageDialog(null, "updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateQuantity(String name, int quantityAtHand, int quantityOrdered) {
        try {
            querry = "update Products set QuantityAtHand=" + (quantityAtHand - quantityOrdered) + " where name=" + name;
            st.executeUpdate(querry);
            JOptionPane.showMessageDialog(null, "Quantity updated");

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            
        }

    }

}
