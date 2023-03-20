/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan;

/**
 *
 * @author ADMIN
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<Phong> p = new ArrayList<>();
        ArrayList<KhachHang> kh = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < n ;i++) {
            String[] s = sc.nextLine().split(" ");
            p.add(new Phong(s[0], s[1], Double.parseDouble(s[2]), Double.parseDouble(s[3])));
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < m ;i++) kh.add(new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        Collections.sort(kh);
        for (KhachHang i : kh) {
            for (Phong j : p) {
                if (i.getKiHieu().equals(j.getKihieu()) ) {
                    int ngay = (int) i.getNgayO();
                    if (ngay == 0) ngay = 1;
                    double thanhtien = (ngay* j.getDongia()*j.getPhi() + ngay*j.getDongia() ) *i.getGiamGia() ;
                    System.out.println( i + " " + String.format("%.2f", thanhtien) );
                }
            }
        }
    }
}
