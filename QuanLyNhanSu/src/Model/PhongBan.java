/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

public class PhongBan implements  Serializable{
    private int ma;
    private String tenphong, mota;
    private double heso;

    public PhongBan(int ma, String tenphong, String mota, double heso) throws ValidException {
        this.ma = ma;
        this.tenphong = tenphong;
        this.mota = mota;
        this.heso = heso;
        if (tenphong.isEmpty() || mota.isEmpty() ) throw new ValidException();
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getHeso() {
        return heso;
    }

    public void setHeso(double heso) {
        this.heso = heso;
    }
    
    public Object[] toObject() {
        return new Object[] {
          ma,tenphong,mota,heso  
        };
    }
}
