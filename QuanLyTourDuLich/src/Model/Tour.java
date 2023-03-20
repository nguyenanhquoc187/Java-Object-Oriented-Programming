/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

public class Tour implements Serializable{
    private int ma;
    private String kieu,thongtin;
    private double dongia;

    public Tour(int ma, String kieu, String thongtin, double dongia) throws ValidException {
        this.ma = ma;
        this.kieu = kieu;
        this.thongtin = thongtin;
        this.dongia = dongia;
        if (thongtin.isEmpty()) throw new ValidException();
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    
    public Object[] toObject() {
        return new Object[] {
            ma,kieu,thongtin,dongia
        };
    }
}
