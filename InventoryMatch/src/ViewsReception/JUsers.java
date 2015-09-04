/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsReception;

import ClassesReception.MainControl;
import ClassesReception.User;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author fcastillo
 */
public class JUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form JUsers
     */
    public JUsers() {
        initComponents();
        mc = new MainControl();
        tblUser.setModel(mc.getDataFromTableUser());
        jListDisponibles.setListData(mc.listModelMenues());
        /*una vez se carguen los  menues a la lista en la sentencia de arriba
            procedo a llenar el vector1 con esos datos
        */
        fillVectorDisponibles();
    }
    MainControl mc;
    Vector<String> vectorMenuesDisponibles = new Vector<String>();
    Vector<String> vectorMenuesUsuario = new Vector<String>();
    boolean modificar = false;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDatosUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnModified = new javax.swing.JButton();
        btnDelete00 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jpMenuesAccess = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListDisponibles = new javax.swing.JList();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListUsuario = new javax.swing.JList();
        btnAddAll = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbCategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento de usuarios");

        jpDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de usuario"));

        jLabel1.setText("*Nombre:");

        txtName.setEnabled(false);

        jLabel2.setText("Apellido:");

        txtLastName.setEnabled(false);

        jLabel3.setText("*Usuario:");

        txtUser.setEnabled(false);

        jLabel4.setText("*Password:");

        jLabel7.setText("Cambiar Password al iniciar sesion");
        jLabel7.setEnabled(false);

        txtPass.setEnabled(false);

        jLabel9.setText("*Campos obligatorios");

        javax.swing.GroupLayout jpDatosUsuarioLayout = new javax.swing.GroupLayout(jpDatosUsuario);
        jpDatosUsuario.setLayout(jpDatosUsuarioLayout);
        jpDatosUsuarioLayout.setHorizontalGroup(
            jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosUsuarioLayout.createSequentialGroup()
                        .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPass)))
                    .addGroup(jpDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(jpDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDatosUsuarioLayout.setVerticalGroup(
            jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnModified.setText("Modificar");
        btnModified.setEnabled(false);
        btnModified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifiedActionPerformed(evt);
            }
        });

        btnDelete00.setText("Eliminar");
        btnDelete00.setEnabled(false);

        btnSave.setText("Guardar");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModified)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete00)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnModified)
                    .addComponent(btnDelete00)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMenuesAccess.setBorder(javax.swing.BorderFactory.createTitledBorder("Acceso a menu"));

        jListDisponibles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Historial cambios rec", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListDisponibles.setEnabled(false);
        jListDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDisponiblesMouseClicked(evt);
            }
        });
        jListDisponibles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jListDisponiblesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jListDisponibles);

        btnAdd.setText("Añadir >");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });

        btnDelete.setText("< Eliminar");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        jListUsuario.setEnabled(false);
        jListUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUsuarioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListUsuario);

        btnAddAll.setText("Añadir todos >>");
        btnAddAll.setEnabled(false);

        btnDeleteAll.setText("<< Eliminar todos");
        btnDeleteAll.setEnabled(false);

        jLabel6.setText("Menues disponibles:");

        jLabel8.setText("*Menus a agregar:");

        jcbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Finanzas", "Compras", "Produccion", "Almacen" }));
        jcbCategory.setEnabled(false);

        jLabel5.setText("Categoria:");

        javax.swing.GroupLayout jpMenuesAccessLayout = new javax.swing.GroupLayout(jpMenuesAccess);
        jpMenuesAccess.setLayout(jpMenuesAccessLayout);
        jpMenuesAccessLayout.setHorizontalGroup(
            jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                        .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteAll))
                        .addGap(15, 15, 15)))
                .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpMenuesAccessLayout.setVerticalGroup(
            jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                        .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpMenuesAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4)))
                    .addGroup(jpMenuesAccessLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteAll)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDatosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpMenuesAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpMenuesAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDatosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (jListDisponibles.getSelectedIndex() >= 0) {//si es mayor que 0 es por que se selecciono algo
                //capturo valor seleccionado de la primera lista para pasarlo a la otra lista
            vectorMenuesUsuario.add(jListDisponibles.getSelectedValue().toString());
            //elimino el seleccionado del primera
            vectorMenuesDisponibles.remove(jListDisponibles.getSelectedValue().toString());
            //ordeno los datos en ambos vectores
            sortVector(vectorMenuesUsuario);
            sortVector(vectorMenuesDisponibles);
            //seteo ambas listas con sus correspondientes vectores ya ordenados
            jListDisponibles.setListData(vectorMenuesDisponibles);
            //agrego el valor de la Lista 1 a las Lista 2
            jListUsuario.setListData(vectorMenuesUsuario);
            btnDelete.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un item de la lista de 'Menues Disponibles' para poder continuar");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (jListUsuario.getSelectedIndex() >= 0) {
            //capturo valor seleccionado de la primera lista para pasarlo a la otra lista
        vectorMenuesDisponibles.add(jListUsuario.getSelectedValue().toString());
        //elimino el seleccionado del primera
        vectorMenuesUsuario.remove(jListUsuario.getSelectedValue().toString());
        //ordeno los datos en ambos vectores
        sortVector(vectorMenuesUsuario);
        sortVector(vectorMenuesDisponibles);
        //setear cada Jlist con sus datos
        jListDisponibles.setListData(vectorMenuesDisponibles);
        jListUsuario.setListData(vectorMenuesUsuario);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un item de la lista 'Menues a agregar' para poder continuar");
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jListDisponiblesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListDisponiblesKeyPressed
        
    }//GEN-LAST:event_jListDisponiblesKeyPressed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (modificar == false) {
                //si alguno de los campos requeridos estan incompletos no continua la accion de guardado
            if (txtName.getText().trim().equals("") | txtUser.getText().trim().equals("") | txtPass.getText().trim().equals("") | jListUsuario.getSelectedIndices().length < 0) {
                JOptionPane.showMessageDialog(null, "Uno o mas campos obligatorios estan incompletos \nFavor completar para poder continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            else{
                User user = new User(txtName.getText(), txtLastName.getText(), txtUser.getText(), txtPass.getText(), jcbCategory.getSelectedItem().toString(), jCheckBox1.isSelected());
                mc.createUser(user);
                int cont = 0;
                while (cont < vectorMenuesUsuario.size()) {            
                    mc.insertMenuesAccess(mc.getLastUserID(), vectorMenuesUsuario.get(cont));
                    cont++;
                }
                tblUser.setModel(mc.getDataFromTableUser());
                JOptionPane.showMessageDialog(null, "Datos insertados con exito", "Datos guardados", JOptionPane.INFORMATION_MESSAGE);
                mc.enableComponents(jpDatosUsuario.getComponents(), false, true);
                jListUsuario.setEnabled(false);
                jListDisponibles.setEnabled(false);
                jListDisponibles.setListData(mc.listModelMenues());
                jListUsuario.setListData(new Vector<String>());
                btnSave.setEnabled(false);
                btnAdd.setEnabled(false);
                btnDelete.setEnabled(false);
            }
        }else{
            //guardar dato modificado
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        mc.enableComponents(jpDatosUsuario.getComponents(), true, true);
        jListUsuario.setEnabled(true);
        jListDisponibles.setEnabled(true);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(true);
        jcbCategory.setEnabled(true);
        vectorMenuesUsuario.clear();
        jLabel7.setEnabled(true);
        fillVectorDisponibles();
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void jListDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDisponiblesMouseClicked
        btnAdd.setFocusable(true);
    }//GEN-LAST:event_jListDisponiblesMouseClicked

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void jListUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUsuarioMouseClicked
        btnDelete.setFocusable(true);
    }//GEN-LAST:event_jListUsuarioMouseClicked

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDeleteActionPerformed(null);
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        
        btnModified.setEnabled(true);
        int row = tblUser.getSelectedRow();
        String userName = tblUser.getValueAt(row, 0).toString();
        //creo objeto con valores 
        User user = mc.findUser(userName);
        //primero seteo textbox con valores del elemento seleccionado en la tabla
        txtName.setText(user.getFirstName());
        txtLastName.setText(user.getLastName());
        txtUser.setText(user.getUserName());
        txtPass.setText(user.getPassword());
        //luego lleno la lista de menues de usuario
        vectorMenuesUsuario = mc.listUserMenues(user.getId());
        jListUsuario.setListData(vectorMenuesUsuario);
//        vectorMenuesDisponibles = mc.listModelUsers;
        //*****************************************************
        //lleno el vector con todos los menues de la aplicacion para la comparacion mas abajo
        Vector<String> vectorMenues = mc.listModelMenues();
        //*****************************************************
        //elimino los menues de la primera lista que ya estan en la segunda
//        int cont = 0;
        for (String mnDisponible : vectorMenues) {
            //si el menu disponible ya esta en la lista menu de usuarios, eliminar
            for (String mnUsuario : vectorMenuesUsuario) {
                if (mnDisponible.equals(mnUsuario)) {
//                    elimino el menu del usuario que haga macth en la lista de los disponibles
                    vectorMenuesDisponibles.remove(mnUsuario);
                    System.out.println("Entro menu: " + mnUsuario);
                }
            }
            //cargo la lista de disponibles con el elemento eliminado (mas bien, esta en la lista de menues de usuario)
            
        }
        jListDisponibles.setListData(vectorMenuesDisponibles);
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnModifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifiedActionPerformed
        modificar = true;
        mc.enableComponents(jpDatosUsuario.getComponents(), true, false);
        jListUsuario.setEnabled(true);
        jListDisponibles.setEnabled(true);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(true);
        jcbCategory.setEnabled(true);
        jLabel7.setEnabled(true);
        fillVectorDisponibles();
        
    }//GEN-LAST:event_btnModifiedActionPerformed
    private void sortVector(Vector<String> vector){
        Collections.sort(vector);
    }
    public void fillVectorDisponibles(){
        int cont = 0;
        while (cont < jListDisponibles.getModel().getSize()) {
//            vectorMenuesDisponibles.clear();
            vectorMenuesDisponibles.add(jListDisponibles.getModel().getElementAt(cont).toString());
            cont++;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAll;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete00;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnModified;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListDisponibles;
    private javax.swing.JList jListUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox jcbCategory;
    private javax.swing.JPanel jpDatosUsuario;
    private javax.swing.JPanel jpMenuesAccess;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
