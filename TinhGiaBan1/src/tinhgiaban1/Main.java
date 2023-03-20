
package J05077;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        LinkedHashMap<String, PhongBan> lhm = new LinkedHashMap<>();
        while (n-- > 0) {
            String s = in.nextLine();
            lhm.put(s.substring(0, 2), new PhongBan(s.substring(0, 2), s.substring(3)));
        }
        n = Integer.parseInt(in.nextLine());
        ArrayList<NhanVien> a = new ArrayList<>();
        while (n-- > 0) {
            String s = in.nextLine();
            String ma = s.charAt(3) + "" + s.charAt(4);
            int nam = Integer.parseInt(s.charAt(1) + "" + s.charAt(2));
            char loai = s.charAt(0);
            a.add(new NhanVien(s, in.nextLine(), lhm.get(ma).getTen(), Integer.parseInt(in.nextLine()),
                    Integer.parseInt(in.nextLine()), loai, nam));
        }
        for (NhanVien nv : a)
            System.out.println(nv);
    }
}

class NhanVien {
    private String ma, ten, phongBan;
    private long luongThang;

    public NhanVien(String ma, String ten, String phongBan, int luongCoBan, int soNgayCong, char loai, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.phongBan = phongBan;
        this.luongThang = tinhLuong(luongCoBan, soNgayCong, loai, nam) * 1000;
    }

    private long tinhLuong(int luongCoBan, int soNgayCong, char c, int nam) {
        long tien = luongCoBan * soNgayCong;
        if (c == 'A') {
            if (nam < 4) return tien * 10;
            else if (nam < 9) return tien * 12;
            else if (nam < 16) return tien * 14;
            else return tien * 20;
        } else if (c == 'B') {
            if (nam < 4) return tien * 10;
            else if (nam < 9) return tien * 11;
            else if (nam < 16) return tien * 13;
            else return tien * 16;
        } else if (c == 'C') {
            if (nam < 4) return tien * 9;
            else if (nam < 9) return tien * 10;
            else if (nam < 16) return tien * 12;
            else return tien * 14;
        } else {
            if (nam < 4) return tien * 8;
            else if (nam < 9) return tien * 9;
            else if (nam < 16) return tien * 11;
            else return tien * 13;
        }
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + phongBan + " " + luongThang;
    }

}

class PhongBan {
    private String ma, ten;

    public PhongBan(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
}