/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CauHoi;
import model.CauHoiTL;
import model.CauHoiTN;
import model.DapAn;
import model.MonHoc;
import model.QLCH;
import model.QLDA;
import model.QLMH;

/**
 *
 * @author ADMIN
 */
public class SoanCauHoi extends javax.swing.JFrame {
    private QLCH modelCauHoi = new QLCH();      //mảng câu hỏi tạm thời dùng để thêm, sửa, xóa câu hỏi cho môn học đang chọn
        
    private QLDA modelDapAn = new QLDA();       //mảng đáp án tạm thời dùng để thêm, sửa, xóa đáp án cho câu hỏi đang chọn
    
    private ChonMonHoc chonMonHoc;
    
    private int cm; //biến lưu thao tác, nếu cm = 0 thì đang thêm câu hỏi mới, cm = 1 thì đang sửa câu hỏi
   
    //danh sách đáp án tạm thời để xử lý thêm sửa xóa đáp án
    private ArrayList<DapAn> dsDapAnTmp = new ArrayList<DapAn>();



    public SoanCauHoi() {
        initComponents();
        loadChuong();
        btnThemDapAn.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoaDapAn.setEnabled(false);
        btnLuuCauHoi.setEnabled(false);
        btnHuyCauHoi.setEnabled(false);
        btnXoaCauHoi.setEnabled(false);
        
    }
    public SoanCauHoi(ChonMonHoc chonMonHoc){
        initComponents();
        this.chonMonHoc = chonMonHoc;
        btnThemDapAn.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoaDapAn.setEnabled(false);
        btnLuuCauHoi.setEnabled(false);
        btnHuyCauHoi.setEnabled(false);
        btnXoaCauHoi.setEnabled(false);
        
        loadChuong();
    }
    
    public SoanCauHoi(ChonMonHoc chonMonHoc, ArrayList<CauHoi> dsCauHoi){
        initComponents();
        btnThemDapAn.setEnabled(false);     //nút thêm đáp án không bấm đc
        btnCapNhat.setEnabled(false);       //nút cập nhật đáp án không bấm đc
        btnXoaDapAn.setEnabled(false);      //nút xóa đáp án không bấm đc
        btnLuuCauHoi.setEnabled(false);     //nút lưu câu hỏi không bấm được
        btnHuyCauHoi.setEnabled(false);     //nút hủy câu hỏi không bấm đc
        btnXoaCauHoi.setEnabled(false);     //nút xóa câu hỏi không bấm đc
        
        this.chonMonHoc = chonMonHoc;
        for (CauHoi ch : dsCauHoi){
            modelCauHoi.insert(ch);         //đưa các câu hỏi của môn học đã chọn ở giao diện ChonMonHoc vào 
        }
        displayCauHoi(modelCauHoi.getDsCauHoi());       //hiển thị các câu hỏi đã có của môn học đc chọn ở giao diện ChonMonHoc lên bảng
        loadChuong();           //load danh sách các chương của môn học được chọn ở giao diện ChonCauHoi vào ComboBox
    }
        
    
        
    public void xoaForm(){      //hàm xóa trắng các dòng và bảng đáp án
        txtDeBai.setText("");
        txtGoiY.setText("");
        DefaultTableModel tblModel = (DefaultTableModel) tblDapAn.getModel();
        while (tblModel.getRowCount() != 0){
            tblModel.removeRow(0);
        }
        txtDapAn.setText("");
        cbDungSai.setSelected(false);
        cbbDoKho.setSelectedIndex(0);
        cbbChuong.setSelectedIndex(0);  
        btnTNTL.clearSelection();
    }   
   
    public void loadChuong(){       //hàm load danh sách các chương của môn học đang chọn
        //lấy ra số chương của môn học được chọn từ ComboBox
        int n = QLMH.getMonHoc(this.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getSoChuong();
        for (int i = 1;i <= n;i++){
            this.cbbChuong.addItem("Chương" + Integer.toString(i));
        }
    }
    
    public void displayCauHoi(ArrayList<CauHoi> dsCauHoi){          //hàm hiển thị danh sách câu hỏi của môn học đang chọn lên bảng
     DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();
        while (tblModel.getRowCount() != 0){
            tblModel.removeRow(0);
        }
        for (CauHoi ch : dsCauHoi){
            String data[] = {ch.getCauHoi()};
            tblModel.addRow(data);
        }
    }
    
    public void displayDapAn(ArrayList<DapAn> dsDapAn){     //hàm hiển thị danh sách đáp án của câu hỏi đang chọn lên bảng
        DefaultTableModel tblModel = (DefaultTableModel) tblDapAn.getModel();
        while (tblModel.getRowCount() != 0){
            tblModel.removeRow(0);
        }
        for (DapAn da : dsDapAn){
            String data[] = {da.getDapAn()};
            tblModel.addRow(data);
        }
    }
    
    public void xoaFormDapAn(){             //hàm xóa trắng phần đáp án
        txtDapAn.setText("");
        cbDungSai.setSelected(false);
    }
    
    public void loadData(){  //hàm đẩy danh sách câu hỏi vào danh sách câu hỏi của môn học được chọn ở ComboBox
        QLMH.getMonHoc(this.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsCauHoi().clear(); //xóa hết câu hỏi của môn đang chọn đi
        for (CauHoi ch : modelCauHoi.getDsCauHoi()){
            QLMH.getMonHoc(this.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsCauHoi().add(ch); //thêm lại list câu hỏi đã sửa
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

        btnTNTL = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCauHoi = new javax.swing.JTable();
        btnThemCauHoi = new javax.swing.JButton();
        pnDangCauHoi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rbTracNghiem = new javax.swing.JRadioButton();
        rbTuLuan = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDeBai = new javax.swing.JTextArea();
        tpDeBai = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDapAn = new javax.swing.JTable();
        btnThemDapAn = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoaDapAn = new javax.swing.JButton();
        txtDapAn = new javax.swing.JTextField();
        cbDungSai = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGoiY = new javax.swing.JTextArea();
        pnDoKho = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLuuCauHoi = new javax.swing.JButton();
        btnHuyCauHoi = new javax.swing.JButton();
        btnXoaCauHoi = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        cbbDoKho = new javax.swing.JComboBox<>();
        cbbChuong = new javax.swing.JComboBox<>();
        cbXaoTron = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH CÂU HỎI");

        tblCauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi"
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
        tblCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCauHoiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblCauHoiMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblCauHoi);

        btnThemCauHoi.setText("Thêm câu hỏi");
        btnThemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCauHoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemCauHoi))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemCauHoi)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Dạng câu hỏi");

        btnTNTL.add(rbTracNghiem);
        rbTracNghiem.setText("Trắc nghiệm");
        rbTracNghiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTracNghiemActionPerformed(evt);
            }
        });

        btnTNTL.add(rbTuLuan);
        rbTuLuan.setText("Tự luận");
        rbTuLuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTuLuanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Đề bài");

        txtDeBai.setColumns(20);
        txtDeBai.setLineWrap(true);
        txtDeBai.setRows(5);
        txtDeBai.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtDeBai);

        javax.swing.GroupLayout pnDangCauHoiLayout = new javax.swing.GroupLayout(pnDangCauHoi);
        pnDangCauHoi.setLayout(pnDangCauHoiLayout);
        pnDangCauHoiLayout.setHorizontalGroup(
            pnDangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                .addGroup(pnDangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(rbTracNghiem)
                        .addGap(28, 28, 28)
                        .addComponent(rbTuLuan)
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addGap(6, 6, 6))
        );
        pnDangCauHoiLayout.setVerticalGroup(
            pnDangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                .addGroup(pnDangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(rbTracNghiem))
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(rbTuLuan)))
                .addGap(18, 18, 18)
                .addGroup(pnDangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDangCauHoiLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnDangCauHoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 12, 400, 150));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Các đáp án");

        tblDapAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Đáp án"
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
        tblDapAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDapAnMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDapAn);

        btnThemDapAn.setText("Thêm");
        btnThemDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDapAnActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoaDapAn.setText("Xóa");
        btnXoaDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDapAnActionPerformed(evt);
            }
        });

        txtDapAn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbDungSai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbDungSai.setText("Đáp án đúng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đáp án mới:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThemDapAn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoaDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbDungSai))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDungSai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDapAn)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoaDapAn))
                .addGap(116, 116, 116))
        );

        tpDeBai.addTab("tab2", jPanel3);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Gợi ý đáp án");

        txtGoiY.setColumns(20);
        txtGoiY.setRows(5);
        jScrollPane2.setViewportView(txtGoiY);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpDeBai.addTab("", jPanel6);

        getContentPane().add(tpDeBai, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 120, 400, 280));

        pnDoKho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Độ khó");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Chương");

        btnLuuCauHoi.setText("Lưu");
        btnLuuCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuCauHoiActionPerformed(evt);
            }
        });

        btnHuyCauHoi.setText("Hủy");
        btnHuyCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyCauHoiActionPerformed(evt);
            }
        });

        btnXoaCauHoi.setText("Xóa câu hỏi");
        btnXoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCauHoiActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        cbbDoKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dễ", "Trung Bình", "Khó" }));
        cbbDoKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDoKhoActionPerformed(evt);
            }
        });

        cbXaoTron.setText("Có thể xáo trộn được");

        javax.swing.GroupLayout pnDoKhoLayout = new javax.swing.GroupLayout(pnDoKho);
        pnDoKho.setLayout(pnDoKhoLayout);
        pnDoKhoLayout.setHorizontalGroup(
            pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDoKhoLayout.createSequentialGroup()
                        .addComponent(btnLuuCauHoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuyCauHoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaCauHoi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoKhoLayout.createSequentialGroup()
                        .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(198, 203, Short.MAX_VALUE)
                        .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbChuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbDoKho, 0, 134, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoKhoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbXaoTron, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pnDoKhoLayout.setVerticalGroup(
            pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbXaoTron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbChuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(pnDoKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuCauHoi)
                    .addComponent(btnHuyCauHoi)
                    .addComponent(btnXoaCauHoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addContainerGap())
        );

        getContentPane().add(pnDoKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 400, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDapAnActionPerformed

         String dapAn = txtDapAn.getText();
            boolean dungSai;
            if (cbDungSai.isSelected()){
                dungSai = true;
            }else dungSai = false;
            //tạo đối tượng đáp án mới
            DapAn dapAnMoi = new DapAn(dapAn,dungSai);
  
            if (cm == 0){       //nếu đang thêm câu hỏi mới
                modelDapAn.insert(dapAnMoi);  //thêm đáp án mới vào ArrayList đáp án
                //biểu diễn lên bảng
                displayDapAn(modelDapAn.getDsDapAn());
                //thông báo
                JOptionPane.showMessageDialog(null, "Đã thêm đáp án!");
                //xóa trắng đáp án
                xoaFormDapAn();  
                
                //nếu đang thêm đáp án cho câu hỏi có sẵn
            } else if (cm == 1){
                DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();
                int index = tblCauHoi.getSelectedRow();
               
                ((CauHoiTN)modelCauHoi.getCauHoi(index)).getDsDapAn().add(dapAnMoi);    //thêm thằng vào danh sách đáp án của câu hỏi đó
                               
                    //biểu diễn lên bảng
                    displayDapAn(((CauHoiTN)modelCauHoi.getCauHoi(index)).getDsDapAn());
                    //thông báo
                    JOptionPane.showMessageDialog(null, "Đã thêm đáp án!");
                    //xóa trắng đáp án
                    xoaFormDapAn();  
                }
                      
    }//GEN-LAST:event_btnThemDapAnActionPerformed

    private void btnLuuCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuCauHoiActionPerformed
            // nếu đang lưu câu hỏi mới
            if (cm == 0){
                if (rbTracNghiem.isSelected()){ //nếu là câu trắc nghiệm
                    String deBai = txtDeBai.getText(); //lưu đề bài
                
                    ArrayList<DapAn> dsDapAn = new ArrayList<DapAn>();               
                    for (DapAn da : modelDapAn.getDsDapAn()){               //thêm các đáp án trong modelDapAn vào mảng đáp án mới
                        dsDapAn.add(da);                                    //lưu danh sách đáp án
                    }
                    
                    int doKho = cbbDoKho.getSelectedIndex();    //lưu độ khó
                    int chuong = cbbChuong.getSelectedIndex() + 1;  //lưu chương
            
                    CauHoiTN cauHoiTN = new CauHoiTN(deBai, 0, doKho, chuong, dsDapAn);     //tạo đối tượng câu hỏi TN mới
                
                
                    modelCauHoi.getDsCauHoi().add(cauHoiTN);        //thêm câu này vào danh sách câu hỏi
                    // thông báo
                    JOptionPane.showMessageDialog(null, "Đã thêm câu hỏi!"); 
                    //hiển thị danh sách câu hỏi lên bảng
                    displayCauHoi(modelCauHoi.getDsCauHoi());
                                   
                    xoaForm();//xóa trắng các dòng
                    
                    modelDapAn.clear();     //xóa trắng danh sách đáp án
                
                } else if (rbTuLuan.isSelected()){      //nếu là câu tự luận
                    String deBai = txtDeBai.getText();      //lưu đề
                    String goiY = txtGoiY.getText();        //lưu gợi ý
                    int doKho = cbbDoKho.getSelectedIndex();        //lưu độ khó
                    int chuong = cbbChuong.getSelectedIndex() + 1;  //lưu chương
                    
            
                    CauHoiTL cauHoiTL = new CauHoiTL(deBai, 1, doKho, chuong, goiY);        //tạo đối tượng câu hỏi TL mới
                
                    modelCauHoi.getDsCauHoi().add(cauHoiTL);        //thêm câu này vào danh sách câu hỏi
                    JOptionPane.showMessageDialog(null, "Đã thêm câu hỏi!");
                
                    //hiển thị danh sách câu hỏi lên bảng
                    displayCauHoi(modelCauHoi.getDsCauHoi());
                    // thông báo 
                    xoaForm();//xóa trắng các dòng
                }
                          
             } else if (cm == 1){      //nếu đang lưu 1 câu hỏi đã có vừa sửa      
                 
                String deBai = txtDeBai.getText(); //lưu đề bài
                int doKho = cbbDoKho.getSelectedIndex();    //lưu độ khó
                int chuong = cbbChuong.getSelectedIndex() + 1;  //lưu chương
                
                DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();      //lấy câu hỏi được chọn
                int index = tblCauHoi.getSelectedRow();
                 
                    if (rbTracNghiem.isSelected()){ //nếu là câu trắc nghiệm    
                        ((CauHoiTN)modelCauHoi.getCauHoi(index)).setCauHoi(deBai);      //sửa đề bài
                     
                        ((CauHoiTN)modelCauHoi.getCauHoi(index)).setDoKho(doKho);       //sửa độ khó
                        ((CauHoiTN)modelCauHoi.getCauHoi(index)).setChuong(chuong);     //sửa chương
                        
                        JOptionPane.showMessageDialog(null, "Đã cập nhật câu hỏi!");  
                        
                        displayCauHoi(modelCauHoi.getDsCauHoi());//biểu diễn danh sách câu hỏi vào bảng
                        
                        xoaForm();        //xóa trắng các dòng
                     
                    } else if (rbTuLuan.isSelected()){      //nếu là câu tự luận
                        String goiY = txtGoiY.getText();        //lấy gợi ý
                        
                        ((CauHoiTL)modelCauHoi.getCauHoi(index)).setCauHoi(deBai);      //sửa đề bài
                        ((CauHoiTL)modelCauHoi.getCauHoi(index)).setGoiY(goiY);         //sửa gợi ý
                        ((CauHoiTL)modelCauHoi.getCauHoi(index)).setDoKho(doKho);       //sửa độ khó
                        ((CauHoiTL)modelCauHoi.getCauHoi(index)).setChuong(chuong);     //sửa chương
                        
                        JOptionPane.showMessageDialog(null, "Đã cập nhật câu hỏi!");  
                        
                         displayCauHoi(modelCauHoi.getDsCauHoi());//biểu diễn danh sách câu hỏi vào bảng
                
                        xoaForm();        //xóa trắng các dòng
                    }

              
            }
            
            btnThemDapAn.setEnabled(false);
            btnCapNhat.setEnabled(false);
            btnXoaDapAn.setEnabled(false);
            btnLuuCauHoi.setEnabled(false);
            btnHuyCauHoi.setEnabled(false);
            btnXoaCauHoi.setEnabled(false);
            
         
    }//GEN-LAST:event_btnLuuCauHoiActionPerformed

    private void btnThemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCauHoiActionPerformed
        // đang thêm câu hỏi mới
            cm = 0;
            
            xoaForm();  //xóa trắng các dòng
            
            btnThemDapAn.setEnabled(true);
            btnLuuCauHoi.setEnabled(true);
            btnHuyCauHoi.setEnabled(true);
            btnXoaCauHoi.setEnabled(true);
            
            tblCauHoi.setRowSelectionAllowed(false);        //không được bấm vào bảng câu hỏi khi đang thêm câu mới
            
    }//GEN-LAST:event_btnThemCauHoiActionPerformed

    private void rbTracNghiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTracNghiemActionPerformed
            // nếu bấm nút trắc nghiệm
            //Hiện tab trắc nghiệm
            tpDeBai.setSelectedIndex(0);        //hiện giao diện của câu hỏi trắc nghiệm
            tpDeBai.setVisible(true);           
            pnDoKho.setVisible(true);

    }//GEN-LAST:event_rbTracNghiemActionPerformed

    private void rbTuLuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTuLuanActionPerformed
        // TODO add your handling code here:
        tpDeBai.setSelectedIndex(1);        //hiện giao diện của câu hỏi tự luận
            tpDeBai.setVisible(true);
            pnDoKho.setVisible(true);
    }//GEN-LAST:event_rbTuLuanActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // nút cập nhật đáp án của 1 câu hỏi
        try{
            
        DefaultTableModel tblModel = (DefaultTableModel) tblDapAn.getModel();
        int index = tblDapAn.getSelectedRow();                  //lấy index dòng đc chọn trong bảng đáp án
        //tạo đáp án mới
        String dapAn = txtDapAn.getText();
            boolean dungSai;
            if (cbDungSai.isSelected()){
                dungSai = true;
            }else dungSai = false;

            DapAn dapAnMoi = new DapAn(dapAn,dungSai);          //tạo ra đối tượng đáp án mới
            
            //nếu là đáp án của 1 câu hỏi mới đang tạo
            if (cm == 0){
                //thay đáp án đang sửa bằng đáp án mới trong modelDapAn
                modelDapAn.update(index, dapAnMoi);
                //hiển thị lại bảng đáp án
                displayDapAn(modelDapAn.getDsDapAn());
            
                JOptionPane.showMessageDialog(null, "Đã cập nhật đáp án!");
        
                xoaFormDapAn();
        
                btnXoaDapAn.setEnabled(false);
                btnCapNhat.setEnabled(false);
                tblDapAn.setRowSelectionAllowed(false);
                
            //nếu là đáp án của 1 câu hỏi đã có 
            }else if (cm == 1){
                DefaultTableModel tblModel1 = (DefaultTableModel) tblCauHoi.getModel();
                int index1 = tblCauHoi.getSelectedRow();                //lấy câu hỏi đang đc chọn
                
                ((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn().get(index).setDapAn(dapAn);      //cập nhật thằng đáp án của câu hỏi đó
                ((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn().get(index).setDungSai(dungSai);
                    //biểu diễn lên bảng
                    displayDapAn(((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn());
                    //thông báo
                    JOptionPane.showMessageDialog(null, "Đã cập nhật đáp án!");
                    //xóa trắng đáp án
                    xoaFormDapAn();  
                    
                    btnXoaDapAn.setEnabled(false);
                    btnCapNhat.setEnabled(false);
                    tblDapAn.setRowSelectionAllowed(false);
            }
        }catch (Exception e){
            
        }

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tblDapAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDapAnMouseClicked
        // khi click vào bảng đáp án
        try{
                    btnCapNhat.setEnabled(true);        //nút cập nhật đáp án có thể bấm đc
                    btnXoaDapAn.setEnabled(true);       //nút xóa đáp án có thể bấm đuợc
                    DefaultTableModel tblModel = (DefaultTableModel) tblDapAn.getModel();
                    int index = tblDapAn.getSelectedRow();      //lấy index của đáp án đc click
                    if (cm == 0){                               //nếu đang thêm câu hỏi mới
                        txtDapAn.setText(modelDapAn.getDsDapAn().get(index).getDapAn());        //lấy đáp án đc click từ modelDapAn
                        cbDungSai.setSelected(modelDapAn.getDsDapAn().get(index).isDungSai());
                    }else if (cm == 1){                         //nếu đang sửa đáp án của câu hỏi có sẵn
                        DefaultTableModel tblModel1 = (DefaultTableModel) tblCauHoi.getModel();   //lấy index của câu hỏi đc chọn
                        int index1 = tblCauHoi.getSelectedRow();
                                       
                        txtDapAn.setText(((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn().get(index).getDapAn());         //lấy đáp án ở vị trí index của câu hỏi đc chọn
                        cbDungSai.setSelected(((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn().get(index).isDungSai());   //đưa lên bảng đáp án
                    }                    
        }catch (Exception e){
            
        }
             
                
    }//GEN-LAST:event_tblDapAnMouseClicked

    private void btnXoaDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDapAnActionPerformed

            int response = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa đáp án không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
            DefaultTableModel tblModel = (DefaultTableModel) tblDapAn.getModel();
            int index = tblDapAn.getSelectedRow();      //lấy index của đáp án đc chọn
                if (cm == 0){                           //nếu đang xóa đáp án trong khi tạo câu hỏi mới
                    tblModel.removeRow(index);          //xóa dòng trong bảng đáp án
                
                    txtDapAn.setText("");
                    cbDungSai.setSelected(false);
                
                
                    modelDapAn.getDsDapAn().remove(index);  //xóa đáp án từ modelDapAn
                    
                    btnCapNhat.setEnabled(false);
                    btnXoaDapAn.setEnabled(false);  
            } else if (cm == 1){                            //nếu đang xóa đáp án của câu hỏi có sẵn
                    tblModel.removeRow(index);              //xóa dòng trong bảng đáp án
                
                    txtDapAn.setText("");
                    cbDungSai.setSelected(false);
                    
                    DefaultTableModel tblModel1 = (DefaultTableModel) tblCauHoi.getModel();
                    int index1 = tblCauHoi.getSelectedRow();
               
                    ((CauHoiTN)modelCauHoi.getCauHoi(index1)).getDsDapAn().remove(index);       //xóa đáp án thẳng trong danh sách đáp án của câu hỏi
                    
                    btnCapNhat.setEnabled(false);
                    btnXoaDapAn.setEnabled(false);  
                }
            }
    }//GEN-LAST:event_btnXoaDapAnActionPerformed

    private void cbbDoKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDoKhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDoKhoActionPerformed

    private void tblCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCauHoiMouseClicked
        // TODO add your handling code here:
        cm = 1; 
        
        btnThemDapAn.setEnabled(true);
        btnCapNhat.setEnabled(true);
        btnXoaDapAn.setEnabled(true);
        btnLuuCauHoi.setEnabled(true);
        btnHuyCauHoi.setEnabled(true);
        btnXoaCauHoi.setEnabled(true);
        
        DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();
        int index = tblCauHoi.getSelectedRow();
               
        if (modelCauHoi.getDsCauHoi().get(index).getDangCauHoi() == 0){ //Nếu câu hỏi ở vị trí index trong modelCauHoi là câu trắc nghiệm
                          
                rbTracNghiem.setSelected(true); //để radio button là trắc nghiệm
                tpDeBai.setSelectedIndex(0);    //tab panel chuyển sang tab trắc nghiệm
                txtDeBai.setText(((CauHoiTN)modelCauHoi.getCauHoi(index)).getCauHoi()); //đưa đề của câu hỏi lên textfield
                
                //hiển thị danh sách đáp án lên table Đáp án
                displayDapAn(((CauHoiTN)modelCauHoi.getCauHoi(index)).getDsDapAn());
                
                cbbDoKho.setSelectedIndex(((CauHoiTN)modelCauHoi.getCauHoi(index)).getDoKho());     //
                cbbChuong.setSelectedIndex((((CauHoiTN)modelCauHoi.getCauHoi(index)).getChuong()) - 1);  
            } 
            else if (modelCauHoi.getDsCauHoi().get(index).getDangCauHoi() == 1){
                
                rbTuLuan.setSelected(true);
                tpDeBai.setSelectedIndex(1);
                txtDeBai.setText(((CauHoiTL)modelCauHoi.getCauHoi(index)).getCauHoi());
                txtGoiY.setText(((CauHoiTL)modelCauHoi.getCauHoi(index)).getGoiY());
                cbbDoKho.setSelectedIndex(((CauHoiTL)modelCauHoi.getCauHoi(index)).getDoKho());
                cbbChuong.setSelectedIndex((((CauHoiTL)modelCauHoi.getCauHoi(index)).getChuong()) - 1);   
                
            }
        
    }//GEN-LAST:event_tblCauHoiMouseClicked

    private void tblCauHoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCauHoiMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCauHoiMouseEntered

    private void btnXoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCauHoiActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa câu hỏi không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
        DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();
        int index = tblCauHoi.getSelectedRow();
   
        modelCauHoi.getDsCauHoi().remove(index);
        
        displayCauHoi(modelCauHoi.getDsCauHoi());
        
        modelDapAn.clear();
        
        xoaForm();
        }
    }//GEN-LAST:event_btnXoaCauHoiActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        loadData();
        this.setVisible(false);
        modelCauHoi.clear();
        this.chonMonHoc.setVisible(true);
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHuyCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyCauHoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyCauHoiActionPerformed

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
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoanCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHuyCauHoi;
    private javax.swing.JButton btnLuuCauHoi;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup btnTNTL;
    private javax.swing.JButton btnThemCauHoi;
    private javax.swing.JButton btnThemDapAn;
    private javax.swing.JButton btnXoaCauHoi;
    private javax.swing.JButton btnXoaDapAn;
    private javax.swing.JCheckBox cbDungSai;
    private javax.swing.JCheckBox cbXaoTron;
    private javax.swing.JComboBox<String> cbbChuong;
    private javax.swing.JComboBox<String> cbbDoKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnDangCauHoi;
    private javax.swing.JPanel pnDoKho;
    private javax.swing.JRadioButton rbTracNghiem;
    private javax.swing.JRadioButton rbTuLuan;
    private javax.swing.JTable tblCauHoi;
    private static javax.swing.JTable tblDapAn;
    private javax.swing.JTabbedPane tpDeBai;
    private javax.swing.JTextField txtDapAn;
    private javax.swing.JTextArea txtDeBai;
    private javax.swing.JTextArea txtGoiY;
    // End of variables declaration//GEN-END:variables
}
