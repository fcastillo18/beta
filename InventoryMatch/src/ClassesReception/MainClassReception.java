/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

import ViewsReception.ConfigProperties;
import ViewsReception.Login;
import conexionDB.Conexion;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fcastillo
 */
public class MainClassReception {
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ParseException {
        Conexion con = new Conexion();
        Connection createConnection = con.createConnection(MainControl.getDBProperties());
        UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
        
        if (createConnection == null) {
            ConfigProperties config = new ConfigProperties();
            config.setVisible(true);          
        }else{
            ConfigProperties.inicio = false;
            Login login = new Login();
            login.setVisible(true);
            System.out.println("Conectado");
        }
        
    }
    
}
