package codeptit;
import java.util.Scanner;
import java.util.ArrayList;
public class DanhSachKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+3][];
        for (int i = 1; i <= n ;i++) {
            a[i] = new int[n+5];
            for (int j =1 ; j <=n;j++) a[i][j] = sc.nextInt();
        }
        for (int i = 1 ; i <=n;i++) {
            ArrayList<Integer> b = new ArrayList<>();
            for (int j = 1; j<=n;j++) {
                 if (a[i][j] == 1 ) b.add(j);
            }
            System.out.print("List(" + i + ") = ");
            for ( int j : b) System.out.print( j+ " ");
            System.out.println("");
        }
    }

}
