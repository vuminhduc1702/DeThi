package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CauHoi;
import model.CauHoiTL;
import model.CauHoiTN;
import model.DapAn;
import model.MonHoc;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.CauHoiTrongDe;
import model.DeThi;
import model.QLMH;

public class SinhDeTuDong extends JFrame {

    private JPanel contentPane;

    private JPanel panel;
    private JTable table;
    private JTextField txt_tendethi;
    private JTextField txt_namhoc;
    private JScrollPane scrollPane_dethi;
    private JPanel cauhoi_dethi;
    private ChonCachTaoDeThi chonCachTaoDeThi;

    private Box box_dethi;
    DefaultTableModel model;

    private ArrayList<CauHoiTrongDe> listCauHoi = new ArrayList<CauHoiTrongDe>();
    private JTextField txt_thoigian;

    private int dangDe = -1;

    private int idCauHoiCanXoa = -1;

    private List<JSpinner> listJSpinners = new ArrayList<JSpinner>();

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    SinhDeTuDong frame = new SinhDeTuDong();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public SinhDeTuDong(ChonCachTaoDeThi chonCachTaoDeThi) {
        this.chonCachTaoDeThi = chonCachTaoDeThi;  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 740, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lb_ddt = new JLabel("Dạng đề thi");
        lb_ddt.setBounds(10, 32, 125, 14);
        contentPane.add(lb_ddt);

        JRadioButton radio_tuluan = new JRadioButton("Tự luận");
        radio_tuluan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dangDe = 1;
            }
        });
        radio_tuluan.setBounds(74, 28, 76, 23);
        contentPane.add(radio_tuluan);

        JRadioButton radio_tracnghiem = new JRadioButton("Trắc nghiệm");
        radio_tracnghiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dangDe = 2;
            }
        });
        radio_tracnghiem.setBounds(152, 28, 97, 23);
        contentPane.add(radio_tracnghiem);

        JRadioButton radio_all = new JRadioButton("Cả trắc nghiệm và tự luận");
        radio_all.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dangDe = 3;
            }
        });
        radio_all.setBounds(251, 28, 230, 23);
        contentPane.add(radio_all);

        JLabel lblSCu = new JLabel("Số câu");
        lblSCu.setBounds(10, 69, 46, 14);
        contentPane.add(lblSCu);

        JLabel lblKh = new JLabel("Độ  khó");
        lblKh.setBounds(10, 105, 46, 14);
        contentPane.add(lblKh);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Bất kỳ", "Dễ", "Trung Bình", "Khó"}));
        comboBox.setBounds(64, 102, 86, 20);
        contentPane.add(comboBox);

        JLabel lblSLngCu = new JLabel("Số lượng câu mỗi chương");
        lblSLngCu.setBounds(278, 69, 180, 14);
        contentPane.add(lblSLngCu);

        JCheckBox check_soCauHoiMoiChuong = new JCheckBox("");
        check_soCauHoiMoiChuong.setSelected(true);
        check_soCauHoiMoiChuong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (check_soCauHoiMoiChuong.isSelected()) {
                    listJSpinners.clear();
                    setGiaTriBangChuong();
                    panel.setVisible(false);
                    panel.setVisible(true);
                } else {
                    listJSpinners.clear();
                    panel.removeAll();
                    panel.setVisible(false);
                    panel.setVisible(true);
                }
            }
        });
        check_soCauHoiMoiChuong.setBounds(251, 63, 35, 23);
        contentPane.add(check_soCauHoiMoiChuong);

        JSpinner txt_socau = new JSpinner();
        txt_socau.setBounds(66, 66, 76, 25);
        contentPane.add(txt_socau);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(464, 69, 203, 124);
        contentPane.add(scrollPane);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        scrollPane.setViewportView(panel);
        panel.setLayout(null);

        scrollPane_dethi = new JScrollPane();
        scrollPane_dethi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_dethi.setBounds(347, 232, 367, 231);
        contentPane.add(scrollPane_dethi);

        JLabel lblDanhSchCu = new JLabel("Danh sách câu hỏi trong đề");
        lblDanhSchCu.setBounds(10, 215, 195, 23);
        contentPane.add(lblDanhSchCu);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 236, 266, 144);
        contentPane.add(scrollPane_2);

        table = new JTable();
        scrollPane_2.setViewportView(table);

        JLabel lblXaCuHi = new JLabel("Xóa câu hỏi ra khỏi đề thi");
        lblXaCuHi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (idCauHoiCanXoa != -1) {
                    listCauHoi.remove(idCauHoiCanXoa);
                    idCauHoiCanXoa = -1;
                    xoaBang();
                    khoiTaoBang();
                } else {
                    Message.getMessage("Hãy chọn 1 câu hỏi cần xóa");
                }
            }
        });
        lblXaCuHi.setVerticalAlignment(SwingConstants.BOTTOM);
        lblXaCuHi.setBounds(148, 381, 158, 14);
        contentPane.add(lblXaCuHi);

        JLabel lblTnThi = new JLabel("Tên đề thi");
        lblTnThi.setBounds(10, 409, 97, 14);
        contentPane.add(lblTnThi);

        txt_tendethi = new JTextField();
        txt_tendethi.setBounds(74, 406, 203, 20);
        contentPane.add(txt_tendethi);
        txt_tendethi.setColumns(10);

        JLabel lblNmHc = new JLabel("Năm học");
        lblNmHc.setBounds(10, 437, 97, 14);
        contentPane.add(lblNmHc);

        txt_namhoc = new JTextField();
        txt_namhoc.setColumns(10);
        txt_namhoc.setBounds(74, 434, 203, 20);
        contentPane.add(txt_namhoc);

        JLabel lblHcK = new JLabel("Học kỳ");
        lblHcK.setBounds(10, 465, 97, 14);
        contentPane.add(lblHcK);

        JComboBox txt_hocki = new JComboBox();
        txt_hocki.setModel(new DefaultComboBoxModel(new String[]{"Kỳ 1", "Kỳ 2", "Kỳ hè"}));
        txt_hocki.setBounds(74, 465, 203, 20);
        contentPane.add(txt_hocki);

        JButton btnLuThi = new JButton("Lưu đề thi");
        btnLuThi.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                DeThi dethi = new DeThi();
                dethi.setTenDeThi(txt_tendethi.getText());
                dethi.setNamHoc(txt_namhoc.getText());
                dethi.setKyHoc(txt_hocki.getSelectedIndex());
                dethi.setDsCauHoiTrongDe(listCauHoi);
                dethi.setThoiGian(Integer.valueOf(txt_thoigian.getText()));
                //MonHocDao.monHocDuocChon.getDsDeThi().add(dethi);
                QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().add(dethi);
                setDethi(dethi);                
//                QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi().add(dethi);
                
            }
        });
        btnLuThi.setForeground(Color.WHITE);
        btnLuThi.setBackground(Color.GREEN);
        btnLuThi.setBounds(183, 513, 149, 23);
        contentPane.add(btnLuThi);

        JButton btnThot = new JButton("Thoát");
        btnThot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                chonCachTaoDeThi.chonDeThi.loadDsDeThi(QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsDeThi());
                chonCachTaoDeThi.chonDeThi.setVisible(true);
            }
        });
        btnThot.setBounds(339, 513, 142, 23);
        contentPane.add(btnThot);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio_tracnghiem);
        bg.add(radio_all);
        bg.add(radio_tuluan);

        model = new DefaultTableModel();
        Object[] column = {"STT", "Câu hỏi", "Loại câu hỏi"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel lblThiGian = new JLabel("Thời gian");
        lblThiGian.setBounds(10, 495, 97, 14);
        contentPane.add(lblThiGian);

        txt_thoigian = new JTextField();
        txt_thoigian.setBounds(74, 492, 57, 20);
        contentPane.add(txt_thoigian);
        txt_thoigian.setColumns(10);

        cauhoi_dethi = new JPanel();
        scrollPane_dethi.setViewportView(cauhoi_dethi);
        cauhoi_dethi.setMinimumSize(new Dimension(500, 500));
        cauhoi_dethi.setPreferredSize(new Dimension(700, 1200));
        cauhoi_dethi.setLayout(null);
        box_dethi = Box.createVerticalBox();
        box_dethi.setBounds(3, 0, 700, 20);
        cauhoi_dethi.add(box_dethi);

        setGiaTriBangChuong();

        /* tao de danh sach cau hoi tu dong */
        JButton btnToThi = new JButton("Tạo đề thi");
        btnToThi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int soCau = Integer.valueOf(txt_socau.getValue().toString());
                String doKho = comboBox.getSelectedItem().toString();
                List<Integer> soCauHoiMoiChuong = new ArrayList<Integer>();
                listJSpinners.forEach(p -> {
                    soCauHoiMoiChuong.add(Integer.valueOf(p.getValue().toString()));
                });

                taoCauHoiTuDong(soCau, doKho, soCauHoiMoiChuong);
            }
        });
        btnToThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnToThi.setBounds(251, 155, 205, 38);
        contentPane.add(btnToThi);

        JLabel lblCuHiTng = new JLabel("Câu hỏi tương đương");
        lblCuHiTng.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CauHoiTrongDe cauHoiCanDoi = listCauHoi.get(idCauHoiCanXoa);
                List<CauHoi> list = QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsCauHoi();
                CauHoi cauHoiSauKhiDoi = null;
                if (cauHoiCanDoi.getCauHoi() instanceof CauHoiTN) {
                    while (cauHoiSauKhiDoi == null) {
                        int viTri = (int) (Math.random() * list.size());
                        if (list.get(viTri) instanceof CauHoiTN
                                && kiemTraCauHoiTonTai(listCauHoi, list.get(viTri)) == false) {
                            if (list.get(viTri).getDoKho() == cauHoiCanDoi.getCauHoi().getDoKho()) {
                                cauHoiSauKhiDoi = list.get(viTri);
                            }
                        }
                    }
                }
                if (cauHoiCanDoi.getCauHoi() instanceof CauHoiTL) {
                    while (cauHoiSauKhiDoi == null) {
                        int viTri = (int) (Math.random() * list.size());
                        if (list.get(viTri) instanceof CauHoiTL) {
                            if (list.get(viTri).getDoKho() == cauHoiCanDoi.getCauHoi().getDoKho()) {
                                cauHoiSauKhiDoi = list.get(viTri);
                            }
                        }
                    }
                }
                if (cauHoiSauKhiDoi != null) {
                    listCauHoi.remove(idCauHoiCanXoa);
                    listCauHoi.add(new CauHoiTrongDe(cauHoiSauKhiDoi, 5));
                    xoaBang();
                    khoiTaoBang();
                }
            }
        });
        lblCuHiTng.setBounds(10, 381, 125, 14);
        contentPane.add(lblCuHiTng);
        clickBang();
    }

    public void khoiTaoBang() {
        int i = 0;
        for (CauHoiTrongDe p : listCauHoi) {
            String loaiCauHoi = "";
            if (p.getCauHoi() instanceof CauHoiTN) {
                loaiCauHoi = "câu hỏi TN";
            } else {
                loaiCauHoi = "câu hỏi TL";
            }
            model.addRow(new Object[]{i++, p.getCauHoi().getCauHoi(), loaiCauHoi});
        }
    }

    public void xoaBang() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public boolean kiemTraCauHoiTonTai(List<CauHoiTrongDe> list, CauHoi cauHoi) {
        for (CauHoiTrongDe c : list) {
            if (c.getCauHoi().getCauHoi().equalsIgnoreCase(cauHoi.getCauHoi())) {
                return true;
            }
        }
        return false;
    }

    public void clickBang() {
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    table.setSelectionBackground(Color.YELLOW);
                    idCauHoiCanXoa = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
                }
            }
        });
    }

    public void setGiaTriBangChuong() {
        MonHoc monhoc = QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex());
        int y = 8;
        for (int i = 0; i < monhoc.getSoChuong(); i++) {
            JLabel lblNewLabel = new JLabel("chương " + (i + 1));
            lblNewLabel.setBounds(10, y, 71, 14);
            panel.add(lblNewLabel);

            JSpinner spinner_1 = new JSpinner();
            spinner_1.setBounds(91, y, 58, 20);
            panel.add(spinner_1);
            listJSpinners.add(spinner_1);
            y = y + 25;
        }
    }

    public void setDethi(DeThi dethi) {
        box_dethi.removeAll();
        box_dethi.setBounds(3, 0, 700, 20);
        Label lb_tende = new Label(dethi.getTenDeThi());
        Label lb_namhoc = new Label(dethi.getKyHoc() + "- " + dethi.getNamHoc());
        Label lb_thoigian = new Label("Thời gian: " + dethi.getThoiGian() + " phút");
        box_dethi.add(lb_tende);
        box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
        box_dethi.add(lb_namhoc);
        box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
        box_dethi.add(lb_thoigian);
        box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);

        int i = 0;
        for (CauHoiTrongDe p : dethi.getDsCauHoiTrongDe()) {
            ++i;
            Label ten_cauhoi = new Label("câu: " + i + " (" + p.getDiem() + " điểm)");
            Label cauhoi = new Label(p.getCauHoi().getCauHoi());
            box_dethi.add(ten_cauhoi);
            box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
            box_dethi.add(cauhoi);
            box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);

            if (p.getCauHoi() instanceof CauHoiTL) {
                Label lb_goiY = new Label("Gợi ý: " + ((CauHoiTL) p.getCauHoi()).getGoiY());
                box_dethi.add(lb_goiY);
                box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
            } else if (p.getCauHoi() instanceof CauHoiTN) {
                String dapan = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                int j = 0;
                for (DapAn d : ((CauHoiTN) p.getCauHoi()).getDsDapAn()) {
                    Label label = new Label(dapan.charAt(j) + ". " + d.getDapAn());
                    box_dethi.add(label);
                    box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
                    ++j;
                }
            }

            box_dethi.setBounds(3, 0, 700, box_dethi.getHeight() + 22);
        }

        box_dethi.setVisible(false);
        box_dethi.setVisible(true);
    }

    public void taoCauHoiTuDong(int soCau, String doKho, List<Integer> soCauHoiMoiChuong) {
        Set<CauHoi> dsCauHoi = new HashSet<CauHoi>();
        List<CauHoi> listCH = QLMH.getMonHoc(chonCachTaoDeThi.chonDeThi.chonMonHoc.getCbbDsMonHoc().getSelectedIndex()).getDsCauHoi();
        System.out.println("hhhh: " + soCauHoiMoiChuong);
        /* cau hoi tu luan */
        if (dangDe == 1) {
            List<CauHoi> list = new ArrayList<CauHoi>();
            for (CauHoi c : listCH) {
                if (c instanceof CauHoiTL) {
                    list.add(c);
                }
            }
            if (list.size() < soCau) {
                Message.getMessage("Không đủ câu hỏi tự luận");
            } /* thuat toan dua cau hoi vao trong de tu luan */ else {
                int maxViTri = list.size();
                while (dsCauHoi.size() < soCau) {
                    int viTri = (int) (Math.random() * maxViTri);
                    if (soCauHoiMoiChuong.size() == 5) {
                        dsCauHoi.add(list.get(viTri));
                    } else {
                        int chuong = list.get(viTri).getChuong();
                        if (kiemTraSoChuongMoiCau(chuong, soCauHoiMoiChuong, dsCauHoi) == false) {
                            dsCauHoi.add(list.get(viTri));
                        }

                    }
                }
            }
        } /* cau hoi trac nghiem */ else if (dangDe == 2) {
            List<CauHoi> list = new ArrayList<CauHoi>();
            for (CauHoi c : listCH) {
                if (c instanceof CauHoiTN) {
                    list.add(c);
                }
            }
            if (list.size() < soCau) {
                Message.getMessage("Không đủ câu hỏi trắc nghiệm");
            } /* thuat toan dua cau hoi vao trong de trac nghiem */ else {
                int maxViTri = list.size();
                while (dsCauHoi.size() < soCau) {
                    int viTri = (int) (Math.random() * maxViTri);
                    if (soCauHoiMoiChuong.size() == 0) {
                        dsCauHoi.add(list.get(viTri));
                    } else {
                        int chuong = list.get(viTri).getChuong();
                        if (kiemTraSoChuongMoiCau(chuong, soCauHoiMoiChuong, dsCauHoi) == false) {
                            dsCauHoi.add(list.get(viTri));
                        }
                    }
                }
            }
        } /* cau hoi tu luan va trac nghiem */ else if (dangDe == 3) {
            int count = listCH.size();
            if (count < soCau) {
                Message.getMessage("Không đủ câu hỏi");
            } /* thuat toan dua cau hoi vao trong de tong hop */ else {
                int maxViTri = listCH.size();
                while (dsCauHoi.size() < soCau) {
                    int viTri = (int) (Math.random() * maxViTri);
                    if (soCauHoiMoiChuong.size() == 0) {
                        dsCauHoi.add(listCH.get(viTri));
                    } else {
                        int chuong = listCH.get(viTri).getChuong();
                        if (kiemTraSoChuongMoiCau(chuong, soCauHoiMoiChuong, dsCauHoi) == false) {
                            dsCauHoi.add(listCH.get(viTri));
                        }
                    }
                }
            }
        }

        System.out.println(dsCauHoi);
        this.listCauHoi.clear();
        for (CauHoi cauHoi : dsCauHoi) {
            listCauHoi.add(new CauHoiTrongDe(cauHoi, 5));
        }
//        listCauHoi = new ArrayList<CauHoi>(dsCauHoi);
        xoaBang();
        khoiTaoBang();
    }

    /* chuong 1 o vi tri so 0, chuong 2 vi tri so 1 cua listSoLuongCauMoiChuong */
    public boolean kiemTraSoChuongMoiCau(int chuong, List<Integer> listSoLuongCauMoiChuong, Set<CauHoi> listCauHoi) {
        int soLuongCauTrongChuong = listSoLuongCauMoiChuong.get(chuong - 1);
        int count = 0;
        for (CauHoi c : listCauHoi) {
            if (c.getChuong() == chuong) {
                count = count + 1;
            }
        }

        System.out.println("chuong: " + chuong);
        System.out.println("count: " + count);
        System.out.println("soluongcautrongchuong; " + soLuongCauTrongChuong);
        System.out.println("slmoicautrongchuog: " + listSoLuongCauMoiChuong);
        System.out.println("soluongmoicau trong chuong " + chuong + " la: " + listSoLuongCauMoiChuong.get(chuong - 1));
        if (count == soLuongCauTrongChuong) {
            return true;
        }
        return false;
    }

    public boolean kiemTraTongSoCauHoi(int tongSoCau, List<Integer> listSoLuongCauMoiChuong) {
        int sum = 0;
        for (Integer p : listSoLuongCauMoiChuong) {
            sum += p;
        }
        if (tongSoCau == sum) {
            return true;
        }
        return true;
    }
}
