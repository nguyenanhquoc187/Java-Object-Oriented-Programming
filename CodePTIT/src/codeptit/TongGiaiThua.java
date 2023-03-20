package codeptit;
import java.util.Scanner;
public class TongGiaiThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 1; i<=n;i++) {
            sum += factorial(i);
        }
        System.out.print(sum);
    }
    public static long factorial(int n) {
        if (n== 1) return n;
        return n*factorial(n-1);
    }
}
