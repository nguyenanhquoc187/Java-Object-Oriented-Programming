package codeptit;
import java.util.*;
public class TinhTienDien2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHangJ05050> a = new ArrayList<>();
        for (int i = 0 ; i < n ;i++) {
            a.add(new KhachHangJ05050(sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        for (KhachHangJ05050 i : a) {
            System.out.println(i);
        }
    }

}
class KhachHangJ05050 {
    private String ma, loaiSD;
    private int cu, moi;
    private static int sma= 1;
    public KhachHangJ05050(String loaiSD, int cu, int moi) {
        this.ma = String.format("KH%02d", sma++);
        this.loaiSD = loaiSD;
        this.cu = cu;
        this.moi = moi;
    }
    
    public int getHeSo() {
        if (loaiSD.equals("KD")) return 3;
        if (loaiSD.equals("NN")) return 5;
        if (loaiSD.equals("TT")) return 4;
        return 2;
    }
    
    public long getThanhTien() {
        return (moi - cu)*getHeSo()*550;
    }
    
    public long getPhuTroi() {
        int x = moi - cu;
        if (x < 50) return 0;
        if (x >=50 && x <=100) return  (long) Math.ceil((getThanhTien()*0.35) );
        return getThanhTien();
    }
    public String toString() {
        return ma + " " + getHeSo() + " " + getThanhTien() + " " + getPhuTroi() + " " + (getThanhTien() + getPhuTroi()) ;
    }
}
