/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.CauHoi;
import model.CauHoiTL;
import model.CauHoiTN;
import model.CauHoiTrongDe;
import model.DapAn;
import model.DeThi;
import model.QLCH;
import model.QLMH;

/**
 *
 * @author ADMIN
 */
public class TaoDeThi extends javax.swing.JFrame {
    
    private ArrayList<CauHoiTrongDe> dsCauHoiTrongDe = new ArrayList<>();
    
    private DeThi deThi = new DeThi();     
    
    protected ChonDeThi chonDeThi;
    
    protected ChonCachTaoDeThi chonCachTaoDeThi;
     
    private QLCH model = new QLCH();
    
    private ArrayList<CauHoi> dsCauHoiHienThi = new ArrayList<>();
        
    private int cm; //cm = 0 là đang tạo đề thi mới, cm = 1 là đan sửa đề thi cũ


    /**
     * Creates new form TaoDeThi
     */
    public TaoDeThi() {
        initComponents();
    }
    
     public TaoDeThi(ChonCachTaoDeThi chonCachTaoDeThi, ArrayList<CauHoi> dsCauHoi) {       //khởi tạo khi tạo đề mới 
        initComponents();
        cm = 0;     //đang tạo đề thi mới
        this.chonCachTaoDeThi = chonCachTaoDeThi;   
        btnThemCauHoiVaoDe.setEnabled(false);       //không cho bấm vào nút thêm câu hỏi khi chưa chọn câu trên bảng
        btnXoaDeThi.setEnabled(false);          //khi đang tạo đề thi mới thì không bấm được nút xóa đề thi        
        rbTatCaCauHoi.setSelected(true);
        for (CauHoi ch : dsCauHoi){             
            this.model.insert(ch);               //truyền danh sách câu hỏi của môn học đã chọn vào
        }                                           
        displayCauHoi(tblCauHoi,dsCauHoiHienThi);       //hiển thị danh sách câu hỏi lên bảng
        //đặt tên cho đề thi
        //deThi.setTenDeThi("Bài thi môn " + QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getTenMonHoc());
        deThi.setDsCauHoiTrongDe(dsCauHoiTrongDe);
        loadDeThi(deThi);
    }
     
     public TaoDeThi(ChonDeThi chonDeThi, ArrayList<CauHoi> dsCauHoi, DeThi deThi) {        //khởi tạo khi sửa đề cũ
        initComponents();
        cm = 1;     //đang sửa đề thi cũ
        btnThemCauHoiVaoDe.setEnabled(false);       //không cho bấm vào nút thêm câu hỏi khi chưa chọn câu trên bảng
        btnXoaDeThi.setEnabled(true);       //khi sửa đề thi có sẵn thì có thể xóa đề thi        
        buttonGroup1.setSelected(rbTatCaCauHoi.getModel(),true);        //ban đầu để nút chọn cả trắc nghiệm và tự luận
        this.chonDeThi = chonDeThi;
        for (CauHoi ch : dsCauHoi){
            this.model.insert(ch);          //đưa danh sách câu hỏi của môn học đã chọn vào
        }
        displayCauHoi(tblCauHoi,dsCauHoiHienThi);       //hiển thị danh sách câu hỏi lên bảng
        this.deThi = deThi;
        displayCauHoiTrongDe(tblCauHoiTrongDe,this.deThi.getDsCauHoiTrongDe());  //hiển thị danh sách các câu hỏi trong đề thi đã chọn lên bảng
        txtTenDeThi.setText(this.deThi.getTenDeThi());
        txtThoiGian.setText(this.deThi.getThoiGian() + "");     //hiển thị thời gian của đề thi đã chọn
        txtNamHoc.setText(this.deThi.getNamHoc());      //hiển thị năm học của đề thi đã chọn
        loadDeThi(this.deThi);
    }
     
public void displayCauHoi(JTable table, ArrayList<CauHoi> dsCauHoi) {
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        while (tblModel.getRowCount() != 0) {
            tblModel.removeRow(0);
        }
        if (rbTatCaCauHoi.isSelected()) {            //nếu bấm nút tất cả thì hiển cả danh sách câu hỏi
            for (CauHoi ch : dsCauHoi) {
                String data[] = {ch.getCauHoi()};
                tblModel.addRow(data);
            }
        } else if (rbCauHoiTN.isSelected()) {        //nếu bấm nút trắc nghiệm thì chỉ hiện câu hỏi trắc nghiệm
            for (CauHoi ch : dsCauHoi) {
                if (ch.getDangCauHoi() == 0) {
                    String data[] = {ch.getCauHoi()};
                    tblModel.addRow(data);
                }
            }
        } else if (rbCauHoiTL.isSelected()) {        //nếu bấm nút tự luận thì chỉ hiện câu hỏi tự luận
            for (CauHoi ch : dsCauHoi) {
                if (ch.getDangCauHoi() == 1) {
                    String data[] = {ch.getCauHoi()};
                    tblModel.addRow(data);
                }
            }
        }
    }
    
    public void displayCauHoiTrongDe(JTable table,ArrayList<CauHoiTrongDe> dsCauHoiTrongDe){ //hàm hiển thị danh sách câu hỏi trong đề
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        while (tblModel.getRowCount() != 0){
            tblModel.removeRow(0);
        }
        for (CauHoiTrongDe ch : dsCauHoiTrongDe){
            String data[] = {ch.getCauHoi().getCauHoi()};
            tblModel.addRow(data);
        }
    }
    
    public void loadCauHoi(CauHoi cauHoi){          //hàm hiển thị thông tin chi tiết của câu hỏi lên text area
        txtThongTinCauHoi.setText("");              //xóa trắng textArea
        txtThongTinCauHoi.append(cauHoi.getCauHoi() + "\n");        //điền đề bài
        if (cauHoi.getDangCauHoi() == 0){                //nếu là câu trắc nghiệm
            char x = 'A';
            for (DapAn da : ((CauHoiTN)cauHoi).getDsDapAn()){
                txtThongTinCauHoi.append("      " + x + ". " + da.getDapAn() + "\n");  //hiện các đáp án của câu hỏi
                x++;
            }
            txtThongTinCauHoi.append("------------------------------------------- \n");
            txtThongTinCauHoi.append("Thông tin chi tiết \n");
            txtThongTinCauHoi.append("Đáp án đúng: \n");                
            for (DapAn da : ((CauHoiTN)cauHoi).getDsDapAn()){
                if (da.isDungSai() == true) txtThongTinCauHoi.append("      " + da.getDapAn() + "\n"); //hiện các đáp án đúng
            }        
            
            if (cauHoi.getDoKho() == 0) {
                txtThongTinCauHoi.append("Độ khó: Dễ \n");
            } else if (cauHoi.getDoKho() == 1){
                txtThongTinCauHoi.append("Độ khó: Trung bình \n");
            } else if (cauHoi.getDoKho() == 2){
                txtThongTinCauHoi.append("Độ khó: Khó \n");
            }
            
            txtThongTinCauHoi.append("Chương: " + ((Integer)cauHoi.getChuong()).toString() + "\n");
        } else if (cauHoi.getDangCauHoi() == 1){        //nếu là câu hỏi tự luận
            txtThongTinCauHoi.append("------------------------------------------- \n");
            txtThongTinCauHoi.append("Thông tin chi tiết \n");
            txtThongTinCauHoi.append("Gợi ý đáp án:  \n");
            txtThongTinCauHoi.append(((CauHoiTL)cauHoi).getGoiY() + "\n");      //hiện gợi ý
            if (cauHoi.getDoKho() == 0) {
                txtThongTinCauHoi.append("Độ khó: Dễ \n");
            } else if (cauHoi.getDoKho() == 1){
                txtThongTinCauHoi.append("Độ khó: Trung bình \n");
            } else if (cauHoi.getDoKho() == 2){
                txtThongTinCauHoi.append("Độ khó: Khó \n");
            }
            
            txtThongTinCauHoi.append("Chương: " + ((Integer)cauHoi.getChuong()).toString() + "\n");
        }
    }
    
    public void loadDeThi(DeThi deThi){         //hàm hiển thị đề thi lên text area
        try{
        txtDeThi.setText("");
        txtDeThi.append(deThi.getTenDeThi() + "\n");
        if (deThi.getKyHoc() == 1){
            txtDeThi.append("\n Kỳ 1 - ");
        } else if (deThi.getKyHoc() == 2){
            txtDeThi.append("\n Kỳ 2 - ");
        } else if (deThi.getKyHoc() == 3){
            txtDeThi.append("\n Kỳ hè - ");
        } 
        
        txtDeThi.append("Năm học " + deThi.getNamHoc() + "\n");
        txtDeThi.append("Thời gian: " + deThi.getThoiGian() + " phút \n");
        txtDeThi.append("\n");
        for (CauHoiTrongDe ch : deThi.getDsCauHoiTrongDe()){
            txtDeThi.append("(" + ch.getDiem() + " điểm) \n");
            txtDeThi.append(ch.getCauHoi().getCauHoi() + "\n");
            if (ch.getCauHoi().getDangCauHoi() == 0){
                char x = 'A';
                for (DapAn da : ((CauHoiTN)ch.getCauHoi()).getDsDapAn()){
                    txtDeThi.append("       " + x + ". " + da.getDapAn() + "\n");
                    x++;
                }          
            }
            txtDeThi.append("\n");
        }
        
    }catch (Exception e){
        
        }
    }
    
    public void xaoTronCauHoi(ArrayList<CauHoiTrongDe> dsCauHoiTrongDe){        //hàm xáo trộn vị trí các câu hỏi trong đề
        ArrayList<CauHoiTrongDe> dsCauHoiTmp = new ArrayList<CauHoiTrongDe>();      //mảng câu hỏi trong đề tạm thòi để lưu danh sách với thứ tự mới
        while (dsCauHoiTrongDe.size() != 0){                        //nếu danh sách ban đầu chưa rỗng
            int index = (int)(Math.random() * dsCauHoiTrongDe.size());      //chọn random 1 câu hỏi nào đó trong danh sách
            dsCauHoiTmp.add(dsCauHoiTrongDe.get(index));                    //thêm câu đó vào mảng tạm thời
            dsCauHoiTrongDe.remove(index);                                  //xóa câu đó khỏi danh sách gốc
        }
        for (CauHoiTrongDe ch : dsCauHoiTmp){
            dsCauHoiTrongDe.add(ch);    //lấy lần lượt các câu hỏi trong mảng tạm thời thêm lại vào danh sách gốc thì sẽ đc thứ tự mới
        }
    }
    
    public boolean kiemTraCauHoiTonTai(ArrayList<CauHoiTrongDe> list, CauHoi cauHoi) {
        for (CauHoiTrongDe c : list) {
            if (c.getCauHoi().getCauHoi().equalsIgnoreCase(cauHoi.getCauHoi())) {
                return true;
            }
        }
        return false;
    }
    
    public void saveToDoc(String content) {
        try {
            File file = new File("D://DeThi.doc");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
//    public void search(String s){
//        DefaultTableModel m = (DefaultTableModel) tblCauHoi.getModel();
//        //m.fireTableDataChanged();
//        TableRowSorter sorter = new TableRowSorter(m);
//        tblCauHoi.setRowSorter(sorter);
//        sorter.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCauHoiTrongDe = new javax.swing.JTable();
        btnXoaCauHoiKhoiDe = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbKy1 = new javax.swing.JRadioButton();
        rbKy2 = new javax.swing.JRadioButton();
        rbKyHe = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDeThi = new javax.swing.JTextArea();
        btnTronCauHoi = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        btnLuuDeThi = new javax.swing.JButton();
        btnXoaDeThi = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTenDeThi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCauHoi = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtThongTinCauHoi = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        rbTatCaCauHoi = new javax.swing.JRadioButton();
        rbCauHoiTN = new javax.swing.JRadioButton();
        rbCauHoiTL = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        btnThemCauHoiVaoDe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("DANH SÁCH CÁC CÂU TRONG ĐỀ");

        tblCauHoiTrongDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi trong đề"
            }
        ));
        jScrollPane3.setViewportView(tblCauHoiTrongDe);

        btnXoaCauHoiKhoiDe.setText("Xóa câu hỏi khỏi đề");
        btnXoaCauHoiKhoiDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCauHoiKhoiDeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thông tin đề thi");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Thời gian");

        txtThoiGian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianActionPerformed(evt);
            }
        });
        txtThoiGian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThoiGianKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtThoiGianKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("phút");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Năm học");

        txtNamHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamHocActionPerformed(evt);
            }
        });
        txtNamHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamHocKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamHocKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Kỳ");

        buttonGroup2.add(rbKy1);
        rbKy1.setText("1");
        rbKy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKy1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbKy2);
        rbKy2.setText("2");
        rbKy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKy2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbKyHe);
        rbKyHe.setText("Kỳ hè");
        rbKyHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKyHeActionPerformed(evt);
            }
        });

        txtDeThi.setColumns(20);
        txtDeThi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDeThi.setLineWrap(true);
        txtDeThi.setRows(5);
        txtDeThi.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtDeThi);

        btnTronCauHoi.setText("Xáo trộn các câu hỏi");
        btnTronCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTronCauHoiActionPerformed(evt);
            }
        });

        btnXuatFile.setText("Xuất ra file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        btnLuuDeThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLuuDeThi.setText("Lưu đề thi");
        btnLuuDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDeThiActionPerformed(evt);
            }
        });

        btnXoaDeThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDeThi.setText("Xóa đề thi");
        btnXoaDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDeThiActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên đề thi");

        txtTenDeThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnLuuDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnXoaDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamHoc)
                                    .addComponent(txtTenDeThi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(rbKy1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbKy2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbKyHe)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaCauHoiKhoiDe, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTronCauHoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXuatFile))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaCauHoiKhoiDe)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTenDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatFile)
                    .addComponent(btnTronCauHoi)
                    .addComponent(rbKyHe)
                    .addComponent(rbKy2)
                    .addComponent(rbKy1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuDeThi)
                    .addComponent(btnXoaDeThi)
                    .addComponent(btnCancel))
                .addGap(18, 18, 18))
        );

        tblCauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi"
            }
        ));
        tblCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCauHoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCauHoi);

        txtThongTinCauHoi.setColumns(20);
        txtThongTinCauHoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThongTinCauHoi.setLineWrap(true);
        txtThongTinCauHoi.setRows(5);
        txtThongTinCauHoi.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtThongTinCauHoi);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Dạng câu hỏi");

        buttonGroup1.add(rbTatCaCauHoi);
        rbTatCaCauHoi.setText("Tất cả");
        rbTatCaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTatCaCauHoiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCauHoiTN);
        rbCauHoiTN.setText("Trắc nghiệm");
        rbCauHoiTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCauHoiTNActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCauHoiTL);
        rbCauHoiTL.setText("Tự luận");
        rbCauHoiTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCauHoiTLActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Điểm cho câu hỏi");

        txtDiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemActionPerformed(evt);
            }
        });
        txtDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemKeyTyped(evt);
            }
        });

        btnThemCauHoiVaoDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemCauHoiVaoDe.setText("Thêm vào đề thi");
        btnThemCauHoiVaoDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCauHoiVaoDeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("DANH SÁCH CÂU HỎI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(438, 438, 438))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(btnThemCauHoiVaoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbTatCaCauHoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCauHoiTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCauHoiTL)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemCauHoiVaoDe)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTatCaCauHoi)
                    .addComponent(rbCauHoiTN)
                    .addComponent(rbCauHoiTL))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCauHoiMouseClicked
        // TODO add your handling code here:
        btnThemCauHoiVaoDe.setEnabled(true);        //khi chọn 1 câu hỏi trên bảng thì nút thêm câu hỏi được bật
        DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();      //lấy câu hỏi được chọn
        int index = tblCauHoi.getSelectedRow();
        //hiển thị thông tin của câu hỏi đc chọn lên textArea
        loadCauHoi(dsCauHoiHienThi.get(index));
            
    }//GEN-LAST:event_tblCauHoiMouseClicked

    private void btnThemCauHoiVaoDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCauHoiVaoDeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) tblCauHoi.getModel();  
        //lấy câu hỏi được chọn
        int index = tblCauHoi.getSelectedRow();
        //tạo ra 1 câu hỏi trong đề mới với câu hỏi chọn ở table và điểm của câu hỏi đã nhập vào
        CauHoiTrongDe cauHoiTrongDe = new CauHoiTrongDe(dsCauHoiHienThi.get(index), Float.parseFloat(txtDiem.getText()));
        //thêm câu này vào deThi
        deThi.getDsCauHoiTrongDe().add(cauHoiTrongDe);
        //hiển thị danh sách các câu hỏi trong đề thi
        displayCauHoiTrongDe(tblCauHoiTrongDe,deThi.getDsCauHoiTrongDe());
        //hiển thị đề thi lên textArea
        loadDeThi(deThi);
        
        txtDiem.setText("");
        
    }//GEN-LAST:event_btnThemCauHoiVaoDeActionPerformed

    private void txtDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemActionPerformed

    private void txtDiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtDiemKeyTyped

    private void txtThoiGianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThoiGianKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtThoiGianKeyTyped

    private void txtNamHocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamHocKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamHocKeyTyped

    private void rbKy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKy1ActionPerformed
        
        this.deThi.setKyHoc(1);
        //deThi.setTenDeThi("Bài thi môn " + QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getTenMonHoc());
        loadDeThi(deThi);
    }//GEN-LAST:event_rbKy1ActionPerformed

    private void rbKy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKy2ActionPerformed

        this.deThi.setKyHoc(2);
        //deThi.setTenDeThi("Bài thi môn " + QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getTenMonHoc());
        loadDeThi(deThi);
    }//GEN-LAST:event_rbKy2ActionPerformed

    private void rbKyHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKyHeActionPerformed

        this.deThi.setKyHoc(3);
        //deThi.setTenDeThi("Bài thi môn " + QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getTenMonHoc() + " kỳ hè " + deThi.getNamHoc());
        loadDeThi(deThi);
    }//GEN-LAST:event_rbKyHeActionPerformed

    private void txtThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianActionPerformed

    }//GEN-LAST:event_txtThoiGianActionPerformed

    private void txtThoiGianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThoiGianKeyPressed

        loadDeThi(deThi);
    }//GEN-LAST:event_txtThoiGianKeyPressed

    private void txtNamHocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamHocKeyPressed

        loadDeThi(deThi);
    }//GEN-LAST:event_txtNamHocKeyPressed

    private void btnXoaCauHoiKhoiDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCauHoiKhoiDeActionPerformed
        int response = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa đáp án không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
        DefaultTableModel tblModel = (DefaultTableModel) tblCauHoiTrongDe.getModel();  
        //lấy câu hỏi được chọn
        int index = tblCauHoiTrongDe.getSelectedRow();
        //xóa câu này trong deThi
        this.deThi.getDsCauHoiTrongDe().remove(index);
        //hiển thị lại danh sách các câu hỏi trong đề thi
        displayCauHoiTrongDe(tblCauHoiTrongDe, this.deThi.getDsCauHoiTrongDe());
        //hiển thị lại đề thi lên textArea
        //loadDeThi(deThi);
        }
    }//GEN-LAST:event_btnXoaCauHoiKhoiDeActionPerformed

    private void btnLuuDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDeThiActionPerformed

            if (cm == 0){       //nếu đang tạo đề thi mới
                deThi.setTenDeThi(txtTenDeThi.getText());
                deThi.setThoiGian(Integer.parseInt(txtThoiGian.getText())); 
                deThi.setNamHoc(txtNamHoc.getText());
                loadDeThi(this.deThi);
                //thêm deThi vào danh sách đề thi của môn học đã chọn ở giao diện ChonMonHoc
                QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().add(deThi);
                //load danh sách đề thi của môn học đc chọn lên trên bảng ở giao diện ChonDeThi
                this.chonCachTaoDeThi.chonDeThi.loadDsDeThi(QLMH.getMonHoc(this.chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi());
        
                //this.setVisible(false);
                //this.chonCachTaoDeThi.chonDeThi.setVisible(true);
            } else if (cm == 1){        //nếu đang sửa 1 đề thi có sẵn
                deThi.setTenDeThi(txtTenDeThi.getText());
                deThi.setThoiGian(Integer.parseInt(txtThoiGian.getText()));
                deThi.setNamHoc(txtNamHoc.getText());
                //xóa đề thi đang sửa trong danh sách đề thi của môn học đc chọn
                QLMH.getMonHoc(this.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().remove(this.chonDeThi.getTblDeThi().getSelectedRow());
                //thay bằng đề thi đã sửa vào đúng vị trí đã xóa
                QLMH.getMonHoc(this.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().add(this.chonDeThi.getTblDeThi().getSelectedRow(), deThi);
                //load danh sách đề thi của môn học đc chọn lên trên bảng ở giao diện ChonDeThi
                this.chonDeThi.loadDsDeThi(QLMH.getMonHoc(this.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi());
        
                this.setVisible(false);
                this.chonDeThi.setVisible(true);
            }
               
    }//GEN-LAST:event_btnLuuDeThiActionPerformed

    private void rbTatCaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTatCaCauHoiActionPerformed
        // TODO add your handling code here:
        //displayCauHoi(tblCauHoi,model.getDsCauHoi());
        while (!dsCauHoiHienThi.isEmpty()){
            dsCauHoiHienThi.remove(0);
        }
        for (CauHoi ch : model.getDsCauHoi()){
                dsCauHoiHienThi.add(ch);
            }
        displayCauHoi(tblCauHoi,dsCauHoiHienThi);
            
    }//GEN-LAST:event_rbTatCaCauHoiActionPerformed

    private void rbCauHoiTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCauHoiTNActionPerformed
        // TODO add your handling code here:
        //displayCauHoi(tblCauHoi,model.getDsCauHoi());
        while (!dsCauHoiHienThi.isEmpty()){
            dsCauHoiHienThi.remove(0);
        }
        for (CauHoi ch : model.getDsCauHoi()){
            if (ch.getDangCauHoi() == 0) dsCauHoiHienThi.add(ch);
        }
        displayCauHoi(tblCauHoi, dsCauHoiHienThi);
    }//GEN-LAST:event_rbCauHoiTNActionPerformed

    private void rbCauHoiTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCauHoiTLActionPerformed
        // TODO add your handling code here:
        //displayCauHoi(tblCauHoi,model.getDsCauHoi());
        while (!dsCauHoiHienThi.isEmpty()){
            dsCauHoiHienThi.remove(0);
        }
        for (CauHoi ch : model.getDsCauHoi()){
            if (ch.getDangCauHoi() == 1) dsCauHoiHienThi.add(ch);
        }
        displayCauHoi(tblCauHoi, dsCauHoiHienThi);
    }//GEN-LAST:event_rbCauHoiTLActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (cm == 0){
            this.setVisible(false);
            this.chonCachTaoDeThi.chonDeThi.setVisible(true);
        } else if (cm == 1){
            this.setVisible(false);
            this.chonDeThi.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnXoaDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDeThiActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xóa đề thi không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                //xóa đề thi đã chọn ở giao diện ChonDeThi khỏi danh sách đề thi của môn học đc chọn ở giao diện ChonMonHoc
                QLMH.getMonHoc(this.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().remove(this.chonDeThi.getTblDeThi().getSelectedRow());
                //load danh sách đề thi của môn học đc chọn lên trên bảng ở giao diện ChonDeThi
                this.chonDeThi.loadDsDeThi(QLMH.getMonHoc(this.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi());
                this.setVisible(false);
                this.chonDeThi.setVisible(true);
            }
    }//GEN-LAST:event_btnXoaDeThiActionPerformed

    private void txtNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamHocActionPerformed

    }//GEN-LAST:event_txtNamHocActionPerformed

    private void btnTronCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTronCauHoiActionPerformed
        // TODO add your handling code here:
        this.xaoTronCauHoi(this.deThi.getDsCauHoiTrongDe());
        displayCauHoiTrongDe(tblCauHoiTrongDe, this.deThi.getDsCauHoiTrongDe());
        loadDeThi(deThi);
    }//GEN-LAST:event_btnTronCauHoiActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
        saveToDoc(txtDeThi.getText());
    }//GEN-LAST:event_btnXuatFileActionPerformed

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
            java.util.logging.Logger.getLogger(TaoDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoDeThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLuuDeThi;
    private javax.swing.JButton btnThemCauHoiVaoDe;
    private javax.swing.JButton btnTronCauHoi;
    private javax.swing.JButton btnXoaCauHoiKhoiDe;
    private javax.swing.JButton btnXoaDeThi;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rbCauHoiTL;
    private javax.swing.JRadioButton rbCauHoiTN;
    private javax.swing.JRadioButton rbKy1;
    private javax.swing.JRadioButton rbKy2;
    private javax.swing.JRadioButton rbKyHe;
    private javax.swing.JRadioButton rbTatCaCauHoi;
    private javax.swing.JTable tblCauHoi;
    private javax.swing.JTable tblCauHoiTrongDe;
    private javax.swing.JTextArea txtDeThi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtTenDeThi;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextArea txtThongTinCauHoi;
    // End of variables declaration//GEN-END:variables
}
