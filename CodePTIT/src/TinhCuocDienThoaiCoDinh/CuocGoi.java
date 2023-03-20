/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TinhCuocDienThoaiCoDinh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CuocGoi {
    private String goiden;
    private Date batdau,ketthuc;

    public CuocGoi() {
    }

    public CuocGoi(String goiden, String batdau, String ketthuc) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        this.goiden = goiden;
        this.batdau = f.parse(batdau);
        this.ketthuc = f.parse(ketthuc);
    }
    
    public long getSoPhut() {
        long value = ketthuc.getTime() - batdau.getTime();
        TimeUnit phut = TimeUnit.MINUTES;
        return phut.convert(value, TimeUnit.MILLISECONDS);
    }
    
    public boolean isNoiMang() {
        if (goiden.charAt(0) == '0') return false;
        return true;
    }
    
    public String getMaVung() {
        if ( !isNoiMang() ) return goiden.substring(1,3);
        return "";
    }

    public String getGoiden() {
        return goiden;
    }

    public Date getBatdau() {
        return batdau;
    }

    public Date getKetthuc() {
        return ketthuc;
    }
    
}
