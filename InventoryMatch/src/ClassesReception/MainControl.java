/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

import ViewsReception.Login;
import conexionDB.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author fcastillo
 */
public class MainControl extends Thread{
    
    public MainControl() {
        //para eliminar
//        Conexion con = new Conexion();
//        con.createConnection();
    }
    public Date endDate;
    public Item item;
    public Details detail;
    public List<String> listaDeMenues;
    public static User user;
    private int detailSize = 0;
    //variables del reporte
    private JasperReport report = null;
    private JasperPrint reportFilled = null;
    private JasperViewer viewer = null;
    public List<User> listUser = new ArrayList<>();
        
    @Override
    public void run(){
    
            
    }
        
    public int getLastItemID(){
        ResultSet result = null;
        int id = 0;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select TOP 1 (itID) from tbl_Item ORDER BY itID DESC");
            result = callStm.executeQuery();
            if (result == null) {
                id = 0;
            }
            else{
                while (result.next()) {
                    id = Integer.parseInt(result.getString(1));
                    System.out.println("el id es= "+id);
                }
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
            detailSize++;    
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
            if (comp[i] instanceof JList) {
                ((JList)comp[i]).setEnabled(enable);
            }
            if (comp[i] instanceof JComboBox) {
                ((JComboBox)comp[i]).setEnabled(enable);
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
                if (comp[i] instanceof JComboBox) {
                ((JComboBox)comp[i]).setSelectedIndex(0);
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
    
    public void modifiedUser(User user){
        
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_modifiedUser (?, ?, ?, ?, ?, ?, ?)}");
            callStm.setInt(1, user.getId());
            callStm.setString(2, user.getFirstName());
            callStm.setString(3, user.getLastName());
            callStm.setString(4, user.getUserName());
            callStm.setString(5, user.getPassword());
            callStm.setBoolean(6, user.isToChangePass());
            callStm.setString(7, user.getCategory());
            callStm.executeUpdate();
            callStm.close();
        } catch (SQLException ex) {
            System.out.println("Error al Modificar Usuario " + user.toString()+ ex.getMessage());
        }
    }
    
//    public void modifiedMenuesAccess(int usId, String menu){
//        try {
//            
//            //ahora inserto los nuevos valores
//            insertMenuesAccess(usId, menu);
////            CallableStatement callStm = Conexion.getConnection().prepareCall("{call sp_modifiedMenuesAccess(?,?)}");
////            callStm.setInt(1, usId);
////            callStm.setString(2, menu);
////            callStm.executeUpdate();
////            callStm.close();
//            } catch (SQLException ex) {
//            System.out.println("Error al modificar Menues" + ex.getMessage());
//        }
//    }
    
    public void deleteMenuesAccess(int usId){
        try {
            //primero eliminar todos los menues anteriores para luego proceder a insertar los nuevos
            CallableStatement callStm0 = Conexion.getConnection().prepareCall("DELETE FROM tbl_MenuesAccess WHERE usID = ? ");
            callStm0.setInt(1, usId);
            callStm0.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
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
        Vector<String> listModelUsers = new Vector<String>();
        ResultSet resultSet ;
//        listaDeMenues = new ArrayList<>();
        try {
            resultSet = queryToDB("select (mnMenu) from tbl_Menues ");
            while (resultSet.next()) {                
                listModelUsers.addElement(resultSet.getString("mnMenu"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(listModelUsers);
        return listModelUsers;
    }
    /*Este metodo retornara los menues por ID de usuario*/
    public Vector<String> listUserMenues (int userID){
        
        Vector<String> listUserMenues = new Vector<String>();
        ResultSet resultSet ;
//        listaDeMenues = new ArrayList<>();
        try {
            resultSet = queryToDB("select * from tbl_MenuesAccess where usID = " + userID);
            while (resultSet.next()) {                
                listUserMenues.addElement(resultSet.getString("mnaAccessTo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(listUserMenues);
        return listUserMenues;
    }
    
    public User findUser(String userName){
        User user = new User();
        ResultSet result = null;
        try {
            CallableStatement callStm = Conexion.getConnection().prepareCall("select * from tbl_User where usUserName = ?");
            callStm.setString(1, userName);
            result = callStm.executeQuery();         
            while (result.next()) {                
                user.setId(result.getInt("usID"));
                user.setFirstName(result.getString("usFirstName"));
                user.setLastName(result.getString("usLastName"));
                user.setUserName(result.getString("usUserName"));
                user.setPassword(result.getString("usPassword"));
                user.setCategory(result.getString("usCategory"));
                user.setToChangePass(result.getBoolean("usToChangePassword"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public DefaultTableModel getDataFromTableUser(){
        String [][] data = {};
        String [] columns = {"ID", "Usuario", "Nombre", "Categoria", };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        model.setRowCount(0);
        User user = null;
        try {
            ResultSet resultSet = queryToDB("select * from tbl_User");
            while (resultSet.next()) {                
                Object[] row = {resultSet.getString("usID"),resultSet.getString("usUserName"),resultSet.getString("usFirstName")+" "+ resultSet.getString("usLastName"), resultSet.getString("usCategory")};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer datos de la tabla User");
            ex.getMessage();
            ex.printStackTrace();
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
//                System.out.println("Menues verificados e insertados con exito");
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
    
    public void runTimer(Long time){
    
        TimerTask timerTask = new TimerTask(){
            int cont = 0;
        @Override
        public void run() {
            System.out.println(cont);
            cont++;
        }
        };
        
        Timer timer = new Timer();
                        //task, cantidad en milisegundos de tiempo de espera para ejecutar el timer, con que frecuencia se ejecutara esta accion
        timer.schedule(timerTask, 1800000, time);
                                   //30min
    }
    
    public void reportHistorialCambios(){

        try {
            report = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\fcastillo\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\src\\reports\\ControlDeCambios.jasper");
            reportFilled = JasperFillManager.fillReport(report, null, Conexion.getConnection());
            viewer = new JasperViewer(reportFilled);
            viewer.setTitle("Historial de cambios en recepción");
            viewer.setVisible(true);
            //to prevent close the whole program when the user click con close buttom
            viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
        } catch (JRException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void exportToPDF(){
        try {
            JasperExportManager.exportReportToPdfFile(reportFilled, "src/reports/reporte01.pdf");
        } catch (JRException ex) {
            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static Properties getDBProperties(){
        Properties properties = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("c:/conexion/configDB.properties");
            properties.load(entrada);
        } catch (IOException ex) {
//            Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
      public  void setProperties(String servidor, String user, String pass, String port, String dbName){
            Properties propiedades = new Properties();
            OutputStream salida = null;
            
            try {
            File folder = new File("c:\\conexion");
            if (folder.exists() == false) {
                    folder.mkdirs();
            }
                    
              salida = new FileOutputStream("c:/conexion/configDB.properties");

             //Completar URL con parametros recibidos
              String urlDB = "jdbc:sqlserver://"+servidor+":"+port+ ";databaseName="+dbName;
               // asignamos los valores a las propiedades
              propiedades.setProperty("database", urlDB);
              propiedades.setProperty("dbName", dbName);
              propiedades.setProperty("user", user);
              propiedades.setProperty("pass", pass);
              propiedades.setProperty("servidor", servidor);
              propiedades.setProperty("port", port);

              // guardamos el archivo de propiedades en la carpeta de aplicación
              propiedades.store(salida, null);

             } catch (IOException io) {
                io.printStackTrace();
             } finally {
              if (salida != null) {
                  try {
                      salida.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }

             }
      
      }
      
      
      public void restartApplication()
    {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        File currentJar = null;
            try {
                currentJar = new File(Login.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* is it a jar file? */
            if(!currentJar.getName().endsWith(".jar"))
              return;

            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
                  try {
                      builder.start();
                  } catch (IOException ex) {
                      Logger.getLogger(MainControl.class.getName()).log(Level.SEVERE, null, ex);
                  }
            System.exit(0);
        }
      
      
}


// usar setToolTipText para mostrar datos segun se valla typeando
