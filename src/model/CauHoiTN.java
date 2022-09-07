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
public class CauHoiTN extends CauHoi {
    private ArrayList<DapAn> dsDapAn;

    public ArrayList<DapAn> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    public CauHoiTN(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    @Override
    public void setDoKho(int doKho) {
        super.setDoKho(doKho); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getDoKho() {
        return super.getDoKho(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setCauHoi(String cauHoi) {
        super.setCauHoi(cauHoi); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getCauHoi() {
        return super.getCauHoi(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public CauHoiTN() {
    }

    public CauHoiTN(String cauHoi, int dangCauHoi, int doKho, int chuong, ArrayList<DapAn> dsDapAn) {
        super(cauHoi, dangCauHoi, doKho, chuong);
        this.dsDapAn = dsDapAn;
    }



    
    
}
