package codeptit;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class BaoCaoThucTapCoSo {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc1 = new Scanner(new File("src/codeptit/SINHVIEN.in"));
//        Scanner sc2 = new Scanner(new File("src/codeptit/DETAI.in"));
//        Scanner sc3 = new Scanner(new File("src/codeptit/NHIEMVU.in"));
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("DETAI.in"));
        Scanner sc3 = new Scanner(new File("HOIDONG.in"));
        ArrayList<SinhVienTTCS> a = new ArrayList<>();
        ArrayList<DeTai> b = new ArrayList<>();
        ArrayList<NhiemVu> c = new ArrayList<>();
        int n_sv = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n_sv; i++) {
            String ma = sc1.nextLine();;
            String ten = sc1.nextLine();
            String sdt = sc1.nextLine();
            String email = sc1.nextLine();
            a.add(new SinhVienTTCS(ma, ten, sdt, email));
        }
        int n_dt = Integer.parseInt(sc2.nextLine());
        for (int i = 0; i < n_dt; i++) {
            String gv = sc2.nextLine();
            String dt = sc2.nextLine();
            b.add(new DeTai(gv, dt));
        }
        int n_nv = Integer.parseInt(sc3.nextLine());
        for (int i = 0; i < n_nv; i++) {
            String[] s = sc3.nextLine().split("\\s+");
            c.add(new NhiemVu(s[0], s[1], s[2]));
        }

        
        Set<String> lstHD = new TreeSet<>();
        for (NhiemVu i : c) {
            lstHD.add(i.getMaHd());
        }
        ArrayList<ArrayList<NhiemVu> > lst = new ArrayList<>();
        
        for (String hd : lstHD) {
            for (NhiemVu i : c) {
                if (i.getMaHd().equals(hd)) {
                    
                }
            }
            System.out.println("");
        }
    }

}

class SinhVienTTCS {

    private String ma, ten, sdt, email;

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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SinhVienTTCS(String ma, String ten, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    @Override
    public String toString() {
        return ma + " " + ten;
    }

}

class DeTai {

    private String ma, gv, detai;
    private static int j = 1;

    public DeTai(String gv, String detai) {
        ma = String.format("DT%03d", j);
        j++;
        this.gv = gv;
        this.detai = detai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getGv() {
        return gv;
    }

    public void setGv(String gv) {
        this.gv = gv;
    }

    public String getDetai() {
        return detai;
    }

    public void setDetai(String detai) {
        this.detai = detai;
    }

    @Override
    public String toString() {
        return detai + " " + gv;
    }

}

class NhiemVu {

    private String maSv, maDt, maHd;

    public NhiemVu(String maSv, String maDt, String maHd) {
        this.maSv = maSv;
        this.maDt = maDt;
        this.maHd = maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaHd() {
        return maHd;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getMaDt() {
        return maDt;
    }

    public void setMaDt(String maDt) {
        this.maDt = maDt;
    }

}
