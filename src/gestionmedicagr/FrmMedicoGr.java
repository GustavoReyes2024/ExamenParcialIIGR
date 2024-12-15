/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionmedicagr;

import DAO.Conexion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.stream.Collectors.toList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FrmMedicoGr extends javax.swing.JFrame {

    /**
     * Creates new form FrmMedicoGr
     */
    public FrmMedicoGr() {
        initComponents();
    }
    
    DefaultTableModel modelo;
    
    Conexion conn = new Conexion("gestionmedicagr");
    String mensaje = "";

        public void InsertNewMedicoGR() {
                Connection con = null;
                PreparedStatement ps = null;

                try {
                    
                    String name = txtNombreGR.getText().trim();
                    String age = txtEdadGR.getText().trim();
                    String direction = txtDireccionGR.getText().trim();
                    String experiency = txtExperienciaGR.getText().trim();
                    String especialidad = String.valueOf(cmbEspecialidadGR.getSelectedItem()).trim();
                    

                    
                    con = conn.getConexion();
                    String sql = "INSERT INTO medicos (name, direction, edad, especialidad, experiencia) VALUES (?, ?, ?, ?,?)";
                    ps = con.prepareStatement(sql);

                    // Asignar los valores a los parámetros de la consulta
                    ps.setString(1, name);
                    ps.setString(2, direction);
                    ps.setString(3, age);
                    ps.setString(4, especialidad);
                    ps.setString(5, experiency);

                    // Ejecutar la inserción y verificar el resultado
                    int rowsInserted = ps.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "¡Datos insertados exitosamente!");
                        toList(); // Refrescar la lista si es necesario
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo insertar la información.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al insertar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (ps != null) ps.close();
                        if (con != null) con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        
        
                    public void buscarMedicoGR(){

            Object dataClient[] = new Object[3];
            modelo = (DefaultTableModel) tblMedicosGR.getModel();
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Statement st = null;
            modelo.setRowCount(0);

            try {
                con = conn.getConexion();
                st = con.createStatement();
                rs = st.executeQuery("select * from medicos where name like '%" + txtBuscarNombre.getText() + "%'");

                while(rs.next()){
                    dataClient[0] = rs.getString("id");
                    dataClient[1] = rs.getString("name");
                    dataClient[2] = rs.getString("direction");

                    modelo.addRow(dataClient);

                    tblMedicosGR.setModel(modelo);

                }
            } catch (Exception e) {
                System.out.println("Error en la consulta. problema en BuscarCliente");
            }

        }
                    
                           public void mostrarMedicoGR(String Id){


                Connection con = null;

                ResultSet rs = null;
                Statement st = null;


                try {
                    con = conn.getConexion();
                    st = con.createStatement();
                    rs = st.executeQuery("select * from medicos where id = '"+ Id +"'");

                    while(rs.next()){
                        txtId.setText(rs.getString("id"));
                        txtNombreGR.setText(rs.getString("name"));
                        txtEdadGR.setText(rs.getString("edad"));
                        txtDireccionGR.setText(rs.getString("direction"));
                        txtExperienciaGR.setText(rs.getString("experiencia"));
                        cmbEspecialidadGR.setSelectedItem(rs.getString("especialidad"));
                    }
                } catch (Exception e) {
                    System.out.println("Error en la consulta.");
                }

            }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreGR = new javax.swing.JTextField();
        txtEdadGR = new javax.swing.JTextField();
        txtDireccionGR = new javax.swing.JTextField();
        txtExperienciaGR = new javax.swing.JTextField();
        cmbEspecialidadGR = new javax.swing.JComboBox<>();
        btnActualizarGR = new javax.swing.JButton();
        btnAceptarGR = new javax.swing.JButton();
        btnEliminarGR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicosGR = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Especialidad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 81, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("años experiencia");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 121, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 161, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direccion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 195, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 241, -1, -1));

        txtNombreGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 158, 104, -1));
        jPanel1.add(txtEdadGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 238, 104, -1));
        jPanel1.add(txtDireccionGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 192, 104, -1));
        jPanel1.add(txtExperienciaGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 118, 104, -1));

        cmbEspecialidadGR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neurologia ", "Ginecologia", "Pediatria", "Urologia", "Cardiologia" }));
        jPanel1.add(cmbEspecialidadGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 78, 104, -1));

        btnActualizarGR.setText("Actualizar");
        btnActualizarGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarGRActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        btnAceptarGR.setText("Aceptar");
        btnAceptarGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarGRActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        btnEliminarGR.setText("Eliminar");
        jPanel1.add(btnEliminarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 315, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 33, -1, -1));

        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyPressed(evt);
            }
        });
        jPanel1.add(txtBuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 30, 90, -1));

        tblMedicosGR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Direccion"
            }
        ));
        tblMedicosGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicosGRMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicosGR);
        if (tblMedicosGR.getColumnModel().getColumnCount() > 0) {
            tblMedicosGR.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblMedicosGR.getColumnModel().getColumn(0).setMaxWidth(30);
            tblMedicosGR.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblMedicosGR.getColumnModel().getColumn(1).setMaxWidth(200);
            tblMedicosGR.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblMedicosGR.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 110, 290, 120));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarGRActionPerformed

    private void txtNombreGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreGRActionPerformed

    private void btnAceptarGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarGRActionPerformed
        // TODO add your handling code here:
        InsertNewMedicoGR();
    }//GEN-LAST:event_btnAceptarGRActionPerformed

    private void txtBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyPressed
        buscarMedicoGR();
    }//GEN-LAST:event_txtBuscarNombreKeyPressed

    private void tblMedicosGRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicosGRMouseClicked
        int fila =  tblMedicosGR.getSelectedRow();
        String Id = tblMedicosGR.getValueAt(fila, 0).toString();
        mostrarMedicoGR(Id);
    }//GEN-LAST:event_tblMedicosGRMouseClicked

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMedicoGr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMedicoGr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMedicoGr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMedicoGr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMedicoGr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarGR;
    private javax.swing.JButton btnActualizarGR;
    private javax.swing.JButton btnEliminarGR;
    private javax.swing.JComboBox<String> cmbEspecialidadGR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedicosGR;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtDireccionGR;
    private javax.swing.JTextField txtEdadGR;
    private javax.swing.JTextField txtExperienciaGR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreGR;
    // End of variables declaration//GEN-END:variables
}
