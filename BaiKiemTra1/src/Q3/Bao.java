package Q3;

import java.util.*;

public class Bao extends TaiLieu implements ITaiLieu{
    private Date ngayph;

    public Bao() {
    }

    public Bao( String ma, String tenNxb, int sobanph, Date ngayph) {
        super(ma, tenNxb, sobanph);
        this.ngayph = ngayph;
    }

    public Date getNgayph() {
        return ngayph;
    }

    public void setNgayph(Date ngayph) {
        this.ngayph = ngayph;
    }

    @Override
    public String getCode() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngayph);
        return getMa().toUpperCase() + cal.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngayph);
        String ngay = cal.get(Calendar.DATE) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
        return getCode() + "\t" + getTenNxb() + "\t" + getSobanph() + ngay;
    }
    
    
    
    
}
