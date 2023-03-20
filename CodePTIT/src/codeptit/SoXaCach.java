package codeptit;
import java.util.*;
public class SoXaCach {
    
    static int n;
    static int[] a;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            n = sc.nextInt();
            a = new int[n+5];
            check = new int[100];
            for (int i = 0 ; i<= n+1 ;i++) check[i] = 1;
            hoanvi(1);
        }
    }
    public static boolean check1() {
        for (int i = 1 ; i< n ;i++) if ( Math.abs(a[i+1] - a[i])  == 1) return false;
        return true;
    }
    public static void inhoanvi() {
        if (check1() ) {
            for (int i = 1 ; i<= n;i++) System.out.print(a[i]);
            System.out.println();
        }
    }
    public static void hoanvi( int i) {
        for (int j = 1 ; j <= n ; j++) {
            if (check[j] == 1) {
                check[j] = 0;
                a[i] = j;
                if (i == n) inhoanvi();
                else hoanvi( i+1);
                check[j] = 1;
                
            }
        }
    }

}
