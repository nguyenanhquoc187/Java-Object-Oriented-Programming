package codeptit;
import java.util.*;

public class QuanLyBanHang2 {
    static ArrayList<KhachHang> kh = new ArrayList<>();
    static ArrayList<MatHang> mh = new ArrayList<>();
    static ArrayList<HoaDon> hd = new ArrayList<>();

    public static KhachHang findKH(String khachHang) {
        String tmp = khachHang.charAt(2) + "" + khachHang.charAt(3) + "" + khachHang.charAt(4);
        int inDex = Integer.parseInt(tmp) - 1;
        return kh.get(inDex);
    }

    public static MatHang findMH(String matHang) {
        String tmp = matHang.charAt(2) + "" + matHang.charAt(3) + "" + matHang.charAt(4);
        int inDex = Integer.parseInt(tmp) - 1;
        return mh.get(inDex);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= n; i++)
            kh.add(new KhachHang(i, in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine()));
        n = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= n; i++)
            mh.add(new MatHang(i, in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine()),
                    Integer.parseInt(in.nextLine())));
        n = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= n; i++) {
            hd.add(new HoaDon(i, findKH(in.next()), findMH(in.next()), (in.nextInt())));
            in.nextLine();
        }
        Collections.sort(hd);
        for (HoaDon h : hd)
            System.out.println(h);
    }
}
class KhachHang {
    private String maKH, tenKH, gioiTinh, ngaySinh, diaChi;

    public KhachHang(int stt, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = "KH" + String.format("%03d", stt);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return tenKH + " " + diaChi + " ";
    }
}
class HoaDon implements Comparable<HoaDon> {
    private KhachHang khachHang;
    private MatHang matHang;
    private String maHD;
    private int soLuong;
    private long thanhTien, loiNhuan;

    public HoaDon(int stt, KhachHang khachHang, MatHang matHang, int soLuong) {
        this.maHD = "HD" + String.format("%03d", stt);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
        this.thanhTien = matHang.getGiaBan() * soLuong;
        this.loiNhuan = thanhTien - matHang.getGiaMua() * soLuong;
    }

    public int compareTo(HoaDon h) {
        if (this.loiNhuan <= h.loiNhuan) return 1;
        return -1;
    }

    @Override
    public String toString() {
        return maHD + " " + khachHang + matHang + soLuong + " " + thanhTien + " " + loiNhuan;
    }
}

class MatHang {
    private String maMH, tenMH, donViTinh;
    private int giaMua, giaBan;

    public MatHang(int stt, String tenMH, String donViTinh, int giaMua, int giaBan) {
        this.maMH = "MH" + String.format("%03d", stt);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return tenMH + " ";
    }
}