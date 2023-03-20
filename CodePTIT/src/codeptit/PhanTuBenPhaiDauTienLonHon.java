package codeptit;
import java.util.*;
public class PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            int[] a = new int[n+1];
            for (int i = 0 ; i < n;i++ ) {
                a[i] = sc.nextInt();
            }
            for (int i = 0 ; i < n ;i++) {
                int check = 0;
                for (int j = i+1 ; j < n; j++) {
                    if (a[j] > a[i] ) {
                        System.out.print(a[j] + " ");
                        check = 1;
                        break;
                    }
                }
                if (check == 0) System.out.print("-1 ");
            }
            System.out.println("");
        }
    }

}
