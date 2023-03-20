package codeptit;
import java.util.*;
public class DanhSachDoiTuongSinhVien3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            SinhVien x  = new SinhVien();
            x.nextSv(sc);
            x.chuanHoaNgaysinh();
            x.chuanhoahoten();
            a.add(x);
        }
        Collections.sort(a,new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
               if (o1.getGpa() < o2.getGpa()) return 1;
               return -1;
            }
        });
        for (int i = 0 ; i< n;i++) 
            System.out.printf("%s %s %s %s %.2f\n", a.get(i).getmaSv(), a.get(i).getHoten(), a.get(i).getLop(), a.get(i).getNgaysinh(), a.get(i).getGpa());
    }

}