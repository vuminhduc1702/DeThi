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
public class CauHoiTrongDe{
    private CauHoi cauHoi;
    private float diem;

    public CauHoiTrongDe(CauHoi cauHoi, float diem) {
        this.cauHoi = cauHoi;
        this.diem = diem;
    }

    public CauHoiTrongDe() {
    }   
    
    public CauHoi getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public float chamDiem(CauTraLoi cauTraLoi){
        //boolean lamDungSai = false;
        if (this.cauHoi.getDangCauHoi() == 0){              //nếu là câu trắc nghiệm
            ArrayList<Integer> dapAn = new ArrayList<>();
            for (int i = 0; i < ((CauHoiTN)this.cauHoi).getDsDapAn().size(); i++){    
                if (((CauHoiTN)this.cauHoi).getDsDapAn().get(i).isDungSai() == true){
                    dapAn.add(1);
                } else dapAn.add(0);
            }if (((CauTraLoiTN)cauTraLoi).getDsLuaChon().equals(dapAn)) return this.diem;
            else return 0;
           
        } else if (this.cauHoi.getDangCauHoi() == 1)
            return 0;
        
        return 0;
//duyệt danh sách lựa chọn
//                //if ((((CauHoiTN)this.cauHoi).getDsDapAn().get(i).isDungSai() == true) && (((CauTraLoiTN)cauTraLoi).getDsLuaChon().get(i) == 1)){     //nếu các đáp án ở vị trí đc chọn đúng  
//                    
//                } else {
//                    return 0;
//                }
//            }
//        }return this.diem;
 //  }
}
}
//        } else if (this.cauHoi.getDangCauHoi() == 1){
//            lamDungSai = false;
//        }
//        if (lamDungSai == true) return this.diem;
//        else return 0;
//    }
    
    



    
    

