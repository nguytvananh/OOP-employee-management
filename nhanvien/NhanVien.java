/*
 * Method inLuong(), getLuong(), setLuongTungThang(): Le Pham Thuy Tien 20207633
 * Other things: Nguyen Thi Van Anh 20200035
 */
package nhanvien;

import utils.HelpMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public abstract class NhanVien {
    private String ten;
    private String soCMT;
    private String donVi;
    private Date tgBatDauLam;
    private Hashtable<String, Double> luongTungThang = new Hashtable<>();

    public NhanVien(){}
    public NhanVien(String ten, String soCMT, String donVi, Date tgBatDauLam){
        this.ten = ten;
        this.soCMT = soCMT;
        this.donVi = donVi;
        this.tgBatDauLam = tgBatDauLam;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Date getTgBatDauLam() {
        return tgBatDauLam;
    }

    public void setTgBatDauLam(Date tgBatDauLam) {
        this.tgBatDauLam = tgBatDauLam;
    }

    public Hashtable<String, Double> getLuongTungThang() {
        return luongTungThang;
    }
    public void setLuongTungThang(String monthYear, double luong){
        luongTungThang.put(monthYear, luong);
    }

    public abstract double tinhLuong();

    public abstract void nhapLuong(String monthYear);
    public void nhapTT() throws ParseException
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Nhap ten nhan vien: ");
            String ten = sc.nextLine();
            if(HelpMethod.checkLength(ten, 3))
            {
                setTen(ten);
                break;
            }
            else
            {
                System.out.println("Nhap lai ten co tren 3 ky tu");
            }
        }

        while (true)
        {
            System.out.print("Nhap so chung minh thu: ");
            String soCMT = sc.nextLine();
            if(HelpMethod.checkCMT(soCMT))
            {
                setSoCMT(soCMT);
                break;
            }
            else
            {
                System.out.println("Nhap lai so CMT la day 9 so");
            }
        }

        while(true){
            System.out.print("Nhap don vi: ");
            String donVi = sc.nextLine();
            if(HelpMethod.checkLength(donVi, 1)){
                setDonVi(donVi);
                break;
            }else{
                System.out.println("[Error]: Nhap lai day du thong tin don vi");
            }
        }

        while(true)
        {
            System.out.print("Nhap thoi gian bat dau lam : ");
            String tgBatDauLam = sc.nextLine();
            if(HelpMethod.checkDateInput(tgBatDauLam))
            {
                setTgBatDauLam(HelpMethod.stringToDate(tgBatDauLam));
                break;
            }
            else
            {
                System.out.println("[Error]: Nhap lai thai gian co dang DD/MM/YYYY");
            }
        }
    }
    public void inTT()
    {
        System.out.println("-------IN THONG TIN NHAN VIEN--------");
        System.out.println("Ten: " + getTen());
        System.out.println("So CMT: " + getSoCMT());
        System.out.println("Don vi: " + getDonVi());
        System.out.println("Thoi gian bat dau lam: " + HelpMethod.formatDate(getTgBatDauLam()));
    }

    public void inLuong(String monthYear){
        double luong = getLuong(monthYear);
        if(luong !=0){
            System.out.println("Ten nhan vien: " + getTen());
            System.out.println("Luong thang " + monthYear + " : " + HelpMethod.formatNumber(luong));
        }else{
            System.out.println("[Error]: Chua ton tai du lieu ve luong thang " + monthYear);
            System.out.println("[Error]: Vui long nhap thong tin truoc khi tim kiem !");
        }
    }
    public double getLuong(String monthYear){
        if(luongTungThang.containsKey(monthYear)){
            return luongTungThang.get(monthYear);
        }else{
            return 0;
        }
    }
}
