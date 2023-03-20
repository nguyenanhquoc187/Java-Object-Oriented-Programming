package codeptit;
import java.util.*;
public class DanhSachDoiTuongSinhVien2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SinhVien[] a = new SinhVien[n+5];
        for (int i = 0; i < n; i++) {
            a[i] = new SinhVien();
            a[i].nextSv(sc);
            a[i].chuanHoaNgaysinh();
            a[i].chuanhoahoten();
        }
        for (int i = 0 ; i< n;i++) 
            System.out.printf("%s %s %s %s %.2f\n", a[i].getmaSv(), a[i].getHoten(), a[i].getLop(), a[i].getNgaysinh(), a[i].getGpa());
    }

}
