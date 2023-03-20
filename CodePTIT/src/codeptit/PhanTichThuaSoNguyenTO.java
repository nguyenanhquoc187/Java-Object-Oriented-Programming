package codeptit;
import java.util.Scanner;
public class PhanTichThuaSoNguyenTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = 0;
        while ( k != t) {
            int n = sc.nextInt();
            System.out.print("Test " + (k+1) + ": ");
            for (int i = 2 ; i<= Math.sqrt(n);i++) {
                int mu = 0;
                while ( n% i == 0) {
                    mu++;
                    n = n/i;
                }
                if (mu >= 1 ) System.out.print(i + "(" + mu + ") " );
            }
            if (n > 1 ) System.out.print(n + "(1)" );
            System.out.println(" ");
            k++;
        }
    }

}