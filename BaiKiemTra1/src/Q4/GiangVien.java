package Q4;
public class GiangVien implements Comparable<GiangVien>{
    private String ma, ten, email, hocham, hocvi, diachi, sdt;
    private int sogiogiangday;
    private double hesoluong;

    public GiangVien() {
    }

    public GiangVien(String ma, String ten, String email, String hocham, String hocvi, String diachi, String sdt, int sogiogiangday) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.hocham = hocham;
        this.hocvi = hocvi;
        this.diachi = diachi;
        this.sdt = sdt;
        this.sogiogiangday = sogiogiangday;
        setHesoluong();
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHocham() {
        return hocham;
    }

    public void setHocham(String hocham) {
        this.hocham = hocham;
    }

    public String getHocvi() {
        return hocvi;
    }

    public void setHocvi(String hocvi) {
        this.hocvi = hocvi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSogiogiangday() {
        return sogiogiangday;
    }

    public void setSogiogiangday(int sogiogiangday) {
        this.sogiogiangday = sogiogiangday;
    }

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong() {
        this.hesoluong = 0;
        if (hocvi.equalsIgnoreCase("Dai hoc")) {
            this.hesoluong+=1;
        } else {
            if (hocvi.equalsIgnoreCase("Thac si") ) this.hesoluong+=1.1;
            else this.hesoluong+=1.2;
        }
        if (hocham.equalsIgnoreCase("Giao su")) this.hesoluong+=0.2;
        else if (hocham.equalsIgnoreCase("Pho giao su")) this.hesoluong+=0.1;
    }
    
    
    
    
    @Override
    public String toString() {
        return ma + "\t" + ten + "\t" +email + "\t" + hocham + "\t" + hocvi + "\t" + diachi + "\t" + sdt + "\t" + sogiogiangday + "\t" + hesoluong;
    }

    @Override
    public int compareTo(GiangVien o) {
        return ten.compareTo(o.getTen());
    }
    
}
