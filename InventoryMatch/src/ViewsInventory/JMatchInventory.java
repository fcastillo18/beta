/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsInventory;

import ClassesInventory.Conexion;
import ClassesInventory.ManagmentCSV;
import java.io.File;
import java.sql.ResultSet;
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
        adminCSV.enableComponents(jpChooseFiles.getComponents(), false, true);
        btnShowResults.setEnabled(false);
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
        jpData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jpActions = new javax.swing.JPanel();
        btnShowResults = new javax.swing.JButton();
        btnMatchExport = new javax.swing.JButton();
        jcbMes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbAno = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtInv0 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCompras = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNameInv = new javax.swing.JTextField();

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

        javax.swing.GroupLayout jpChooseFilesLayout = new javax.swing.GroupLayout(jpChooseFiles);
        jpChooseFiles.setLayout(jpChooseFilesLayout);
        jpChooseFilesLayout.setHorizontalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtConsumptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInventory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadIventory)
                    .addComponent(btnLoadConsumptions)
                    .addComponent(btnLoaShopping))
                .addGap(18, 18, 18)
                .addGroup(jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbInventory)
                    .addComponent(jrbConsumptions)
                    .addComponent(jrbShopping)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jpChooseFilesLayout.setVerticalGroup(
            jpChooseFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChooseFilesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpActions.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnShowResults.setText("Mostrar cuadre");
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

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel5.setText("Mes:");

        jLabel6.setText("Año:");

        jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----", "2013", "2014", "2015", "2016" }));

        jLabel7.setText("Fecha de archivos");

        javax.swing.GroupLayout jpActionsLayout = new javax.swing.GroupLayout(jpActions);
        jpActions.setLayout(jpActionsLayout);
        jpActionsLayout.setHorizontalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActionsLayout.createSequentialGroup()
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpActionsLayout.createSequentialGroup()
                        .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jcbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpActionsLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMatchExport, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(jpActionsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnShowResults)))
                .addGap(13, 13, 13))
        );
        jpActionsLayout.setVerticalGroup(
            jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpActionsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnMatchExport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShowResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cargar nuevos datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ultimo cuadre"));

        jLabel9.setText("Inv. Inicial:");

        txtInv0.setEditable(false);

        jLabel11.setText("Compras");

        txtCompras.setEditable(false);

        jLabel10.setText("Consumo:");

        txtConsumo.setEditable(false);

        jLabel8.setText("Total Inv Final:");

        txtTotalCost.setEditable(false);

        jLabel12.setText("Inventario de:");

        txtNameInv.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInv0, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNameInv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(txtTotalCost, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtInv0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNameInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpChooseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpChooseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowResultsActionPerformed
        if (match = true) {
            try {
                tblData.setModel(adminCSV.getTableModelDB(adminCSV.readDataFromDB(ManagmentCSV.getLastItemID())));
                DecimalFormat df = new DecimalFormat("#,###,###,##0.0000");
                txtInv0.setText(df.format(Double.parseDouble(adminCSV.stringValueFromDB(adminCSV.queryToDB("select sum(Costo) from Inventory where ID ="+ManagmentCSV.getLastItemID())))));
                txtCompras.setText(df.format(Double.parseDouble(adminCSV.stringValueFromDB(adminCSV.queryToDB("select sum(Costo) from Consumptions where ID ="+ManagmentCSV.getLastItemID())))));
                txtConsumo.setText(df.format(Double.parseDouble(adminCSV.stringValueFromDB(adminCSV.queryToDB("select sum(Costo) from Shopping where ID ="+ManagmentCSV.getLastItemID())))));
                txtTotalCost.setText(df.format(Double.parseDouble(adminCSV.stringValueFromDB(adminCSV.queryToDB("select sum(temp.CostoFinal) from (select Codigo, Descripcion, ((Cantidad+CantidadCompras) - CantidadConsumo)  as 'Cantidad Final', ((Costo+CostoCompras) - CostoConsumo)  as 'CostoFinal' \n" +
                "from FinalInventory where id = "+ManagmentCSV.getLastItemID()+ ") temp")))));
                txtNameInv.setText(adminCSV.stringValueFromDB(adminCSV.queryToDB("select Fecha from FinalInventory where ID ="+ManagmentCSV.getLastItemID())));
//                txtTotalCost.setText(adminCSV.stringValueFromDB(adminCSV.queryToDB("select sum(Costo) from FinalInventory")));
//            JOptionPane.showMessageDialog(null, "Mostrando Inventario final del mes de " + jcbMes.getSelectedItem().toString() +" del " + jcbAno.getSelectedItem().toString());
            match = false;
            JOptionPane.showMessageDialog(null, "Mostrando Inventario final del ultimo cuadre realizado");
            } catch (SQLException ex) {
                Logger.getLogger(JMatchInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aun no se a cuadrado inventario para poder usar esta opcion, \favor intentelo de nuevo cargando los archivos y volviendo a pulsar el boton Cuadrar", "Error al intentar mostrar datos", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnShowResultsActionPerformed

    private void btnMatchExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchExportActionPerformed
        try {
            //        adminCSV.insertToDB("Inventory");
            String fecha = jcbMes.getSelectedItem().toString() + "-" + jcbAno.getSelectedItem().toString();
            
            if (txtInventory.getText().isEmpty() | txtConsumptions.getText().isEmpty() | txtShopping.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,  "Falta cargar documentos","Favor cargar todos los archivos que se piden para poder continuar", JOptionPane.ERROR_MESSAGE);
            }
            else if(jcbMes.getSelectedIndex()==0 | jcbAno.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Falta especificar la fecha de estos documentos",  "Favor cargar todos los archivos que se piden para poder continuar", JOptionPane.ERROR_MESSAGE);
            }
//            else if (adminCSV.stringValueFromDB(adminCSV.queryToDB("select top 1 (fecha) from Inventory where fecha = "+fecha))!= "") {
//                JOptionPane.showMessageDialog(null, "Error al insertar datos",  "Ya existen datos con esta fecha, favor verifique e intente de nuevo", JOptionPane.ERROR_MESSAGE);
//            }
//            else if (adminCSV.queryToDB("select top 1 (fecha) from Inventory where fecha = "+fecha) != null) {
//                JOptionPane.showMessageDialog(null, "Error al insertar datos",  "Ya existen datos con esta fecha, favor verifique e intente de nuevo", JOptionPane.ERROR_MESSAGE);
//            }
            else{
//                ResultSet resultSet = adminCSV.queryToDB("select count (*) from Inventory where fecha = "+fecha);
                if (adminCSV.stringValueFromDB(adminCSV.queryToDB("select count (*) from Inventory where fecha = "+"'"+fecha+"'")).equals("0")) {
                    adminCSV.executeProcedure(fecha);
                    JOptionPane.showMessageDialog(null, "Operacion exitosa");
                    match = true;
                    btnShowResults.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Actualmente existen registros con esta fecha, favor verificar e introducir nuevos datos", "Datos ya existen", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JMatchInventory.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminCSV.enableComponents(jpChooseFiles.getComponents(), true, true);
        btnShowResults.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoaShopping;
    private javax.swing.JButton btnLoadConsumptions;
    private javax.swing.JButton btnLoadIventory;
    private javax.swing.JButton btnMatchExport;
    private javax.swing.JButton btnShowResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField txtCompras;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtConsumptions;
    private javax.swing.JTextField txtInv0;
    private javax.swing.JTextField txtInventory;
    private javax.swing.JTextField txtNameInv;
    private javax.swing.JTextField txtShopping;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
