/*
 * Method sua(), inDS(): Nguyen Thi Van Anh 20200035
 * Other things: Le Pham Thuy Tien 20207633
 */
package congtyBH;

import nhanvien.NhanVien;
import nhanvien.NhanVienBienChe;
import nhanvien.NhanVienThoiVu;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CongTyBH {
    private PhongQuanLy pql;
    private PhongTaiChinh ptc;
    private String tenCongTy;

    public CongTyBH(String tenCongTy) {
        this.pql = new PhongQuanLy();
        this.ptc = new PhongTaiChinh();
        this.tenCongTy = tenCongTy;
    }

    // them nhan vien
    public void themNV() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon loai nhan vien ban muon them");
        System.out.println("1. Nhan vien bien che");
        System.out.println("2. Nhan vien thoi vu");
        System.out.println("Lua chon cua ban: ");
        String choiceStr = sc.nextLine();
        if(HelpMethod.checkNumber(choiceStr)){
            int choice = Integer.parseInt(choiceStr);
            switch (choice) {
                case 1:
                    // upcasting
                    NhanVien nv = new NhanVienBienChe();
                    nv.nhapTT();
                    pql.themNV(nv);
                    nv.inTT();
                    break;
                case 2:
                    // up casting
                    NhanVien nvien = new NhanVienThoiVu();
                    // down casting
                    NhanVienThoiVu nvtv = (NhanVienThoiVu) nvien;
                    nvtv.nhapTT();
                    pql.themNV(nvtv);
                    nvtv.inTTin();
                    break;
                default:
                    System.out.println("Lua chon cua ban khong hop le");
                    break;
            }
        }else{
            System.out.println("[Error]: Nhap thong tin khong hop le!");
        }


    }
    // xóa nhân viên
    public void xoaNV(){
        if(pql.getDsNV().size()!=0){
            pql.inDS();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap lua chon thong tin can xoa: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                pql.xoaNV(pql.getDsNV().get(choice-1));
                System.out.println("[Info]: Xoa nhan vien thanh cong");
            }catch (Exception e){
                System.out.println(e);
                System.out.println("[Error]: Nhap thong tin khong hop le");
                System.out.println("Xoa khong thanh cong");
            }
        }else{
            System.out.println("Chua ton tai du lieu. Vui long them nhan vien vao dach sach truoc");
        }

    }

    // sua nhan vien
    public void suaNV(){
        if(pql.getDsNV().size()!=0){
            pql.inDS();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap lua chon thong tin can sua: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                pql.suaNV(pql.getDsNV().get(choice-1));
                System.out.println("[Info]: Sua nhan vien thanh cong");
            }catch (Exception e){
                System.out.println(e);
                System.out.println("[Error]: Nhap thong tin khong hop le");
                System.out.println("Sua khong thanh cong");
            }
        }else{
            System.out.println("Chua ton tai du lieu. Vui long them nhan vien vao dach sach truoc");
        }
    }
    // tìm kiếm
    public void timKiem() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap lua chon" + "\n" +
                "1. Tim kiem theo ten" + "\n"+
                "2. Tim kiem theo so CMT"+ "\n"+
                "3. Tim kiem theo ngay");
        System.out.println("Lua chon cua ban: ");
        String choice_str = sc.nextLine();
        if(HelpMethod.checkNumber(choice_str)){
            int choice = Integer.parseInt(choice_str);
            String keywords;
            switch(choice){
                case 1 :
                    System.out.println("Nhap tu khoa ten nhan vien ban muon tim kiem");
                    keywords = sc.nextLine();
                    ArrayList <NhanVien> result1 = pql.timKiem(keywords);
                    if(result1.size() == 0) System.out.println("Khong tim thay du lieu");
                    else {
                        for(NhanVien nv: result1){
                            nv.inTT();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhap CMT ban muon tim kiem");
                    keywords = sc.nextLine();
                    ArrayList<NhanVien> result2 = pql.timKiemCMT(keywords);
                    if(result2.size() == 0) System.out.println("Khong tim thay du lieu");
                    else {
                        for(NhanVien nv: result2){
                            nv.inTT();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhap ngay thang nam ban muon tim kiem");
                    keywords = sc.nextLine();
                    if(HelpMethod.checkDateInput(keywords)){
                        Date date = HelpMethod.stringToDate(keywords);
                        ArrayList<NhanVien> result3 = pql.timKiem(date);
                        if(result3.size()==0) System.out.println("Khong tim thay du lieu");
                        else{
                            for(NhanVien nv: result3){
                                nv.inTT();
                            }
                        }
                    }else{
                        System.out.println("[Error]: Nhap thong tin khong hop le");
                    }
                    break;
                default:
                    System.out.println("[Error]: Lua chon khong hop le !");
                    break;

            }

        }else{
            System.out.println("[Error]: Nhap thong tin khong hop le");
        }
    }


    // tính lương TB tại thời điểm hiện tại
    public void tinhLuongTB(){
        double luongTB = ptc.tinhLuongTB(pql.getDsNV());
        if(luongTB==0){
            System.out.println("Chua co thong tin ve gio lam them va so hop dong thang nay");
            System.out.println("Vui long nhap day du cac thong tin tren");
        }else{
            System.out.println("Luong TB cua tat ca cac nhan vien thoi diem hien tai : " + HelpMethod.formatNumber(luongTB));
        }
    }

    // nhập lương của nhân viên theo tháng
    public void nhapLuongHangThang(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap MM/YYYY ma ban muon nhap luong");
        String monthYear = sc.nextLine();
        if(HelpMethod.checkMonthYearInput(monthYear)){
            ptc.nhapLuongTheoThang(monthYear, pql.getDsNV());
        }else{
            System.out.println("[Error]: Nhap thong tin khong hop le. Vui long nhap thong tin dung dinh dang");
        }
    }

    // thống kê luong tại một thời điểm bất kì
    public void thongKeLuong(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap MM/YYYY ma ban muon nhap luong");
        String monthYear = sc.nextLine();
        if(HelpMethod.checkMonthYearInput(monthYear)){
            ptc.inLuongTheoThang(monthYear, pql.getDsNV());
        }else{
            System.out.println("[Error]: Nhap thong tin khong hop le");
        }

    }
    // in danh sach
    public void inDS(){
        pql.inDS();
    }
    public void inTT(){
        System.out.println("Ten cong ty: " + getTenCongTy());
        System.out.println("Tong so nhan vien: " + pql.getSoNV());
    }
    public String getTenCongTy() {
        return tenCongTy;
    }
}