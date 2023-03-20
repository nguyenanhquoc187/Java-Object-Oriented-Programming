/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan;

/**
 *
 * @author ADMIN
 */
public class Phong {
    private String kihieu, ten;
    private double  dongia, phi;

    public Phong() {
    }

    public Phong(String kihieu, String ten, double dongia, double phi) {
        this.kihieu = kihieu;
        this.ten = ten;
        this.dongia = dongia;
        this.phi = phi;
    }

    public String getKihieu() {
        return kihieu;
    }

    public String getTen() {
        return ten;
    }

    public double getDongia() {
        return dongia;
    }

    public double getPhi() {
        return phi;
    }
    
}
