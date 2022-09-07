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
public class QLDeThi {
    private ArrayList<DeThi> dsDeThi;

    public QLDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }
    
    public QLDeThi() {
        this.dsDeThi = new ArrayList<DeThi>();
    }

    public ArrayList<DeThi> getDsDeThi() {
        return dsDeThi;
    }

    public void setDsDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }
    
    public void insert(DeThi deThi){
        this.dsDeThi.add(deThi);       
    }
    
    public void delete(DeThi deThi){
        this.dsDeThi.remove(deThi);
    }
    
    public void update(int index, DeThi deThi){
        this.dsDeThi.remove(index);
        this.dsDeThi.add(index, deThi);
    }
}
