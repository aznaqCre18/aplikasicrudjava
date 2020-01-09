
package com.tutorial;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tampil extends javax.swing.JFrame {
    private DefaultTableModel DftTabMode1;

    /**
     * Creates new form Tampil
     */
    public Tampil() {
        initComponents();
        loadTable();
        
    }
    
    private void hapus(){
        int ok=JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?","Konfirmasi",JOptionPane.YES_NO_OPTION);

        if(ok==0){
            try{
                //panggil method koneksi
                java.sql.Connection koneksi = new Config().connect();

                String sql="delete from data where kode = '" + txtKode.getText()+"'";
                java.sql.PreparedStatement stmt=koneksi.prepareStatement(sql);
                stmt.executeUpdate();
                //bersihkan teks
                JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
                reset();

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal dihapus!"
                    + "\nDengan pesan error : " + e.getMessage());
            }
        }
    }
    
    private void loadTable(){
        Object[] Baris = {"Kode","Nama Bingkai","Harga", "Jumlah Beli",};
           DftTabMode1 = new DefaultTableModel(null, Baris);
           tabelData.setModel(DftTabMode1);

           //panggil method koneksi
           java.sql.Connection koneksi = new Config().connect();

           //untuk menampilkan di table
           try{
               String sql="Select * from data where kode like'%"+ txtCari.getText() +"%' order by nama asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet rslt=stmt.executeQuery(sql);
               while(rslt.next()){
                   String id = rslt.getString("kode");
                   String nama = rslt.getString("nama");
                   String jurusan = rslt.getString("harga");
                   String jumlah = rslt.getString("jumlah");

                   String[] dataField={id, nama, jurusan, jumlah};
                   DftTabMode1.addRow(dataField);
               }
           }catch(Exception ex){}
    }
    
    private void reset(){
        txtKode.setText(null);
        txtNama.setText(null);
        txtHarga.setText(null);
        txtJumlah.setText(null);
    }
    
    private void tampilData(){
        //saat pilih record
        int baris = tabelData.getSelectedRow();
        String kode = DftTabMode1.getValueAt(baris, 0).toString();
        String nama = DftTabMode1.getValueAt(baris, 1).toString();
        String harga = DftTabMode1.getValueAt(baris, 2).toString();
        String jumlah = DftTabMode1.getValueAt(baris, 3).toString();
        

        txtKode.setText(kode);
        txtNama.setText(nama);
        txtHarga.setText(harga);
        txtJumlah.setText(jumlah);
        
    }
   
    
    private void update(){
         java.sql.Connection koneksi = new Config().connect();

        String sql="update data set nama = ?, harga = ?, jumlah = ? where kode = '" 
                + txtKode.getText()+"'";
        java.sql.PreparedStatement stmt = null;
        try {
            stmt = koneksi.prepareStatement(sql);
        } catch (SQLException ex) {}

        try{
            stmt.setString(1,txtNama.getText());
            stmt.setString(2,txtHarga.getText());
            stmt.setString(3,txtJumlah.getText());
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil diubah!");
            reset();
            loadTable();
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null,"Data gagal diubah!"
                + "\nTerjadi error dengan pesan : " + se.getMessage());
        }
    }
    
    private void simpan(){
        if (txtKode.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nomor masih kosong!\n"
                    + "Silahkan diisi terlebih dahulu!");
            txtKode.requestFocus();
        }else if (txtNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama masih kosong!\n"
                    + "Silahkan diisi terlebih dahulu!");
            txtNama.requestFocus();
        }else if (txtHarga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jurusan masih kosong!\n"
                    + "Silahkan diisi terlebih dahulu!");
            txtHarga.requestFocus();
        }else if (txtJumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jurusan masih kosong!\n"
                    + "Silahkan diisi terlebih dahulu!");
            txtJumlah.requestFocus();
        }else {
            try{
            Connection koneksi = new Config().connect();
            String sql = "insert into data values(?,?,?,?)";
            java.sql.PreparedStatement stmt = koneksi.prepareStatement(sql);
            
            try{
                stmt.setString(1,txtKode.getText());
                stmt.setString(2,txtNama.getText());
                stmt.setString(3,txtHarga.getText());
                stmt.setString(4,txtJumlah.getText());
                
                
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil disimpan!");
                //bersihkan teks
                reset();
                loadTable();
            }catch(SQLException se){
                //System.out.println("Gagal di simpan");
                JOptionPane.showMessageDialog(null,"Data Gagal disimpan!"
                    + "\nDengan Pesan : " + se.getMessage());
            }
            stmt.close();
        }catch(Exception e){}
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        tbKeluar = new javax.swing.JButton();
        tbSimpan = new javax.swing.JButton();
        tbEdit = new javax.swing.JButton();
        tbHapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplkasi Pendataan Sederhana");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 165, 0));
        jLabel1.setText("APLIKASI PENDATAAN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 165, 0));
        jLabel2.setText("Kode Pembelian");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 165, 0));
        jLabel3.setText("Nama Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 165, 0));
        jLabel4.setText("Harga");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 165, 0));
        jLabel5.setText("Jumlah Beli");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 384, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 384, -1));
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 384, -1));
        getContentPane().add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 384, -1));

        tabelData.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 320, 799, 184));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 165, 0));
        jLabel6.setText("PEMBELIAN BINGKAI SERANGGA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 44, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jButton1.setForeground(new java.awt.Color(128, 0, 0));
        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbKeluar.setForeground(new java.awt.Color(128, 0, 0));
        tbKeluar.setText("KELUAR");
        tbKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbKeluarActionPerformed(evt);
            }
        });

        tbSimpan.setForeground(new java.awt.Color(128, 0, 0));
        tbSimpan.setText("SIMPAN");
        tbSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSimpanActionPerformed(evt);
            }
        });

        tbEdit.setForeground(new java.awt.Color(128, 0, 0));
        tbEdit.setText("EDIT");
        tbEdit.setEnabled(false);
        tbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEditActionPerformed(evt);
            }
        });

        tbHapus.setForeground(new java.awt.Color(128, 0, 0));
        tbHapus.setText("HAPUS");
        tbHapus.setEnabled(false);
        tbHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbHapusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 165, 0));
        jLabel7.setText("Cari");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(tbSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(tbEdit)
                        .addGap(18, 18, 18)
                        .addComponent(tbHapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(tbKeluar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tbKeluar)
                    .addComponent(tbSimpan)
                    .addComponent(tbEdit)
                    .addComponent(tbHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(205, 205, 205))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtKodeActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void tbKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tbKeluarActionPerformed

    private void tabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataMouseClicked
        // TODO add your handling code here:
        tampilData();
        tbHapus.setEnabled(true);
        tbEdit.setEnabled(true);
        txtKode.setEnabled(false);
    }//GEN-LAST:event_tabelDataMouseClicked

    private void tbSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
        loadTable();
        txtKode.setEnabled(true);
    }//GEN-LAST:event_tbSimpanActionPerformed

    private void tbHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbHapusActionPerformed
        // TODO add your handling code here:
        hapus();
        loadTable();
        txtKode.setEnabled(true);
    }//GEN-LAST:event_tbHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
        txtKode.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEditActionPerformed
        // TODO add your handling code here:
        update();
        txtKode.setEnabled(true);
       
    }//GEN-LAST:event_tbEditActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_txtCariKeyReleased

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
            java.util.logging.Logger.getLogger(Tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelData;
    private javax.swing.JButton tbEdit;
    private javax.swing.JButton tbHapus;
    private javax.swing.JButton tbKeluar;
    private javax.swing.JButton tbSimpan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
