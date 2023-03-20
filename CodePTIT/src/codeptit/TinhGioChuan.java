package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TinhGioChuan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in") );
        ArrayList<MonHocJ06007> mh = new ArrayList<>();
        ArrayList<GiangVienJ06007> gv = new ArrayList<>();
        ArrayList<GiangDayJ06007> gd = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i =0 ; i < n; i++) {
            mh.add(new MonHocJ06007(sc.next(), sc.nextLine()));
        }
        sc = new Scanner(new File("GIANGVIEN.in") );
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < m ;i++) gv.add(new GiangVienJ06007(sc.next(), sc.nextLine()));
        sc = new Scanner(new File("GIOCHUAN.in") );
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i< k ;i++) {
            String magv = sc.next(), mamon = sc.next();
            double gio = sc.nextDouble();
            GiangVienJ06007 x = new GiangVienJ06007();
            MonHocJ06007 y = new MonHocJ06007();
            for (GiangVienJ06007 j : gv) if (j.getMa().equals(magv)) x = j;
            for (MonHocJ06007 j : mh ) if (j.getMa().equals(mamon) ) y = j;
            gd.add(new GiangDayJ06007(x, y, gio) );
        }
        
        for (GiangVienJ06007 i : gv) {
            double sum = 0 ;
            for (GiangDayJ06007 j : gd) if (j.getGv().getMa().equals(i.getMa()) ) sum += j.getGiochuan();
            System.out.println(i.getTen() + " " + String.format("%.2f", sum));
        }
    }

}
class MonHocJ06007 {
    private String ma, ten;

    public MonHocJ06007() {
    }

    public MonHocJ06007(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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
    
}
class GiangVienJ06007 {
    private String ma, ten;

    public GiangVienJ06007() {
    }

    public GiangVienJ06007(String ma, String ten) {
        this.ma = ma;
        this.ten = ten.trim();
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
    
}

class GiangDayJ06007 {
    private GiangVienJ06007 gv;
    private MonHocJ06007 mh;
    private double giochuan;

    public GiangDayJ06007(GiangVienJ06007 gv, MonHocJ06007 mh, double giochuan) {
        this.gv = gv;
        this.mh = mh;
        this.giochuan = giochuan;
    }

    public GiangVienJ06007 getGv() {
        return gv;
    }

    public void setGv(GiangVienJ06007 gv) {
        this.gv = gv;
    }

    public MonHocJ06007 getMh() {
        return mh;
    }

    public void setMh(MonHocJ06007 mh) {
        this.mh = mh;
    }

    public double getGiochuan() {
        return giochuan;
    }

    public void setGiochuan(double giochuan) {
        this.giochuan = giochuan;
    }
    
    public String getTenGV() {
        return gv.getTen();
    }
    
}
