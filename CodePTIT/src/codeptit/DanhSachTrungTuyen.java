package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class DanhSachTrungTuyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThiSinh2> a = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            ThiSinh2 tmp = new ThiSinh2();
            tmp.input(sc);
            a.add(tmp);
        }
        int chitieu = Integer.parseInt(sc.nextLine());
        Collections.sort(a);
        double diemchuan = a.get(chitieu -1).getDiemXT();
        System.out.println(diemchuan);
        for (int i = 0 ; i < n ;i++) {
            a.get(i).check(diemchuan);
            System.out.println(a.get(i));
        }
    }

}
class ThiSinh2 implements Comparable<ThiSinh2>{
    private String mats,ten, status;
    private double toan,ly,hoa;
    public void input(Scanner sc) {
        mats = sc.nextLine();
        ten = chuanhoa(sc.nextLine());
        toan = Double.valueOf(sc.nextLine());
        ly = Double.valueOf(sc.nextLine());;
        hoa = Double.valueOf(sc.nextLine());
    }
    public double getDiemuutien() {
        if (mats.substring(0,3).equals("KV1")) return 0.5;
        if (mats.substring(0,3).equals("KV2")) return 1.0;
        return 2.5;
    }
   
    public double getDiemXT() {
        return toan*2 + ly + hoa + getDiemuutien();
    }
    public void check(double diemchuan) {
        if ( getDiemXT() >= diemchuan ) status = "TRUNG TUYEN";
        else status =  "TRUOT";
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
    
    public static String xulyso(double x) {
        if (x == (int) x ) return String.valueOf( (int) x);
        return String.valueOf(x);
    }
    
    @Override
    public int compareTo(ThiSinh2 o) {
        if (this.getDiemXT() <= o.getDiemXT()) return 1;
        return -1;
    }
    @Override
    public String toString() {
        return mats + " " + ten + " " + xulyso(getDiemuutien()) + " " + xulyso(getDiemXT()) + " " + status;
    }
}