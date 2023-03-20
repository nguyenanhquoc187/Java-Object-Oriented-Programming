package codeptit;
import java.util.Scanner;
public class TinhThuNhapGiaoVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GiaoVien a = new GiaoVien();
        a.nextGv(sc);
        System.out.println(a.getMangach() + " " + a.gethoten() + " " + a.getBacluong() + " " + a.getPhucap() + " " + a.getSalary() );
    }
}
class GiaoVien {
    private String mangach, hoten;
    private long luong;
    public int getBacluong() {
        return (mangach.charAt(2) - '0')*10 + mangach.charAt(3) - '0';
    }
    public String getChucvu() {
        return mangach.substring(0,2);
    }
    public void nextGv(Scanner sc) {
        mangach = sc.next();
        sc.nextLine();
        hoten = sc.nextLine();
        luong = sc.nextLong();
    }
    public long getPhucap() {
        switch (getChucvu()) {
            case "HT":
                return 2000000;
            case "HP":
                return 900000;
            default:
                return 500000;
        }
    }
    
    public String gethoten() {
        return hoten;
    }
    public String getMangach() {
        return mangach;
    }
    public long getLuong() {
        return luong;
    }
    public long getSalary() {
        return getPhucap() + luong*getBacluong();
    }
}
