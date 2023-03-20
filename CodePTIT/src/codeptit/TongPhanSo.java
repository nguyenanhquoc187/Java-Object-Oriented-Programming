package codeptit;

import java.util.Scanner;

public class TongPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo();
        PhanSo b = new PhanSo();
        a.nextPhanSo(sc);
        b.nextPhanSo(sc);
        a.tongPhanSo(b);
        a.rutgon();
        a.display();
    }   
}