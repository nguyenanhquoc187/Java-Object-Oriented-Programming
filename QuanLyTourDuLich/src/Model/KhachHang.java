/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

public class KhachHang implements Serializable{
    private int ma;
    private String hoten,kieu;

    public KhachHang(int ma, String hoten, String kieu) throws ValidException {
        this.ma = ma;
        this.hoten = hoten;
        this.kieu = kieu;
        if (hoten.isEmpty()) throw new ValidException();
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

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }
    
    public Object[] toObject() {
        return new Object[] {
            ma,hoten,kieu
        };
    }
}
