package codeptit;
import java.util.*;
public class BaiToanTuyenSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh a = new ThiSinh();
        a.setMats(sc.nextLine());
        a.setTen(sc.nextLine());
        a.setToan(sc.nextDouble());
        a.setLy(sc.nextDouble());
        a.setHoa(sc.nextDouble());
        System.out.println(a.getMats() + " " + a.getTen() + " " + xulyso(a.getDiemuutien()) + " " + xulyso((a.toan*2 + a.ly + a.hoa)) + " " + a.check());
    }
     public static String xulyso(double x) {
        if (x == (int) x ) return String.valueOf( (int) x);
        return String.valueOf(x);
    }
}
class ThiSinh {
    private String mats,ten;
    public double toan,ly,hoa;
    public void setMats(String mats) {
        this.mats = mats;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setToan(double toan) {
        this.toan = toan;
    }
    public void setLy(double ly) {
        this.ly = ly;
    }
    public void setHoa(double hoa) {
        this.hoa = hoa;
    }
    public String getMats() {
        return mats;
    }
    public String getTen() {
        return ten;
    }
    public double getDiemuutien() {
        if (mats.substring(0,3).equals("KV1")) return 0.5;
        if (mats.substring(0,3).equals("KV2")) return 1.0;
        return 2.5;
    }
   
    public String check() {
        if ( toan*2 + ly + hoa + getDiemuutien() >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }
}