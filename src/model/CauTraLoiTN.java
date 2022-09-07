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
public class CauTraLoiTN extends CauTraLoi {
    private ArrayList<Integer> dsLuaChon;

    public CauTraLoiTN(ArrayList<Integer> dsLuaChon) {
        this.dsLuaChon = dsLuaChon;
    }

    public CauTraLoiTN() {
    }
    
    

    public ArrayList<Integer> getDsLuaChon() {
        return dsLuaChon;
    }

    public void setDsLuaChon(ArrayList<Integer> dsLuaChon) {
        this.dsLuaChon = dsLuaChon;
    }
    
    
}
