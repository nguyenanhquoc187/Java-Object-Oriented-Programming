package codeptit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DanhSachMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MONHOC.in");
        Scanner sc = new Scanner (  file);
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<MonHoc2> a = new ArrayList<>();
        for (int i = 0 ; i< n;i++) {
            MonHoc2 tmp  = new MonHoc2();
            tmp.nextMh(sc);
            a.add(tmp);
        }
        Collections.sort(a,(MonHoc2 t1, MonHoc2 t2) -> {
            return t1.getTenmon().compareTo(t2.getTenmon());
        });
        for (int i = 0 ;i <n ;i++) System.out.println(a.get(i));
    }

}

class MonHoc2 {
    private String mamon,tenmon,sotinchi;
    public void nextMh(Scanner sc) {
        mamon = sc.nextLine();
        tenmon = sc.nextLine();
        sotinchi = sc.nextLine();
    }
    public String getMamon() {
        return mamon;
    }

    public String getTenmon() {
        return tenmon;
    }
    @Override
    public String toString() {
        System.out.print(mamon + " " + tenmon + " " + sotinchi);
        return "";
    }
}
