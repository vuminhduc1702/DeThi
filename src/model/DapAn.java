/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class DapAn {
    private String dapAn;
    private boolean dungSai;

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public boolean isDungSai() {
        return dungSai;
    }

    public void setDungSai(boolean dungSai) {
        this.dungSai = dungSai;
    }

    public DapAn(String dapAn, boolean dungSai) {
        this.dapAn = dapAn;
        this.dungSai = dungSai;
    }
    
    
    
    
}
