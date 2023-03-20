package codeptit;
import java.util.Scanner;
public class TinhLuyThua {
    static long mod = (long) Math.pow(10,9) + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a ==0 && b==0) break;
            System.out.println(pow(a,b));
        }
    }
    
    public static long pow(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long x = pow(a,b/2) %mod;
        if (b %2 == 0) return (x*x)%mod;
        else return ((x*x) % mod ) *a %mod;
    }
}
