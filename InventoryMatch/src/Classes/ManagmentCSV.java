/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Views.MainView;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author fcastillo
 */
public class ManagmentCSV {
    
    List<Items> listItems;
    List<Items> listInventory = new ArrayList<>();
    List<Items> listConsumption = new ArrayList<>();
    List<Items> listShopping = new ArrayList<>();
    List<Object> listFinalIventory;
    
    
    Items item = null;
    
    public void readCSV(String fileCsv, String fileName){
        listItems = new ArrayList<>();
        try {
            CsvReader itemsImport = new CsvReader(fileCsv);
            itemsImport.readHeaders();//con este metodo se elimina el primer registro de la tabla (la barra de titulo)
            
            while(itemsImport.readRecord()){
                item = new Items();
                item.setCodigo(itemsImport.get(0));
                item.setDescripcion(itemsImport.get(1));
                item.setCantidad(itemsImport.get(2));
                item.setCosto(itemsImport.get("Costo"));
                listItems.add(item);
            }
            itemsImport.close();
            
//            for (Items item1 :  listItems) {
//                System.out.println(item1.getCodigo() + " : " + item1.getDescripcion() + " : " + item1.getCantidad() +item1.getCosto());
//            }
        }
        catch (Exception ex){
            ex.getMessage();
        }
        //to save the data into List, later in a database
        switch(fileName) {
        
        case "Existencia":
            for (Items items : listItems) {
                listInventory.add(items);
            }
            break;
        case "Consumo":
            for (Items items : listItems) {
                listConsumption.add(items);
            }
            break;
        case "Compras":
            for (Items items : listItems) {
                listShopping.add(items);
            }
            break;
            
        default:
            
    }
    
    }
    
    public DefaultTableModel getTableModelToJRB(String jrbName){
        String [][] data = {};
        String [] columns = {"Codigo", "Descripcion", "Cantidad", "Costo"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        //to delete the columns and rows from the old table
//                model.setColumnCount(0);
        model.setRowCount(0);
        List<Items> listItemInter = new ArrayList<Items>();
        switch (jrbName){
        
            case "inventory":
                listItemInter = listInventory;
            break;
                
            case "consumptions":
                listItemInter = listConsumption;
            break;    
                    
            case "shopping":
                listItemInter = listShopping;
            break;    
        }
 
        for (int i = 0; i < listItemInter.size(); i++) {
            Object [] row= {listItemInter.get(i).getCodigo(), listItemInter.get(i).getDescripcion(), listItemInter.get(i).getCantidad(), listItemInter.get(i).getCosto()};
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel getTableModel(){        
        String [][] data = {};
        String [] columns = {"Codigo", "Descripcion", "Cantidad", "Costo"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        //to delete the columns and rows from the old table
//                model.setColumnCount(0);
        model.setRowCount(0);
        while(model.getRowCount()>0)model.removeRow(0);
        for (int i = 0; i < listItems.size(); i++) {
            Object [] row= {listItems.get(i).getCodigo(), listItems.get(i).getDescripcion(), listItems.get(i).getCantidad(), listItems.get(i).getCosto()};
            model.addRow(row);
        }
//        other way to make
//        Object [] row=new Object[4];
//        for (int i = 0; i < listItems.size(); i++) {
//            row[0] = listItems.get(i).getCodigo();
//            row[1] = listItems.get(i).getDescripcion();
//            row[2] = listItems.get(i).getCantidad();
//            row[3] = listItems.get(i).getCosto();
//            model.addRow(row);
//        }
        
        return model;
    
    }
   //Create a method that return a model but, from a database
    public DefaultTableModel getTableModelDB(ResultSet result){
        String [][] data = {};
        String [] columns = {"Codigo", "Descripcion", "Cantidad", "Costo"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        model.setRowCount(0);
        try {
            while(result.next()){
                Object [] row = {result.getString(1), result.getString(2), result.getString(3), result.getString(4)};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("error al leer datos");
        }
    return model;
    }
    
    //to read from the database
     public ResultSet queryToDB(String query) throws SQLException{
    
        ResultSet result;
//        statement = con.preparedStatement();
        try {
            PreparedStatement statement = Conexion.getConnection().prepareStatement(query);
            result = statement.executeQuery();
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
//        finally{
//            if (result != null) {
//                result.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//        }

    }
     public ResultSet readDataFromDB(){
        ResultSet result = null;
        try {
            CallableStatement ctm = Conexion.getConnection().prepareCall("{call sp_viewFinalInventory}");
            result = ctm.executeQuery();
            System.out.println("Datos INV Cargados");
        } catch (SQLException ex) {
            System.out.println("Error al leer Inventario final de la base de datos");
        }
        return result;
     }
     
     public void executeProcedure(String tableName, String date){
        boolean resultVal;
        
                try {
                    for (Items itemInv : listInventory) {
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertInventory(?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setInt(3, Integer.parseInt(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
//                        ResultSet resultSet = callStm.executeQuery();
                        resultVal = callStm.executeUpdate() > 0;
                    }
                    System.out.println("Datos de Existencia almacenados por Store Procedured");
                } catch (SQLException ex) {
                    System.out.println("Error al exportar datos de inventario "+ex.getMessage());
                    ex.printStackTrace();
                }
                
                try {
                    for (Items itemInv : listConsumption) {
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertConsumptions(?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setInt(3, Integer.parseInt(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
//                        ResultSet resultSet = callStm.executeQuery();
                        resultVal = callStm.executeUpdate() > 0;
                    }
                    System.out.println("Datos de Consumo almacenados por Store Procedured");
                } catch (SQLException ex) {
                    System.out.println("Error al exportar datos de Consumo "+ex.getMessage());
                    ex.printStackTrace();
                }
                
                try {
                    for (Items itemInv : listShopping) {
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertShopping(?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setInt(3, Integer.parseInt(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
//                        ResultSet resultSet = callStm.executeQuery();
                        resultVal = callStm.executeUpdate() > 0;
                    }
                    System.out.println("Datos de Compras almacenados por Store Procedured");
                } catch (SQLException ex) {
                    System.out.println("Error al exportar datos de Compras "+ex.getMessage());
                    ex.printStackTrace();
                }
         
     }
     
     public void insertToDB(String tableName){
         
         ResultSet result;
         for (Items item1 : listInventory) {
             try {
                PreparedStatement stm = Conexion.getConnection().prepareStatement
                ("insert into "+ tableName + "(codigo, descripcion, cantidad, costo)"+ " values (?, ?, ?, ?)");
                stm.setString(1, item1.getCodigo());
                stm.setString(2, item1.getDescripcion());
                stm.setInt(3, Integer.parseInt(item1.getCantidad()));
                stm.setFloat(4, Float.parseFloat(item1.getCosto()));
                stm.executeUpdate();
//                stm.execute();
                 System.out.println("Registros insertados");
             } 
             catch (SQLException ex) {
                 Logger.getLogger(ManagmentCSV.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
}
