// Nguyen Thi Van Anh 20200035
package nhanvien;

import utils.HelpMethod;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class NhanVienBienChe extends NhanVien {
    private double luongCoBan;
    private double gioLamThem;
    private final double TIEN_LUONG_CB = 2000000;
    private final double TIEN_LUONG_LT = 200000;
    public NhanVienBienChe(){};
    public NhanVienBienChe(String ten, String soCMT, String donvi, Date tgBatDauLam, double luongCoBan) {
        super(ten, soCMT, donvi, tgBatDauLam);
        this.luongCoBan = luongCoBan;
        this.gioLamThem = 0;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * TIEN_LUONG_CB + gioLamThem * TIEN_LUONG_LT;
    }
    public void inTT(){
        super.inTT();
        System.out.println("Loai nhan vien: Nhan vien bien che");
        System.out.println("Luong co ban: " + HelpMethod.formatNumber(luongCoBan));
    }

    public void nhapLuong(String monthYear){
        inTT();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhap so gio lam them: ");
            String soGioLamThem = sc.nextLine();
            if(HelpMethod.checkNumber(soGioLamThem)){
                setGioLamThem(Double.parseDouble(soGioLamThem));
                super.setLuongTungThang(monthYear, tinhLuong());
                System.out.println("------- Ket qua ---------");
                inLuong(monthYear);
                break;
            }else{
                System.out.println("[Error]: Nhap thong tin chua hop le");
            }
        }

    }
    public void nhapTT() throws ParseException {
        super.nhapTT();
        while (true){
            System.out.print("Nhap luong co ban: ");
            Scanner sc = new Scanner(System.in);
            String luongCoBan = sc.nextLine();
            if (HelpMethod.checkNumber(luongCoBan))
            {
                setLuongCoBan(Double.parseDouble(luongCoBan));
                break;
            }
            else {
                System.out.println("[Error]: Nhap luong co ban chua hop le");
            }
        }
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getGioLamThem() {
        return gioLamThem;
    }

    public void setGioLamThem(double gioLamThem) {
        this.gioLamThem = gioLamThem;
    }

    public double getTIEN_LUONG_CB() {
        return TIEN_LUONG_CB;
    }

    public double getTIEN_LUONG_LT() {
        return TIEN_LUONG_LT;
    }
}