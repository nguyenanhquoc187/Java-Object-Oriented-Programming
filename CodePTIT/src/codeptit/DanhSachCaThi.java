package codeptit;
import java.util.*;
import java.io.File;
public class DanhSachCaThi {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("CATHI.in"));
        int t = Integer.parseInt(in.nextLine());
        ArrayList<CaThi> a = new ArrayList<>();
        for (int i = 1; i <= t; i++)
            a.add(new CaThi(i, in.nextLine(), in.nextLine(), in.nextLine()));
        Collections.sort(a);
        for (CaThi c : a)
            System.out.println(c);
    }

}
class CaThi implements Comparable<CaThi> {
    private String ma, ngay, gio, phong;

    public CaThi(int stt, String ngay, String gio, String phong) {
        this.ma = "C" + String.format("%03d", stt);
        this.ngay = chuanHoaNgay(ngay);
        this.gio = chuanHoaGio(gio);
        this.phong = phong;
    }

    private String chuanHoaNgay(String ngay) {
        String str[] = ngay.split("/");
        int d = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int y = Integer.parseInt(str[2]);
        return String.format("%02d/%02d/%04d", d, m, y);
    }

    private String chuanHoaGio(String gio) {
        String str[] = gio.split(":");
        int g = Integer.parseInt(str[0]);
        int p = Integer.parseInt(str[1]);
        return String.format("%02d:%02d", g, p);
    }

    public int compareTo(CaThi c) {
        if (this.ngay.compareTo(c.ngay) > 0) return 1;
        else if (this.ngay.compareTo(c.ngay) == 0 && this.gio.compareTo(c.gio) > 0) return 1;
        else if (this.ngay.compareTo(c.ngay) == 0 && this.gio.compareTo(c.gio) == 0 &&
                this.ma.compareTo(c.ma) > 0) return 1;
        return -1;
    }

    @Override
    public String toString() {
        return ma + " " + ngay + " " + gio + " " + phong;
    }
}