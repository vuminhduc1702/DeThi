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
public class QLMH{
    private static ArrayList<MonHoc> dsMonHoc = new ArrayList<>();

    public QLMH() {
    }

    public static ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public static void setDsMonHoc(ArrayList<MonHoc> dsMonHoc) {
        QLMH.dsMonHoc = dsMonHoc;
    }

    public static void themMonHoc(MonHoc monHoc){
        QLMH.getDsMonHoc().add(monHoc);
    }
    
    public static void xoaMonHoc(int index){
        QLMH.getDsMonHoc().remove(index);
    }
    
    public static void capNhatMonHoc(int index, MonHoc monHoc){
        QLMH.xoaMonHoc(index);
        QLMH.getDsMonHoc().add(index, monHoc);
    }
    
    public static MonHoc getMonHoc(int index){
        return QLMH.getDsMonHoc().get(index);
    }
}
