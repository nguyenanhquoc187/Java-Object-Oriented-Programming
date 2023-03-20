package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class LuyenTapLapTrinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<LuyenTap> a = new ArrayList<>();
        for (int i = 0 ; i < n;i++) {
            String ten = sc.nextLine();
            String[] s = sc.nextLine().split("\\s+");
            int lamdung = Integer.parseInt(s[0]);
            int submit = Integer.parseInt(s[1]);
            a.add(new LuyenTap(ten, lamdung, submit));
        }
        Collections.sort(a);
        for (LuyenTap i : a) System.out.println(i);
    }

}
class LuyenTap implements Comparable<LuyenTap>{
    private String ten;
    private int lamdung,submit;

    public LuyenTap(String ten, int lamdung, int submit) {
        this.ten = ten;
        this.lamdung = lamdung;
        this.submit = submit;
    }

    @Override
    public String toString() {
        return ten + " " + lamdung + " " + submit;
    }

    @Override
    public int compareTo(LuyenTap o) {
        if (lamdung == o.lamdung && submit == o.submit) return ten.compareTo(o.ten);
        if (lamdung == o.lamdung) return submit - o.submit;
        return o.lamdung - lamdung;
    }
    
    
}
