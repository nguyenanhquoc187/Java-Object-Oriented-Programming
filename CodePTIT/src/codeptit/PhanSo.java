package codeptit;
import java.util.Scanner;
public class PhanSo {
    private long tu,mau;
    public PhanSo() {
        tu = 0; mau = 0;
    }
    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }
    public Scanner nextPhanSo(Scanner sc) {
        tu = sc.nextLong();
        mau = sc.nextLong();
        return sc;
    }
    public static long gcd(long a, long b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static long lcm(long a,long b) {
        return (a*b)/gcd(a,b);
    }
     public void rutgon() {
        long ucln = gcd(tu,mau);
        tu/=ucln;
        mau/=ucln;
    }
    public void tongPhanSo(PhanSo b) {
        long bcnn = lcm(this.mau, b.mau);
        this.tu = this.tu * (bcnn/this.mau);
        b.tu = b.tu * (bcnn/b.mau);
        this.tu+=b.tu;
        this.mau = bcnn; 
    }
    public void tichPhanSo(PhanSo b) {
        this.tu = this.tu*b.tu;
        this.mau = this.mau*b.mau;
    }
    public static PhanSo tongPhanSo(PhanSo a, PhanSo b) {
        PhanSo c = new PhanSo();
        long bcnn = lcm(a.mau, b.mau);
        c.tu = a.tu * (bcnn/a.mau);
        c.tu += b.tu * (bcnn/b.mau);
        c.mau = bcnn;
        return c;
    }
    public static PhanSo tichPhanSo(PhanSo a, PhanSo b ) {
        PhanSo c = new PhanSo();
        c.tu = a.tu*b.tu;
        c.mau = a.mau*b.mau;
        return c;
    }
    public void display() {
        System.out.print(tu + "/" + mau + " ");
    }
    @Override
    public String toString() {
        System.out.print(tu + "/" + mau);
        return "";
    }
}   
