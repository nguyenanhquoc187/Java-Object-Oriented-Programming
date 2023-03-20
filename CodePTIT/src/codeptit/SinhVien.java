package codeptit;
import java.util.Scanner;

public class SinhVien {
    private String maSv,Hoten,Lop,Ngaysinh;
    private double gpa;
    public static int j = 1;
    public SinhVien() {
        maSv = "B20DCCN001";
        Hoten ="";
        Lop = "";
        Ngaysinh = "";
    }
    public String getmaSv() {
        return maSv;
    }
    public String getHoten() {
        return Hoten;
    } 
    public String getLop() {
        return Lop;
    }
    public String getNgaysinh() {
        return Ngaysinh;
    }
    public double getGpa() {
        return gpa;
    }
    public void setMasv(String maSv) {
        this.maSv = maSv;
    }
    public void setHoten( String Hoten) {
        this.Hoten = Hoten;
    }
    public void setLop(String Lop) {
        this.Lop = Lop;
    }
    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    public void nextSv( Scanner sc) {
        if (j < 10) maSv = "B20DCCN00" + String.valueOf(j);
        else maSv = "B20DCCN0" + String.valueOf(j);
        j++;
        sc.nextLine();
        Hoten = sc.nextLine();
        Lop = sc.nextLine();
        Ngaysinh = sc.nextLine();
        gpa = sc.nextDouble();
    }
    public void chuanHoaNgaysinh() {
        if (Ngaysinh.charAt(2) != '/' ) Ngaysinh = "0" + Ngaysinh;
        if (Ngaysinh.charAt(5) != '/') Ngaysinh = Ngaysinh.substring(0,3) + "0" + Ngaysinh.substring(3);
    }
    public void chuanhoahoten() {
        Hoten = Hoten.trim();
        while (Hoten.contains("  ")) {
            Hoten = Hoten.replace("  ", " ");
        }
        Hoten = Hoten.toLowerCase();
        String[] a = Hoten.split(" ");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        Hoten = s2;
    }
}
