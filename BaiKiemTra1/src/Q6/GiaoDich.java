package Q6;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class GiaoDich  implements Serializable{
    private String ma;
    private String ngaygd;
    private double dongia;
    private int soluong;

    public GiaoDich() {
    }

    public GiaoDich(String ma, String ngaygd, double dongia, int soluong) {
        this.ma = ma;
        this.ngaygd = ngaygd;
        this.dongia = dongia;
        this.soluong = soluong;
    }
    
    public double getThanhtien() {
        return soluong*dongia;
    }
    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgaygd() {
        return ngaygd;
    }

    public void setNgaygd(String ngaygd) {
        this.ngaygd = ngaygd;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    public int getNgay() {
        return Integer.parseInt(ngaygd.substring(0,ngaygd.indexOf("/")));
    }
    public int getNam() {
        return Integer.parseInt(ngaygd.substring(ngaygd.lastIndexOf("/")+1));
    }
    @Override
    public String toString() {
        
        return ma + "\t" + ngaygd + "\t" + dongia + "\t" + soluong ;
    }
    
}
