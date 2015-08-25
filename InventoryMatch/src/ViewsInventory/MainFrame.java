/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsInventory;

import ViewsReception.JUsers;
import ClassesReception.MainControl;
import ViewsReception.ConfigProperties;
import ViewsReception.DisplayTrayIcon;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import ViewsReception.JReceptionForm;
import ViewsReception.JReceptionLog;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author fcastillo
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        mainControl.readMenuBar(jMenuBar1.getComponents());
        mainControl.loadMenuBar(jMenuBar1, false, null);
        mainControl.loadMenuBar(jMenuBar1, true, MainControl.user);
//        System.out.println(jMenuItem1.getSize().toString());
//        jMenu1.getSubElements().length
        this.setTitle("Solution Program                User:  " + MainControl.user.getUserName() +" | " + MainControl.user.getFirstName() + " "+ MainControl.user.getLastName());
        this.setLocationRelativeTo(null);
//       new DisplayTrayIcon().runTimer(time);
    }
    MainControl mainControl =  new MainControl();
//    long time = 10000;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Inventory = new javax.swing.JMenu();
        jmnConsultInv = new javax.swing.JMenuItem();
        jmnMatchInv = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmnHelp = new javax.swing.JMenu();
        jmnAbout = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 620));

        javax.swing.GroupLayout deskPanelLayout = new javax.swing.GroupLayout(deskPanel);
        deskPanel.setLayout(deskPanelLayout);
        deskPanelLayout.setHorizontalGroup(
            deskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        deskPanelLayout.setVerticalGroup(
            deskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        Inventory.setText("Inventario");

        jmnConsultInv.setText("Consultar inventarios anteriores");
        jmnConsultInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnConsultInvActionPerformed(evt);
            }
        });
        Inventory.add(jmnConsultInv);

        jmnMatchInv.setText("Cuadrar inventario");
        jmnMatchInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnMatchInvActionPerformed(evt);
            }
        });
        Inventory.add(jmnMatchInv);

        jMenuBar1.add(Inventory);

        jMenu1.setText("Recepcion");

        jMenuItem1.setText("Formulario entrada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Historial de recepción");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Historial de cambios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuarios");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Agregar usuario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Modificar/Eliminar usuarios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jmnHelp.setText("Ayuda");

        jmnAbout.setText("Acerca de");
        jmnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnAboutActionPerformed(evt);
            }
        });
        jmnHelp.add(jmnAbout);

        jMenuBar1.add(jmnHelp);

        jMenu3.setText("Administrator Tools");

        jMenuItem6.setText("Configurar base de datos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnMatchInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnMatchInvActionPerformed
        JMatchInventory mainView = new JMatchInventory();
        deskPanel.add(mainView);
        mainView.show();
    }//GEN-LAST:event_jmnMatchInvActionPerformed

    private void jmnConsultInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnConsultInvActionPerformed
        JConsultInventory2 jConsultInv = new JConsultInventory2();
        deskPanel.add(jConsultInv);
        jConsultInv.show();
    }//GEN-LAST:event_jmnConsultInvActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JReceptionForm jrf = new JReceptionForm();
        deskPanel.add(jrf);
        jrf.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JReceptionLog jrl = new JReceptionLog();
        deskPanel.add(jrl);
        jrl.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JUsers jUser = new JUsers();
        deskPanel.add(jUser);
        jUser.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JUsers jUser = new JUsers();
        deskPanel.add(jUser);
        jUser.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnAboutActionPerformed
//        mainControl.exportToPDF();
        mainControl.restartApplication();
    }//GEN-LAST:event_jmnAboutActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        mainControl.reportHistorialCambios();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ConfigProperties config = new ConfigProperties();
        config.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

//        Synth look and feel
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
        } catch (Exception e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Inventory;
    private javax.swing.JDesktopPane deskPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jmnAbout;
    private javax.swing.JMenuItem jmnConsultInv;
    private javax.swing.JMenu jmnHelp;
    private javax.swing.JMenuItem jmnMatchInv;
    // End of variables declaration//GEN-END:variables
}
