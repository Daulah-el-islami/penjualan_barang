/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package penjualan_barang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daulah
 */

public class fbarang extends javax.swing.JFrame {
    private DefaultTableModel model;

    /**
     * Creates new form fbarang
     */
    
    public fbarang() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        tabelinput.setModel(model);
        model.addColumn("kode_barang");
        model.addColumn("nama_barang");
        model.addColumn("jumlah_barang");
        model.addColumn("harga_beli");
        model.addColumn("harga_jual");
        loadData();
        kode();
    }
    
        public final void loadData() {
        btn_tambah2.setEnabled(true);
        btn_hapus2.setEnabled(false);
        btn_ubah2.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_barang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kode_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jumlah_barang");
                o[3] = r.getString("harga_beli");
                o[4] = r.getString("harga_jual");
                model.addRow(o);
            }

            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memuat data: " + e.getMessage());
        }
    }


    private void kode() {
        try {
            Connection c = penjualan_barang.koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_barang ORDER by kode_barang desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("kode_barang").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_kodebarang.setText("B" + Nol + AN);
            } else {
                txt_kodebarang.setText("B0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_kodebarang = new javax.swing.JTextField();
        btn_tambah2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        btn_hapus2 = new javax.swing.JButton();
        btn_ubah2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        txt_jumlahbarang = new javax.swing.JTextField();
        txt_cari = new javax.swing.JTextField();
        txt_hargabeli = new javax.swing.JTextField();
        txt_hargajual = new javax.swing.JTextField();
        btn_back2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pengolahan data barang");

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(236, 240, 241));
        jLabel20.setText("Kode Barang");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 35, 126, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(236, 240, 241));
        jLabel21.setText("Nama Barang");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 75, 126, -1));

        txt_kodebarang.setBackground(new java.awt.Color(108, 122, 137));
        txt_kodebarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_kodebarang.setForeground(new java.awt.Color(228, 241, 254));
        txt_kodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodebarangActionPerformed(evt);
            }
        });
        jPanel4.add(txt_kodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 34, 188, -1));

        btn_tambah2.setBackground(new java.awt.Color(34, 167, 240));
        btn_tambah2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_tambah2.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah2.setText("Tambah");
        btn_tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah2ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_tambah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 34, 150, 38));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(236, 240, 241));
        jLabel22.setText("Jumlah Barang");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 117, 126, -1));

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinputMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelinput);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 308, 570, 355));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(236, 240, 241));
        jLabel25.setText("Harga Beli");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 161, 116, -1));

        btn_hapus2.setBackground(new java.awt.Color(34, 167, 240));
        btn_hapus2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_hapus2.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus2.setText("Hapus");
        btn_hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus2ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_hapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 117, 150, 38));

        btn_ubah2.setBackground(new java.awt.Color(34, 167, 240));
        btn_ubah2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ubah2.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah2.setText("Ubah");
        btn_ubah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah2ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_ubah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 150, 38));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(236, 240, 241));
        jLabel28.setText("Harga Jual");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 203, 116, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(236, 240, 241));
        jLabel29.setText("Cari :");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 266, 55, -1));

        txt_namabarang.setBackground(new java.awt.Color(108, 122, 137));
        txt_namabarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_namabarang.setForeground(new java.awt.Color(228, 241, 254));
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        jPanel4.add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 76, 188, -1));

        txt_jumlahbarang.setBackground(new java.awt.Color(108, 122, 137));
        txt_jumlahbarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_jumlahbarang.setForeground(new java.awt.Color(228, 241, 254));
        txt_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbarangActionPerformed(evt);
            }
        });
        jPanel4.add(txt_jumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 118, 188, -1));

        txt_cari.setBackground(new java.awt.Color(108, 122, 137));
        txt_cari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_cari.setForeground(new java.awt.Color(228, 241, 254));
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        jPanel4.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 267, 462, -1));

        txt_hargabeli.setBackground(new java.awt.Color(108, 122, 137));
        txt_hargabeli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_hargabeli.setForeground(new java.awt.Color(228, 241, 254));
        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });
        jPanel4.add(txt_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 158, 188, -1));

        txt_hargajual.setBackground(new java.awt.Color(108, 122, 137));
        txt_hargajual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_hargajual.setForeground(new java.awt.Color(228, 241, 254));
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        jPanel4.add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 202, 188, -1));

        btn_back2.setBackground(new java.awt.Color(242, 38, 19));
        btn_back2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_back2.setForeground(new java.awt.Color(255, 255, 255));
        btn_back2.setText("Back");
        btn_back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back2ActionPerformed(evt);
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
                .addComponent(btn_back2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btn_back2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah2ActionPerformed
        if (txt_kodebarang.getText().equals("")
                || txt_namabarang.getText().equals("")
                || txt_jumlahbarang.getText().equals("")
                || txt_hargabeli.getText().equals("")
                || txt_hargajual.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String kbarang = txt_kodebarang.getText();
            String nbarang = txt_namabarang.getText();
            String jbarang = txt_jumlahbarang.getText();
            String hbeli = txt_hargabeli.getText();
            String hjual = txt_hargajual.getText();

            try {
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                String tgl = date.toString();

                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tbl_barang VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);

                p.setString(1, kbarang);
                p.setString(2, nbarang);
                p.setString(3, jbarang);
                p.setString(4, hbeli);
                p.setString(5, hjual);
                p.setString(6, tgl);

                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "PT PRABU", JOptionPane.ERROR_MESSAGE);
            } finally {
                loadData();
                kode();
                txt_kodebarang.setText("");
                txt_namabarang.setText("");
                txt_jumlahbarang.setText("");
                txt_hargabeli.setText("");
                txt_hargajual.setText("");
            }
        }
    }//GEN-LAST:event_btn_tambah2ActionPerformed

    private void btn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus2ActionPerformed
        try {
            String sql = "delete from tbl_barang where kode_barang='" + txt_kodebarang.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        txt_kodebarang.setText("");
        txt_namabarang.setText("");
        txt_jumlahbarang.setText("");
        txt_hargabeli.setText("");
        txt_hargajual.setText("");
    }//GEN-LAST:event_btn_hapus2ActionPerformed

    private void btn_ubah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah2ActionPerformed
        if (txt_kodebarang.getText().equals("")
                || txt_namabarang.getText().equals("")
                || txt_jumlahbarang.getText().equals("")
                || txt_hargabeli.getText().equals("")
                || txt_hargajual.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int i = tabelinput.getSelectedRow();
            if (i == -1) {
                return;
            }

            String user = (String) model.getValueAt(i, 0);

            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE tbl_barang SET nama_barang = ?, jumlah_barang = ?, harga_beli = ?, harga_jual = ? WHERE kode_barang = ?";
                PreparedStatement p = c.prepareStatement(sql);

                p.setString(1, txt_namabarang.getText());
                p.setString(2, txt_jumlahbarang.getText());
                p.setString(3, txt_hargabeli.getText());
                p.setString(4, txt_hargajual.getText());
                p.setString(5, txt_kodebarang.getText());

                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "PT PRABU", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "PT PRABU", JOptionPane.ERROR_MESSAGE);
            } finally {
                loadData();
                txt_kodebarang.setText("");
                txt_namabarang.setText("");
                txt_jumlahbarang.setText("");
                txt_hargabeli.setText("");
                txt_hargajual.setText("");
                btn_tambah2.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btn_ubah2ActionPerformed

    private void btn_back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back2ActionPerformed
        fmenu fb = new fmenu();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_back2ActionPerformed

    private void tabelinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinputMouseClicked
        btn_tambah2.setEnabled(false);
        btn_ubah2.setEnabled(true);
        btn_hapus2.setEnabled(true);
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kbarang = (String) model.getValueAt(i, 0);
        txt_kodebarang.setText(kbarang);
        txt_kodebarang.setEnabled(false);
        String nbarang = (String) model.getValueAt(i, 1);
        txt_namabarang.setText(nbarang);
        String jumlah = (String) model.getValueAt(i, 2);
        txt_jumlahbarang.setText(jumlah);
        String hbeli = (String) model.getValueAt(i, 3);
        txt_hargabeli.setText(hbeli);
        String hjual = (String) model.getValueAt(i, 4);
        txt_hargajual.setText(hjual);
    }//GEN-LAST:event_tabelinputMouseClicked

    private void txt_kodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodebarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kodebarangActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahbarangActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "select * from tbl_barang where kode_barang like '%" + txt_cari.getText() + "%' or nama_barang like'%" + txt_cari.getText() + "%' or jumlah_barang like'" + txt_cari.getText() + "%' or harga_beli like'%" + txt_cari.getText() + "%' " + "or harga_jual like'%" + txt_cari.getText() + "%'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[5];
                o[0] = r.getString("kode_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jumlah_barang");
                o[3] = r.getString("harga_beli");
                o[4] = r.getString("harga_jual");

                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_txt_cariKeyReleased

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
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fbarang().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back2;
    private javax.swing.JButton btn_hapus2;
    private javax.swing.JButton btn_tambah2;
    private javax.swing.JButton btn_ubah2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelinput;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_jumlahbarang;
    private javax.swing.JTextField txt_kodebarang;
    private javax.swing.JTextField txt_namabarang;
    // End of variables declaration//GEN-END:variables
}


