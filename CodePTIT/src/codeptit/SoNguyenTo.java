package codeptit;
import java.util.Scanner;

public class SoNguyenTo {
    public static boolean ktSnt(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n);i++) 
            if (n % i == 0 ) return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            if (ktSnt(n)) System.out.println("YES");
            else System.out.println("NO");
            t--;
        }
    }
}
