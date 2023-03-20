/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

public class DanhSachMuaHang implements Serializable{
    private MatHang mh;
    private KhachHang kh;
    private int soluong;
    private double thanhtien;

    public DanhSachMuaHang(MatHang mh, KhachHang kh, int soluong) {
        this.mh = mh;
        this.kh = kh;
        this.soluong = soluong;
        this.thanhtien = mh.getGiaban()*soluong;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    public String vietTk() {
        return mh.getMa() + ":" + mh.getTenhang();
    }
    
    public Object[] toObject() {
        return new Object[] {
          kh.getMaKh(), kh.getHoten(),
            mh.getMa(), mh.getTenhang(),
            soluong,thanhtien
        };
    }
    
}
