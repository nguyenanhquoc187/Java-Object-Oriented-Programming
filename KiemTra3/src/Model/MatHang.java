/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;


public class MatHang implements Serializable{
    private int ma;
    private String tenhang,nhomHang;
    private double giaban;

    public MatHang(int ma, String tenhang, String nhomHang, double giaban) throws ValidException {
        this.ma = ma;
        this.tenhang = tenhang;
        this.nhomHang = nhomHang;
        this.giaban = giaban;
        if (tenhang.isEmpty() ) throw new ValidException();
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getNhomHang() {
        return nhomHang;
    }

    public void setNhomHang(String nhomHang) {
        this.nhomHang = nhomHang;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }
    
    public Object[] toObject() {
        return new Object[] {
          ma,tenhang,nhomHang,giaban  
        };
    }
    
}
