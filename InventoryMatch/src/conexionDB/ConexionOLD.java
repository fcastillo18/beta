/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin
 */
public class ConexionOLD {

   static Connection conexion = null; 
    
   public Connection createConnection(){
       
       String url = "jdbc:sqlserver://localhost:1433;databaseName=CuadreInventario";
       
       try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       }catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos "+e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
       }
       
       try {
           conexion = DriverManager.getConnection(url, "sa", "sa");
           System.out.println("Se conecto correctamente a la base de datos");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error "+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
       }
//       finally{
//           if (conexion != null) {
//               try {
////                   conexion.close();
//               } catch (SQLException ex) {
//                   
//               }
//           }
//       }
       
    return conexion;
   }
   public static Connection getConnection(){
   
       return conexion;
   }
   
   public static void closeConnection(){
       try {
           conexion.close();
       } catch (SQLException ex) {
           //
       }
   }
   
   //to read from the database
    public ResultSet queryToDB(String query) throws SQLException{
    
        Connection con = getConnection();
        ResultSet result = null;
        Statement statement;
        statement = con.createStatement();
        try {
            result = statement.executeQuery(query);
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        finally{
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        
    }

}
