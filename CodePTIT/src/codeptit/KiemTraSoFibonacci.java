package codeptit;
import java.util.Scanner;
public class KiemTraSoFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] a = new long[93];
        a[0] = 0; a[1] = 1; a[2] = 1;   
        for (int i = 3; i <=92;i++) a[i] = a[i-1] + a[i-2];
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            int check = 0;
            for (int i = 0 ; i< 92; i++) {
                if (a[i] == n) {
                    check = 1;
                    break;
                }
            }
            if (check == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
