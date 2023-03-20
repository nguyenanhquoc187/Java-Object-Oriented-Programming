package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SapXepLichThi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        ArrayList<MonThiJ07060> mt = new ArrayList<>();
        ArrayList<CaThiJ07060> ct = new ArrayList<>();
        ArrayList<LichThiJ07060> lt = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 0 ; i < n ;i++ ) {
            mt.add(new MonThiJ07060(sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        }
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 0 ; i < m ;i++ ) {
            ct.add(new CaThiJ07060(sc2.nextLine(), sc2.nextLine(), sc2.nextLine()));
        }
        int k = Integer.parseInt(sc3.nextLine());
        for (int i = 0 ; i < k ;i++ ) {
            String[] a = sc3.nextLine().split("\\s+");
            MonThiJ07060 x = new MonThiJ07060();
            CaThiJ07060 y = new CaThiJ07060();
            for (MonThiJ07060 j : mt) if (j.getMa().equals(a[1])) x = j;
            for (CaThiJ07060 j : ct) if (j.getMa().equals(a[0])) y = j;
            lt.add(new LichThiJ07060(x, y, a[2], a[3]));
        }
        Collections.sort(lt);
        for (LichThiJ07060 i : lt) System.out.println(i);
    }

}
class MonThiJ07060 {
    private String ma,ten,hinhthuc;

    public MonThiJ07060() {
    }

    public MonThiJ07060(String ma, String ten, String hinhthuc) {
        this.ma = ma;
        this.ten = ten;
        this.hinhthuc = hinhthuc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }
    
}
class CaThiJ07060 {
    private String ma, ngaythi,giothi,phongthi;
    private static int j = 1;
    public CaThiJ07060() {
    }

    public CaThiJ07060(String ngaythi, String giothi, String phongthi) {
        this.ma = String.format("C%03d", j++);
        this.ngaythi = ngaythi;
        this.giothi = giothi;
        this.phongthi = phongthi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public String getGiothi() {
        return giothi;
    }

    public void setGiothi(String giothi) {
        this.giothi = giothi;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }

    public static int getJ() {
        return j;
    }

    public static void setJ(int j) {
        CaThiJ07060.j = j;
    }
    
    public Date getNgayGio() throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(ngaythi + " " + giothi);
    }
    
}

class LichThiJ07060 implements Comparable<LichThiJ07060>{
    private MonThiJ07060 mt;
    private CaThiJ07060 ct;
    private String nhom, sosv;

    public LichThiJ07060(MonThiJ07060 mt, CaThiJ07060 ct, String nhom, String sosv) {
        this.mt = mt;
        this.ct = ct;
        this.nhom = nhom;
        this.sosv = sosv;
    }

    @Override
    public String toString() {
        return ct.getNgaythi() + " " + ct.getGiothi() + " " + ct.getPhongthi() + " " + mt.getTen() + " " + nhom + " " + sosv;
    }

    @Override
    public int compareTo(LichThiJ07060 o) {
       
        try {
            if (ct.getNgayGio().compareTo(o.ct.getNgayGio()) == 0) return ct.getMa().compareTo(o.ct.getMa());
        } catch (ParseException ex) {
            Logger.getLogger(LichThiJ07060.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return ct.getNgayGio().compareTo(o.ct.getNgayGio());
        } catch (ParseException ex) {
            Logger.getLogger(LichThiJ07060.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}