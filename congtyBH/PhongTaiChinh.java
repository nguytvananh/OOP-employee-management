// Le Pham Thuy Tien 20207633
package congtyBH;

import nhanvien.NhanVien;
import utils.HelpMethod;

import java.util.*;

public class PhongTaiChinh {

    public PhongTaiChinh(){};
    // tinh luong tb tai thoi diem hien tai
    public double tinhLuongTB(ArrayList<NhanVien> dsNV){
        Date dateNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        String monthYear;
        if(cal.get(Calendar.MONTH)+1<11){
            monthYear = "0"+ (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        }else{
            monthYear = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        }


        double sum = 0;
        int count = 0;
        for(NhanVien nv: dsNV){
            if(HelpMethod.compareMonthYear(nv.getTgBatDauLam(), monthYear)){
                sum += nv.getLuong(monthYear);
                count++;
            }
        }
        if(count == 0) return 0;
        else return sum /count;
    }
    // nhap luong theo thang
    public void nhapLuongTheoThang(String monthYear,ArrayList<NhanVien> dsNV){
        for (NhanVien nv : dsNV) {
            if (HelpMethod.compareMonthYear(nv.getTgBatDauLam(), monthYear)) {
                nv.nhapLuong(monthYear);
            }
        }

    }


    // in luong theo tung thang
    public void inLuongTheoThang(String monthYear, ArrayList<NhanVien> dsNV){
        for(NhanVien nv: dsNV){
            if(HelpMethod.compareMonthYear(nv.getTgBatDauLam(), monthYear)){
                nv.inLuong(monthYear);
            }
        }
    }


}