/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.BaiLam;
import model.CauHoi;
import model.CauHoiTL;
import model.CauHoiTN;
import model.CauHoiTrongDe;
import model.CauTraLoi;
import model.CauTraLoiTL;
import model.CauTraLoiTN;
import model.DapAn;
import model.DeThi;
import model.QLBL;
import model.QLMH;

/**
 *
 * @author ADMIN
 */
public class ChamBaithiTL extends javax.swing.JFrame {

    private ArrayList<CauHoiTrongDe> listch = new ArrayList<>();
    private BaiLam baiLam;
    private DanhSanhBailam dsBaiLam;
    private int i = 0;          //index để chuyển câu, load câu trả lời, lưu câu trả lời
    protected ChonDeThiLamBai chonDeThiLamBai;
    private DeThi deThi;
    private ArrayList<CauTraLoiTL> dsCauTraLoiTL = new ArrayList<CauTraLoiTL>();

    /**
     * Creates new form LamBaiThi
     */
    public ChamBaithiTL() {
        initComponents();
    }

    public ChamBaithiTL(BaiLam baiLam,DanhSanhBailam dsBaiLam) {
        initComponents();
        this.dsBaiLam = dsBaiLam;
        this.baiLam = baiLam;
        this.deThi = baiLam.getDeThi();
        for (CauHoiTrongDe cauHoiTrongDe : this.deThi.getDsCauHoiTrongDe()) {
            if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 1) {
                this.listch.add(cauHoiTrongDe);
            }
        }
        for (CauTraLoiTL cauTraLoiTL : baiLam.getDsCauTraLoi()) {
            dsCauTraLoiTL.add(cauTraLoiTL);
        }
        loadCauHoi(this.listch.get(i));     //hiển thị câu hỏi đầu tiên lên (lúc này i = 0)           
        chuyenCau();                        //nút chuyển trước và chuyển sau
    }

    public void loadCauHoi(CauHoiTrongDe cauHoiTrongDe) {        //hàm hiển thị câu hỏi lên giao diện làm bài
        Font font = new Font("Segoe UI", Font.PLAIN, 24);         //set font
            txtDeBai.setText(cauHoiTrongDe.getCauHoi().getCauHoi());        //đưa câu hỏi lên txtDeBai
            loadCauTraLoi(dsCauTraLoiTL.get(i));            //load câu trả lời tương ứng lên
    }

    public void chuyenCau() {        //hàm cho nút chuyển tiếp và chuyển trước        
        if (i == 0){                //nếu đang ở câu hỏi đầu tiên
            btnCauTruoc.setEnabled(false);      //nút chuyển về câu trước sẽ không bấm được
        } if (i == this.listch.size() - 1){            //nếu đang ở câu cuối cùng
            btnCauTiep.setEnabled(false);       //nút chuyển sang câu sau sẽ không bấm được
        } else if ((i > 0) && (i < this.listch.size() - 1)) {                                //nếu đang ở các câu giữa
            btnCauTruoc.setEnabled(true);           //cho bấm cả 2 nút
            btnCauTiep.setEnabled(true);
        }
    }


    //hàm load các câu trả lời đã có lên giao diện
    public void loadCauTraLoi(CauTraLoiTL cauTraLoi) {
        try {
                txtcautl.setText(cauTraLoi.getCauTraLoi());      //đưa đáp án vào textArea 
        } catch (Exception e) {
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDeBai = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcautl = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnCauTiep = new javax.swing.JButton();
        btnCauTruoc = new javax.swing.JButton();
        txtdiem = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDeBai.setColumns(20);
        txtDeBai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDeBai.setLineWrap(true);
        txtDeBai.setRows(5);
        txtDeBai.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDeBai);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Câu hỏi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtcautl.setColumns(20);
        txtcautl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtcautl.setLineWrap(true);
        txtcautl.setRows(5);
        txtcautl.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtcautl);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Câu trả lời");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        btnCauTiep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCauTiep.setText("Câu tiếp");
        btnCauTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCauTiepActionPerformed(evt);
            }
        });

        btnCauTruoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCauTruoc.setText("Câu trước");
        btnCauTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCauTruocActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Điểm Tổng TL");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(btnCauTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCauTiep, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCauTiep)
                            .addComponent(btnCauTruoc)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu)
                            .addComponent(txtdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCauTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCauTiepActionPerformed
        //mỗi khi bấm chuyển sang câu tiếp theo
        i++;                //tăng index lên để chuyển câu tiếp
        chuyenCau();        //set các nút chuyển câu
        loadCauHoi(this.listch.get(i));       //hiển thị câu hỏi tiếp lên giao diện

    }//GEN-LAST:event_btnCauTiepActionPerformed

    private void btnCauTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCauTruocActionPerformed
        //mỗi khi bấm chuyển về câu trước 
        i--;        //giảm index lên để chuyển câu trước
        chuyenCau();        //set các nút chuyển câu
        loadCauHoi(this.listch.get(i));  //hiển thị câu hỏi tiếp lên giao diện

    }//GEN-LAST:event_btnCauTruocActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        this.baiLam.setDiemTL(Float.parseFloat(txtdiem.getText()));
        this.dsBaiLam.getDsBaiLam().get(this.dsBaiLam.getTblBaiLam().getSelectedRow()).setDiemTL(Float.parseFloat(txtdiem.getText()));
        this.dsBaiLam.loadDsBaiLam();
        this.setVisible(false);
        this.dsBaiLam.setVisible(true);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dsBaiLam.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChamBaithiTL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChamBaithiTL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChamBaithiTL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChamBaithiTL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChamBaithiTL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCauTiep;
    private javax.swing.JButton btnCauTruoc;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtDeBai;
    private javax.swing.JTextArea txtcautl;
    private javax.swing.JTextField txtdiem;
    // End of variables declaration//GEN-END:variables
}
