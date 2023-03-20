package Q6;

import java.util.Date;

public class GiaoDichTienTe extends GiaoDich implements TinhTien{
    private double tigia;
    private String loaitiente;

    public GiaoDichTienTe() {
    }

    public GiaoDichTienTe( String ma, String ngaygd, double dongia, int soluong, double tigia, String loaitiente) {
        super(ma, ngaygd, dongia, soluong);
        this.tigia = tigia;
        this.loaitiente = loaitiente;
    }

    @Override
    public double getThanhtien() {
        if (loaitiente.equalsIgnoreCase("USD") || loaitiente.equalsIgnoreCase("Euro") ) return super.getThanhtien()*tigia;
        return super.getThanhtien();
    }
    
    public double getTigia() {
        return tigia;
    }

    public void setTigia(double tigia) {
        this.tigia = tigia;
    }

    public String getLoaitiente() {
        return loaitiente;
    }

    public void setLoaitiente(String loaitiente) {
        this.loaitiente = loaitiente;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + tigia + "\t" + loaitiente + "\t" + getThanhtien();
    }
    
    
}
