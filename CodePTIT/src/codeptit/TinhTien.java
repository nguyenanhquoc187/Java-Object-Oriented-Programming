package codeptit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TinhTien {
    // So sanh Long dung Long.compare
    private String ma,ten;
    private long soLuong, donGia, chietKhau, tongTien;

    public TinhTien(String ma, String ten, long soLuong, long donGia, long chietKhau) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.chietKhau = chietKhau;
        this.tongTien = soLuong*donGia - chietKhau;
    }

    @Override
    public String toString() {
        return ma+" "+ten+" "+soLuong+" "+donGia+" "+chietKhau+" "+tongTien;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  t = Integer.parseInt(scanner.nextLine());
        ArrayList<TinhTien> list = new ArrayList<>();
        while(t-->0){
            list.add(new TinhTien(scanner.nextLine(),scanner.nextLine(),Long.parseLong(scanner.nextLine()),Long.parseLong(scanner.nextLine()),Long.parseLong(scanner.nextLine())));
        }
        Collections.sort(list, new Comparator<TinhTien>() {
            @Override
            public int compare(TinhTien o1, TinhTien o2) {
                return Long.compare(o2.tongTien,o1.tongTien);
            }
        });
        for(TinhTien x : list)
            System.out.println(x.toString());
    }
}