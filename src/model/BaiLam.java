/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BaiLam {
    private ArrayList<CauTraLoiTL> dsCauTraLoi;
    private float diemTN;
    private float diemTL=-1;
    private DeThi deThi;
    private User user;

    public BaiLam(ArrayList<CauTraLoiTL> dsCauTraLoi, float diem) {
        this.dsCauTraLoi = dsCauTraLoi;
        this.diemTN = diem;
    }

    public BaiLam(ArrayList<CauTraLoiTL> dsCauTraLoi, float diemTN, DeThi deThi, User user) {
        this.dsCauTraLoi = dsCauTraLoi;
        this.diemTN = diemTN;
        this.deThi = deThi;
        this.user = user;
    }

    public DeThi getDeThi() {
        return deThi;
    }

    public void setDeThi(DeThi deThi) {
        this.deThi = deThi;
    }
    
    public BaiLam(ArrayList<CauTraLoiTL> dsCauTraLoi, float diemTN, float diemTL) {
        this.dsCauTraLoi = dsCauTraLoi;
        this.diemTN = diemTN;
        this.diemTL = diemTL;
    }

    public BaiLam(ArrayList<CauTraLoiTL> dsCauTraLoi) {
        this.dsCauTraLoi = dsCauTraLoi;
    }

    public BaiLam() {
    }

    public float getDiemTN() {
        return diemTN;
    }

    public void setDiemTN(float diemTN) {
        this.diemTN = diemTN;
    }

    public float getDiemTL() {
        return diemTL;
    }

    public void setDiemTL(float diemTL) {
        this.diemTL = diemTL;
    }

    public ArrayList<CauTraLoiTL> getDsCauTraLoi() {
        return dsCauTraLoi;
    }

    public void setDsCauTraLoi(ArrayList<CauTraLoiTL> dsCauTraLoi) {
        this.dsCauTraLoi = dsCauTraLoi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
