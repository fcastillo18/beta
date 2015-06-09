/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import com.sun.media.sound.ModelOscillator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Franklin
 */
public class ManagmentCSV {
    
    List<Items> listItems = new ArrayList<>();
    Items item = null;
    
    public void readCSV(String fileCsv){
        
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
            
            for (Items item1 :  listItems) {
                System.out.println(item1.getCodigo() + " : " + item1.getDescripcion() + " : " + item1.getCantidad() +item1.getCosto());
            }
        }
        catch (Exception ex){
            ex.getMessage();
    } 
    
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
    
    public static void restartJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
 
        TableColumnModel modCol = Tabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
    }
    
}
