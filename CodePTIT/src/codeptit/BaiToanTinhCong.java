package codeptit;
import java.util.*;
public class BaiToanTinhCong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien a = new NhanVien();
        a.nextNv(sc, 1);
        System.out.println(a);
    }

}
class NhanVien {
    private String manv,ten,chucvu;
    private int luongcoban,songaycong;
    public void nextNv(Scanner sc, int i) {
        if (i < 10) manv = "NV0" + String.valueOf(i);
        else manv = "NV" + String.valueOf(i);
        ten = sc.nextLine();
        luongcoban = sc.nextInt();
        songaycong = sc.nextInt();
        chucvu = sc.next();
    }
    public int getSalary() {
        return luongcoban*songaycong;
    }
    public double getBonus() {
        if (songaycong > 25 ) return 0.2;
        else if (songaycong > 22) return 0.1;
        else return 0;
    }
    public int getPhucap() {
        if (chucvu.equals("GD") ) return 250000 ;
        if (chucvu.equals("PGD") ) return 200000;
        if (chucvu.equals("TP")) return 180000;
        if (chucvu.equals("NV")) return 150000;
        return 0;
    }
    public double getThunhap() {
        return getSalary()* (double) (1 + getBonus()) + getPhucap();
    }
    @Override
    public String toString() {
        System.out.println(manv + " " + ten +  " " + getSalary() + " " + (int)(getSalary()*getBonus()) + " " + getPhucap() + " " + (int)getThunhap() );
        return "";
    }
}
