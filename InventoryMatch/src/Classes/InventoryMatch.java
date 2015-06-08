/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.sun.javafx.scene.accessibility.Attribute;

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
        manCsv.readCSV("C:\\Users\\fcastillo\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program\\Existencia CSV.csv");
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
