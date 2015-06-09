/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.ManagmentCSV;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Franklin
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        btnGroup = new ButtonGroup();
        btnGroup.add(jrbInventory);
        btnGroup.add(jrbConsumptions);
        btnGroup.add(jrbShopping);
    }
    String inventory;
    String consumptions;
    String shopping;
    public ButtonGroup btnGroup;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpChooseFiles = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtInventory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtConsumptions = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtShopping = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jrbInventory = new javax.swing.JRadioButton();
        jrbConsumptions = new javax.swing.JRadioButton();
        jrbShopping = new javax.swing.JRadioButton();
        btnLoadIventory = new javax.swing.JButton();
        btnLoadConsumptions = new javax.swing.JButton();
        btnLoaShopping = new javax.swing.JButton();
        jpActions = new javax.swing.JPanel();
        btnResults = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jpData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista general");

        jpChooseFiles.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleccion de Archivos"));

        jLabel1.setText(" Inventario:");

        txtInventory.setEditable(false);
        txtInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInventoryActionPerformed(evt);
            }
        });

        jLabel2.setText("Consumo:");

        txtConsumptions.setEditable(false);

        jLabel3.setText("Compras:");

        txtShopping.setEditable(false);

        jLabel4.setText("Mostrar tabla:");

        jrbInventory.setText("Inventario");
        jrbInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInventoryActionPerformed(evt);
            }
        });

        jrbConsumptions.setText("Consumo");

        jrbShopping.setText("Compras");

        btnLoadIventory.setText("Cargar");
        btnLoadIventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadIventoryActionPerformed(evt);
            }
        });

        btnLoadConsumptions.setText("Cargar");
        btnLoadConsumptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadConsumptionsActionPerformed(evt);
            }
        });

        btnLoaShopping.setText("Cargar");
        btnLoaShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaShoppingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpChooseFilesLayout = new javax.swing.GroupLayout(jpChooseFiles);
        jpChooseFiles.setLayout(jpChooseFilesLayout);
        jpChooseFilesLayout.setHorizontalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtConsumptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(txtInventory, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShopping))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadIventory)
                    .addComponent(btnLoadConsumptions)
                    .addComponent(btnLoaShopping))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbShopping)
                    .addComponent(jLabel4)
                    .addComponent(jrbInventory)
                    .addComponent(jrbConsumptions))
                .addContainerGap())
        );
        jpChooseFilesLayout.setVerticalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadIventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConsumptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadConsumptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoaShopping))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jpChooseFilesLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbConsumptions)
                .addGap(0, 0, 0)
                .addComponent(jrbShopping)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpActions.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnResults.setText("Generar inventario Final");

        btnExport.setText("Exportar archivo");

        javax.swing.GroupLayout jpActionsLayout = new javax.swing.GroupLayout(jpActions);
        jpActions.setLayout(jpActionsLayout);
        jpActionsLayout.setHorizontalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jpActionsLayout.setVerticalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnResults, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpData.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblData.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblData.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblData.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpChooseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpChooseFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadIventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadIventoryActionPerformed
        //to create a filter of files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Excel CSV", "csv");
        JFileChooser jfcIventory = new JFileChooser();
        //setting the filter to the fileChooser
        jfcIventory.setFileFilter(filter);
        //to change the name of the window
        jfcIventory.setDialogTitle("Abrir archivo de Existencia");
        /*
        /to change the directory when the dialog is open
        File file = new File("Ruta del directorio");
        jfcIventory.setCurrentDirectory(file);
        jfcIventory.showOpenDialog(this);
        */
        File file = new File("C:\\Users\\fcastillo\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);
        
        int result = jfcIventory.showOpenDialog(this);
               
        if (result == JFileChooser.APPROVE_OPTION) {
            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath + " or " + file.getPath());
            adminCSV.readCSV(filePath);
            tblData.setModel(adminCSV.getTableModel());
            txtInventory.setText(String.valueOf(file));
            //to use the JRadioButtoms
            inventory = filePath;
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnLoadIventoryActionPerformed

    private void txtInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInventoryActionPerformed

    private void btnLoadConsumptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadConsumptionsActionPerformed
//        ManagmentCSV.restartJTable(tblData);
        //to create a filter of files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Excel CSV", "csv");
        JFileChooser jfcIventory = new JFileChooser();
        //setting the filter to the fileChooser
        jfcIventory.setFileFilter(filter);
        //to change the name of the window
        jfcIventory.setDialogTitle("Abrir archivo de Consumo");
        /*
        /to change the directory when the dialog is open
        File file = new File("Ruta del directorio");
        jfcIventory.setCurrentDirectory(file);
        jfcIventory.showOpenDialog(this);
        */
        File file = new File("C:\\Users\\fcastillo\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);
        int result = jfcIventory.showOpenDialog(this);
               
        if (result == JFileChooser.APPROVE_OPTION) {
            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath);
            adminCSV.readCSV(filePath);
            tblData.setModel(adminCSV.getTableModel());
            txtConsumptions.setText(String.valueOf(file));
            //to use the JRadioButtoms
            consumptions = filePath;
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoadConsumptionsActionPerformed

    private void btnLoaShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaShoppingActionPerformed
        //to create a filter of files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Excel CSV", "csv");
        JFileChooser jfcIventory = new JFileChooser();
        //setting the filter to the fileChooser
        jfcIventory.setFileFilter(filter);
        //to change the name of the window
        jfcIventory.setDialogTitle("Abrir archivo de Compras");
        /*
        /to change the directory when the dialog is open
        File file = new File("Ruta del directorio");
        jfcIventory.setCurrentDirectory(file);
        jfcIventory.showOpenDialog(this);
        */
        File file = new File("C:\\Users\\fcastillo\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);
        
        int result = jfcIventory.showOpenDialog(this);
               
        if (result == JFileChooser.APPROVE_OPTION) {
            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath);
            adminCSV.readCSV(filePath);
            tblData.setModel(adminCSV.getTableModel());
            txtShopping.setText(String.valueOf(file));
            //to use the JRadioButtoms
            shopping = filePath;
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoaShoppingActionPerformed

    private void jrbInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInventoryActionPerformed
//        ManagmentCSV.restartJTable(tblData);
        ManagmentCSV adminCSV = new ManagmentCSV();
        adminCSV.readCSV(inventory);
        tblData.setModel(adminCSV.getTableModel());
    }//GEN-LAST:event_jrbInventoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnLoaShopping;
    private javax.swing.JButton btnLoadConsumptions;
    private javax.swing.JButton btnLoadIventory;
    private javax.swing.JButton btnResults;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpActions;
    private javax.swing.JPanel jpChooseFiles;
    private javax.swing.JPanel jpData;
    private javax.swing.JRadioButton jrbConsumptions;
    private javax.swing.JRadioButton jrbInventory;
    private javax.swing.JRadioButton jrbShopping;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtConsumptions;
    private javax.swing.JTextField txtInventory;
    private javax.swing.JTextField txtShopping;
    // End of variables declaration//GEN-END:variables
}
