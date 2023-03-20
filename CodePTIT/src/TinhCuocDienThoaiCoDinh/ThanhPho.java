/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TinhCuocDienThoaiCoDinh;
public class ThanhPho {
    private String mavung,ten;
    private int giacuoc;

    public ThanhPho() {
    }

    public ThanhPho(String mavung, String ten, int giacuoc) {
        this.mavung = mavung;
        this.ten = ten;
        this.giacuoc = giacuoc;
    }

    public String getMavung() {
        return mavung;
    }

    public String getTen() {
        return ten;
    }

    public int getGiacuoc() {
        return giacuoc;
    }
    
    
}
