package codeptit;
import java.util.Scanner;
public class KhaiBaoLopThiSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh a = new ThiSinh();
        a.nextThiSinh(sc);
        a.display();
    }
}
class ThiSinh {
    private String ten;
    private String ngaysinh;
    private double p1,p2,p3;
    public Scanner nextThiSinh(Scanner sc) {
        ten = sc.nextLine();
        ngaysinh = sc.next();
        p1 = sc.nextDouble();
        p2 = sc.nextDouble();
        p3 = sc.nextDouble();
        return sc;
    }
    public double tongdiem() {
        return p1+ p2 + p3;
    }
    public void display() {
        System.out.printf("%s %s %.1f \n", ten, ngaysinh, tongdiem() );
    }
}

