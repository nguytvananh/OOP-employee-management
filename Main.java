// Le Pham Thuy Tien 20207633
import congtyBH.CongTyBH;
import utils.HelpMethod;

import java.text.ParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        CongTyBH cty = new CongTyBH("Cong ty Bao hiem");
        Scanner sc = new Scanner(System.in);

        while(true){
            showMenu();
            cty.inTT();

            System.out.println("Lua chon cua ban (Chon tu 1-9): ");
            String choiceStr = sc.nextLine();
            if(HelpMethod.checkNumber(choiceStr)){
                int choice = Integer.parseInt(choiceStr);
                switch (choice){
                    case 1:
                        cty.themNV();
                        break;
                    case 2:
                        cty.xoaNV();
                        break;
                    case 3:
                        cty.suaNV();
                        break;
                    case 4:
                        cty.timKiem();
                        break;
                    case 5:
                        cty.inDS();
                        break;
                    case 6:
                        cty.nhapLuongHangThang();
                        break;
                    case 7:
                        cty.tinhLuongTB();
                        break;
                    case 8:
                        cty.thongKeLuong();
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        break;
                }

            }else {
                System.out.println("[Error]: Nhap thong tin khong hop le");
            }

        }


    }
    public static void showMenu(){
        System.out.println("\n======================================================================");
        System.out.println("*                    QUAN LY CONG TY BAO HIEM                        *");
        System.out.println("======================================================================");
        System.out.println("*  1. Them nhan vien                                                 *");
        System.out.println("*  2. Xoa nhan vien                                                  *");
        System.out.println("*  3. Cap nhat thong tin nhan vien                                   *");
        System.out.println("*  4. Tim kiem nhan vien                                             *");
        System.out.println("*  5. Hien thi danh sach cac nhan vien                               *");
        System.out.println("*  6. Nhap luong cua nhan vien theo tung thang                       *");
        System.out.println("*  7. Tinh luong trung binh cua cac nhan vien tai thoi diem hien tai *");
        System.out.println("*  8. Thong ke muc luong cua nhan vien tai thoi diem nhap vao        *");
        System.out.println("*  9. Thoat                                                          *");
        System.out.println("======================================================================");
        System.out.println("");

    }
    /*public static void showMenu(){
        System.out.println("******************************************************************");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Xoa nhan vien");
        System.out.println("3. Cap nhat thong tin nhan vien");
        System.out.println("4. Tim kiem nhan vien");
        System.out.println("5. Hien thi danh sach cac nhan vien");
        System.out.println("6. Nhap luong cua nhan vien theo tung thang");
        System.out.println("7. Tinh luong trung binh cua cac nhan vien tai thoi diem hien tai");
        System.out.println("8. Thong ke muc luong cua nhan vien tai thoi diem nhap vao");
        System.out.println("9. Thoat");

    }*/
}