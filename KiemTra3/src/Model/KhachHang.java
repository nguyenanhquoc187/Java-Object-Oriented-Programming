/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.SodienthoaiException;
import Controller.ValidException;
import java.io.Serializable;

public class KhachHang implements Serializable{
    private int maKh;
    private String hoten,sdt;
    private double tienco;

    public KhachHang(int maKh, String hoten, String sdt, double tienco) throws SodienthoaiException, ValidException {
        this.maKh = maKh;
        this.hoten = hoten;
        this.sdt = sdt;
        this.tienco = tienco;
        if (hoten.isEmpty() ) throw new ValidException();
        if (!sdt.matches("\\d+") ) throw new SodienthoaiException();
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getTienco() {
        return tienco;
    }

    public void setTienco(double tienco) {
        this.tienco = tienco;
    }
    public Object[] toObject() {
        return new Object[] {
          maKh, hoten, sdt,tienco  
        };
    }
}
