package Q6;

import java.util.Date;

public class GiaoDichVang extends GiaoDich implements TinhTien{
    private String loaivang;

    public GiaoDichVang() {
    }

    public GiaoDichVang( String ma, String ngaygd, double dongia, int soluong, String loaivang) {
        super(ma, ngaygd, dongia, soluong);
        this.loaivang = loaivang;
    }
    
    @Override
    public double getThanhtien() {
        return super.getThanhtien();
    }
    
    public String getLoaivang() {
        return loaivang;
    }

    public void setLoaivang(String loaivang) {
        this.loaivang = loaivang;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +loaivang + "\t" + getThanhtien();
    }
    
}
