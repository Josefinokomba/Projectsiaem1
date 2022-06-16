/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.saem.telas;

import br.com.saem.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Josefino Komba
 */
public class TelaPrincipalUsuario extends javax.swing.JFrame {
String deboy;
String NomeF;
    /**
     * Creates new form TelaPrincipalUsuario
     */
    public TelaPrincipalUsuario(String senha) {
        initComponents();
        NomeF = senha;
        CarregarComboArea();
        cmbAreaUser.setSelectedIndex(1);
        ControlarEstado();
//        deboy = (cmbAreaUser.getItemAt(1));
//        System.out.println(cmbCursoUser.getItemAt(1).toString());
//        CarregarComboCurso();
    }
    
    private void ControlarEstado(){
        Connection conex = ModuloConexao.Conector();

        String sql = String.format("SELECT*FROM candidatura where Senha = %s", NomeF);
        try ( Statement stmt = conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                 rs.next();
                   
                   if(rs.getInt("estado") == 1){
                       lblEstado.setText("Estado: Inscrito");
                       jButton2.setEnabled(false);
                   }
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
     private void CarregarComboArea() {

        Connection conex = ModuloConexao.Conector();

        String sql = String.format("SELECT*FROM areaCurso");
        try ( Statement stmt = conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                cmbAreaUser.removeAllItems();
                while (rs.next()) {
                   
                    cmbAreaUser.addItem(rs.getString("NomeArea"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
     
    private void CarregarComboCurso() {

        Connection conex = ModuloConexao.Conector();
       deboy = (String) (cmbAreaUser.getSelectedItem());

        String sql = String.format("SELECT*FROM curso, areaCurso WHERE curso.IdArea = areaCurso.IdArea AND NomeArea = '%s'",deboy);
        try ( Statement stmt = conex.createStatement()) {
            stmt.execute(sql);
            try ( ResultSet rs = stmt.executeQuery(sql)) {
                cmbCursoUser.removeAllItems();
                while (rs.next()) {
                   
                    cmbCursoUser.addItem(rs.getString("NomeCurso"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

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

        jPanel1 = new javax.swing.JPanel();
        cmbCursoUser = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbAreaUser = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblDatauser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIAEM-ALUNOS");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmbCursoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Increver-Se");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Áreas");

        cmbAreaUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAreaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbAreaUserMouseClicked(evt);
            }
        });
        cmbAreaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaUserActionPerformed(evt);
            }
        });

        jLabel3.setText("Cursos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAreaUser, 0, 310, Short.MAX_VALUE)
                            .addComponent(cmbCursoUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton2)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAreaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCursoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(100, 100, 100)
                .addComponent(jButton2)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblEstado.setText("Estado");

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblUser.setText("Usuário");

        lblDatauser.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDatauser.setText("Data");
        lblDatauser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblDatauserAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jMenu2.setText("Sair");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addComponent(lblEstado)
                    .addComponent(lblDatauser))
                .addGap(0, 272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblUser)
                .addGap(37, 37, 37)
                .addComponent(lblEstado)
                .addGap(18, 18, 18)
                .addComponent(lblDatauser, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Connection conex = ModuloConexao.Conector();

        try ( PreparedStatement stmt = conex.prepareStatement("update candidatura set IdCurso = (select IdCurso from curso where nomeCurso = ?), estado = 1 where Senha= ?")) {
            stmt.setString(1, cmbCursoUser.getSelectedItem().toString());
            stmt.setString(2, NomeF);
            stmt.execute();
//            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            System.out.println("Cad sucesso");
            jButton2.setVisible(false);
            

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbAreaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaUserActionPerformed
        // TODO add your handling code here:
        CarregarComboCurso();
        
    }//GEN-LAST:event_cmbAreaUserActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
         int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
            
        }
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void lblDatauserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblDatauserAncestorAdded
        // TODO add your handling code here:
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblDatauser.setText(formatador.format(data));
    }//GEN-LAST:event_lblDatauserAncestorAdded

    private void cmbAreaUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbAreaUserMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbAreaUserMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalUsuario("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAreaUser;
    private javax.swing.JComboBox<String> cmbCursoUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatauser;
    private javax.swing.JLabel lblEstado;
    public static javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
