/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiKT2;

/**
 *
 * @author ADMIN
 */
public class HoaDoanBanSi extends HoaDon implements IHoaDon{
    private boolean tra;

    public HoaDoanBanSi( String ma, String hoten, int soluong, double dongia, boolean tra) {
        super(ma, hoten, soluong, dongia);
        this.tra = tra;
    }

    public boolean isTra() {
        return tra;
    }

    public void setTra(boolean tra) {
        this.tra = tra;
    }

    @Override
    public double getTienTT() {
        if (tra) {
            return super.getSoluong()*super.getDongia()*0.85;
        } else
            return super.getSoluong()*super.getDongia()*0.90;
    }

    @Override
    public String toString() {
        String x;
        if (tra == true) x = "Tra truoc";
        else x = "Tra sau";
        return super.toString() + x + "\t" + getTienTT();
    }
    
    
}
