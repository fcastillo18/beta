/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formReception;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fcastillo
 */
public class MainControl {

    public MainControl() {
        Conexion con = new Conexion();
        con.createConnection();
    }
    Date endDate;
    
    public int getLastItemID(){
        ResultSet result = null;
        int id = 0;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select TOP 1 (itID) from tbl_Item ORDER BY itID DESC");
            result = callStm.executeQuery();
            while (result.next()) {
                id = Integer.parseInt(result.getString(1));
                System.out.println("el id es= "+id);
            }
//            int var = result.get
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void createItem(Item item){
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_Item (itSupplierName, itDescription) values ( ? , ?)");
//            callStm.setInt(1, item.getId());
            callStm.setString(1, item.getSupplierName());
            callStm.setString(2, item.getDescription());
            callStm.executeUpdate();
            System.out.println("Registro Item insertado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al intentar insertar datos Item-- "+ ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void createDetail(Details detail){
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_Details (itID, dtDateIN, dtDateOUT,dtReceivedBy, dtCategory) values (? , ? , ? ,? , ?) ");
//            callStm.setInt(1, detail.getDtId());
            callStm.setInt(1, detail.getItId());
            callStm.setTimestamp(2, getCurrentTimeStamp());
            callStm.setTimestamp(3, null);
            callStm.setString(4, detail.getDtReceivedBy());
            callStm.setString(5, detail.getDtCategory());
            callStm.executeUpdate();
            System.out.println("Registro Detail insertado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public ResultSet readDataFromTableDetail(){
        ResultSet result = null;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{select * from tbl_Details}");
            result = callStm.executeQuery();
//            int var = result.get
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static java.sql.Timestamp getCurrentTimeStamp() {
 
	java.util.Date today = new java.util.Date();
	return new java.sql.Timestamp(today.getTime());
 
    }
    
    public void modifiedItem(Item item, Details detail){
        
    }
}
