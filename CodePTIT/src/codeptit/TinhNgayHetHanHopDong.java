package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TinhNgayHetHanHopDong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SanPhamJ07049> sp = new ArrayList<>();
        ArrayList<KhachHangJ07049> kh = new ArrayList<>();
        ArrayList<MuaHangJ07049> mh = new ArrayList<>();
        for (int i = 0 ; i < n ;i++ ) {
            sp.add(new SanPhamJ07049(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < m ;i++) {
            KhachHangJ07049 tmp = new KhachHangJ07049(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine());
            kh.add(tmp);
            for (int j = 0 ; j  < n ;j++) {
                if (sp.get(j).getMa().equals(tmp.getMasp()) ) {
                    mh.add(new MuaHangJ07049(tmp, sp.get(j)));
                    break;
                }
            }
        }
        Collections.sort(mh);
        for (MuaHangJ07049 i : mh) System.out.println(i);
    }

}
class SanPhamJ07049 {
    private String ma,ten;
    private int giaban, tgianBH;

    public SanPhamJ07049() {
    }

    public SanPhamJ07049(String ma, String ten, int giaban, int tgianBH) {
        this.ma = ma;
        this.ten = ten;
        this.giaban = giaban;
        this.tgianBH = tgianBH;
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

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getTgianBH() {
        return tgianBH;
    }

    public void setTgianBH(int tgianBH) {
        this.tgianBH = tgianBH;
    }
    
    
}

class KhachHangJ07049 {
    private String ma,hoten,diachi, masp;
    private int soluong; 
    private String ngaymua;
    private static int j = 1;

    public KhachHangJ07049() {
    }
    
    public KhachHangJ07049(String hoten, String diachi, String masp, int soluong, String ngaymua) {
        this.ma = String.format("KH%02d", j++);
        this.hoten = hoten;
        this.diachi = diachi;
        this.masp = masp;
        this.soluong = soluong;
        this.ngaymua = ngaymua;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public static int getJ() {
        return j;
    }

    public static void setJ(int j) {
        KhachHangJ07049.j = j;
    }
    
}

class MuaHangJ07049 implements Comparable<MuaHangJ07049>{
    private KhachHangJ07049 kh;
    private SanPhamJ07049 sp;
    private int thanhtoan;
    private LocalDate ngayhetBH;

    public MuaHangJ07049() {
        KhachHangJ07049 kh = new KhachHangJ07049();
        SanPhamJ07049 sp = new SanPhamJ07049();
    }

    public MuaHangJ07049(KhachHangJ07049 kh, SanPhamJ07049 sp) {
        this.kh = kh;
        this.sp = sp;
        this.thanhtoan = kh.getSoluong()*sp.getGiaban();
        this.ngayhetBH = LocalDate.parse(kh.getNgaymua() , DateTimeFormatter.ofPattern("dd/MM/yyyy") );
        this.ngayhetBH = this.ngayhetBH.plusMonths(sp.getTgianBH());
    }

    @Override
    public int compareTo(MuaHangJ07049 o) {
        if (this.ngayhetBH.isEqual(o.ngayhetBH) ) return this.kh.getMa().compareTo(o.kh.getMa());
        return this.ngayhetBH.compareTo(o.ngayhetBH);
    }
    
    public String toString() {
        return kh.getMa() + " " + kh.getHoten() + " " + kh.getDiachi() + " " + kh.getMasp() + " " 
                + thanhtoan + " " + ngayhetBH.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) ;
    }
}
