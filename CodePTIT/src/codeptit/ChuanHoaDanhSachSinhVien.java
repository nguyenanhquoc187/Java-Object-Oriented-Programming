package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ChuanHoaDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File( "SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i  = 0 ; i< n ; i++ ) {
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String nsinh = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            System.out.println(new SinhVienJ07018(ten, lop, nsinh, gpa));
        }
    }

}
class SinhVienJ07018 {
    private String ma,hoten,lop,nsinh;
    private double gpa;
    private static int j = 1;
    public SinhVienJ07018(String hoten, String lop, String nsinh, double gpa) {
        this.ma = String.format("B20DCCN%03d", j++);
        this.hoten = chuanhoaTen(hoten);
        this.lop = lop;
        this.nsinh = chuanhoaNgaySinh(nsinh);
        this.gpa = gpa;
    }
    private String chuanhoaTen(String ten) {
        ten = ten.trim().toLowerCase();
        String[] a = ten.split("\\s+");
        String s = "";
        for (int i = 0 ; i< a.length ; i++) {
            s+= a[i].substring(0,1).toUpperCase() + a[i].substring(1) + " ";
        }
        return s;
    }
    private String chuanhoaNgaySinh(String nsinh) {
        String[] a = nsinh.split("/");
        int ngay = Integer.parseInt(a[0]);
        int thang = Integer.parseInt(a[1]);
        int nam = Integer.parseInt(a[2]);
        return String.format("%02d/%02d/%4d", ngay, thang, nam);
    }
    public String toString() {
        return ma + " " + hoten + " " + lop + " " + nsinh + " " + String.format("%.2f", gpa);
    }
}
