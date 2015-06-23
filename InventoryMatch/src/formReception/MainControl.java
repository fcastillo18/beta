/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formReception;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    Item item;
    Details detail;
    
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_viewFullDetails}");
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
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_sp_modifieRow (?,?,?,?,?,?,?)}");
            callStm.setInt(1, detail.getDtId());
            callStm.setInt(2, item.getId());
            callStm.setString(3, item.getSupplierName());
            callStm.setString(4, item.getDescription());
            callStm.setString(5, detail.getDtReceivedBy());
            callStm.setTimestamp(6, detail.getDateOut());
            callStm.setString(7, detail.getDtCategory());
            //Agregar dos objetos y setearlos
            callStm.executeUpdate();
//            llenarObjetos(null);
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //en el consultar para porceder a la modificacion, tendria dos objetos que llenaria con klos datos para completar los textfield
    public ResultSet findRow(int dtID){
        ResultSet rs = null;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_findRow(?)}");
            callStm.setInt(1, dtID);
            rs = callStm.executeQuery();
            //Agregar dos objetos y setearlos
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void llenarObjetos(ResultSet result){

        try {
            while (result.next()) {
                detail = new Details(result.getInt("dtID"), result.getInt("itID"), result.getTimestamp("dtDateIN"), result.getTimestamp("dtDateOUT"), result.getString("dtReceivedBy"), result.getString("dtCategory"));
                item = new Item(result.getInt("itID"), result.getString("itSupplierName"), result.getString("itDescription"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos alos objetos: Item and Details " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public ResultSet readFullDetailsFromDB(){
        ResultSet rs = null;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_viewFullDetails}");
            rs = callStm.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: sp_"
                    + "viewFullDetails  en la base de datos " + ex.getMessage());
            ex.printStackTrace();
        }
        return rs;
    }
    
    public DefaultTableModel getModelDetails(ResultSet rs){
    
        String [][] data = {};
        String [] titles = {"ID", "Fecha entrada", "Suplidor", "Descripcion", "Recibido por", "Fecha entregado"};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        model.setRowCount(0);
        try {
            //        while(model.getRowCount()>0)model.removeRow(0);
            while (rs.next()) {
                Object [] row = {rs.getInt("dtID"), rs.getTimestamp("dtDateIN"), rs.getString("itSupplierName"), rs.getString("itDescription"), rs.getString("dtReceivedBy"), rs.getString("dtDateOUT")};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo getModelDetails al leer datos " + ex.getMessage());
            ex.printStackTrace();
        }
        return model;
    }
    
    public ResultSet executeQueryToDB(String queryToDB){
        ResultSet result = null;
        try {
            PreparedStatement pstm = Conexion.getConnection().prepareCall(queryToDB);
            result = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
//    public void enableComponents (Component [] comp, boolean var) {
//        for (int i = 0; i < comp.length; i++) {
//            if (comp[i] instanceof JTextField) {
//                (JTextField)(comp[i]))
//                (JTextField)(  comp[i])).setEnabled(false);
//            }
//        }
    
//    }
}
