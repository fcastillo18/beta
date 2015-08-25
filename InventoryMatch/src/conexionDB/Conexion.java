/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;

import ClassesReception.MainControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author fcastillo
 */
public class Conexion {
   static Connection conexion = null; 
    
   public Connection createConnection(){
       
       String url = "jdbc:sqlserver://servert605:1024;databaseName=RepHoras";
       
       try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       }catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos "+e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
       }
       
       try {
           conexion = DriverManager.getConnection(url, "as", "as");
           System.out.println("Se conecto correctamente a la base de datos");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error "+ ex.getSQLState() + "---"+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
          ex.printStackTrace();
          
       }

       
        return conexion;
   }
   
   public Connection createConnection(Properties properties){
              
       try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       }catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos "+e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
       }
       
       try {
           conexion = DriverManager.getConnection(properties.getProperty("database"), properties.getProperty("user"), properties.getProperty("pass"));
           System.out.println("Se conecto correctamente a la base de datos");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error "+ ex.getSQLState() + "---"+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
          ex.printStackTrace();
          
       }

       
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
