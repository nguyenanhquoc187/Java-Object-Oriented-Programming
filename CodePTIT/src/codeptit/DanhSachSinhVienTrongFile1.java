package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class DanhSachSinhVienTrongFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SINHVIEN.in"));
        int n = sc.nextInt();
        sc.nextLine();
//      else int n = Integer.valueOf(sc.nextLine() );
        ArrayList< Sinhvien> a = new ArrayList<>();
        for (int i = 0 ; i < n ;i++) {
            Sinhvien x  = new Sinhvien();
            x.nextsv(sc);
            a.add(x);
        }
        Collections.sort(a, (Sinhvien a1, Sinhvien b) -> a1.getMasv().compareTo(b.getMasv()));
        for (int i = 0 ; i < n ;i++) 
            System.out.println( a.get(i) );
    }
    
}

class Sinhvien {
    private String masv,hoten,lop,email;
    
    public void nextsv(Scanner sc) {
//        sc.nextLine();
        masv = sc.nextLine();
        hoten = sc.nextLine();
        lop = sc.nextLine();
        email = sc.nextLine();
        hoten = chuanhoa(hoten);
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMasv() {
        return masv;
    }

    public String getLop() {
        return lop;
    }

    public String getHoten() {
        return hoten;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        System.out.print(masv + " " + hoten + " " + lop + " " + email);
        return "";
    }
    public static String chuanhoa(String s) {
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        s = s.toLowerCase();
        String[] a = s.split(" ");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        return s2;
    }
}
