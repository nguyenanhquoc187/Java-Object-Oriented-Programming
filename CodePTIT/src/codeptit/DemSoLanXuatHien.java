package codeptit;
import java.util.Scanner;
public class DemSoLanXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 1; j <=t;j++) {
            int[] c = new int[1000000];
            int n = sc.nextInt();
            int[] a = new int[n+5];
            int[] b = new int[1000000];
            for (int i = 0 ; i < n ;i++) {
                a[i] =  sc.nextInt();
                c[a[i]]++;
            }
            System.out.println("Test " + j + ":");
            for (int i = 0; i < n;i++) {
                if ( b[a[i]] == 0 ) {
                    System.out.println(a[i] + " xuat hien " + c[a[i]] + " lan");
                    b[a[i]] = 1;
                }
            }
        }
    }

}
