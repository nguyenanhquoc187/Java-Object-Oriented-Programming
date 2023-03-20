package Q4;
public class GiangVienHC extends GiangVien implements TinhLuong{
    private double luongthoathuan;

    public GiangVienHC( String ma, String ten, String email, String hocham, String hocvi, String diachi, String sdt, int sogiogiangday, double luongthoathuan) {
        super(ma, ten, email, hocham, hocvi, diachi, sdt, sogiogiangday);
        this.luongthoathuan = luongthoathuan;
    }

    public double getLuongthoathuan() {
        return luongthoathuan;
    }

    public void setLuongthoathuan(double luongthoathuan) {
        this.luongthoathuan = luongthoathuan;
    }
    
    
   
    @Override
    public double getLuong() {
        if (super.getSogiogiangday() > 40) return luongthoathuan*super.getHesoluong() + (super.getSogiogiangday()-40)*50000;
        return luongthoathuan*super.getHesoluong();
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + luongthoathuan + "\t" + getLuong();
    }
    
}
