/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class DeThi {
    private String tenDeThi;
    private int kyHoc;
    private String namHoc;
    private int thoiGian;
    private ArrayList<CauHoiTrongDe> dsCauHoiTrongDe;

    public DeThi(String tenDeThi, int kyHoc, String namHoc, int thoiGian, ArrayList<CauHoiTrongDe> dsCauHoiTrongDe) {
        this.tenDeThi = tenDeThi;
        this.kyHoc = kyHoc;
        this.namHoc = namHoc;
        this.thoiGian = thoiGian;
        this.dsCauHoiTrongDe = dsCauHoiTrongDe;
    }

    public DeThi() {
    }
    
    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(int kyHoc) {
        this.kyHoc = kyHoc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public ArrayList<CauHoiTrongDe> getDsCauHoiTrongDe() {
        return dsCauHoiTrongDe;
    }

    public void setDsCauHoiTrongDe(ArrayList<CauHoiTrongDe> dsCauHoiTrongDe) {
        this.dsCauHoiTrongDe = dsCauHoiTrongDe;
    }
}
