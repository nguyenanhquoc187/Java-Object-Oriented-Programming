/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan;

/**
 *
 * @author ADMIN
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class KhachHang implements Comparable<KhachHang> {
    private String ma,hoten, maphong;
    private Date den, di;
    private static int sma= 1;

    public KhachHang() {
    }

    public KhachHang( String hoten, String maphong, String den, String di) throws ParseException {
        this.ma = String.format("KH%02d", sma++);
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        this.hoten = hoten;
        this.maphong = maphong;
        this.den = f.parse(den);
        this.di = f.parse(di);
    }
    
    public long getNgayO() {
        long value = di.getTime() - den.getTime();
        TimeUnit t = TimeUnit.DAYS;
        long ngay = t.convert(value, TimeUnit.MILLISECONDS);
        return ngay;
    }
    
    public double getGiamGia() {
        if (getNgayO() < 10) return 1.0;
        if ( getNgayO() < 20) return 0.98;
        if (getNgayO() < 30) return 0.96;
        return 0.94;
    }
    
    public String getKiHieu() {
        return maphong.substring(2,3);
    }

    public String getMa() {
        return ma;
    }

    public String getHoten() {
        return hoten;
    }

    public String getMaphong() {
        return maphong;
    }

    public Date getDen() {
        return den;
    }

    public Date getDi() {
        return di;
    }

    public static int getSma() {
        return sma;
    }

    @Override
    public int compareTo(KhachHang o) {
        return (int) (o.getNgayO() - getNgayO());
    }

    @Override
    public String toString() {
        return  ma + " " + hoten + " " + maphong + " " + getNgayO() ;
    }
    
}
