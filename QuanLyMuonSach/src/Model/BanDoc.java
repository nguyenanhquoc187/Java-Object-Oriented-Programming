/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.SodienthoaiException;
import Controller.ValidException;
import java.io.Serializable;

public class BanDoc implements Serializable{
    private int ma;
    private String hoten,dchi,sdt;
    private static int sma = 10000;

    public BanDoc(String hoten, String dchi, String sdt) throws ValidException, SodienthoaiException {
        this.ma = sma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.sdt = sdt;
        if (hoten.isEmpty() || dchi.isEmpty() || sdt.isEmpty() ) throw new ValidException();
        if (!sdt.matches("\\d+") ) throw  new SodienthoaiException();
        sma++;
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

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        BanDoc.sma = sma;
    }
    
    public Object[] toObject() {
        return new Object[] {
            ma,hoten,dchi,sdt
        };
    }
}
