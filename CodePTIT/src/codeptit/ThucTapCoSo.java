package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ThucTapCoSo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("DETAI.in"));
        Scanner sc3 = new Scanner(new File("NHIEMVU.in"));
        ArrayList<SinhVienTTCS> a = new ArrayList<>();
        ArrayList<DeTai> b = new ArrayList<>();
        ArrayList<NhiemVu> c = new ArrayList<>();
        int n_sv = Integer.parseInt(sc1.nextLine());
        for (int i = 0 ; i < n_sv ;i++ ) {
            String ma = sc1.nextLine();;
            String ten = sc1.nextLine();
            String sdt = sc1.nextLine();
            String email = sc1.nextLine();
            a.add(new SinhVienTTCS(ma, ten, sdt, email));
        }
        int n_dt = Integer.parseInt(sc2.nextLine());
        for (int i = 0 ; i <n_dt ; i++) {
            String gv = sc2.nextLine();
            String dt = sc2.nextLine();
            b.add(new DeTai(gv, dt));
        }
        int n_nv = Integer.parseInt(sc3.nextLine());
        for (int i = 0 ; i< n_nv;i++) {
            String[] s = sc3.nextLine().split("\\s+");
            c.add(new NhiemVu(s[0], s[1]));
        }
        
        Collections.sort(c, new Comparator<NhiemVu>() {
            @Override
            public int compare(NhiemVu o1, NhiemVu o2) {
                String t1 = "",t2 ="";
                for (DeTai i : b) {
                    if (o1.getMaDt().equals(i.getMa())) {
                        t1 = i.getDetai();
                        break;
                    }
                }
                for (DeTai i : b) {
                    if (o2.getMaDt().equals(i.getMa())) {
                        t2 = i.getDetai();
                        break;
                    }
                }
                return t1.compareTo(t2);
            }
        });
        for (NhiemVu i : c) {
            for (SinhVienTTCS j : a) {
                if (i.getMaSv().equals(j.getMa())) {
                    System.out.print(j + " ");
                    break;
                }
            }
            for (DeTai j : b) {
                if (i.getMaDt().equals(j.getMa() )) {
                    System.out.print(j + " ");
                    break;
                }
            }
            System.out.println("");
            
        }
    }

}
class SinhVienTTCS {
    private String ma,ten,sdt,email;

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
        return ma + " " + ten + " " + sdt + " " + email;
    }
    
}

class DeTai {
    private String ma,gv,detai;
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
        return gv + " " + detai;
    }
    
}

class NhiemVu {
    private String maSv, maDt;

    public NhiemVu(String maSv, String maDt) {
        this.maSv = maSv;
        this.maDt = maDt;
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