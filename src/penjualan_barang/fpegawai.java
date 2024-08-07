/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package penjualan_barang;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daulah
 */
public class fpegawai extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form fpegawai
     */
    public fpegawai() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();

        tb.setModel(model);

        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("jenis_kelamin");
        model.addColumn("email");
        model.addColumn("no_telp");
        model.addColumn("agama");
        model.addColumn("alamat");
        loadData();
    }

    public void loadData() {
        btn_tambah.setEnabled(true);
        btn_ubah.setEnabled(false);
        txt_username2.setEnabled(true);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_login";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("username");
                o[1] = r.getString("password");
                o[2] = r.getString("jenis_kelamin");
                o[3] = r.getString("email");
                o[4] = r.getString("no_telp");
                o[5] = r.getString("agama");
                o[6] = r.getString("alamat");

                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_username2 = new javax.swing.JTextField();
        txt_password2 = new javax.swing.JPasswordField();
        btn_tambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_retype = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_agama = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        txt_telp = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pengolahan data pegawai");

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 31, 107, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 107, -1));

        txt_username2.setBackground(new java.awt.Color(108, 122, 137));
        txt_username2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_username2.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(txt_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 31, 188, -1));

        txt_password2.setBackground(new java.awt.Color(108, 122, 137));
        txt_password2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password2.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(txt_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 78, 188, -1));

        btn_tambah.setBackground(new java.awt.Color(34, 167, 240));
        btn_tambah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 286, 150, 38));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Retype");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 129, 107, -1));

        txt_retype.setBackground(new java.awt.Color(108, 122, 137));
        txt_retype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_retype.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(txt_retype, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 130, 188, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("No. Telp");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 31, 92, -1));

        tb.setModel(new javax.swing.table.DefaultTableModel(
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
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 358, 801, 214));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Jenis Kelamin");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 171, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Email");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 211, 113, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Agama");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 77, 92, -1));

        cb_agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Kristen", "Katolik", "Hindu", "Budha", "Ateis" }));
        cb_agama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_agamaActionPerformed(evt);
            }
        });
        jPanel2.add(cb_agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 79, 185, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Alamat");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 129, 92, -1));

        btn_hapus.setBackground(new java.awt.Color(34, 167, 240));
        btn_hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 286, 150, 38));

        btn_ubah.setBackground(new java.awt.Color(34, 167, 240));
        btn_ubah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 286, 150, 38));

        txt_telp.setBackground(new java.awt.Color(108, 122, 137));
        txt_telp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_telp.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(txt_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 32, 188, -1));

        txt_email.setBackground(new java.awt.Color(108, 122, 137));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 212, 188, -1));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane2.setViewportView(txt_alamat);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 129, 185, 107));

        buttonGroup1.add(laki);
        laki.setForeground(new java.awt.Color(255, 255, 255));
        laki.setText("Laki-Laki");
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });
        jPanel2.add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 171, -1, -1));

        buttonGroup1.add(perempuan);
        perempuan.setForeground(new java.awt.Color(255, 255, 255));
        perempuan.setText("Perempuan");
        jPanel2.add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 171, -1, -1));

        btn_back.setBackground(new java.awt.Color(242, 38, 19));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        fmenu fb = new fmenu();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void cb_agamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_agamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_agamaActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        if (txt_username2.getText().equals("")
                || txt_password2.getPassword().equals("")
                || laki.getText().equals("")
                || txt_email.getText().equals("")
                || txt_telp.getText().equals("")
                || cb_agama.getSelectedItem().equals("")
                || txt_alamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String user = txt_username2.getText();
            String pass = txt_password2.getText();

            String emaill = txt_email.getText();
            String notelpp = txt_telp.getText();
            String agamaa = (String) cb_agama.getSelectedItem();
            String alamatt = txt_alamat.getText();
            String jk = "";
            if (laki.isSelected()) {
                jk = laki.getText();
            } else {
                jk = perempuan.getText();
            }
            try {
                Connection c = koneksi.getKoneksi();

                String sql = "INSERT INTO tbl_login VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, user);
                p.setString(2, pass);
                p.setString(3, jk);
                p.setString(4, emaill);
                p.setString(5, notelpp);
                p.setString(6, agamaa);
                p.setString(7, alamatt);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                txt_username2.setText("");
                txt_password2.setText("");
                txt_retype.setText("");
                buttonGroup1.clearSelection();
                txt_email.setText("");
                txt_telp.setText("");
                cb_agama.setSelectedItem("");
                txt_alamat.setText("");

                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if (txt_username2.getText().equals("")
                || txt_password2.getText().equals("")
                || laki.getText().equals("")
                || txt_email.getText().equals("")
                || txt_telp.getText().equals("")
                || cb_agama.getSelectedItem().equals("")
                || txt_alamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                String sql = "delete from tbl_login where username='" + txt_username2.getText() + "'";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "berhasil di hapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            loadData();
            txt_username2.setText("");
            txt_password2.setText("");
            txt_retype.setText("");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        int i = tb.getSelectedRow();
        if (i == -1) {
            return;
        }
        String user = (String) model.getValueAt(i, 0);

        try {
            Connection c = koneksi.getKoneksi();

            String jk = "";
            if (laki.isSelected()) {
                jk = laki.getText();
            } else if (perempuan.isSelected()) {
                jk = perempuan.getText();
            }

            String email = txt_email.getText();
            String noTelp = txt_telp.getText();
            String agama = (String) cb_agama.getSelectedItem();
            String alamat = txt_alamat.getText();

            String sql = "UPDATE tbl_login SET password = ?, jenis_kelamin = ?, email = ?, no_telp = ?, agama = ?, alamat = ? WHERE username = ?";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, txt_password2.getText());
            p.setString(2, jk);
            p.setString(3, email);
            p.setString(4, noTelp);
            p.setString(5, agama);
            p.setString(6, alamat);
            p.setString(7, user);

            p.executeUpdate();
            p.close();

        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
        } finally {
            loadData();
            txt_username2.setText("");
            txt_password2.setText("");
            txt_retype.setText("");
            buttonGroup1.clearSelection();
            txt_email.setText("");
            txt_telp.setText("");
            cb_agama.setSelectedItem("");
            txt_alamat.setText("");
            btn_tambah.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
            txt_username2.requestFocus();
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lakiActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        txt_username2.setEnabled(false);
        int i = tb.getSelectedRow();
        if (i == -1) {
            return;
        }
        String user = (String) model.getValueAt(i, 0);
        txt_username2.setText(user);

        String pass = (String) model.getValueAt(i, 1);
        txt_password2.setText(pass);
        txt_retype.setText(pass);

        String jk = (String) model.getValueAt(i, 2);
        String l = "Laki-Laki";
        if (jk.equals(l)) {
            laki.setSelected(true);
        } else {
            perempuan.setSelected(true);
        }

        String emaill = (String) model.getValueAt(i, 3);
        txt_email.setText(emaill);

        String notelpp = (String) model.getValueAt(i, 4);
        txt_telp.setText(notelpp);

        String agamaa = (String) model.getValueAt(i, 5);
        cb_agama.setSelectedItem(agamaa);

        String alamatt = (String) model.getValueAt(i, 6);
        txt_alamat.setText(alamatt);
    }//GEN-LAST:event_tbMouseClicked

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
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fpegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_agama;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton laki;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JTable tb;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_password2;
    private javax.swing.JPasswordField txt_retype;
    private javax.swing.JTextField txt_telp;
    private javax.swing.JTextField txt_username2;
    // End of variables declaration//GEN-END:variables
}
