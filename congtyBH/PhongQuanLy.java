/*
 * Method timKiemCMT(), sua(), timKiem(): Le Pham Thuy Tien 20207633
 * Method them(), xoa(), inDS(): Nguyen Thi Van Anh 20200035
 */
package congtyBH;

import nhanvien.NhanVien;
import nhanvien.NhanVienBienChe;
import nhanvien.NhanVienThoiVu;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.*;

public class PhongQuanLy {
    private int soNV;
    private PhongTaiChinh ptc;
    private ArrayList<NhanVien> dsNV;

    public PhongQuanLy() {
        this.soNV = 0;
        this.dsNV = new ArrayList<>();
        this.ptc = new PhongTaiChinh();
    }
    // them, sua, xoa nhan vien
    public void themNV(NhanVien nv){
        dsNV.add(nv);
        soNV++;
    }
    public void xoaNV(NhanVien nv){
        dsNV.remove(nv);
        soNV--;
    }
    public void suaNV(NhanVien nv) throws ParseException {
        nv.nhapTT();
    }
    public void inDS()
    {
        System.out.printf("------------------------                IN DANH SACH NHAN VIEN                ------------------------%n");
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-30s | %-12s | %-30s | %-15s | %-10s |%n ", "STT", "TEN NHAN VIEN", "SO CMT", "DON VI", "LOAI NHAN VIEN", "TG BAT DAU");
        System.out.printf("------------------------------------------------------------------------------------------------------%n");
        for(int i=1; i<= getDsNV().size(); i++)
        {
            if (dsNV.get(i-1) instanceof NhanVienBienChe)
            {
                System.out.printf("| %3d | %-30s | %-12s | %-30s | %-15s | %-10s |%n", i, dsNV.get(i-1).getTen(), dsNV.get(i-1).getSoCMT(), dsNV.get(i-1).getDonVi(), "bien che", HelpMethod.formatDate(dsNV.get(i-1).getTgBatDauLam()));
            }
            if (dsNV.get(i-1) instanceof NhanVienThoiVu)
            {
                System.out.printf("| %3d | %-30s | %-12s | %-30s | %-15s | %-10s |%n", i, dsNV.get(i-1).getTen(), dsNV.get(i-1).getSoCMT(), dsNV.get(i-1).getDonVi(), "thoi vu", HelpMethod.formatDate(dsNV.get(i-1).getTgBatDauLam()));
            }
        }
        System.out.printf("----------------------------------------------------------------------%n");
    }

    // tim kiem nhan vien
    public ArrayList<NhanVien> timKiem(String ten){

        ArrayList<NhanVien> result = new ArrayList<>();
        String regex = ".*\\b"+ ten.toLowerCase() +".*";
        for (NhanVien nv: dsNV){
            if(nv.getTen().toLowerCase().matches(regex)){
                result.add(nv);
            }
        }
        return result;
    }
    public ArrayList<NhanVien> timKiemCMT(String cmt){
        ArrayList<NhanVien> result = new ArrayList<>();
        for(NhanVien nv: dsNV){
            if(Objects.equals(nv.getSoCMT(), cmt)){
                result.add(nv);
            }
        }
        return result;
    }
    // overloading
    public ArrayList<NhanVien> timKiem(Date date){
        ArrayList<NhanVien> result = new ArrayList<>();
        for(NhanVien nv: dsNV){
            if(nv.getTgBatDauLam().equals(date)){
                result.add(nv);
            }
        }
        return result;
    }


    public int getSoNV() {
        return soNV;
    }

    public void setSoNV(int soNV) {
        this.soNV = soNV;
    }

    public PhongTaiChinh getPtc() {
        return ptc;
    }

    public void setPtc(PhongTaiChinh ptc) {
        this.ptc = ptc;
    }

    public ArrayList<NhanVien> getDsNV() {
        return dsNV;
    }

}