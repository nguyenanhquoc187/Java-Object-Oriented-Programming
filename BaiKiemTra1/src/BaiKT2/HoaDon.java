
package BaiKT2;

import java.io.Serializable;

public class HoaDon implements Comparable<HoaDon>, Serializable{
    private String ma, hoten;
    private int soluong;
    private double dongia,thanhtien;

    public HoaDon(String ma, String hoten, int soluong, double dongia) {
        this.ma = ma;
        this.hoten = hoten;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    @Override
    public String toString() {
        return ma + "\t" + hoten + "\t" + soluong + "\t" + dongia + "\t";
    }

    @Override
    public int compareTo(HoaDon o) {
        String ten1 = hoten.substring(hoten.lastIndexOf(" ") + 1) + hoten.substring(0, hoten.lastIndexOf(" "));
        String ten2 = hoten.substring(hoten.lastIndexOf(" ") + 1) + hoten.substring(0, hoten.lastIndexOf(" "));
        return ten1.compareTo(ten2);
    }
    
}
