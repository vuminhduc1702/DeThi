/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import model.MonHoc;
import model.QLMH;

/**
 *
 * @author ADMIN
 */
public class ChonMonHoc extends javax.swing.JFrame{
    protected GiaoDienChinh giaoDienChinh;

    /**
     * Creates new form ChonMonHoc
     */
    public ChonMonHoc() {
        initComponents();
    }
    
    public ChonMonHoc(GiaoDienChinh giaoDienChinh){
        initComponents();
        this.giaoDienChinh = giaoDienChinh;
        loadComboBox();      
    }
    
    public void loadComboBox(){
        this.cbbDsMonHoc.removeAllItems();
        for (MonHoc mh : QLMH.getDsMonHoc()){
            cbbDsMonHoc.addItem(mh.getTenMonHoc());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbDsMonHoc = new javax.swing.JComboBox<>();
        btnQuanLyMonHoc = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CHỌN MÔN HỌC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Danh sách môn học");

        cbbDsMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDsMonHocActionPerformed(evt);
            }
        });

        btnQuanLyMonHoc.setText("Quản lý môn học");
        btnQuanLyMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyMonHocActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbDsMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuanLyMonHoc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(cbbDsMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyMonHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLyMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyMonHocActionPerformed
        this.setVisible(false);
        TaoMonHoc taoMonHoc = new TaoMonHoc(this);      //mở giao diện tạo môn học
        taoMonHoc.setVisible(true);
        taoMonHoc.pack();
        taoMonHoc.setLocationRelativeTo(null);
        taoMonHoc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_btnQuanLyMonHocActionPerformed

    private void cbbDsMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDsMonHocActionPerformed

    }//GEN-LAST:event_cbbDsMonHocActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

            if (this.giaoDienChinh.getCm() == 1){          //nếu đã chọn chức năng soạn câu hỏi ở giao diện chính
            this.setVisible(false);
            //mở giao diện soạn câu hỏi và truyền vào danh sách câu hỏi của môn học đã chọn ở ComboBox
            SoanCauHoi soanCauHoi = new SoanCauHoi(this,QLMH.getMonHoc(this.cbbDsMonHoc.getSelectedIndex()).getDsCauHoi());
            soanCauHoi.setVisible(true);
            soanCauHoi.pack();
            soanCauHoi.setLocationRelativeTo(null);
            soanCauHoi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (this.giaoDienChinh.getCm() == 2){     //nếu đã chọn chức năng tạo đề thi ở giao diện chính
            this.setVisible(false);
            //mở giao diện chọn đề thi và truyền vào danh sách đề thi cề môn học đã chọn ở ComboBox
            ChonDeThi chonDeThi = new ChonDeThi(this,QLMH.getMonHoc(this.cbbDsMonHoc.getSelectedIndex()).getDsDeThi());
            chonDeThi.setVisible(true);
            chonDeThi.pack();
            chonDeThi.setLocationRelativeTo(null);
            chonDeThi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (this.giaoDienChinh.getCm() == 3){        //nếu chọn chức năng đánh giá kết quả
            this.setVisible(false);
            //mở giao diện hiện lên các đề thi của môn học đã chọn ở ComboBox
            DanhSachDeThiChamDiem danhSachDeThi = new DanhSachDeThiChamDiem(this,QLMH.getMonHoc(this.cbbDsMonHoc.getSelectedIndex()).getDsDeThi() );
            danhSachDeThi.setVisible(true);
            danhSachDeThi.pack();
            danhSachDeThi.setLocationRelativeTo(null);
            danhSachDeThi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // quay lại giao diện chính
        this.setVisible(false);
        this.giaoDienChinh.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed
    
    public JComboBox<String> getCbbDsMonHoc() {
        return cbbDsMonHoc;
    }

    public void setCbbDsMonHoc(JComboBox<String> cbbDsMonHoc) {
        this.cbbDsMonHoc = cbbDsMonHoc;
    }
    
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
            java.util.logging.Logger.getLogger(ChonMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChonMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChonMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChonMonHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnQuanLyMonHoc;
    private javax.swing.JComboBox<String> cbbDsMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
