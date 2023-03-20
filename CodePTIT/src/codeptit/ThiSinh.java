package codeptit;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ThiSinh {
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
    public String tongdiem() {
        DecimalFormat df;
        df = new DecimalFormat("#.#");
        double sum = p1 + p2 + p3;
        return df.format(sum);
    }
    public void display() {
        System.out.println(ten + " " + ngaysinh + " " + tongdiem() );
    }
}
