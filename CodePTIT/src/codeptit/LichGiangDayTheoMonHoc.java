package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class LichGiangDayTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MonHoc> mh = new ArrayList<>();
        for (int i = 0 ; i < n ;i++) {
            String ma  = sc.nextLine();
            String ten = sc.nextLine();
            int sotc = Integer.parseInt(sc.nextLine());
            MonHoc x = new MonHoc(ma, ten, sotc);
            mh.add(x);
        }
        ArrayList<LichGiangDay> lgd = new ArrayList<>();
        n = Integer.parseInt(sc2.nextLine());
        for (int i = 0 ; i < n ;i++) {
            String maMon = sc2.nextLine();
            int thu = Integer.parseInt(sc2.nextLine());
            int kip = Integer.parseInt(sc2.nextLine());
            String hoten = sc2.nextLine();
            String phong = sc2.nextLine();
            LichGiangDay x = new LichGiangDay(maMon, hoten, thu, kip, phong);
            lgd.add(x);
        }
        String maMon = sc2.nextLine();
        String tenmon = "";
        for (MonHoc i : mh) if (i.getMa().equals(maMon) ) tenmon = i.getTen();
        System.out.println("LICH GIANG DAY MON " + tenmon+ ":");
        Collections.sort(lgd);
        for (LichGiangDay i : lgd) {
            if (i.getMaMon().equals(maMon) ) System.out.println(i);
        }
    }

}
class MonHoc {
    private String ma,ten;
    private int sotc;

    public MonHoc(String ma, String ten, int sotc) {
        this.ma = ma;
        this.ten = ten;
        this.sotc = sotc;
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

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }
    
}

class LichGiangDay implements Comparable<LichGiangDay>{
    private String maNhom, maMon, hoten, phong;
    private int ngayGd,kip;
    private static int j = 1;

    public LichGiangDay(String maMon, String hoten, int ngayGd, int kip, String phong) {
        this.maNhom = String.format("HP%03d", j);
        this.maMon = maMon;
        this.hoten = hoten;
        this.phong = phong;
        this.ngayGd = ngayGd;
        this.kip = kip;
        j++;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getNgayGd() {
        return ngayGd;
    }

    public void setNgayGd(int ngayGd) {
        this.ngayGd = ngayGd;
    }

    public int getKip() {
        return kip;
    }

    public void setKip(int kip) {
        this.kip = kip;
    }

    public static int getJ() {
        return j;
    }

    public static void setJ(int j) {
        LichGiangDay.j = j;
    }

    @Override
    public String toString() {
        return maNhom + " " + ngayGd + " " + kip + " " + hoten + " " +phong;
    }

    @Override
    public int compareTo(LichGiangDay o) {
        if (ngayGd > o.ngayGd) return 1;
        if (ngayGd == o.ngayGd && kip > o.kip) return 1;
        if (ngayGd == o.ngayGd && kip == o.kip ) return hoten.compareTo(o.hoten);
        return -1;
    }
    
}