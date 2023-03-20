/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LietKeNhanVienTheoNhom;
public class NhanVien implements Comparable<NhanVien>{
    private String ten, chucvu, bacluong, sohieu;

    public NhanVien( String chucvu, String bacluong, String sohieu, String ten) {
        this.ten = ten;
        this.chucvu = chucvu;
        this.bacluong = bacluong;
        this.sohieu = sohieu;
    }

    public NhanVien(String s,String ten) {
        this.ten = ten;
        this.chucvu = s.substring(0,2);
        this.bacluong = s.substring(2,4);
        this.sohieu = s.substring(4);
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public void setBacluong(String bacluong) {
        this.bacluong = bacluong;
    }

    public void setSohieu(String sohieu) {
        this.sohieu = sohieu;
    }

    public String getTen() {
        return ten;
    }

    public String getChucvu() {
        return chucvu;
    }

    public String getBacluong() {
        return bacluong;
    }

    public String getSohieu() {
        return sohieu;
    }

    @Override
    public int compareTo(NhanVien o) {
        int bac1 = Integer.parseInt(bacluong), bac2 = Integer.parseInt(o.bacluong);
        if (bac1 == bac2) return Integer.parseInt(sohieu)- Integer.parseInt(o.sohieu);
        return bac2 - bac1;
    }

    @Override
    public String toString() {
        return ten + " " + chucvu + " " + sohieu + " " + bacluong ; 
    }
    
    
}
