/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class CauHoiTL extends CauHoi {
    private String goiY;

    public String getGoiY() {
        return goiY;
    }

    public void setGoiY(String goiY) {
        this.goiY = goiY;
    }

    public CauHoiTL(String cauHoi, int dangCauHoi, int doKho, int chuong, String goiY) {
        super(cauHoi, dangCauHoi, doKho, chuong);
        this.goiY = goiY;
    }

    public CauHoiTL() {
    }    

    
}
