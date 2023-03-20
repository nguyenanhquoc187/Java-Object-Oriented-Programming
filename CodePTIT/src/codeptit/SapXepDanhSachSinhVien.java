package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SapXepDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien2> a = new ArrayList<>();
        for (int i = 0 ; i < n;i++) {
            SinhVien2 tmp = new SinhVien2();
            tmp.input(sc);
            a.add(tmp);
        }
        Collections.sort(a);
        for (int i = 0; i < n;i++) System.out.println(a.get(i));
    }

}
class SinhVien2 implements Comparable<SinhVien2>{
    private String code,name, sdt, mail;
    public void input(Scanner sc) {
        code = sc.nextLine();
        name = sc.nextLine();
        sdt = sc.nextLine();
        mail = sc.nextLine();
    }
    
    @Override
    public int compareTo(SinhVien2 o) {
        String[] a = name.split(" ");
        String[] a2 = o.name.split(" ");
        String s = a[a.length - 1], s2 = a2[a2.length - 1];
        for (int i = 0 ; i < a.length - 1; i++) s+= a[i];
        for (int i = 0 ; i < a2.length - 1; i++) s2+= a2[i];
        if (s.compareTo(s2) > 0 ) return 1;
        if (s.equals(s2) &&  code.compareTo(o.code) > 0   )  return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " +sdt + " " +mail;
    }
    
    
}
