/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.Conexion;
import Classes.ManagmentCSV;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fcastillo
 */
public class JMatchInventory extends javax.swing.JInternalFrame {

    /**
     * Creates new form JMainView
     */
    public JMatchInventory() {
        initComponents();
         btnGroup = new ButtonGroup();
        btnGroup.add(jrbInventory);
        btnGroup.add(jrbConsumptions);
        btnGroup.add(jrbShopping);
        new Conexion().createConnection();
    }
    boolean match =false;
    public ButtonGroup btnGroup;
    ManagmentCSV adminCSV = new ManagmentCSV();
    DefaultTableModel modelo = new DefaultTableModel(){
            
        @Override
        public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
    };

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
        jButton1 = new javax.swing.JButton();
        jpData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        jpActions = new javax.swing.JPanel();
        btnShowResults = new javax.swing.JButton();
        btnMatchExport = new javax.swing.JButton();
        jcbMes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbAno = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cuadrar Inventario por mes");
        setAutoscrolls(true);

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
        jrbConsumptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbConsumptionsActionPerformed(evt);
            }
        });

        jrbShopping.setText("Compras");
        jrbShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbShoppingActionPerformed(evt);
            }
        });

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

        jButton1.setText("Cargar nuevos datos");

        javax.swing.GroupLayout jpChooseFilesLayout = new javax.swing.GroupLayout(jpChooseFiles);
        jpChooseFiles.setLayout(jpChooseFilesLayout);
        jpChooseFilesLayout.setHorizontalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpChooseFilesLayout.createSequentialGroup()
                        .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtShopping, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInventory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConsumptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadIventory)
                            .addComponent(btnLoadConsumptions)
                            .addComponent(btnLoaShopping))
                        .addGap(24, 24, 24)
                        .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbInventory)
                            .addComponent(jrbConsumptions)
                            .addComponent(jrbShopping)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jpChooseFilesLayout.setVerticalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpChooseFilesLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbConsumptions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpChooseFilesLayout.createSequentialGroup()
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
                            .addComponent(btnLoaShopping))))
                .addContainerGap())
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

        jLabel8.setText("Costo total:");

        txtTotalCost.setEditable(false);

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDataLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpActions.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnShowResults.setText("Mostrar cuadre Inv. Final");
        btnShowResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowResultsActionPerformed(evt);
            }
        });

        btnMatchExport.setText("Cuadrar");
        btnMatchExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchExportActionPerformed(evt);
            }
        });

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel5.setText("Mes:");

        jLabel6.setText("Año:");

        jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016" }));

        jLabel7.setText("Fecha de archivos");

        javax.swing.GroupLayout jpActionsLayout = new javax.swing.GroupLayout(jpActions);
        jpActions.setLayout(jpActionsLayout);
        jpActionsLayout.setHorizontalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jpActionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMatchExport, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShowResults))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbAno, 0, 59, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jpActionsLayout.setVerticalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMatchExport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShowResults, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jpChooseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowResultsActionPerformed
        if (match = true) {
            try {
                tblData.setModel(adminCSV.getTableModelDB(adminCSV.readDataFromDB(ManagmentCSV.getLastItemID())));
                DecimalFormat df = new DecimalFormat("#,###,###,##0.0000");
                txtTotalCost.setText(df.format(Double.parseDouble(adminCSV.totalCost(adminCSV.queryToDB("select sum(Costo) from FinalInventory where ID ="+ManagmentCSV.getLastItemID())))));
//                txtTotalCost.setText(adminCSV.totalCost(adminCSV.queryToDB("select sum(Costo) from FinalInventory")));
//            JOptionPane.showMessageDialog(null, "Mostrando Inventario final del mes de " + jcbMes.getSelectedItem().toString() +" del " + jcbAno.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(JMatchInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aun no se a cuadrado inventario para poder usar esta opcion, \favor intentelo de nuevo cargando los archivos y volviendo a pulsar el boton Cuadrar", "Error al intentar mostrar datos", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnShowResultsActionPerformed

    private void btnMatchExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchExportActionPerformed
        //        adminCSV.insertToDB("Inventory");
        if (txtInventory.getText().isEmpty() | txtConsumptions.getText().isEmpty() | txtShopping.getText().isEmpty()) {
            match = false;
            JOptionPane.showMessageDialog(null, "Favor cargar todos los archivos que se piden para poder continuar", "Falta cargar documento", JOptionPane.ERROR_MESSAGE);
        }else{
            adminCSV.executeProcedure(jcbMes.getSelectedItem().toString() + "-" + jcbAno.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
            match = true;
        }
        
    }//GEN-LAST:event_btnMatchExportActionPerformed

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
        File file = new File("C:\\Users\\Franklin\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);

        int result = jfcIventory.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            //            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath);
            adminCSV.readCSV(filePath, "Compras");
            tblData.setModel(adminCSV.getTableModel());
            txtShopping.setText(String.valueOf(file));
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoaShoppingActionPerformed

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
        File file = new File("C:\\Users\\Franklin\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);
        int result = jfcIventory.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            //            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath);
            adminCSV.readCSV(filePath, "Consumo");
            tblData.setModel(adminCSV.getTableModel());
            txtConsumptions.setText(String.valueOf(file));
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoadConsumptionsActionPerformed

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
        File file = new File("C:\\Users\\Franklin\\Documents\\NetBeansProjects\\beta\\InventoryMatch\\Materials to program");
        jfcIventory.setCurrentDirectory(file);
        int result = jfcIventory.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            //            ManagmentCSV adminCSV = new ManagmentCSV();
            file = jfcIventory.getSelectedFile();
            //to open the file
            String filePath = jfcIventory.getCurrentDirectory().toString()+ "\\" + jfcIventory.getName(file);
            System.out.println(filePath + " or " + file.getPath());
            adminCSV.readCSV(filePath, "Existencia");
            tblData.setModel(adminCSV.getTableModel());
            txtInventory.setText(String.valueOf(file));
        }else if (result == JFileChooser.CANCEL_OPTION){
            //the user push cancel, nothing happen
        }else if (result == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null, "Se a producido un error. Favor verificar que haya cargado el archivo correcto e internar de nuevo", "Error al cargar el archivo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoadIventoryActionPerformed

    private void jrbShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbShoppingActionPerformed
        //        ManagmentCSV adminCSV = new ManagmentCSV();
        tblData.setModel(adminCSV.getTableModelToJRB("shopping"));
    }//GEN-LAST:event_jrbShoppingActionPerformed

    private void jrbConsumptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbConsumptionsActionPerformed
        //        ManagmentCSV adminCSV = new ManagmentCSV();
        tblData.setModel(adminCSV.getTableModelToJRB("consumptions"));
    }//GEN-LAST:event_jrbConsumptionsActionPerformed

    private void jrbInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInventoryActionPerformed
        //        ManagmentCSV adminCSV = new ManagmentCSV();
        tblData.setModel(adminCSV.getTableModelToJRB("inventory"));
    }//GEN-LAST:event_jrbInventoryActionPerformed

    private void txtInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventoryActionPerformed

    }//GEN-LAST:event_txtInventoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoaShopping;
    private javax.swing.JButton btnLoadConsumptions;
    private javax.swing.JButton btnLoadIventory;
    private javax.swing.JButton btnMatchExport;
    private javax.swing.JButton btnShowResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbAno;
    private javax.swing.JComboBox jcbMes;
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
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
