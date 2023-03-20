package baithuchanh1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap mang");
            System.out.println("Chon so 2: Viet");
            System.out.println("Chon so 3: Lay ra so nam nhan bang");
            System.out.println("Chon so 4: Sua gioi tinh");
            System.out.println("Chon so 5: Tang hoa cho nhung nguoi loai F");
            System.out.println("Chon so 6: Tang hoa cho nhung nguoi loai F");
            System.out.println("Chon so 7: Tang hoa cho nhung nguoi loai F");
            System.out.println("Chon so 8: Tang hoa cho nhung nguoi loai F");
            System.out.println("Chon so 8: Tang hoa cho nhung nguoi loai F");
            System.out.println("Moi chon 0 -9");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    System.out.println("Da chon so 1: Nhap bang ");
                    break;
                case 2:
                    System.out.println("Da chon so 2:");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Da chon so 3:");
                    break;
                case 4:
                    System.out.println("Da chon so 4:");
                    System.out.println("Nhap: ");
                    a.input();
                    break;
                case 5:
                    System.out.println("Da cho so 5: ");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Da chon so 6: ");
                    System.out.println("Tuoi la:" );
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }

}
