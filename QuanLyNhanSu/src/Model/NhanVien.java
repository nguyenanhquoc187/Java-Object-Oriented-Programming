
package Model;

import Controller.ValidException;
import Controller.soDienThoaiException;
import java.io.Serializable;

public class NhanVien implements Serializable{
    private String hoten,dchi,sdt;
    private int ma,bacluong;

    public NhanVien(int ma, String hoten, String dchi, String sdt, int bacluong) throws ValidException, soDienThoaiException {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.sdt = sdt;
        this.bacluong = bacluong;
        if (hoten.isEmpty() || dchi.isEmpty() || sdt.isEmpty()  ) throw new ValidException();
        if (!sdt.matches("\\d+") ) throw new soDienThoaiException();
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBacluong() {
        return bacluong;
    }

    public void setBacluong(int bacluong) {
        this.bacluong = bacluong;
    }
    
    public Object[] toObject() {
        return new Object[] {
            ma,hoten,dchi,sdt,bacluong
        };
    }
}
