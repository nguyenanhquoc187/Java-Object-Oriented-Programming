package codeptit;
import java.util.Scanner;
public class SoChinhPhuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            double n2 = (double) Math.sqrt(n);
            n = (int) Math.sqrt(n);
            if (n == n2) System.out.println("YES");
            else System.out.println("NO");
         } 
    }

}
