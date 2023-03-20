package baikiemtra1;

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
    public void nextPhanSo() {
        Scanner sc = new Scanner(System.in);
        tu = sc.nextLong();
        mau = sc.nextLong();
    }
    
    public PhanSo tongPhanSo( PhanSo b) {
        PhanSo c = new PhanSo();
        long mauA = mau, mauB =b.mau, tuA =tu, tuB = b.tu;
        c.mau = mauA*mauB;
        tuA = tuA*mauB; 
        tuB = tuB*mauA;
        c.tu= tuA + tuB;
        return c;
    }
    public PhanSo hieuPhanSo(PhanSo b) {
        PhanSo c = new PhanSo();
        long mauA = mau, mauB =b.mau, tuA =tu, tuB = b.tu;
        c.mau = mauA*mauB;
        tuA = tuA*mauB; 
        tuB = tuB*mauA;
        c.tu= tuA - tuB;
        return c;
    }
    @Override
    public String toString() {
        return tu + "/" + mau;
    }
    
    public long gcd(long a, long b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public long lcm(long a,long b) {
        return (a*b)/gcd(a,b);
    }
     public PhanSo rutgon() {
        long ucln = gcd(tu,mau);
        tu/=ucln;
        mau/=ucln;
        return this;
    }
}


