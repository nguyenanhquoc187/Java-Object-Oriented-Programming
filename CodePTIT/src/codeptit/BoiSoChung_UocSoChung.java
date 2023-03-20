package codeptit;
import java.util.Scanner;
public class BoiSoChung_UocSoChung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0) {
            long a = sc.nextLong(); 
            long b = sc.nextLong();
            System.out.println(PhanSo.lcm(a, b) + " " + PhanSo.gcd(a, b));
        }
    }

}