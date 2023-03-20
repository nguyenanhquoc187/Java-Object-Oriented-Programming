package codeptit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SapXepDonHang {
    private String ten, ma, stt;
    private int donGia, soLuong, giamGia, thanhTien;

    public SapXepDonHang(String ten, String ma, int donGia, int soLuong) {
        this.ten = ten;
        this.ma = ma;
        this.stt = ma.substring(1,4);
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.giamGia = getGiamGia();
        this.thanhTien = donGia*soLuong - giamGia;
    }

    private int getGiamGia() {
        if(ma.charAt(4) == '1') {
            return (int) (0.5 * donGia * soLuong);
        }
        return (int) (0.3 * donGia * soLuong);
    }

    @Override
    public String toString() {
        return ten+" "+ma+" "+stt+" "+giamGia+" "+thanhTien;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SapXepDonHang> ds = new ArrayList<>();
        int t = Integer.parseInt(scanner.nextLine());
        while(t-->0){
            SapXepDonHang p = new SapXepDonHang(scanner.nextLine(), scanner.nextLine(),Integer.parseInt(scanner.nextLine()),Integer.parseInt(scanner.nextLine()));
            ds.add(p);
        }
        Collections.sort(ds, new Comparator<SapXepDonHang>() {
            @Override
            public int compare(SapXepDonHang o1, SapXepDonHang o2) {
                return Integer.parseInt(o1.stt) - Integer.parseInt(o2.stt);
            }
        });
        for(SapXepDonHang x : ds)
            System.out.println(x.toString());
    }
}