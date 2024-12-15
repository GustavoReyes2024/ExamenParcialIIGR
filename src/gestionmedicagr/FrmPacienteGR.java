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
public class FrmPacienteGR extends javax.swing.JFrame {

    /**
     * Creates new form FrmPacienteGR
     */
    public FrmPacienteGR() {
        initComponents();
    }
    
    DefaultTableModel modelo;
    
    Conexion conn = new Conexion("gestionmedicagr");
    String mensaje = "";
    
     public void InsertNewPacienteGR() {
                Connection con = null;
                PreparedStatement ps = null;

                try {
                    
                    String name = txtNombreGR.getText().trim();
                    String age = txtEdadGR.getText().trim();
                    String direction = txtDireccionGR.getText().trim();
                    String historial = txtHistorialGR.getText().trim();
                    String enfermedad = txtEnfermedadGR.getText().trim();
                    

                    
                    con = conn.getConexion();
                    String sql = "INSERT INTO pacientes (name, direction, edad, historial, enfermedad) VALUES (?, ?, ?, ?,?)";
                    ps = con.prepareStatement(sql);

                    // Asignar los valores a los parámetros de la consulta
                    ps.setString(1, name);
                    ps.setString(2, direction);
                    ps.setString(3, age);
                    ps.setString(4, historial);
                    ps.setString(5, enfermedad);

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
     
     
            public void buscarPacientesGR(){

            Object dataClient[] = new Object[3];
            modelo = (DefaultTableModel) tblPacientesGR.getModel();
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Statement st = null;
            modelo.setRowCount(0);

            try {
                con = conn.getConexion();
                st = con.createStatement();
                rs = st.executeQuery("select * from pacientes where name like '%" + txtBuscarNombre.getText() + "%'");

                while(rs.next()){
                    dataClient[0] = rs.getString("id");
                    dataClient[1] = rs.getString("name");
                    dataClient[2] = rs.getString("direction");

                    modelo.addRow(dataClient);

                    tblPacientesGR.setModel(modelo);

                }
            } catch (Exception e) {
                System.out.println("Error en la consulta. problema en BuscarCliente");
            }

        }
            
            
            public void mostrarPacienteGR(String Id){


                Connection con = null;

                ResultSet rs = null;
                Statement st = null;


                try {
                    con = conn.getConexion();
                    st = con.createStatement();
                    rs = st.executeQuery("select * from pacientes where id = '"+ Id +"'");

                    while(rs.next()){
                        txtId.setText(rs.getString("id"));
                        txtNombreGR.setText(rs.getString("name"));
                        txtEdadGR.setText(rs.getString("edad"));
                        txtDireccionGR.setText(rs.getString("direction"));
                        txtHistorialGR.setText(rs.getString("historial"));
                        txtEnfermedadGR.setText(rs.getString("enfermedad"));
                    }
                    
                } catch (Exception e) {
                    System.out.println("Error en la consulta.");
                }

            }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreGR = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHistorialGR = new javax.swing.JTextField();
        txtEnfermedadGR = new javax.swing.JTextField();
        txtEdadGR = new javax.swing.JTextField();
        txtDireccionGR = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientesGR = new javax.swing.JTable();
        btnAceptarGR = new javax.swing.JButton();
        btnEliminarGR = new javax.swing.JButton();
        btnActualizarGR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        jLabel5.setText("Edad");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 50, -1));

        txtNombreGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 110, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enfermedad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        txtHistorialGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHistorialGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtHistorialGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 110, -1));

        txtEnfermedadGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnfermedadGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtEnfermedadGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 110, -1));

        txtEdadGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdadGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 110, -1));

        txtDireccionGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionGRActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccionGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 110, -1));

        tblPacientesGR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Direccion"
            }
        ));
        tblPacientesGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesGRMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientesGR);
        if (tblPacientesGR.getColumnModel().getColumnCount() > 0) {
            tblPacientesGR.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblPacientesGR.getColumnModel().getColumn(0).setMaxWidth(30);
            tblPacientesGR.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblPacientesGR.getColumnModel().getColumn(1).setMaxWidth(200);
            tblPacientesGR.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblPacientesGR.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 250, 120));

        btnAceptarGR.setText("Aceptar");
        btnAceptarGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarGRActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        btnEliminarGR.setText("Eliminar");
        jPanel1.add(btnEliminarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        btnActualizarGR.setText("Actualizar");
        jPanel1.add(btnActualizarGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Historial");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 60, -1));

        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyPressed(evt);
            }
        });
        jPanel1.add(txtBuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 90, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreGRActionPerformed

    private void txtEnfermedadGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnfermedadGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnfermedadGRActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txtEdadGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadGRActionPerformed

    private void txtDireccionGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionGRActionPerformed

    private void txtHistorialGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHistorialGRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHistorialGRActionPerformed

    private void btnAceptarGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarGRActionPerformed
        // TODO add your handling code here:
        InsertNewPacienteGR();
    }//GEN-LAST:event_btnAceptarGRActionPerformed

    private void txtBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyPressed
        buscarPacientesGR();
    }//GEN-LAST:event_txtBuscarNombreKeyPressed

    private void tblPacientesGRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesGRMouseClicked
        int fila =  tblPacientesGR.getSelectedRow();
        String Id = tblPacientesGR.getValueAt(fila, 0).toString();
        mostrarPacienteGR(Id);
    }//GEN-LAST:event_tblPacientesGRMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPacienteGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPacienteGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPacienteGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPacienteGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPacienteGR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarGR;
    private javax.swing.JButton btnActualizarGR;
    private javax.swing.JButton btnEliminarGR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblPacientesGR;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtDireccionGR;
    private javax.swing.JTextField txtEdadGR;
    private javax.swing.JTextField txtEnfermedadGR;
    private javax.swing.JTextField txtHistorialGR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreGR;
    // End of variables declaration//GEN-END:variables
}
