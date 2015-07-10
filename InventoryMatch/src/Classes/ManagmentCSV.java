/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Views.MainViewOBSOLETO;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.AbstractList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
    public float finalCost;
    public Double costInv;
    public Double costSho;
    public Double costCom;
    
    private static int idRow = 0;
    
    Items item = null;
    
    //en este metodo se leera un CSV, ser archivaran los valores en una lista para cada caso (compras, ventas, existencia)
    //y Luego 
    public void readCSV(String fileCsv, String fileName){
        listItems = new ArrayList<>();
        try {
            CsvReader itemsImport = new CsvReader(fileCsv);
            itemsImport.readHeaders();//con este metodo se elimina el primer registro de la tabla (la barra de titulo)
            consultLastItemID();
            while(itemsImport.readRecord()){
                item = new Items();
                item.setCodigo(itemsImport.get(0));
                item.setDescripcion(itemsImport.get(1));
                item.setCantidad(itemsImport.get(2));
                item.setCosto(itemsImport.get("Costo"));
                item.setIdRow(getLastItemID()+1);
                listItems.add(item);
                System.out.println(item.getCosto());
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
    public DefaultTableModel getTableModelDB(ResultSet result) throws SQLException{
        String [][] data = {};
        String [] columns = {"Codigo", "Descripcion", "Cantidad", "Costo"};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        model.setRowCount(0);
        String fecha = "";
        finalCost = 0;
        DecimalFormat df = new DecimalFormat("###,###,##0.000");
        //OJO, COMENTE LA LINEA DE ABAJO PERO ESTA ESTABA TRABAJANDO, HICE ESTO POR QUE NO ME ESTABA TOMANDO EN CUENTA EL PRIMER REGISTRO PARA LA SUMA
//        if (result.next() != false) {
        if (result != null ) {
            try {
                while(result.next()){
                    Object [] row = {result.getString(1), result.getString(2), result.getString(3), df.format(Float.parseFloat(result.getString(4)))};
                    model.addRow(row);
                    finalCost = finalCost + Float.parseFloat(result.getString(4));
                }
            } catch (SQLException ex) {
                System.out.println("error al leer datos en metodo: getTableModelDB "+ ex.getMessage());
                ex.printStackTrace();
            }
            
        }else{
            //
        }
    return model;
    }
    
    public String stringValueFromDB(ResultSet rs){
        String totalCost = "";
        try {
            if (rs.next()) {
                totalCost = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagmentCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return totalCost;
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
     
     public ResultSet readDataFromDB(int idRow){
        ResultSet result = null;
        try {
            CallableStatement ctm = Conexion.getConnection().prepareCall("{call sp_viewFinalInventory (?)}");
            ctm.setInt(1, idRow);
            result = ctm.executeQuery();
            if (result.next() == false) {
                JOptionPane.showMessageDialog(null, "No hay datos para mostrar, favor intente de nuevo");
            }
//            System.out.println("Datos INV Cargados");
        } catch (SQLException ex) {
            System.out.println("Error al leer Inventario final de la base de datos");
        }
        return result;
     }
     
     public void executeProcedure(String date){
        boolean resultVal = false;
        
                try {
                    for (Items itemInv : listInventory) {
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertInventory(?, ?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setFloat(3, Float.parseFloat(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
                        callStm.setInt(6, itemInv.getIdRow());
//                        ResultSet resultSet = callStm.executeQuery();
                        resultVal = callStm.executeUpdate() > 0;
                    }
                    System.out.println("Datos de Existencia almacenados por Store Procedured");
                } catch (SQLException ex) {
                    System.out.println("Error al exportar datos de inventario "+ex.getMessage());
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ERROR", "Error al intentar guardar los datos. \n Verifique que no este insertando adtos duplicados o verifique y ajuste la forma en que se presentan los datos", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    for (Items itemInv : listConsumption) {
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertConsumptions(?, ?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setFloat(3, Float.parseFloat(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
                        callStm.setInt(6, itemInv.getIdRow());
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
                        CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertShopping(?, ?, ?, ?, ?, ?)}");
                        callStm.setString(1, itemInv.getCodigo());
                        callStm.setString(2, itemInv.getDescripcion());
                        callStm.setFloat(3, Float.parseFloat(itemInv.getCantidad()));
                        callStm.setFloat(4, Float.parseFloat(itemInv.getCosto()));
                        callStm.setString(5, date);
                        callStm.setInt(6, itemInv.getIdRow());
//                        ResultSet resultSet = callStm.executeQuery();
                        resultVal = callStm.executeUpdate() > 0;
                    }
                    System.out.println("Datos de Compras almacenados por Store Procedured");
                } catch (SQLException ex) {
                    System.out.println("Error al exportar datos de Compras "+ex.getMessage());
                    ex.printStackTrace();
                }
         consultLastItemID();
     }
     
     public void insertToDB(String tableName){
         
         ResultSet result;
         for (Items item1 : listInventory) {
             try {
                PreparedStatement stm = Conexion.getConnection().prepareStatement
                ("insert into "+ tableName + "(codigo, descripcion, cantidad, costo)"+ " values (?, ?, ?, ?)");
                stm.setString(1, item1.getCodigo());
                stm.setString(2, item1.getDescripcion());
                stm.setFloat(3, Float.parseFloat(item1.getCantidad()));
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
     
     public int consultLastItemID(){
        ResultSet result = null;
//        int id = 0;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select TOP 1 (ID) from FinalInventory ORDER BY ID DESC");
            result = callStm.executeQuery();
            while (result.next()) {
                idRow = Integer.parseInt(result.getString(1));
                System.out.println("el id es= "+idRow);
            }
//            int var = result.get
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ultimo ID "+ex.getMessage() );
        }
        return idRow;
    }
     
     public static int getLastItemID(){
     
         return idRow;
     }
     
     public void enableComponents (Component [] comp, boolean enable, boolean limpiar) {
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JTextField) {
                ((JTextField)comp[i]).setEnabled(enable);
            }
            if (comp[i] instanceof JComboBox) {
                ((JComboBox)comp[i]).setEnabled(enable);
            }
            if (comp[i] instanceof JDateChooser) {
                ((JDateChooser)comp[i]).setEnabled(enable);
            }
            if (comp[i] instanceof JButton) {
                ((JButton)comp[i]).setEnabled(enable);
            }
            if (comp[i] instanceof JRadioButton) {
                ((JRadioButton)comp[i]).setEnabled(enable);
            }
            if (limpiar) {
                
                if (comp[i] instanceof JTextField) {
                ((JTextField)comp[i]).setText("");
                }
                if (comp[i] instanceof JComboBox) {
                ((JComboBox)comp[i]).setSelectedIndex(0);
                }             
                if (comp[i] instanceof JDateChooser) {
                ((JDateChooser)comp[i]).setDate(null);
                }
                if (comp[i] instanceof JButton) {
                ((JButton)comp[i]).setEnabled(enable);
                }
                if (comp[i] instanceof JRadioButton) {
                ((JRadioButton)comp[i]).setEnabled(enable);
                }
            }
        }
    
    }
     ResultSet rstForTotalCost = null;
     public ResultSet consultInventories(String table, String date){
         ResultSet resultSet = null;
         
         switch (table){
             
             case "Inventario Inicial":
            {
                try {
                    resultSet = queryToDB("select * from Inventory where Fecha ='"+ date+"' order by Codigo");
                    rstForTotalCost = queryToDB("select sum(Costo) from Inventory where Fecha ='"+ date+"'");
                    costInv = Double.parseDouble(stringValueFromDB(rstForTotalCost));
                } catch (SQLException ex) {
                    System.out.println("Error al leer datos del "+ table);
                }
            }
                 break;
                 
             case "Consumo":
            {
                try {
                    resultSet = queryToDB("select * from Consumptions where Fecha ='"+ date+"' order by Codigo");
                    rstForTotalCost = queryToDB("select sum(Costo) from Consumptions where Fecha ='"+ date+"'");
                    costInv = Double.parseDouble(stringValueFromDB(rstForTotalCost));
                } catch (SQLException ex) {
                    System.out.println("Error al leer datos del "+ table);
                }
            }
                 break;
                 
             case "Compras":
            {
                try {
                    resultSet = queryToDB("select * from Shopping where Fecha ='"+ date+"' order by Codigo");
                    rstForTotalCost = queryToDB("select sum(Costo) from Shopping where Fecha ='"+ date+"'");
                    costInv = Double.parseDouble(stringValueFromDB(rstForTotalCost));
                } catch (SQLException ex) {
                    System.out.println("Error al leer datos del "+ table);
                }
            }
                 break;
                 
             case "Inventario Final":
            {
                try {
                    resultSet = queryToDB("select Codigo, Descripcion, ((Cantidad+CantidadCompras) - CantidadConsumo)  as 'Cantidad', ((Costo+CostoCompras) - CostoConsumo)  as 'Costo' from FinalInventory where Fecha ='"+ date+"' order by Codigo");
                    String selectBefore = "(select Codigo, Descripcion, ((Cantidad+CantidadCompras) - CantidadConsumo)  as 'Cantidad', ((Costo+CostoCompras) - CostoConsumo)  as 'Costo' from FinalInventory where Fecha ='"+ date+"' order by Codigo)";
                    rstForTotalCost = queryToDB("select sum(temp.Costo) from (select Codigo, Descripcion, ((Cantidad+CantidadCompras) - CantidadConsumo)  as 'Cantidad', ((Costo+CostoCompras) - CostoConsumo)  as 'Costo' from FinalInventory where Fecha ='"+ date+"') temp");
                    costInv = Double.parseDouble(stringValueFromDB(rstForTotalCost));
                } catch (SQLException ex) {
                    System.out.println("Error al leer datos del"+ table);
                }
            }
                 break;
         }
          return resultSet;
     }
}
