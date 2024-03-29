/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi.laundry;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irsan Achmad
 */
public class Pengambilan extends javax.swing.JFrame implements Runnable{
    
    int hour,minute,second;
    
    public void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nomor Antrian");
        model.addColumn("Nama");
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        model.addColumn("Parfum");
        model.addColumn("Berat");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        
        String Cari = cari.getText();
        
        try {
            int no = 1;
            String sql = "SELECT * FROM tb_transaksi WHERE Nama LIKE '%"+Cari+"%'";
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/laundry", "root", "");
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {                
                model.addRow(new Object[] {
                    res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8)
                });
                tableMasuk.setModel(model);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR : "+ e.getMessage());
        }
    }
    
    public void clearForm(){
        nomor.setText(null);
        nama.setText(null);
        jam.setText(null);
        parfum.setSelectedIndex(0);
        berat.setText(null);
        jumlah.setText(null);
        harga.setText(null);
    }
    
    public void tampilkan_data_keluar(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nomor Antrian");
        model.addColumn("Nama");
        model.addColumn("Tanggal Keluar");
        model.addColumn("Jam Keluar");
        model.addColumn("Parfum");
        model.addColumn("Berat");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        
        try {
            int no = 1;
            String sql = "SELECT * FROM tb_pengambilan";
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/laundry", "root", "");
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {                
                model.addRow(new Object[] {
                    res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8)
                });
                tableKeluar.setModel(model);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR : "+ e.getMessage());
        }
    }
        
    
    /**
     * Creates new form Pengambilan
     */
    public Pengambilan() {
        initComponents();
        tampilkan_data();
        tampilkan_data_keluar();
        clearForm();
        Image icon = Toolkit.getDefaultToolkit().getImage("src/Image/LaundryLogo.png");
        setIconImage(icon);
        Thread t = new Thread(this);
        t.start();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nomor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        parfum = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        berat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKeluar = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMasuk = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jam = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Laundry");
        setPreferredSize(new java.awt.Dimension(1023, 685));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(39, 73, 109));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM PENGAMBILAN LAUNDRY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1030, 80);

        jPanel2.setBackground(new java.awt.Color(0, 168, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomor.setBackground(new java.awt.Color(245, 245, 245));
        nomor.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        nomor.setForeground(new java.awt.Color(0, 0, 0));
        nomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorActionPerformed(evt);
            }
        });
        jPanel2.add(nomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 45, 210, 30));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tanggal Keluar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 154, -1, -1));

        tanggal.setBackground(new java.awt.Color(245, 245, 245));
        tanggal.setForeground(new java.awt.Color(0, 0, 0));
        tanggal.setDateFormatString("dd-MM-yyyy");
        tanggal.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jPanel2.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 141, 210, 30));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Jam Keluar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 199, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Jenis Parfum");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 247, -1, -1));

        parfum.setBackground(new java.awt.Color(245, 245, 245));
        parfum.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        parfum.setForeground(new java.awt.Color(0, 0, 0));
        parfum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mawar", "Sakura", "Snapy", "Downy Mistiq", "Downy Passion", "Ocean Fresh", "Lavender ", "Lily", "Aqua Fresh", "Phonix" }));
        jPanel2.add(parfum, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 237, 210, 30));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Berat Pakaian");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 295, -1, -1));

        berat.setBackground(new java.awt.Color(245, 245, 245));
        berat.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        berat.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(berat, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 285, 120, 30));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Jumlah Pakaian");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jumlah.setBackground(new java.awt.Color(245, 245, 245));
        jumlah.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jumlah.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 120, 30));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Harga");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jButton1.setBackground(new java.awt.Color(20, 40, 80));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("HITUNG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 210, 30));

        nama.setBackground(new java.awt.Color(245, 245, 245));
        nama.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 93, 210, 30));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nomor Antrian");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 55, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nama Pelanggan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 103, -1, -1));

        jButton2.setBackground(new java.awt.Color(20, 40, 80));
        jButton2.setFont(new java.awt.Font("Bahnschrift", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gtk-edit.png"))); // NOI18N
        jButton2.setText("AMBIL LAUNDRY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, 30));

        jButton4.setBackground(new java.awt.Color(20, 40, 80));
        jButton4.setFont(new java.awt.Font("Bahnschrift", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/application-exit.png"))); // NOI18N
        jButton4.setText("KEMBALI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, 30));

        tableKeluar.setBackground(new java.awt.Color(245, 245, 245));
        tableKeluar.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Nama", "Tanggal Keluar", "Jam Keluar", "Parfum", "Berat", "Jumlah", "Harga"
            }
        ));
        jScrollPane2.setViewportView(tableKeluar);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 520, 200));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("TABEL PENGAMBILAN LAUNDRY");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        tableMasuk.setBackground(new java.awt.Color(245, 245, 245));
        tableMasuk.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        tableMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Nama", "Tanggal", "Jam", "Parfum", "Berat", "Jumlah", "Harga"
            }
        ));
        tableMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMasuk);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 520, 190));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("TABEL TRANSAKSI LAUNDRY");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cari :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 38, -1, 40));

        cari.setBackground(new java.awt.Color(245, 245, 245));
        cari.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        jPanel2.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 210, 30));

        refresh.setBackground(new java.awt.Color(20, 40, 80));
        refresh.setFont(new java.awt.Font("Bahnschrift", 1, 13)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        refresh.setText("REFRESH");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 120, 30));

        jam.setBackground(new java.awt.Color(245, 245, 245));
        jam.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jam.setForeground(new java.awt.Color(0, 0, 0));
        jam.setText("00:00:00");
        jPanel2.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 210, 30));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Kilogram");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 60, 40));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Pakaian");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 90, 30));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Rp :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, 30));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Rupiah");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 50, 30));

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 2, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("*Harga Perkilo Rp 8.000");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 130, 20));

        harga.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        harga.setForeground(new java.awt.Color(0, 0, 0));
        harga.setText("0");
        jPanel2.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 110, 30));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 1030, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int Jumlah,Harga;
        Double Berat;
        Berat = Double.parseDouble(String.valueOf(berat.getText()));
        Jumlah = Integer.parseInt(String.valueOf(jumlah.getText()));
        Harga = (int)(Berat*8000);
        String HargaF = String.format("%,d", Harga);
        harga.setText(HargaF);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String tgl = ((JTextField)tanggal.getDateEditor().getUiComponent()).getText();
        
        
        try {
            String sql = "INSERT INTO tb_pengambilan VALUES ('"+nomor.getText()+"','"+nama.getText()+
            "','"+tgl+"','"+jam.getText()+"','"+parfum.getSelectedItem()+"','"+berat.getText()
            +"','"+jumlah.getText()+"','"+harga.getText()+"')";
            
            String sqldel = "DELETE FROM tb_transaksi WHERE NomorAntrian='" + nomor.getText() + "'";
            
            //koneksi database
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/laundry", "root", "");
            
            //insert
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            
            //delete
            java.sql.PreparedStatement pre = con.prepareStatement(sqldel);
            pre.execute();
            
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Simpan Data Gagal");
        }
        tampilkan_data_keluar();
        clearForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        tampilkan_data();
    }//GEN-LAST:event_cariKeyReleased

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tableMasuk.getModel();
        DefaultTableModel model2 = (DefaultTableModel)tableKeluar.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        tampilkan_data();
        tampilkan_data_keluar();
    }//GEN-LAST:event_refreshMouseClicked

    private void tableMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMasukMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tblmodel = (DefaultTableModel)tableMasuk.getModel();
        
        String tblnomor = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 0).toString();
        String tblnama = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 1).toString();
        String tblparfum = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 4).toString();
        String tblberat = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 5).toString();
        String tbljumlah = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 6).toString();
        String tblharga = tblmodel.getValueAt(tableMasuk.getSelectedRow(), 7).toString();
        
        nomor.setText(tblnomor);
        nama.setText(tblnama);
        parfum.setSelectedItem(tblparfum);
        berat.setText(tblberat);
        jumlah.setText(tbljumlah);
        harga.setText(tblharga);
    }//GEN-LAST:event_tableMasukMouseClicked

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
            java.util.logging.Logger.getLogger(Pengambilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengambilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengambilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengambilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengambilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField berat;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel harga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jam;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JComboBox<String> parfum;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tableKeluar;
    private javax.swing.JTable tableMasuk;
    private com.toedter.calendar.JDateChooser tanggal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) { 
            //get current hour minute second
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
            
            SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
            Date dat = cal.getTime();
            String time24 = sdf24.format(dat);
            
            //set to textfield
            jam.setText(time24);
        }
    }
}
