package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TenVietTat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Ten> a = new ArrayList<>();
        for (int i= 0 ;i < n ;i++) {
            String s = sc.nextLine();
            String[] b = s.split("\\s+");
            String res ="";
            for (int j = 0 ;j < b.length-1;j++) res+=b[j].substring(0,1).toUpperCase() + ".";
            res += b[b.length-1].substring(0,1).toUpperCase();
            a.add(new Ten(s, res) );
        }
        Collections.sort(a);
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < k; i++) {
            String re = sc.nextLine();
            for (Ten it : a) {
                if (it.checkMatch(re) ) System.out.println(it);
            }
        }
    }

}
class Ten implements Comparable<Ten>{
    private String ten,vietat;

    public Ten(String ten, String vietat) {
        this.ten = ten;
        this.vietat = vietat;
    }

    public String getVietat() {
        return vietat;
    }

    public String getTen() {
        return ten;
    }
    
    public boolean checkMatch(String re) {
        re = re.toUpperCase();
        if (vietat.length() != re.length() ) return false;
        for (int i = 0 ; i < re.length() ;i+=2 ) {
            if ( vietat.charAt(i) != re.charAt(i)  && re.charAt(i) != '*'  ) return false;
        }
        return true;
    }

    @Override
    public int compareTo(Ten o) {
        String[] a = ten.split("\\s+");
        String[] b = o.ten.split("\\s+");
        String ten1= a[a.length-1], ho1 = a[0];
        String ten2= b[b.length-1], ho2 = b[0];
        if (ten1.compareTo(ten2) != 0 ) return ten1.compareTo(ten2);
        return ho1.compareTo(ho2);
    }
    @Override
    public String toString() {
        return ten;
    }
}