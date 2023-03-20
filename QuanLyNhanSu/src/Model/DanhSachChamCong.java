
package Model;

import java.io.Serializable;

public class DanhSachChamCong implements Serializable{
    private NhanVien nv;
    private PhongBan pb;
    private int songay;

    public DanhSachChamCong(NhanVien nv, PhongBan pb, int songay) {
        this.nv = nv;
        this.pb = pb;
        this.songay = songay;
    }
    public String vietTK() {
        return nv.getMa() + ":" + nv.getHoten();
    }
    public int getSalary() {
        return (int) ( 85000*(2 + nv.getBacluong()/3)*pb.getHeso()*songay/22 ) ;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public PhongBan getPb() {
        return pb;
    }

    public void setPb(PhongBan pb) {
        this.pb = pb;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }
    
    public Object[] toObject() {
        return new Object[] {
          nv.getMa(), nv.getHoten(),
          pb.getMa(),pb.getTenphong(),
          songay
        };
    }
    public Object[] toObject2() {
        return new Object[] {
          nv.getMa(), nv.getHoten(),
          getSalary()
        };
    }
}
