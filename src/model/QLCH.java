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
public class QLCH {
    private ArrayList<CauHoi> dsCauHoi;

    public QLCH(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public QLCH() {
        this.dsCauHoi = new ArrayList<CauHoi>();
    }
    
    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }
    
    public void insert(CauHoi cauHoi){
        this.dsCauHoi.add(cauHoi);       
    }
    
    public void delete(CauHoi cauHoi){
        this.dsCauHoi.remove(cauHoi);       
    }    
    
    public void update(int index, CauHoi cauHoi){
        this.dsCauHoi.remove(index);
        this.dsCauHoi.add(index, cauHoi);
    }
    
    public CauHoi getCauHoi(int index){
        return dsCauHoi.get(index);
    }
    
    public void clear(){
        while (!dsCauHoi.isEmpty())
            dsCauHoi.remove(0);
    }
}
