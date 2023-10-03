package Test;
import congtyBH.CongTyBH;
import nhanvien.NhanVien;
import nhanvien.NhanVienBienChe;
import nhanvien.NhanVienThoiVu;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập số ");
//        String number = sc.nextLine();
//        System.out.println(HelpMethod.checkNumber(number));
//        System.out.println(HelpMethod.checkDateInput(number));
        Date dateNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        String monthYear = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.YEAR);
//        System.out.println(monthYear);
//        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
//        NhanVien nv1 = new NhanVienThoiVu("Nguyen Van A", "0912344444", "A", HelpMethod.stringToDate("12/12/2002"),
//                3);
//        dsnv.add(nv1);
//        for(NhanVien nv: dsnv){
//            System.out.println(nv.getTen());
//        }
//        nv1.setTen("Nguyen Van B");
//        for(NhanVien nv: dsnv){
//            System.out.println(nv.getTen());
//        }
//       CongTyBH ct = new CongTyBH("công ty");
        NhanVien nv = new NhanVienBienChe();
//       nv.nhapTT();
//       nv.nhapLuong("4/2022");
//       nv.inLuong("4/2022");
//        nv.setLuongTungThang("4/2022", 2000);
//        System.out.println(nv.getLuongTungThang());
//        nv.inLuong("4/2022");

//       nv.inTT();
//        System.out.println(nv instanceof NhanVienThoiVu);
//        System.out.println(HelpMethod.checkMonthYearInput("11/2022"));
    }
}