package Q3;
public class Sach extends TaiLieu{
    private String tentg, tensach;
    private int sotrang;
    public Sach() {
    }
    
    public Sach( String ma, String tenNxb, int sobanph, String tentg, String tensach, int sotrang) {
        super(ma, tenNxb, sobanph);
        this.tentg = tentg;
        this.tensach = tensach;
        this.sotrang = sotrang;
    }

    public String getTentg() {
        return tentg;
    }

    public void setTentg(String tentg) {
        this.tentg = tentg;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    @Override
    public String toString() {
        return "";
    }
    
}
