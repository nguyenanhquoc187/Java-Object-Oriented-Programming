package Q6;

import java.util.Date;

public class GiaoDichDat extends GiaoDich implements TinhTien{
    private int loaidat;

    public GiaoDichDat() {
    }

    public GiaoDichDat( String ma, String ngaygd, double dongia, int soluong, int loaidat) {
        super(ma, ngaygd, dongia, soluong);
        this.loaidat = loaidat;
    }

    @Override
    public double getThanhtien() {
        return super.getThanhtien()*getHeso(); 
    }
    
    public int getLoaidat() {
        return loaidat;
    }

    public void setLoaidat(int loaidat) {
        this.loaidat = loaidat;
    }
    
    public int getHeso() {
        if (loaidat == 1) return 200;
        if (loaidat == 2) return 400;
        return 800;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + loaidat + "\t" + getThanhtien();
    }
    
}
