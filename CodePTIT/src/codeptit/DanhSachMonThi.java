package codeptit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DanhSachMonThi {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MONHOC.in");
        Scanner sc = new Scanner (  file);
        ArrayList<MonHoc> a = new ArrayList<>();
        int j = 0;
        String[] s = new String[3];
        while (sc.hasNextLine()) {
            s[j] = sc.nextLine();
            j++;
            if (j == 3) {
                int check = 0;
                for (MonHoc i : a)  if ( i.getMamon().equals(s[0]) ) check = 1;
                if (check == 0) a.add(new MonHoc(s[0], s[1],s[2]) );
                j = 0;
            }
        }
        Collections.sort(a,(MonHoc t1, MonHoc t2) -> {
            return t1.getMamon().compareTo(t2.getMamon());
        });
        for (MonHoc i : a) System.out.println(i);
    }

}

class MonHoc {
    private String mamon,tenmon,hinhthucthi;

    public MonHoc(String mamon, String tenmon, String hinhthucthi) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.hinhthucthi = hinhthucthi;
    }
    
    public String getMamon() {
        return mamon;
    }
    @Override
    public String toString() {
        System.out.print(mamon + " " + tenmon + " " + hinhthucthi);
        return "";
    }
}
