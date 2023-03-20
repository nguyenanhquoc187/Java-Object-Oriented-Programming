package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TinhDiemTrungBinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> a = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            SV tmp = new SV();
            tmp.input(sc);
            a.add(tmp);
        }
        Collections.sort(a);
        a.get(0).setRank(1);
        for (int i = 0 ; i < n;i++) a.get(i).setRank(i+1);
        int dem = 1;
        System.out.println(a.get(0));
        for (int i = 1 ; i < n ;i++) {
            if (a.get(i).getTB() == a.get(i-1).getTB() ) a.get(i).setRank(a.get(i-1).getRank());
            else a.get(i).setRank(i+1);
            System.out.println(a.get(i));
        }
    }

}
class SV implements Comparable<SV>{
    private String code, name; 
    private double p1,p2,p3;
    private int rank;
    private static int j = 1;
    public void input(Scanner sc) {
        if ( j < 10) code ="SV0" + j;
        else code = "SV" + j;
        name = chuanhoa(sc.nextLine());
        p1 = Double.valueOf(sc.nextLine());
        p2 = Double.valueOf(sc.nextLine());
        p3 = Double.valueOf(sc.nextLine());
        j++;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    
    public double getTB() {
        return (p1*3+p2*3+p3*2) / 8;
    }
    
    public static String chuanhoa(String s) {
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        s = s.toLowerCase();
        String[] a = s.split(" ");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        return s2;
    }
    
    @Override
    public int compareTo(SV o) {
        if (this.getTB() == o.getTB() && this.code.compareTo(o.code) > 0) return 1;
        if (this.getTB() <= o.getTB()) return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " + String.format("%.2f", getTB() ) + " " + rank ;
    }
}