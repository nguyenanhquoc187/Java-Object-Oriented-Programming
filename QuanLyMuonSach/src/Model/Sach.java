/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

public class Sach implements Serializable{
    private int ma, soluong;
    private String ten,tacgia, cnganh,nxb;
    private static int sma = 10000;

    public Sach(int ma,  String ten, String tacgia, String cnganh, String nxb,int soluong) throws ValidException {
        this.ma = ma;
        this.soluong = soluong;
        this.ten = ten;
        this.tacgia = tacgia;
        this.cnganh = cnganh;
        this.nxb = nxb;
        if (ten.isEmpty() || tacgia.isEmpty() || nxb.isEmpty()) throw new ValidException();
    }

    public Sach( String ten, String tacgia, String cnganh, String nxb, int soluong) throws ValidException {
        this.ma = sma;
        this.soluong = soluong;
        this.ten = ten;
        this.tacgia = tacgia;
        this.cnganh = cnganh;
        this.nxb = nxb;
        if (ten.isEmpty() || tacgia.isEmpty() || nxb.isEmpty()) throw new ValidException();
        sma++;
    }

    public String getCnganh() {
        return cnganh;
    }

    public void setCnganh(String cnganh) {
        this.cnganh = cnganh;
    }

    public int getMa() {
        return ma;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Sach.sma = sma;
    }
    
    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }
    
    public Object[] toObject() {
        return new Object[] {
            ma,ten,tacgia,nxb,soluong
        };
    }
    
}
