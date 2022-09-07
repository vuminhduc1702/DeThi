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
public class QuanLyUser {
    private static ArrayList<User> dsUser = new ArrayList<User>();

    public QuanLyUser() {
    }

    public static ArrayList<User> getDsUser() {
        return dsUser;
    }

    public static void setDsUser(ArrayList<User> dsUser) {
        QuanLyUser.dsUser = dsUser;
    }
    
     public static void themUser(User user){
        QuanLyUser.getDsUser().add(user);
    }
    
    public static void xoaUser(int index){
        QuanLyUser.getDsUser().remove(index);
    }
    
    public static void capNhatMonHoc(int index, User user){
        QuanLyUser.xoaUser(index);
        QuanLyUser.getDsUser().add(index, user);
    }
    
    public static User getUser(int index){
        return QuanLyUser.getDsUser().get(index);
    }
    
}
