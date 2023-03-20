package Q1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();
        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap so trong nuoc");
            System.out.println("Chon so 2: Nhap so quoc te");
            System.out.println("Chon so 3: Tim theo ma vung");
            System.out.println("Chon so 4: Liet ke so trong nuoc");
            System.out.println("Chon so 5: Liet ke so quoc te ");
            System.out.println("Chon so 6: Hien thi danh sach ");
            System.out.println("Chon so 7: Tong so dien thoai theo tung vung ");
            System.out.println("Chon so 8: Tim kiem so theo duoi ");
            System.out.println("Chon so 9: Sap xep so dien thoai tang dan ");
            System.out.print("Moi chon 0-9: ");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    pb.nhapSoTrongNuoc();
                    break;
                case 2:
                    pb.nhapSoQuocTe();
                    break;
                case 3:
                    pb.timTheoMaVung();
                    break;
                case 4:
                    pb.lietKeSoTrongNuoc();
                    break;
                case 5:
                    pb.lietKeSoQuocTe();
                    break;
                case 6:
                    pb.lietKeSoTrongNuoc();
                    pb.lietKeSoQuocTe();
                    break;
                case 7:
                    pb.tinhTongSoDienThoaiTheoTungVung();
                    break;
                case 8:
                    pb.timKiemSoTheoDuoi();
                    break;
                case 9:
                    pb.SapXep();
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }

}

