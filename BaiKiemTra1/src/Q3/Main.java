package Q3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLGD gd = new QLGD();
        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Them giao dich vang");
            System.out.println("Chon so 2: Them giao dich tien te");
            System.out.println("Chon so 3: Hien thi danh sach giao dich");
            System.out.println("Chon so 4: Sua");
            System.out.println("Chon so 5: Xoa ");
            System.out.println("Chon so 6: Tong so luong cac giao dich  ");
            System.out.println("Chon so 7: Hien thi danh sach giao dich theo ngay ");
            System.out.println("Chon so 8: Hien thi danh sach giao dich co chua ngay ");
            System.out.println("Chon so 9: Hien thi danh sach giao dich tu nam den nam ");
            System.out.print("Moi chon 0-9: ");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    gd.nhapGiaoDichVang();
                    break;
                case 2:
                    gd.nhapGiaoDichTienTe();
                    break;
                case 3:
                    gd.hienthiDs();
                    break;
                case 4:
                    gd.sua();
                    break;
                case 5:
                    gd.xoa();
                    System.out.println("");
                    break;
                case 6:
                    gd.tongsoluongGiaoDichVang();
                    gd.tongsoluongGiaoDichTienTe();
                    gd.tongsoluongGiaoDichDat();
                    break;
                case 7:
                    gd.hienThiDanhSachTheoNgay();
                    break;
                case 8:
                    gd.hienthiDanhSachCoChuaNgay();
                    break;
                case 9:
                    gd.hienthiDanhSachTuNamDenNam();
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }

}

