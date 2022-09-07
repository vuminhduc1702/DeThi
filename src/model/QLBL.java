/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author thanhkali
 */
public class QLBL {

    private static ArrayList<BaiLam> list= new ArrayList<>();

    public QLBL() {
        
    }
    public static ArrayList<BaiLam> getDsBaiLam() {
        return list;
    }

    public static void setDsBaiLam(ArrayList<BaiLam> dsBaiLam) {
        list = dsBaiLam;
    }
    
    public static void insert(BaiLam baiLam){
        list.add(baiLam);       
    }
    
    public static void delete(BaiLam baiLam){
        list.remove(baiLam);       
    }    
    
    public static void update(BaiLam baiLam){
        BaiLam bl= list.get(list.indexOf(baiLam));
        bl.setDiemTL(baiLam.getDiemTL());
    }
    
    public static BaiLam getCauHoi(int index){
        return list.get(index);
    }
    
    public static void clear(){
        while (!list.isEmpty())
            list.clear();
    }

}
