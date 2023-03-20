package Q4;
public class GiangVienTG extends GiangVien implements TinhLuong{
    private String coquan;

    public GiangVienTG( String ma, String ten, String email, String hocham, String hocvi, String diachi, String sdt, int sogiogiangday, String coquan) {
        super(ma, ten, email, hocham, hocvi, diachi, sdt, sogiogiangday);
        this.coquan = coquan;
    }

    public String getCoquan() {
        return coquan;
    }

    public void setCoquan(String coquan) {
        this.coquan = coquan;
    }
    
    @Override
    public double getLuong() {
        return super.getHesoluong()*super.getSogiogiangday()*2000000;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + coquan + "\t" + getLuong();
    }
    
}
