package codeptit;
import java.util.*;
public class TinhToanPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            PhanSo a = new PhanSo();
            PhanSo b = new PhanSo();
            a.nextPhanSo(sc);
            b.nextPhanSo(sc);
            PhanSo c = PhanSo.tongPhanSo(a, b);
            c = PhanSo.tichPhanSo(c, c);
            c.rutgon();
            System.out.print(c + " ");
            c.tichPhanSo(a);
            c.tichPhanSo(b);
            c.rutgon();
            System.out.println(c);
        }
    }

}
