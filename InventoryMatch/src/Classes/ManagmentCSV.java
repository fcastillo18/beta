/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
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
    
    

}
