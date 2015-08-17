/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsReception;

import trayIcon.*;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author fcastillo
 */
public class DisplayTrayIcon {

    public DisplayTrayIcon() {
        showTrayIcon();
    }
    
    static TrayIcon trayIcon;
    
    public static void showTrayIcon(){
    //check if PC supported tray icon
        if (!SystemTray.isSupported()) {
            System.out.println("Error, la computadora no soporta TrayIcon");
            System.exit(0);
            return;
        }
        
        trayIcon = new TrayIcon(createIcon("/images/icon.png", "Tray Icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        final PopupMenu popupMenu = new PopupMenu();
        //add components /menu items
        MenuItem openItem = new MenuItem("Abrir");
        MenuItem aboutItem = new MenuItem("About");
        MenuItem exitItem = new MenuItem("Exit");
        //populate the message display menu
        Menu displayMenu = new Menu("Menu");
//        MenuItem errorItem = new MenuItem("Error");
//        MenuItem warningItem = new MenuItem("Warning");
//        MenuItem normalItem = new MenuItem("Normal");
//        MenuItem infoItem = new MenuItem("Info");
        //populate the pop up menu
        popupMenu.add(openItem);
        popupMenu.add(aboutItem);
        popupMenu.addSeparator();
        popupMenu.add(exitItem);
        //
//        displayMenu.add(errorItem);
        //PopMessage when you pass the mouse through the icon
        trayIcon.setToolTip("App solutions TI \nFranklin's Project");
        
        trayIcon.setPopupMenu(popupMenu);
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    //to set an action when you click a menu its necesary to override the acction listener
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lugar donde se pondra visible la aplicacion
            }
        });
        
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Made by Franklin Castillo");
            }
        });
        
        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    
    protected static Image createIcon(String path, String desc){
        
        URL imageURL = DisplayTrayIcon.class.getResource(path);
        return ( new ImageIcon(imageURL, desc)).getImage();
    }
    //movido a la clase MainControl
//    public void runTimer(Long time){
//    
//        TimerTask timerTask = new TimerTask(){
//            int cont = 0;
//        @Override
//        public void run() {
//            System.out.println(cont);
//            cont++;
//        }
//        };
//        
//        Timer timer = new Timer();
//                        //task, cantidad en milisegundos de tiempo de espera para ejecutar el timer, con que frecuencia se ejecutara esta accion
//        timer.schedule(timerTask, 1800000, time);
//                                   //30min
//    }
    
}
