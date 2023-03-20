package codeptit;
import java.util.Scanner;
public class SoKhongLienKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (check1(n) && check2(n) ) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    public static boolean check1(long n) {
        int sum = 0;
        while (n > 0) {
            sum += (n%10);
            n/=10;
        }
        return (sum%10 == 0);
    }
    public static String toString(long n) {
        return n+"";
    }
    public static boolean check2(long n) {
        String s = toString(n);
        for (int i = 1 ; i< s.length();i++) {
            if ( Math.abs( s.charAt(i) - s.charAt(i-1) ) != 2 ) return false;
        }
        return true;
    }
}
