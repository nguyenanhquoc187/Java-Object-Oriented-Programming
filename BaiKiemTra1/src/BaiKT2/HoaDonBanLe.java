/*
 */
package BaiKT2;

/**
 *
 * @author ADMIN
 */
public class HoaDonBanLe extends HoaDon implements IHoaDon{
    private String ngayban;

    public HoaDonBanLe( String ma, String hoten, int soluong, double dongia, String ngayban) {
        super(ma, hoten, soluong, dongia);
        this.ngayban = ngayban;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }
    
    public int getNam() {
        return Integer.parseInt(ngayban.substring(ngayban.lastIndexOf("/")+1));
    }

    @Override
    public double getTienTT() {
        String ngay = ngayban.substring(0,ngayban.lastIndexOf("/"));
        if (ngay.equals("2/4") ) return super.getSoluong()*super.getDongia()*0.95;
        return super.getSoluong()*super.getDongia();
    }

    @Override
    public String toString() {
        return super.toString() + ngayban + "\t" + getTienTT();
    }
}
