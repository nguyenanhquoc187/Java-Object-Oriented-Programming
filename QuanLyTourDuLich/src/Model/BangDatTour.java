/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

public class BangDatTour implements Serializable{
    private KhachHang kh;
    private Tour tour;
    private int songuoiDK;
    private String ngaybd;

    public BangDatTour(KhachHang kh, Tour tour, int songuoiDK, String ngaybd) throws ValidException {
        this.kh = kh;
        this.tour = tour;
        this.songuoiDK = songuoiDK;
        this.ngaybd = ngaybd;
        if (ngaybd.isEmpty()) throw new ValidException();
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getSonguoiDK() {
        return songuoiDK;
    }

    public void setSonguoiDK(int songuoiDK) {
        this.songuoiDK = songuoiDK;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }
    
    public Object[] toObject() {
        return new Object[] {
            kh.getMa(), kh.getHoten(),
            tour.getMa(),tour.getThongtin(),
            songuoiDK,ngaybd
        };
    }
}
