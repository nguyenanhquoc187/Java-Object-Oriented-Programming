package test1online;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SoThuc st = new SoThuc();
        VanBan vb = new VanBan();
        DaThuc p = new DaThuc();
        DaThuc q = new DaThuc();
        while (true) {
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap vao day so thuc");
            System.out.println("Chon so 2: Viet ra phan tu nho nhat cua day");
            System.out.println("Chon so 3: Sap xep va dua ra day so giam dan");
            System.out.println("Chon so 4: Nhap vao 1 doan van ban ");
            System.out.println("Chon so 5: Dua ra so cau(ket thuc boi .?! ");
            System.out.println("Chon so 6: Chuẩn hóa và viết ra ");
            System.out.println("Chon so 7: Nhập vào 1 đa thức (Pn(x)) ");
            System.out.println("Chon so 8: Tính Pn(x) + Qm(x) ");
            System.out.println("Chon so 9: Tính Pn(x) / Qm(x) và đa thức dư ");
            System.out.println("Moi chon 0 -9");
            int x = Integer.parseInt(sc.nextLine());
            switch (x) {
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    System.out.println("Da chon so 1: Nhap vao day so thuc: ");
                    st.input();
                    break;
                case 2:
                    System.out.println("Da chon so 2: Phan tu nho nhat cua day la: ");
                    System.out.println(st.PhanTuNhoNhat());
                    break;
                case 3:
                    System.out.println("Da chon so 3: ");
                    st.SapXep();
                    break;
                case 4:
                    System.out.println("Da chon so 4: Nhap van ban: ");
                    vb.input();
                    break;
                case 5:
                    System.out.println("Da cho so 5: So cau la: ");
                    System.out.println(vb.getSoCau());
                    break;
                case 6:
                    System.out.println("Da chon so 6: Van ban da duoc chuan hoa la: ");
                    System.out.println(vb.chuanHoa());
                    break;
                case 7:
                    System.out.println("Da chon so 7:Nhap da thuc (Vi du: 1 0 3 (1x^0 + 3x^2 )  )");
                    p.input();
                    q.input();
                    break;
                case 8:
                    System.out.println("Da chon so 8: Pn(x) + Qm(x) la: ");
                    System.out.println(p.TongDaThuc(q));
                    break;
                case 9:
                    System.out.println("Da cho so 9:  Pn(x) / Qm(x) và đa thức dư la: ");
                    break;
                default:
                    System.out.println("Phai chon tu 0-9");
                    break;
            }
        }
    }
}
