package baitaptrenlop;
import java.util.*;
public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap 2 phan so");
            System.out.println("Chon so 2: Tinh tong 2 phan so");
            System.out.println("Chon so 3: Tinh hieu 2 phan so");
            System.out.println("Chon so 4: Nhap vao 1 so nguyen duong n: ");
            System.out.println("Chon so 5: Liet ke cac so Fibonaci nho hon n la so nguyen to: ");
            System.out.println("Chon so 6: Kiem tra xem n cos phai so thuan nghich khong: ");
            System.out.println("Chon so 7: Nhap vao 1 ma tran vuong: ");
            System.out.println("Chon so 8: Dua ra cac hang chi co cac so duong chan: ");
            System.out.println("Chon so 9: Tim ma tran nghich dao: ");
            System.out.println("Moi chon 0 -9");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    System.out.println("Da chon so 1: Nhap 2 phan so ");
                    A.nextPhanSo();
                    B.nextPhanSo();
                    break;
                case 2:
                    System.out.println("Da chon so 2: Tong 2 phan so la: ");
                    System.out.println(A.tongPhanSo(B).rutgon() );
                    break;
                case 3:
                    System.out.println("Da chon so 3: Hieu 2 phan so la: ");
                    System.out.println(A.hieuPhanSo(B).rutgon() );
                    break;
                case 4:
                    System.out.println("Da chon so 4: Nhap n: ");
                    SN.intput();
                    break;
                case 5:
                    System.out.println("Da cho so 5: Cac so Fibonaci nho hon n la so nguyen to la: ");
                    SN.Fibonaci();
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("Da chon so 6: ");
                    System.out.println(SN.KTthuannghich() );
                    break;
                case 7:
                    System.out.println("Da chon so 7:Nhap ma tran ");
                    mt.input();
                    break;
                case 8:
                    System.out.println("Da chon so 8: Cac hang chi co cac so duong chan ");
                    mt.Hangsoduongchan();
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }

}
