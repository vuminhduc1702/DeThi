 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author ADMIN
 */
public abstract class CauHoi {
    private String cauHoi;
    private int dangCauHoi;
    private int doKho;
    private int chuong;

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public int getDangCauHoi() {
        return dangCauHoi;
    }

    public void setDangCauHoi(int dangCauHoi) {
        this.dangCauHoi = dangCauHoi;
    }

    public int getDoKho() {
        return doKho;
    }

    public void setDoKho(int doKho) {
        this.doKho = doKho;
    }

    public int getChuong() {
        return chuong;
    }

    public void setChuong(int chuong) {
        this.chuong = chuong;
    }

    public CauHoi(String cauHoi, int dangCauHoi, int doKho, int chuong) {
        this.cauHoi = cauHoi;
        this.dangCauHoi = dangCauHoi;
        this.doKho = doKho;
        this.chuong = chuong;
    }

    public CauHoi() {
    }

}
