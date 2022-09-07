
import static java.time.Clock.system;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.CauHoi;
import model.CauHoiTL;
import model.CauHoiTN;
import model.DapAn;
import model.DeThi;
import model.MonHoc;
import model.QLMH;
import view.ChonMonHoc;
import view.GiaoDienChinh;
import view.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args){
        
         //MH1
        ArrayList<CauHoi> dsCauHoiMH1 = new ArrayList<>();
        ArrayList<DeThi> dsDeThiMH1 = new ArrayList<>();
        MonHoc MH1=new MonHoc("Toán","1111",3,"hay",dsCauHoiMH1,dsDeThiMH1);
        QLMH.themMonHoc(MH1);
        //TN11
        ArrayList<DapAn> dsDapAnTN11 = new ArrayList<>();
        CauHoiTN TN11 = new CauHoiTN("1+1",0,0,1,dsDapAnTN11);
        DapAn DA11a = new DapAn("2",true);
        DapAn DA11b = new DapAn("3",false);
        DapAn DA11c = new DapAn("4",false);
        DapAn DA11d = new DapAn("5",false);
        dsDapAnTN11.add(DA11a);
        dsDapAnTN11.add(DA11b);
        dsDapAnTN11.add(DA11c);
        dsDapAnTN11.add(DA11d);
        dsCauHoiMH1.add(TN11);
        //TN12
        ArrayList<DapAn> dsDapAnTN12 = new ArrayList<>();
        CauHoiTN TN12 = new CauHoiTN("1+2+3",0,0,2,dsDapAnTN12);
        DapAn DA12a = new DapAn("5",false);
        DapAn DA12b = new DapAn("6",true);
        DapAn DA12c = new DapAn("7",false);
        DapAn DA12d = new DapAn("8",false);
        dsDapAnTN12.add(DA12a);
        dsDapAnTN12.add(DA12b);
        dsDapAnTN12.add(DA12c);
        dsDapAnTN12.add(DA12d);
        dsCauHoiMH1.add(TN12);
        //TN13
        ArrayList<DapAn> dsDapAnTN13 = new ArrayList<>();
        CauHoiTN TN13 = new CauHoiTN("130320368/19244",0,2,3,dsDapAnTN13);
        DapAn DA13a = new DapAn("7762",false);
        DapAn DA13b = new DapAn("6772",true);
        DapAn DA13c = new DapAn("2677",false);
        DapAn DA13d = new DapAn("2766",false);
        dsDapAnTN13.add(DA13a);
        dsDapAnTN13.add(DA13b);
        dsDapAnTN13.add(DA13c);
        dsDapAnTN13.add(DA13d);
        dsCauHoiMH1.add(TN13);
        //TN14
        ArrayList<DapAn> dsDapAnTN14 = new ArrayList<>();
        CauHoiTN TN14 = new CauHoiTN("5^6",0,1,1,dsDapAnTN14);
        DapAn DA14a = new DapAn("125",false);
        DapAn DA14b = new DapAn("625",false);
        DapAn DA14c = new DapAn("3125",false);
        DapAn DA14d = new DapAn("15625",true);
        dsDapAnTN14.add(DA14a);
        dsDapAnTN14.add(DA14b);
        dsDapAnTN14.add(DA14c);
        dsDapAnTN14.add(DA14d);
        dsCauHoiMH1.add(TN14);
        //TN15
        ArrayList<DapAn> dsDapAnTN15 = new ArrayList<>();
        CauHoiTN TN15 = new CauHoiTN("2^12",0,1,2,dsDapAnTN15);
        DapAn DA15a = new DapAn("1024",false);
        DapAn DA15b = new DapAn("2048",false);
        DapAn DA15c = new DapAn("4096",true);
        DapAn DA15d = new DapAn("8192",false);
        dsDapAnTN15.add(DA15a);
        dsDapAnTN15.add(DA15b);
        dsDapAnTN15.add(DA15c);
        dsDapAnTN15.add(DA15d);
        dsCauHoiMH1.add(TN15);
        //TN16
        ArrayList<DapAn> dsDapAnTN16 = new ArrayList<>();
        CauHoiTN TN16 = new CauHoiTN("Công thức tính diện tích hình tròn",0,0,3,dsDapAnTN16);
        DapAn DA16a = new DapAn("πr",false);
        DapAn DA16b = new DapAn("dr",false);
        DapAn DA16c = new DapAn("πd^2",false);
        DapAn DA16d = new DapAn("πr^2",true);
        dsDapAnTN16.add(DA16a);
        dsDapAnTN16.add(DA16b);
        dsDapAnTN16.add(DA16c);
        dsDapAnTN16.add(DA16d);
        dsCauHoiMH1.add(TN16);
        //TN17
        ArrayList<DapAn> dsDapAnTN17 = new ArrayList<>();
        CauHoiTN TN17 = new CauHoiTN("454,647,484,950,?",0,2,1,dsDapAnTN17);
        DapAn DA17a = new DapAn("515",true);
        DapAn DA17b = new DapAn("626",false);
        DapAn DA17c = new DapAn("737",false);
        DapAn DA17d = new DapAn("838",false);
        dsDapAnTN17.add(DA17a);
        dsDapAnTN17.add(DA17b);
        dsDapAnTN17.add(DA17c);
        dsDapAnTN17.add(DA17d);
        dsCauHoiMH1.add(TN17);
        //TN18
        ArrayList<DapAn> dsDapAnTN18 = new ArrayList<>();
        CauHoiTN TN18 = new CauHoiTN("6,24,60,120,?",0,1,2,dsDapAnTN18);
        DapAn DA18a = new DapAn("200",false);
        DapAn DA18b = new DapAn("205",false);
        DapAn DA18c = new DapAn("210",true);
        DapAn DA18d = new DapAn("240",false);
        dsDapAnTN18.add(DA18a);
        dsDapAnTN18.add(DA18b);
        dsDapAnTN18.add(DA18c);
        dsDapAnTN18.add(DA18d);
        dsCauHoiMH1.add(TN18);
        //TN19
        ArrayList<DapAn> dsDapAnTN19 = new ArrayList<>();
        CauHoiTN TN19 = new CauHoiTN("111*111",0,0,3,dsDapAnTN19);
        DapAn DA19a = new DapAn("12321",true);
        DapAn DA19b = new DapAn("32123",false);
        DapAn DA19c = new DapAn("23132",false);
        DapAn DA19d = new DapAn("21312",false);
        dsDapAnTN19.add(DA19a);
        dsDapAnTN19.add(DA19b);
        dsDapAnTN19.add(DA19c);
        dsDapAnTN19.add(DA19d);
        dsCauHoiMH1.add(TN19);
        //TN19
        ArrayList<DapAn> dsDapAnTN110 = new ArrayList<>();
        CauHoiTN TN110 = new CauHoiTN("Đạo hàm của tan x là",0,0,1,dsDapAnTN110);
        DapAn DA110a = new DapAn("sec(x)^2",true);
        DapAn DA110b = new DapAn("csc(x)^2",false);
        DapAn DA110c = new DapAn("sin(x)^2",false);
        DapAn DA110d = new DapAn("sin(x)+cos(x)",false);
        dsDapAnTN110.add(DA110a);
        dsDapAnTN110.add(DA110b);
        dsDapAnTN110.add(DA110c);
        dsDapAnTN110.add(DA110d);
        dsCauHoiMH1.add(TN110);
        //TL11
        CauHoiTL TL11 = new CauHoiTL("Tìm x biết x+1=2",1,0,2,"meo");
        dsCauHoiMH1.add(TL11);
        //TL12
        CauHoiTL TL12 = new CauHoiTL("Tìm tất cả các hàm f:R+→R+ sao cho với mọi x∈R+ có đúng 1 giá trị y∈R+ thỏa mãn xf(y)+yf(x)≤2",1,1,3,"meo");
        dsCauHoiMH1.add(TL12);        
        //TL13
        CauHoiTL TL13 = new CauHoiTL("Tìm giá trị nguyên lớn nhất của x biết tồn tại a b c nguyên sao cho a^x+b^x=c^x",1,2,1,"meo");
        dsCauHoiMH1.add(TL13);
        //TL14
        CauHoiTL TL14 = new CauHoiTL("Tìm tất cả bộ số nguyên dương (a,b,p) với p nguyên tố thỏa mãn a^p=b!+p",1,2,2,"meo");
        dsCauHoiMH1.add(TL14);
        //TL15
        CauHoiTL TL15 = new CauHoiTL("Tính nhanh : (129479219+18482811555/5)^2",1,2,3,"meo");
        dsCauHoiMH1.add(TL15); 
        
        //MH2
        ArrayList<CauHoi> dsCauHoiMH2 = new ArrayList<>();
        ArrayList<DeThi> dsDeThiMH2 = new ArrayList<>();
        MonHoc MH2=new MonHoc("tieng anh","1111",3,"hay",dsCauHoiMH2,dsDeThiMH2);
        QLMH.themMonHoc(MH2);
        //TN11
        ArrayList<DapAn> dsDapAnTN21 = new ArrayList<>();
        CauHoiTN TN21 = new CauHoiTN("My mom really loves the ___ handbag I gave her on her birthday",0,0,1,dsDapAnTN21);
        DapAn DA21a = new DapAn("American red big",false);
        DapAn DA21b = new DapAn("red American big",false);
        DapAn DA21c = new DapAn("red big American",false);
        DapAn DA21d = new DapAn("big red American",true);
        dsDapAnTN21.add(DA21a);
        dsDapAnTN21.add(DA21b);
        dsDapAnTN21.add(DA21c);
        dsDapAnTN21.add(DA21d);
        dsCauHoiMH2.add(TN21);
        //TN12
        ArrayList<DapAn> dsDapAnTN22 = new ArrayList<>();
        CauHoiTN TN22 = new CauHoiTN("Chọn từ phát âm khác loại :",0,0,3,dsDapAnTN22);
        DapAn DA22a = new DapAn("<html></u>occur<u>ed</html>",false);
        DapAn DA22b = new DapAn("<html></u>play<u>ed</html>",false);
        DapAn DA22c = new DapAn("<html></u>point<u>ed</html>",true);
        DapAn DA22d = new DapAn("<html></u>cycl<u>ed</html>",false);
        dsDapAnTN22.add(DA22a);
        dsDapAnTN22.add(DA22b);
        dsDapAnTN22.add(DA22c);
        dsDapAnTN22.add(DA22d);
        dsCauHoiMH2.add(TN22);
        //TN13
        ArrayList<DapAn> dsDapAnTN23 = new ArrayList<>();
        CauHoiTN TN23 = new CauHoiTN("He lives in a small house ___ the city",0,2,2,dsDapAnTN23);
        DapAn DA23a = new DapAn("on",false);
        DapAn DA23b = new DapAn("from",false);
        DapAn DA23c = new DapAn("in",true);
        DapAn DA23d = new DapAn("at",false);
        dsDapAnTN23.add(DA23a);
        dsDapAnTN23.add(DA23b);
        dsDapAnTN23.add(DA23c);
        dsDapAnTN23.add(DA23d);
        dsCauHoiMH2.add(TN23);
        //TN14
        ArrayList<DapAn> dsDapAnTN24 = new ArrayList<>();
        CauHoiTN TN24 = new CauHoiTN("Chọn từ trái nghĩa: If you want to be a famous music composer, you need to have talent and determination",0,1,1,dsDapAnTN24);
        DapAn DA24a = new DapAn("well-known",false);
        DapAn DA24b = new DapAn("public",false);
        DapAn DA24c = new DapAn("outstanding",false);
        DapAn DA24d = new DapAn("unknown",true);
        dsDapAnTN24.add(DA24a);
        dsDapAnTN24.add(DA24b);
        dsDapAnTN24.add(DA24c);
        dsDapAnTN24.add(DA24d);
        dsCauHoiMH2.add(TN24);
        //TN15
        ArrayList<DapAn> dsDapAnTN25 = new ArrayList<>();
        CauHoiTN TN25 = new CauHoiTN("Chọn từ có trọng âm khác với từ còn lại",0,1,2,dsDapAnTN25);
        DapAn DA25a = new DapAn("student",false);
        DapAn DA25b = new DapAn("worker",false);
        DapAn DA25c = new DapAn("hotel",false);
        DapAn DA25d = new DapAn("village",true);
        dsDapAnTN25.add(DA25a);
        dsDapAnTN25.add(DA25b);
        dsDapAnTN25.add(DA25c);
        dsDapAnTN25.add(DA25d);
        dsCauHoiMH2.add(TN25);
        //TN16
        ArrayList<DapAn> dsDapAnTN26 = new ArrayList<>();
        CauHoiTN TN26 = new CauHoiTN("Chọn từ có trọng âm khác với từ còn lại",0,0,1,dsDapAnTN26);
        DapAn DA26a = new DapAn("equipment",true);
        DapAn DA26b = new DapAn("customer",false);
        DapAn DA26c = new DapAn("relative",false);
        DapAn DA26d = new DapAn("document",false);
        dsDapAnTN26.add(DA26a);
        dsDapAnTN26.add(DA26b);
        dsDapAnTN26.add(DA26c);
        dsDapAnTN26.add(DA26d);
        dsCauHoiMH2.add(TN26);
        //TN17
        ArrayList<DapAn> dsDapAnTN27 = new ArrayList<>();
        CauHoiTN TN27 = new CauHoiTN("The little boy pleaded _____ his mother not to leave him alone in the dark.",0,2,3,dsDapAnTN27);
        DapAn DA27a = new DapAn("on",false);
        DapAn DA27b = new DapAn("with",true);
        DapAn DA27c = new DapAn("///",false);
        DapAn DA27d = new DapAn("at",false);
        dsDapAnTN27.add(DA27a);
        dsDapAnTN27.add(DA27b);
        dsDapAnTN27.add(DA27c);
        dsDapAnTN27.add(DA27d);
        dsCauHoiMH2.add(TN27);
        //TN18
        ArrayList<DapAn> dsDapAnTN28 = new ArrayList<>();
        CauHoiTN TN28 = new CauHoiTN(" _____, the people who come to this club are in their twenties and thirties",0,1,1,dsDapAnTN28);
        DapAn DA28a = new DapAn("Altogether",false);
        DapAn DA28b = new DapAn("To a degree",false);
        DapAn DA28c = new DapAn("By and large",true);
        DapAn DA28d = new DapAn("Virtually",false);
        dsDapAnTN28.add(DA28a);
        dsDapAnTN28.add(DA28b);
        dsDapAnTN28.add(DA28c);
        dsDapAnTN28.add(DA28d);
        dsCauHoiMH2.add(TN28);
        //TN19
        ArrayList<DapAn> dsDapAnTN29 = new ArrayList<>();
        CauHoiTN TN29 = new CauHoiTN("Tìm lỗi sai : Developing new technologies are time-consuming and expensive.",0,0,2,dsDapAnTN29);
        DapAn DA29a = new DapAn("developing",false);
        DapAn DA29b = new DapAn("technologies",false);
        DapAn DA29c = new DapAn("are",true);
        DapAn DA29d = new DapAn("time-consuming",false);
        dsDapAnTN29.add(DA29a);
        dsDapAnTN29.add(DA29b);
        dsDapAnTN29.add(DA29c);
        dsDapAnTN29.add(DA29d);
        dsCauHoiMH2.add(TN29);
        //TN19
        ArrayList<DapAn> dsDapAnTN210 = new ArrayList<>();
        CauHoiTN TN210 = new CauHoiTN("A novel is a story long enough to fill a complete book, in that the characters and events are usually imaginary.",0,1,3,dsDapAnTN210);
        DapAn DA210a = new DapAn("long enough",false);
        DapAn DA210b = new DapAn("complete",false);
        DapAn DA210c = new DapAn("that",true);
        DapAn DA210d = new DapAn("imaginary",false);
        dsDapAnTN210.add(DA210a);
        dsDapAnTN210.add(DA210b);
        dsDapAnTN210.add(DA210c);
        dsDapAnTN210.add(DA210d);
        dsCauHoiMH2.add(TN210);
        //TL11
        CauHoiTL TL21 = new CauHoiTL("Rewrite the following sentences that keep the same meaning : bYou should take the train instead of the bus-> If........",1,0,1,"meo");
        dsCauHoiMH2.add(TL21);
        //TL12
        CauHoiTL TL22 = new CauHoiTL("Introduce yourself",1,1,3,"meo");
        dsCauHoiMH2.add(TL22);        
        //TL13
        CauHoiTL TL23 = new CauHoiTL("Advantage of doing exercise regularly",1,2,2,"meo");
        dsCauHoiMH2.add(TL23);
        //TL14
        CauHoiTL TL24 = new CauHoiTL("Write about your best friend",1,2,1,"meo");
        dsCauHoiMH2.add(TL24);
        //TL15
        CauHoiTL TL25 = new CauHoiTL("Write about your favourite pet",1,2,2,"meo");
        dsCauHoiMH2.add(TL25); 
    

    
        
        Login login = new Login();
        login.setVisible(true);
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
