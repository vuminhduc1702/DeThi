package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.CauHoi;
import model.DeThi;
import model.MonHoc;
import model.QLMH;
import view.GiaoDienChinh;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */


public class TaoMonHoc extends javax.swing.JFrame {
    private int cm; //biến lưu thao tác, cm = 0 là đang thêm môn học mới, cm = 1 là đang chọn môn từ bảng
    
    private ChonMonHoc chonMonHoc;

    /**
     * Creates new form TaoMonHoc
     */
    public TaoMonHoc() {
        initComponents();
        btnDelete.setEnabled(false);
        btnLuu.setEnabled(false);
    }
            
    public TaoMonHoc(ChonMonHoc chonMonHoc){
        initComponents();
        this.chonMonHoc = chonMonHoc;
        displayData(QLMH.getDsMonHoc());
        btnDelete.setEnabled(false);
        btnLuu.setEnabled(false);
        }
  
    public void xoaForm(){
        txtTenMH.setText("");
        txtMaHP.setText("");
        spnSoChuong.setValue(1);
        txtGioiThieu.setText("");
    }
        
    public void displayData(ArrayList<MonHoc> dsMonHoc){
        DefaultTableModel tblModel = (DefaultTableModel) tableMonHoc.getModel();
        while (tblModel.getRowCount() != 0){
            tblModel.removeRow(0);
        }
        for (MonHoc mh : dsMonHoc){
            String data[] = {mh.getTenMonHoc()};
            tblModel.addRow(data);
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMonHoc = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        txtMaHP = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        spnSoChuong = new javax.swing.JSpinner();
        btnLuu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGioiThieu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DANH SÁCH MÔN HỌC");

        tableMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Môn học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column){
                return false;
            }
        });
        tableMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMonHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMonHoc);

        btnInsert.setText("Thêm môn học");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsert)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setText("Tên môn học: ");

        jLabel2.setText("Mã học phần:");

        jLabel3.setText("Số chương:");

        jLabel4.setText("Giới thiệu:");

        txtTenMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMHActionPerformed(evt);
            }
        });

        txtMaHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHPActionPerformed(evt);
            }
        });

        btnReset.setText("Hủy");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa môn học");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("OK");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        spnSoChuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 60, 1));
        spnSoChuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSoChuongStateChanged(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtGioiThieu.setColumns(20);
        txtGioiThieu.setLineWrap(true);
        txtGioiThieu.setRows(5);
        txtGioiThieu.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtGioiThieu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel4))
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(spnSoChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaHP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txtTenMH)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spnSoChuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void txtTenMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMHActionPerformed

    private void txtMaHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHPActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

            xoaForm();
            btnLuu.setEnabled(false);
            btnDelete.setEnabled(false);

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        //đang thêm môn mới
        cm = 0;
        //bật nút Lưu
        btnLuu.setEnabled(true);
        //không cho bấm vào bảng
        tableMonHoc.setRowSelectionAllowed(false);
        //xóa trắng các dòng
        xoaForm();
                
    }//GEN-LAST:event_btnInsertActionPerformed
 
    private void spnSoChuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSoChuongStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spnSoChuongStateChanged

    private void tableMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMonHocMouseClicked
        cm = 1;
        
        btnDelete.setEnabled(true);
        btnLuu.setEnabled(true);
        
        DefaultTableModel tblModel = (DefaultTableModel) tableMonHoc.getModel();
        int index = tableMonHoc.getSelectedRow();
        
                txtTenMH.setText(QLMH.getMonHoc(index).getTenMonHoc());
                txtMaHP.setText(QLMH.getMonHoc(index).getMaMonHoc());
                spnSoChuong.setValue(QLMH.getMonHoc(index).getSoChuong());
                txtGioiThieu.setText(QLMH.getMonHoc(index).getGioiThieu());
                

      
        
    }//GEN-LAST:event_tableMonHocMouseClicked
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        //nếu đang tạo môn mới
        if (cm == 0){
            //tạo đối tượng môn học mới
            String tenMH = txtTenMH.getText();
            String maHP = txtMaHP.getText();
            int soChuong = (int)spnSoChuong.getValue();
            String gioiThieu = txtGioiThieu.getText();
            ArrayList<CauHoi> dsCauHoi = new ArrayList<>();
            ArrayList<DeThi> dsDeThi = new ArrayList<>();
                //tạp môn học mới
                MonHoc mh = new MonHoc(tenMH,maHP,soChuong,gioiThieu,dsCauHoi,dsDeThi);        
                //thêm môn học vào ArrayList QLMH
                QLMH.themMonHoc(mh);
                //hiển thị lên bảng
                displayData(QLMH.getDsMonHoc());
                //thông báo
                JOptionPane.showMessageDialog(null, "Đã thêm môn học!");
                //xóa trắng các dòng
                xoaForm();
                //tắt nút Lưu
                btnLuu.setEnabled(false);
        }
        //nếu đang cập nhật môn đã có
        else if (cm == 1){
            DefaultTableModel tblModel = (DefaultTableModel) tableMonHoc.getModel();
            int index = tableMonHoc.getSelectedRow();
            //cập nhật các thông tin
            QLMH.getDsMonHoc().get(index).setTenMonHoc(txtTenMH.getText());
            QLMH.getDsMonHoc().get(index).setMaMonHoc(txtMaHP.getText());
            QLMH.getDsMonHoc().get(index).setSoChuong((int)spnSoChuong.getValue());
            QLMH.getDsMonHoc().get(index).setGioiThieu(txtGioiThieu.getText());
            
            
            
            //hiển thị lại bảng
            displayData(QLMH.getDsMonHoc());
            //thông báo
            JOptionPane.showMessageDialog(null, "Đã cập nhật môn học!");
               
        xoaForm();
      } 
      
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int response = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa môn học không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
        DefaultTableModel tblModel = (DefaultTableModel) tableMonHoc.getModel();
        int index = tableMonHoc.getSelectedRow();
   
        QLMH.xoaMonHoc(index);
        
        displayData(QLMH.getDsMonHoc());
        
        xoaForm();
        
        btnDelete.setEnabled(false);
        btnLuu.setEnabled(false);
        
        }
                    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.chonMonHoc.loadComboBox();
        this.setVisible(false);
        this.chonMonHoc.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(TaoMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoMonHoc().setVisible(true);
            }
        });
    }

    public JSpinner getSpnSoChuong() {
        return spnSoChuong;
    }

    public void setSpnSoChuong(JSpinner spnSoChuong) {
        this.spnSoChuong = spnSoChuong;
    }

    public JTextArea getTxtGioiThieu() {
        return txtGioiThieu;
    }

    public void setTxtGioiThieu(JTextArea txtGioiThieu) {
        this.txtGioiThieu = txtGioiThieu;
    }

    

    public JTextField getTxtMaHP() {
        return txtMaHP;
    }

    public void setTxtMaHP(JTextField txtMaHP) {
        this.txtMaHP = txtMaHP;
    }

    public JTextField getTxtTenMH() {
        return txtTenMH;
    }

    public void setTxtTenMH(JTextField txtTenMH) {
        this.txtTenMH = txtTenMH;
    }

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnSoChuong;
    private javax.swing.JTable tableMonHoc;
    private javax.swing.JTextArea txtGioiThieu;
    private javax.swing.JTextField txtMaHP;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables



}