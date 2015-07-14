/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInventory;

import ClassesReception.MainControl;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin
 */
public class InventoryMatch {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        ManagmentCSV manCsv = new ManagmentCSV();
//        Timestamp tm = new java.util.Date().getTime();
        System.out.println(MainControl.getCurrentTimeStamp().toString());
//        manCsv.readCSV("C:\\Users\\Franklin\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program\\Existencia CSV.csv");
//    Conexion con = new Conexion();
//    con.getConnection();
//        try {
//            ResultSet result = manCsv.queryToDB("select * from Inventory");
//            while (result.next()) {
//              String data = result.getString(1)+ " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4);
//              System.out.println(data);
//}
//        } catch (SQLException ex) {
//            System.out.println("Error al leer datos" + ex.getMessage());
//            ex.printStackTrace();
//        }
    }
    
 /*
 Lo unico que tienes que hacer es obtener la columna que quieras editar de tu tabla y cambiarle el tamaño:
1. TableColumn columna = tabla.getColumn;
2. columna .setPreferredWidth(320);
    
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
    
    
    Si quieres darle un tamaño fijo e idéntico a cada columna, puedes hacer ésto:

TableColumnModel columnModel = tabla.getColumnModel();
for (int i = 0; i < columnModel.getColumnCount(); i++) {
columnModel.getColumn(i).setPreferredWidth(200);
}

Si lo que quieres es darle un tamaño diferente a cada columna, solo tienes que escribir más código:

TableColumnModel columnModel = tabla.getColumnModel();
columnModel.getColumn(2).setPreferredWidth(200);
columnModel.getColumn(4).setPreferredWidth(100);

Y así sucesivamente.


    
    
 */   
}
