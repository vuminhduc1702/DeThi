/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.BaiLam;
import model.CauHoi;
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
public class LamBaiThi extends javax.swing.JFrame {
    private int i = 0;          //index để chuyển câu, load câu trả lời, lưu câu trả lời
    private float diemBaiThi = 0;       //
    protected ChonDeThiLamBai chonDeThiLamBai;
    private DeThi deThi;
    private ArrayList<JCheckBox> dsCheckBox = new ArrayList<JCheckBox>();       //lưu các lựa chọn ở mỗi câu trắc nghiệm
    private ArrayList<CauTraLoi> dsCauTraLoi = new ArrayList<CauTraLoi>();      //mảng các câu trả lời của cả bài thi
    private ArrayList<CauTraLoiTL> dsCauTraLoiTL = new ArrayList<CauTraLoiTL>();
    private JTextArea textArea = new JTextArea(10,20);          //lưu các câu trả lời ở mỗi câu tự luận
    private int nopBai = 0;

    
    
    public LamBaiThi() {
        initComponents();
    }
    
    public LamBaiThi(ChonDeThiLamBai chonDeThiLamBai, DeThi deThi){
        initComponents();
        this.chonDeThiLamBai = chonDeThiLamBai;
        this.deThi = deThi;
        for (int i = 0; i < deThi.getDsCauHoiTrongDe().size(); i++){                    //khởi tạo danh sách các câu trả lời trắc nghiệm
            if (deThi.getDsCauHoiTrongDe().get(i).getCauHoi().getDangCauHoi() == 0){    //và tự luận theo đúng thứ tự của đề thi
                ArrayList<Integer> dsCauTLTmp = new ArrayList<>();
                for (int j = 0; j < ((CauHoiTN)deThi.getDsCauHoiTrongDe().get(i).getCauHoi()).getDsDapAn().size(); j++){
                    dsCauTLTmp.add(0);
                }
                CauTraLoiTN cauTraLoi = new CauTraLoiTN(dsCauTLTmp);
                dsCauTraLoi.add(cauTraLoi);
            } else if (deThi.getDsCauHoiTrongDe().get(i).getCauHoi().getDangCauHoi() == 1){
                CauTraLoiTL cauTraLoi = new CauTraLoiTL();
                dsCauTraLoi.add(cauTraLoi);
            }
        }
        loadCauHoi(this.deThi.getDsCauHoiTrongDe().get(i));     //hiển thị câu hỏi đầu tiên lên (lúc này i = 0)
        setTime(this.deThi.getThoiGian() * 60);     //đồng hồ đếm ngược
        chuyenCau();                        //nút chuyển trước và chuyển sau
        }    
    

    
    public void loadCauHoi(CauHoiTrongDe cauHoiTrongDe){        //hàm hiển thị câu hỏi lên giao diện làm bài
        Font font = new Font("Segoe UI",Font.PLAIN,24);         //set font
        if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 0){       //nếu là câu trắc nghiệm
            //set jpanel3 là gridlayout để chia thành các dòng đáp án
            jPanel3.setLayout(new GridLayout(((CauHoiTN)cauHoiTrongDe.getCauHoi()).getDsDapAn().size(),1));
            //đưa câu hỏi vào txtDeBai
            txtDeBai.setText(cauHoiTrongDe.getCauHoi().getCauHoi());
            //đưa các đáp án của câu hỏi lên giao diện
            for (DapAn dapAn : ((CauHoiTN)cauHoiTrongDe.getCauHoi()).getDsDapAn()){
                JCheckBox jCheckBox = new JCheckBox(dapAn.getDapAn());      //tạo 1 checkbox mới, gán đáp án vào
                jCheckBox.setFont(font);        //set font
                dsCheckBox.add(jCheckBox);      //thêm checkbox mới vào danh sách checkbox
                jPanel3.add(jCheckBox);         
                jPanel3.updateUI();
            }
        } else if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 1){     //nếu là câu tự luận
            jPanel3.setLayout(new FlowLayout());
            txtDeBai.setText(cauHoiTrongDe.getCauHoi().getCauHoi());        //đưa câu hỏi lên txtDeBai
            textArea.setFont(font);     //set font
            //tạo text area để điền đáp án tự luận
            JScrollPane jScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            jPanel3.add(jScrollPane);
            jPanel3.updateUI();
        }
    }
    
    public void setTime(int i) {        //hàm cho đồng hồ chạy
        Thread clock = new Thread() 
        {
            public void run() {
                int second = i % 60;
                int minute = i / 60;
                try {
                    while (true) {
                        second--;
                        if (second == -1) {
                            second = 59;
                            minute--;
                        }
                        Second.setText(String.valueOf(second));
                        Minute.setText(String.valueOf(minute));
                        sleep(1000);
                        if (minute == 0) {
                            if (second == 0) {
                                if (nopBai == 0){
                                    nopBai();
                                }
                                break;                               
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        };
        clock.start();

    }

    public void chuyenCau(){        //hàm cho nút chuyển tiếp và chuyển trước
        if (i == 0){                //nếu đang ở câu hỏi đầu tiên
            btnCauTruoc.setEnabled(false);      //nút chuyển về câu trước sẽ không bấm được
        } if (i == this.deThi.getDsCauHoiTrongDe().size() - 1){            //nếu đang ở câu cuối cùng
            btnCauTiep.setEnabled(false);       //nút chuyển sang câu sau sẽ không bấm được
        } else if ((i > 0) && (i < this.deThi.getDsCauHoiTrongDe().size() - 1)) {                                //nếu đang ở các câu giữa
            btnCauTruoc.setEnabled(true);           //cho bấm cả 2 nút
            btnCauTiep.setEnabled(true);
        }
    }
    
    public void luuCauTraLoi(CauHoiTrongDe cauHoiTrongDe, ArrayList<JCheckBox> dsCheckBox, String cauTraLoi){   //hàm lưu lại các câu trả lời
        if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 0){        //nếu là câu trắc nghiệm
            ArrayList<Integer> dsCTL = new ArrayList<Integer>();        //tạo mảng số nguyên để lưu vị trí các đáp án đã chọn
            for (int i = 0; i < dsCheckBox.size(); i++){        //cho i chạy là tổng số lượng checkbox của câu hỏi
                if (dsCheckBox.get(i).isSelected() == true)     //nếu checkbox nào được lựa chọn
                   dsCTL.add(1);                            //thì add index của checkbox đó(trùng với index của đáp án) vào mảng số nguyên
                else if (dsCheckBox.get(i).isSelected() == false)
                    dsCTL.add(0);
            } 
            //if (dsCTL.size()==0) dsCTL.add(-1);     //nếu không chọn đáp án nào thì danh sách đánh dấu = -1
            CauTraLoiTN cauTraLoiTN = new CauTraLoiTN(dsCTL);       //tạo 1 câu trả lời trắc nghiệm mới, gán mảng số nguyên vào
            dsCauTraLoi.remove(i);          //xóa câu trả lời đang ở vị trí i trong mảng các câu trả lời
            dsCauTraLoi.add(i, cauTraLoiTN);    //cập nhật lại câu trả lời mới ở vị trí i đó
            while (!dsCheckBox.isEmpty()){      //xóa hết phần tử trong mảng checkbox
                dsCheckBox.remove(0);   
            }
        } else if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 1){        //nếu là câu tự luận
            CauTraLoiTL cauTraLoiTL = new CauTraLoiTL(textArea.getText());      //tạo câu trả lời tự luận, gán đáp án đã viết vào
            dsCauTraLoi.remove(i);          //xóa câu trả lời đang ở vị trí i trong mảng các câu trả lời
            dsCauTraLoi.add(i, cauTraLoiTL);    //cập nhật lại câu trả lời mới ở vị trí i đó
            dsCauTraLoiTL.add(cauTraLoiTL);
            textArea.setText("");           //set lại textArea là rỗng
        }
    }
   
    //hàm load các câu trả lời đã có lên giao diện
    public void loadCauTraLoi(CauHoiTrongDe cauHoiTrongDe, ArrayList<JCheckBox> dsCheckBox,CauTraLoi cauTraLoi){    
        try{
        if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 0){        //nếu là câu trắc nghiệm
            for (int i = 0; i < ((CauTraLoiTN)cauTraLoi).getDsLuaChon().size(); i++){     //lấy các index ở trong danh sách lựa chọn của câu trả lời này
                if (((CauTraLoiTN)cauTraLoi).getDsLuaChon().get(i) == 1){
                    dsCheckBox.get(i).setSelected(true);                    //đặt checkbox tại các index đó là đã chọn
                }else if (((CauTraLoiTN)cauTraLoi).getDsLuaChon().get(i) == 0){
                                                                                    //nếu câu này chưa trả lời thì không làm gì
                }
            }
        } else if (cauHoiTrongDe.getCauHoi().getDangCauHoi() == 1){     //nếu là câu tự luận
            textArea.setText(((CauTraLoiTL)cauTraLoi).getCauTraLoi());      //đưa đáp án vào textArea
            }      
        } catch(Exception e){
            }
        }
    
    public void nopBai(){
        nopBai = 1;
        luuCauTraLoi(deThi.getDsCauHoiTrongDe().get(i), dsCheckBox, textArea.getText()); //lưu câu trả lời ở câu hỏi hiện tại
        for (int i = 0; i < this.deThi.getDsCauHoiTrongDe().size(); i++){
            diemBaiThi = diemBaiThi + this.deThi.getDsCauHoiTrongDe().get(i).chamDiem(dsCauTraLoi.get(i));  //tính điểm trắc nghiệm của bài làm
        }
        QLBL.insert(new BaiLam(this.dsCauTraLoiTL,this.diemBaiThi,this.deThi, this.chonDeThiLamBai.chonMonHoc.getUser())); //thàm bài làm mới vào danh sách các bài làm
        this.setVisible(false);
        ThongBao thongBao = new ThongBao(this,this.diemBaiThi);
        thongBao.setVisible(true);
        thongBao.pack();
        thongBao.setLocationRelativeTo(null);
        thongBao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        Minute = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Second = new javax.swing.JLabel();
        btnNopBai = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDeBai = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCauTiep = new javax.swing.JButton();
        btnCauTruoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 229, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Minute.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Minute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minute.setText("00");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thời gian");

        Second.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Second.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Second.setText("00");

        btnNopBai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNopBai.setText("Nộp bài");
        btnNopBai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNopBaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Minute, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Second, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNopBai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Minute, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Second, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                .addComponent(btnNopBai)
                .addGap(32, 32, 32))
        );

        txtDeBai.setColumns(20);
        txtDeBai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDeBai.setLineWrap(true);
        txtDeBai.setRows(5);
        txtDeBai.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDeBai);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(btnCauTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnCauTiep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCauTiep)
                    .addComponent(btnCauTruoc))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCauTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCauTiepActionPerformed
        //mỗi khi bấm chuyển sang câu tiếp theo
        luuCauTraLoi(deThi.getDsCauHoiTrongDe().get(i), dsCheckBox, textArea.getText());    //lưu các câu trả lời ở câu hỏi hiện tại
        jPanel3.removeAll();            //xóa hết components ở jPanel3
        i++;                //tăng index lên để chuyển câu tiếp
        chuyenCau();        //set các nút chuyển câu
        loadCauHoi(deThi.getDsCauHoiTrongDe().get(i));       //hiển thị câu hỏi tiếp lên giao diện
        loadCauTraLoi(deThi.getDsCauHoiTrongDe().get(i), dsCheckBox, dsCauTraLoi.get(i));   //load các câu trả lời đã có của câu hỏi này
    }//GEN-LAST:event_btnCauTiepActionPerformed

    private void btnCauTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCauTruocActionPerformed
        //mỗi khi bấm chuyển về câu trước 
        luuCauTraLoi(deThi.getDsCauHoiTrongDe().get(i), dsCheckBox, textArea.getText());    //lưu các câu trả lời ở câu hỏi hiện tại
        jPanel3.removeAll();     //xóa hết components ở jPanel3
        i--;        //giảm index lên để chuyển câu trước
        chuyenCau();        //set các nút chuyển câu
        loadCauHoi(deThi.getDsCauHoiTrongDe().get(i));  //hiển thị câu hỏi tiếp lên giao diện
        loadCauTraLoi(deThi.getDsCauHoiTrongDe().get(i), dsCheckBox, dsCauTraLoi.get(i));   //load các câu trả lời đã có của câu hỏi này
    }//GEN-LAST:event_btnCauTruocActionPerformed

    private void btnNopBaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNopBaiActionPerformed
        nopBai();
    }//GEN-LAST:event_btnNopBaiActionPerformed

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
            java.util.logging.Logger.getLogger(LamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LamBaiThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minute;
    private javax.swing.JLabel Second;
    private javax.swing.JButton btnCauTiep;
    private javax.swing.JButton btnCauTruoc;
    private javax.swing.JButton btnNopBai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDeBai;
    // End of variables declaration//GEN-END:variables
}
