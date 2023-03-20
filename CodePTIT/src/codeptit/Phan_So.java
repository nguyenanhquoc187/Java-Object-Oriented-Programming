package codeptit;
import java.util.Scanner;
public class Phan_So {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo();
        a.nextPhanSo(sc);
        a.rutgon();
        a.display();
    }
}