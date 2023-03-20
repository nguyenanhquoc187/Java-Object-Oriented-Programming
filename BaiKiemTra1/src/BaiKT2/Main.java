package BaiKT2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLBH ql = new QLBH();
        String fname = "src/BaiKT2/hd.dat";
        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Doc");
            System.out.println("Chon so 2: Nhap hoa don ban si ");
            System.out.println("Chon so 3: Nhap hoa don ba le");
            System.out.println("Chon so 4: Hien thi danh sach");
            System.out.println("Chon so 5: Luu");
            System.out.println("Chon so 6: Tim kiem hoa don ban le tu nam den nam");
            System.out.println("Chon so 7: Sap xep danh sach theo ten KH ");
            System.out.println("Chon so 8: Dua ra tong so tien thu duoc theo tung nam cua HDBL");
            System.out.print("Moi chon 0-8: ");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    ql.doc(fname);
                    break;
                case 2:
                    ql.nhapHoaDonBanSi();
                    break;
                case 3:
                    ql.nhapHoaDonBanLe();
                    break;
                case 4:
                    ql.inDS();
                    break;
                case 5:
                    ql.luu(fname);
                    break;
                case 6:
                    ql.timHDBLTheoNam();
                    break;
                case 7:
                    ql.sapXepDSTheoTen();
                    break;
                case 8:
                    ql.duaRaTongSoTienTheoTungNamCuaHDBL();
                    break;
                default:
                    System.out.println("Phai chon tu 0-8");
                    break;
            }
        }
    }

}

