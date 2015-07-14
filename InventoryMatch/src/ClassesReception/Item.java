/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

/**
 *
 * @author fcastillo
 */
public class Item {
    
    private int id;
    private String supplierName;
    private String description;

//    public Item() {
//    } 
//    
    public Item(int id, String supplierName, String description) {
        this.id = id;
        this.supplierName = supplierName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", supplierName=" + supplierName + ", description=" + description + '}';
    }
    
    
    
}
