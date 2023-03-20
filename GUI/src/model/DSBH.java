package model;

import java.io.Serializable;

public class DSBH implements Serializable{
    private NhanVien nv;
    private DichVu dv;
    private int soluong;

    public DSBH(NhanVien nv, DichVu dv, int soluong) {
        this.nv = nv;
        this.dv = dv;
        this.soluong = soluong;
    }
    
    
    
    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public DichVu getDv() {
        return dv;
    }

    public void setDv(DichVu dv) {
        this.dv = dv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public Object[] toObject() {
        return new Object[] {
            nv.getMa(), nv.getHoten(),
            dv.getMa(), dv.getTen(),
            soluong
        } ;
    }
}
