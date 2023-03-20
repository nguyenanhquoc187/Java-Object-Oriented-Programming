package codeptit;
import java.util.Scanner;
public class KhaiBaoLopSinhVIen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien a = new SinhVien();
        a.nextSv(sc);
        a.chuanHoaNgaysinh();
        System.out.printf("%s %s %s %s %.2f", a.getmaSv(), a.getHoten(), a.getLop(), a.getNgaysinh(), a.getGpa());
    }

}