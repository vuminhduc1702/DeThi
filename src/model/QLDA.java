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
public class QLDA {
    private ArrayList<DapAn> dsDapAn;

    public QLDA(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    public QLDA() {
        this.dsDapAn = new ArrayList<DapAn>();
    }

    public ArrayList<DapAn> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }
      
    public void insert(DapAn dapAn){
        this.dsDapAn.add(dapAn);       
    }
    
    public void delete(DapAn dapAn){
        this.dsDapAn.remove(dapAn);
    }
    
    public void update(int index, DapAn dapAn){
        this.dsDapAn.remove(index);
        this.dsDapAn.add(index, dapAn);
    }
    
    public void clear(){
        while (!dsDapAn.isEmpty())
            dsDapAn.remove(0);
    }
}
