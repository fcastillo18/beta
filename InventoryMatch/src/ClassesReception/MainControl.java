/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author fcastillo
 */
public class MainControl extends Thread{
    
    public MainControl() {
        Conexion con = new Conexion();
        con.createConnection();
    }
    public Date endDate;
    public Item item;
    public Details detail;
    public List<String> listaDeMenues;
    
    @Override
    public void run(){
    
            
    }
    
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_Details (itID, dtDateIN, dtDateOUT,dtReceivedBy, dtCategory, dtStatus) values (? , ? , ? ,? , ?, ?) ");
//            callStm.setInt(1, detail.getDtId());
            callStm.setInt(1, detail.getItId());
            callStm.setTimestamp(2, getCurrentTimeStamp());
            callStm.setTimestamp(3, null);
            callStm.setString(4, detail.getDtReceivedBy());
            callStm.setString(5, detail.getDtCategory());
            callStm.setString(6, detail.getDtStatus());
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_modifieRow (?,?,?,?,?,?,?, ?)}");
            callStm.setInt(1, detail.getDtId());
            callStm.setInt(2, item.getId());
            callStm.setString(3, item.getSupplierName());
            callStm.setString(4, item.getDescription());
            callStm.setString(5, detail.getDtReceivedBy());
            callStm.setTimestamp(6, detail.getDateOut());
            callStm.setString(7, detail.getDtCategory());
            callStm.setString(8, detail.getDtStatus());
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
                detail = new Details(result.getInt("dtID"), result.getInt("itID"), result.getTimestamp("dtDateIN"), result.getTimestamp("dtDateOUT"), result.getString("dtReceivedBy"), result.getString("dtCategory"), result.getString("dtStatus"));
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
    
    SimpleDateFormat sdformat = new SimpleDateFormat("dd/M/yyyy - hh:mm:ss");
    public DefaultTableModel getModelDetails(ResultSet rs){
    
        String [][] data = {};
        String [] titles = {"ID", "Fecha entrada", "Suplidor", "Descripcion", "Recibido por", "Fecha entregado", "Estado"};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        model.setRowCount(0);
        try {
            //        while(model.getRowCount()>0)model.removeRow(0);
            while (rs.next()) {
                if (rs.getString("dtDateOUT") == null) {
                    Object [] row = {rs.getInt("dtID"), sdformat.format(rs.getTimestamp("dtDateIN")), rs.getString("itSupplierName"), rs.getString("itDescription"), rs.getString("dtReceivedBy"), rs.getString("dtDateOUT"), rs.getString("dtStatus")};                
                    model.addRow(row);
                }else{
                    Object [] row = {rs.getInt("dtID"), sdformat.format(rs.getTimestamp("dtDateIN")), rs.getString("itSupplierName"), rs.getString("itDescription"), rs.getString("dtReceivedBy"), sdformat.format(rs.getTimestamp("dtDateOUT")), rs.getString("dtStatus")};                
                    model.addRow(row);
                }
                
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
            }
        }
    
    }
    
    /*Login Area */
    public void createUser(User user){
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_User (usFirstName, usLastName, usUserName, usPassword, usToChangePassword, usCategory)  values (?, ?, ?, ?, ?, ?)");
            callStm.setString(1, user.getFirstName());
            callStm.setString(2, user.getLastName());
            callStm.setString(3, user.getUserName());
            callStm.setString(4, user.getPassword());
            callStm.setBoolean(5, user.isToChangePass());
            callStm.setString(6, user.getCategory());
            callStm.executeUpdate();
            callStm.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar Usuario " + user.toString()+ ex.getMessage());
        }
    }
    public void insertMenuesAccess(int usId, String menu){
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertMenueValues(?,?)}");
            callStm.setInt(1, usId);
            callStm.setString(2, menu);
            callStm.executeUpdate();
            callStm.close();
            } catch (SQLException ex) {
            System.out.println("Error al insertar Menues" + ex.getMessage());
        }
    }
    public int getLastUserID(){
        int userID = 0 ;
        ResultSet result = null;
//        int id = 0;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select TOP 1 (usID) from tbl_User ORDER BY ID DESC");
            result = callStm.executeQuery();
            while (result.next()) {
                userID = Integer.parseInt(result.getString(1));
                System.out.println("el id es= "+userID);
            }
            callStm.close();
//            int var = result.get
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ultimo ID "+ex.getMessage() );
        }
        return userID;
    } 
    
    public ResultSet queryToDB(String query) throws SQLException{
    
        ResultSet result;
//        statement = con.preparedStatement();
        try {
            PreparedStatement statement = ClassesInventory.Conexion.getConnection().prepareStatement(query);
            result = statement.executeQuery();
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public DefaultListModel listModelMenues (){
        DefaultListModel listModel = new DefaultListModel();
        ResultSet resultSet ;
        listaDeMenues = new ArrayList<>();
        try {
            resultSet = queryToDB("select (mnMenu) from tbl_Menues ");
            while (resultSet.next()) {                
                listModel.addElement(resultSet.getString("mnMenu"));
                listaDeMenues.add(resultSet.getString("mnMenu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return listModel;
    }
}//
// usar setToolTipText para mostrar datos segun se valla typeando
