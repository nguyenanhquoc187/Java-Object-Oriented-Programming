package Q3;
public class TaiLieu {
    private String ma, tenNxb;
    private int sobanph;
    
    public TaiLieu(String ma, String tenNxb, int sobanph) {
        this.ma = ma;
        this.tenNxb = tenNxb;
        this.sobanph = sobanph;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNxb() {
        return tenNxb;
    }

    public void setTenNxb(String tenNxb) {
        this.tenNxb = tenNxb;
    }

    public int getSobanph() {
        return sobanph;
    }

    public void setSobanph(int sobanph) {
        this.sobanph = sobanph;
    }
    
}
