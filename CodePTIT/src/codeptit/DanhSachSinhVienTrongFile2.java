package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class DanhSachSinhVienTrongFile2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SV.in"));
        int n = Integer.valueOf(sc.nextLine());
        SinhVien[] a = new SinhVien[n+5];
        for (int i = 0 ; i< n;i++) {
            a[i] = new SinhVien();
            a[i].nextSv(sc);
            a[i].chuanHoaNgaysinh();
        }
        for (int i = 0 ; i< n;i++) 
            System.out.printf("%s %s %s %s %.2f\n", a[i].getmaSv(), a[i].getHoten(), a[i].getLop(), a[i].getNgaysinh(), a[i].getGpa());
    }

}
