/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ValidException;
import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class QuanLyMuonSach implements Serializable{
    
    private Sach sach;
    private BanDoc bandoc;
    private String tinhtrang;
    private int soluong;

    public QuanLyMuonSach(Sach sach, BanDoc bandoc, String tinhtrang, int soluong) throws ValidException {
        this.sach = sach;
        this.bandoc = bandoc;
        this.tinhtrang = tinhtrang;
        this.soluong = soluong;
        if (tinhtrang.isEmpty()) throw  new ValidException();
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public Object[] toObject() {
        return new Object[] {
            bandoc.getMa(), bandoc.getHoten(),
            sach.getMa(),sach.getTen(),
            tinhtrang, soluong
        };
    }
}
