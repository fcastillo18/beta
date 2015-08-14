/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsReception;

import ClassesReception.MainControl;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//sdfsd
/**
 *
 * @author fcastillo
 */
public class JReceptionLog extends javax.swing.JInternalFrame {
    

    /**
     * Creates new form JReceptionForm
     */
    public JReceptionLog() {
        initComponents();
        tblLogReception.setModel(mc.getModelDetails(mc.readDataFromTableDetail()));
        mc.enableComponents(jpData.getComponents(), false, false);
        jtaObservation.setEnabled(false);
        changeColumnSize(tblLogReception);
        //poner en un hilo la hora
        jbDate.setText(df.format(new Date()));        
    }
    //esta variable sera paa evitar que cuando esten en el boton nuevo puedan cargar datos del evento mouse clicked
    private boolean nuevo;
    TableColumnModel column;
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
    MainControl mc= new MainControl();
    boolean modified = false;
    
    private void changeColumnSize(JTable table){
        this.column = table.getColumnModel();
        column.getColumn(0).setPreferredWidth(10);
        column.getColumn(1).setPreferredWidth(80);
        column.getColumn(2).setPreferredWidth(100);
        column.getColumn(3).setPreferredWidth(150);
        column.getColumn(4).setPreferredWidth(80);
        column.getColumn(5).setPreferredWidth(80);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcDateIn = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtReceivedBy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdcDateOut = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jcCategory = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaObservation = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jpLogReception = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogReception = new javax.swing.JTable();
        jbDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Historial de recepción");
        setPreferredSize(new java.awt.Dimension(972, 573));

        jpData.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de material recibido"));

        jLabel1.setText("Fecha de recepción:*");

        jLabel2.setText("Suplidor:*");

        jLabel3.setText("Descripción:*");

        jLabel5.setText("Recibido por:");

        jLabel6.setText("Fecha de entrega:");

        jLabel4.setText("Categoria:");

        jcCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Finanzas", "Compras", "Ventas", "Materia Prima", "Almacen", "TI" }));

        jLabel8.setText("Estado:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendiente", "Entregado", " " }));

        jButton1.setText("Filtrar");

        jtaObservation.setColumns(20);
        jtaObservation.setRows(5);
        jScrollPane2.setViewportView(jtaObservation);

        jLabel10.setText("Observacion:");

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDateOut, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jpDataLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpDataLayout.createSequentialGroup()
                                        .addComponent(txtReceivedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSupplier))
                                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10)
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDataLayout.createSequentialGroup()
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtReceivedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpDataLayout.createSequentialGroup()
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jcCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdcDateIn, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcDateOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpLogReception.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial recepción"));
        jpLogReception.setPreferredSize(new java.awt.Dimension(972, 573));

        tblLogReception.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha entrada", "Suplidor", "Descripcion", "Registrado por", "Fecha entragado"
            }
        ));
        tblLogReception.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLogReceptionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLogReception);
        if (tblLogReception.getColumnModel().getColumnCount() > 0) {
            tblLogReception.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLogReception.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLogReception.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblLogReception.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLogReception.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLogReception.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jpLogReceptionLayout = new javax.swing.GroupLayout(jpLogReception);
        jpLogReception.setLayout(jpLogReceptionLayout);
        jpLogReceptionLayout.setHorizontalGroup(
            jpLogReceptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogReceptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpLogReceptionLayout.setVerticalGroup(
            jpLogReceptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jbDate.setText("jLabel9");

        jLabel7.setText("Fecha:");

        jButton2.setText("Marcar recibido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Refrescar Tabla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDate)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpLogReception, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpLogReception, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLogReceptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLogReceptionMouseClicked
//        MainControl mc = new MainControl();
        if (nuevo == false) {
            try {
                tblLogReception.setEnabled(true);
                int rowSel = tblLogReception.getSelectedRow();
                int dtID = (int) tblLogReception.getValueAt(rowSel, 0);
                mc.llenarObjetos(mc.findRow(dtID));
                txtDescription.setText(mc.item.getDescription());
                txtSupplier.setText(mc.item.getSupplierName());
                txtReceivedBy.setText(mc.detail.getDtReceivedBy());
                jdcDateIn.setDate(mc.detail.getDateIn());
                jdcDateOut.setDate(mc.detail.getDateOut());
                jcCategory.setSelectedItem(mc.detail.getDtCategory());
                jtaObservation.setText(mc.detail.getDtObservation());
            } catch (Exception e) {
                System.out.println("Error -1 al click en tabla");
            }
        }
        
    }//GEN-LAST:event_tblLogReceptionMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (mc.detail.getDtStatus().equals("Entregado")) {
                JOptionPane.showMessageDialog(null, "Este item ya esta marcado como entregado y no puede ser modificado "
                        + "\nContacte al administrado para mayor informacion");
            }else{
                int resp = JOptionPane.showConfirmDialog(null, "¿Desea marcar el item seleccionado como recibido?");
                if (resp == JOptionPane.YES_OPTION) {
                    //solo se modifican los campos para quien lo recibe que son fecha y
                    mc.detail.setDtReceivedBy(MainControl.user.getUserName());
                    mc.detail.setDtStatus(jcbStatus.getItemAt(2).toString());
                    mc.detail.setDateOut(MainControl.getCurrentTimeStamp());
                    mc.detail.setDtStatus("Entregado");
                    mc.modifiedItem(mc.item, mc.detail);
                    //Guardar Log de la trasaccion
                    mc.createLogDetail(mc.detail, MainControl.getCurrentTimeStamp(), MainControl.user.getUserName());
                    tblLogReception.setModel(mc.getModelDetails(mc.readDataFromTableDetail()));
                    changeColumnSize(tblLogReception);
                    JOptionPane.showMessageDialog(null, "Realizado Exitosamente");
                }else{
                //nada
                }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tblLogReception.setModel(mc.getModelDetails(mc.readDataFromTableDetail()));
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbDate;
    private javax.swing.JComboBox jcCategory;
    private javax.swing.JComboBox jcbStatus;
    private com.toedter.calendar.JDateChooser jdcDateIn;
    private com.toedter.calendar.JDateChooser jdcDateOut;
    private javax.swing.JPanel jpData;
    private javax.swing.JPanel jpLogReception;
    private javax.swing.JTextArea jtaObservation;
    private javax.swing.JTable tblLogReception;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtReceivedBy;
    private javax.swing.JTextField txtSupplier;
    // End of variables declaration//GEN-END:variables
}
