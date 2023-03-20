package Q4;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLGV gv = new QLGV();
        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap giang vien huu co");
            System.out.println("Chon so 2: Nhap giang vien thinh giang");
            System.out.println("Chon so 3: In tong bo danh sach");
            System.out.println("Chon so 4: In danh sach giang vien huu co");
            System.out.println("Chon so 5: In danh sach giang vien thinh giang");
            System.out.println("Chon so 6: Xoa ");
            System.out.println("Chon so 7: Sua");
            System.out.println("Chon so 8: Tim kiem giang vien theo ten ");
            System.out.println("Chon so 9: Sap xep danh sach theo ten ");
            System.out.println("Chon so 10: Tinh Tong Va Trung Binh Tien Luong Cua Toan Bo GV ");
            System.out.println("Chon so 11: Tim giang vien co luong cao nhat ");
            System.out.print("Moi chon 0-11: ");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    gv.nhapGiangVienHuuCo();
                    break;
                case 2:
                    gv.nhapGiangVienThinhGiang();
                    break;
                case 3:
                    gv.inDanhSachGiangVienHuuCo();
                    gv.inDanhSachGiangVienThinhGiang();
                    break;
                case 4:
                    gv.inDanhSachGiangVienHuuCo();
                    break;
                case 5:
                    gv.inDanhSachGiangVienThinhGiang();
                    break;
                case 6:
                    gv.xoa();
                    break;
                case 7:
                    gv.sua();
                    break;
                case 8:
                    gv.TimKiemGiangVienGanDung();
                    break;
                case 9:
                    gv.SapXepDSTheoTen();
                    break;
                case 10:
                    gv.TinhTongVaTrungBinhTienLuongCuaToanBoGV();
                    break;
                case 11:
                    gv.TimGiangVienCoLuongCaoNhat();
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }

}

