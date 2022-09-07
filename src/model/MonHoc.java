/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

import model.CauHoi;

import model.DeThi;


/**
 *
 * @author ADMIN
 */
public class MonHoc {
    private String tenMonHoc;
    private String maMonHoc;
    private int soChuong;
    private String gioiThieu;
    private ArrayList<CauHoi> dsCauHoi;
    private ArrayList<DeThi> dsDeThi;
    
    public MonHoc(){
    };

    public String getTenMonHoc() {
		return tenMonHoc;
	}
    
    public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	
    public String getMaMonHoc() {
		return maMonHoc;
	}
    
    public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	
    public int getSoChuong(){
            return soChuong;
        }
      
    public void setSoChuong(int soChuong){
            this.soChuong = soChuong;
        }
    
    public String getGioiThieu() {
		return gioiThieu;
	}
    
    public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
        }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public ArrayList<DeThi> getDsDeThi() {
        return dsDeThi;
    }

    public void setDsDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }
    
    
    public MonHoc(String tenMonHoc, String maMonHoc, int soChuong, String gioiThieu, ArrayList<CauHoi> dsCauHoi, ArrayList<DeThi> dsDeThi) {
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.soChuong = soChuong;
        this.gioiThieu = gioiThieu;
        this.dsCauHoi = dsCauHoi;
        this.dsDeThi = dsDeThi;
    }
   
    public void themCauHoi(CauHoi cauHoi){
        this.getDsCauHoi().add(cauHoi);
    }
    
    public void xoaCauHoi(CauHoi cauHoi){
        this.getDsCauHoi().remove(cauHoi);
    }
    
    
   }
    

