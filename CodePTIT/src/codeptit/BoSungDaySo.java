package codeptit;
import java.util.Scanner;
public class BoSungDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+2];
        int Max = 0;
        int[] c = new int[205];
        for (int i = 0 ; i < n;i++) {
            a[i] = sc.nextInt();
            c[a[i] ]++;
            Max = Math.max(a[i], Max);
        }
        int check = 0;
        for (int i = 1; i <= Max;i++) {
            if (c[i] == 0 ) {
                System.out.println(i);
                check = 1;
            }
        }
        if (check == 0)  System.out.println("Excellent!");
    }

}
