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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


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
    public static User user;
    
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
    
    public int getLastDetailID(){
        ResultSet result = null;
        int id = 0;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select max(dtID) dtID from tbl_Details "); //"select TOP 1 (dtID) from tbl_Detail ORDER BY itID DESC"
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_Details (itID, dtDateIN, dtDateOUT,dtReceivedBy, dtCategory, dtStatus, dtRegisterBy, dtObservation) values (? , ? , ? ,? , ?, ?, ?, ?) ");
//            callStm.setInt(1, detail.getDtId());
            callStm.setInt(1, detail.getItId());
            callStm.setTimestamp(2, getCurrentTimeStamp());
            callStm.setTimestamp(3, null);
            callStm.setString(4, detail.getDtReceivedBy());
            callStm.setString(5, detail.getDtCategory());
            callStm.setString(6, detail.getDtStatus());
            callStm.setString(7, detail.getDtRegisterBy());
            callStm.setString(8, detail.getDtObservation());
            callStm.executeUpdate();
            System.out.println("Registro Detail insertado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void createLogDetail(Details detail, Timestamp dtModifiedDate, String dtModifiedBy){
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("insert into tbl_LogDetails ( itID, dtDateIN, dtDateOUT,dtReceivedBy, dtCategory, dtStatus, dtRegisterBy, dtObservation, dtModifiedDate, dtModifiedBy, dtID) values (?, ? , ? , ? ,? , ?, ?, ?, ?, ?, ?) ");
            callStm.setInt(11, getLastDetailID());
            callStm.setInt(1, detail.getItId());
            callStm.setTimestamp(2, getCurrentTimeStamp());
            callStm.setTimestamp(3, null);
            callStm.setString(4, detail.getDtReceivedBy());
            callStm.setString(5, detail.getDtCategory());
            callStm.setString(6, detail.getDtStatus());
            callStm.setString(7, detail.getDtRegisterBy());
            callStm.setString(8, detail.getDtObservation());
            callStm.setTimestamp(9, dtModifiedDate);
            callStm.setString(10, dtModifiedBy);
            
            callStm.executeUpdate();
            System.out.println("Registro LogDetail insertado correctamente");
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_modifieRow (?,?,?,?,?,?,?, ?, ?, ?)}");
            callStm.setInt(1, detail.getDtId());
            callStm.setInt(2, item.getId());
            callStm.setString(3, item.getSupplierName());
            callStm.setString(4, item.getDescription());
            callStm.setString(5, detail.getDtReceivedBy());
            callStm.setTimestamp(6, detail.getDateOut());
            callStm.setString(7, detail.getDtCategory());
            callStm.setString(8, detail.getDtStatus());
            callStm.setString(9, detail.getDtRegisterBy());
            callStm.setString(10, detail.getDtObservation());
            
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
                detail = new Details(result.getInt("dtID"), result.getInt("itID"), result.getTimestamp("dtDateIN"), result.getTimestamp("dtDateOUT"), result.getString("dtReceivedBy"), result.getString("dtCategory"), result.getString("dtStatus"), result.getString("dtRegisterBy"), result.getString("dtObservation"));
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
        String [] titles = {"ID", "Fecha entrada", "Suplidor", "Descripcion", "Recibido por", "Fecha entregado", "Estado", "Registrado por"};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        model.setRowCount(0);
        try {
            //        while(model.getRowCount()>0)model.removeRow(0);
            while (rs.next()) {
                if (rs.getString("dtDateOUT") == null) {
                    Object [] row = {rs.getInt("dtID"), sdformat.format(rs.getTimestamp("dtDateIN")), rs.getString("itSupplierName"), rs.getString("itDescription"), rs.getString("dtReceivedBy"), rs.getString("dtDateOUT"), rs.getString("dtStatus"), rs.getString("dtRegisterBy")};                
                    model.addRow(row);
                }else{
                    Object [] row = {rs.getInt("dtID"), sdformat.format(rs.getTimestamp("dtDateIN")), rs.getString("itSupplierName"), rs.getString("itDescription"), rs.getString("dtReceivedBy"), sdformat.format(rs.getTimestamp("dtDateOUT")), rs.getString("dtStatus"), rs.getString("dtRegisterBy")};                
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
            CallableStatement callStm = Conexion.getConnection().prepareCall("select TOP 1 (usID) from tbl_User ORDER BY usID DESC");
            result = callStm.executeQuery();
            while (result.next()) {
                userID = Integer.parseInt(result.getString(1));
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
            CallableStatement callStm = Conexion.getConnection().prepareCall(query);
            result = callStm.executeQuery();
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Vector<String> listModelMenues (){
        Vector<String> listModel = new Vector<String>();
        ResultSet resultSet ;
//        listaDeMenues = new ArrayList<>();
        try {
            resultSet = queryToDB("select (mnMenu) from tbl_Menues ");
            while (resultSet.next()) {                
                listModel.addElement(resultSet.getString("mnMenu"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(listModel);
        return listModel;
    }
    
    public DefaultTableModel getDataFromTableUser(){
        String [][] data = {};
        String [] columns = {"Usuario", "Nombre", "Categoria", };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        model.setRowCount(0);
        try {
            ResultSet resultSet = queryToDB("select usUserName, usFirstName, usLastName, usCategory from tbl_User");
            while (resultSet.next()) {                
                Object[] row = {resultSet.getString("usUserName"),resultSet.getString("usFirstName")+" "+ resultSet.getString("usLastName"), resultSet.getString("usCategory")};
//                Arrays.sort(row);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer datos de la tabla User");
        }
        
        return model;
    }
    
    public boolean userLogin(String userName, String pass){
        ResultSet result = null;
        boolean status = false;
        try {
//            CallableStatement callStm = Conexion.getConnection().prepareCall("select usUserName, usFirstName, usLastName, usPassword from tbl_User where usUserName = " + user + " and usPassword = "+ pass);
            CallableStatement callStm = Conexion.getConnection().prepareCall("select * from tbl_User where usUserName = ? and usPassword = ?");
            callStm.setString(1, userName);
            callStm.setString(2, pass);
            result = callStm.executeQuery();
            if (result != null) {
                while (result.next()) {
                    user = new User();
                    user.setId(result.getInt(1));
                    user.setFirstName(result.getString(2));
                    user.setLastName(result.getString(3));
                    user.setUserName(result.getString(4));
                    user.setPassword(result.getString(5));
                    user.setCategory(result.getString(6));
                    status = true;
                }
            }else{
                JOptionPane.showMessageDialog(null, "La clave o nombre de usario esta incorrecto \n Favor verifique e intente nuevamente", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
                status = false;
            }
            
            callStm.close();
//            int var = result.get
        } catch (SQLException ex) {
            System.out.println("Error al loguearse "+ex.getMessage());
            ex.printStackTrace();
        }
        return status;
        
    }
    public void readMenuBar(Component[] components){
        String mnName;
        for(int i = 0; i < components.length; i++){
            if (components[i] instanceof JMenu) {
                try {
                    //                System.out.println(((JMenu)components[i]).getText());     
                    CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_insertMenues(?)}");
                    callStm.setString(1, ((JMenu)components[i]).getText());
                    callStm.executeUpdate();
                    
                    int cont = 0;
//                    System.out.println(((JMenu)components[i]).getItemCount());
                    while (cont < ((JMenu)components[i]).getItemCount()) {
//                    System.out.println(((JMenu)components[i]).getItem(cont).getText());
                        
                        callStm = Conexion.getConnection().prepareCall("{call sp_insertMenues(?)}");
                        callStm.setString(1, ((JMenu)components[i]).getItem(cont).getText());
                        callStm.executeUpdate();
                        
                        cont++;
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al insertar menues" + ex.getMessage());
                    ex.printStackTrace();
                }
                System.out.println("Menues verificados e insertados con exito");
            }
//            if (components[i] instanceof JMenuItem) {
//                System.out.println(((JMenuItem)components[i]).getText());
//            }
        }
    }
   
    public void beta(JMenuBar menubar){
        menubar.getComponent(1).setVisible(false);
    }
    
    public void loadMenuBar(JMenuBar menubar, boolean visible, User user){
        try {
            String mnName;
            ResultSet result = null;
            List<String> listMenues = new ArrayList<String>();
            if (user != null) {

                for(int i = 0; i < menubar.getComponents().length; i++){
                    //asigno los datos del componente en cuestion a esta variable para mejor manejo
                    Component component = menubar.getComponents()[i];
                    if (component instanceof JMenu) {
                        //probare tanteando a la base de datos si el component evaluado esta en la lista de mnAccessTo del usuario
                        //debe retornarlo, de lo contrario el resultset sera null, por tanto de ser null no agregue 
                        CallableStatement callStm = Conexion.getConnection().prepareCall("select mnaAccessTo from tbl_MenuesAccess where usID = ? ");
                        callStm.setInt(1,user.getId());
//                        callStm.setString(2, menuName );
                        result = callStm.executeQuery();
                        
                        if (result != null) {
//                            ((JMenu)component).setVisible(visible);// verificar que solo se agregue el menu en cuestion, con este se agregan todos
                            while (result.next()) {                            
                                listMenues.add(result.getString("mnaAccessTo"));
                            }
                        }
                            int cont = 0;
                        
                            while (cont < ((JMenu)component).getItemCount()) {

                                for (String menue : listMenues) {
                                    //Menu
                                    if (((JMenu)component).getText().equals(menue)) {
                                        ((JMenu)component).setVisible(visible);
                                    }
                                    //MenuItem
                                    if (((JMenu)component).getItem(cont).getText().equals(menue)) {
                                        ((JMenu)component).getItem(cont).setVisible(visible);
                                    }else{
                                       //nada
                                    }
                                }
                                cont++;
                            }
                            callStm.close();
                    }
                   
                }
            }else{
                System.out.println("NAda");
                for (int i = 0; i < menubar.getComponents().length; i++) {
                    if (menubar.getComponent(i) instanceof JMenu) {
                        menubar.getComponent(i).setVisible(visible);
                    }
                    int cont =0;
                    while (cont < ((JMenu)menubar.getComponent(i)).getItemCount()) {                        
                        ((JMenu)menubar.getComponent(i)).getItem(cont).setVisible(visible);
                        cont++;
                    }
                }
    
            }
        } catch (SQLException ex) {
//            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    public DefaultTableModel getUsersModel(ResultSet rs){
        String [][] data = {};
        String [] titles = {"Usuario", "Nombres", "Categoria"};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        model.setRowCount(0);
        try {
            //        while(model.getRowCount()>0)model.removeRow(0);
            while (rs.next()) {
                    Object [] row = {rs.getString("usUserName"), rs.getString("usFirstName")+" "+ rs.getString("usLastName"), rs.getString("usCategory")};                
                    model.addRow(row);                
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo getModelDetails al leer datos " + ex.getMessage());
            ex.printStackTrace();
        }  
        return model;
    }
}


// usar setToolTipText para mostrar datos segun se valla typeando
