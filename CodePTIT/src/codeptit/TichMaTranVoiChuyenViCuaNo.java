package codeptit;
import java.util.*;
public class TichMaTranVoiChuyenViCuaNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int h = 1; h <=t;h++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n+5][m+5];
            for (int i = 1;  i<=n;i++) {
                for (int j = 1 ; j<=m ;j++) a[i][j] = sc.nextInt();
            }
            int[][] b = new int[n+5][m+5];
            for (int i = 1 ; i <=m;i++) {
                for (int j = 1; j<= n;j++) b[i][j] = a[j][i];
            }
            int[][] c = new int[n+5][n+5];
            tichmatran(c, a, b, n, m);            
            System.out.println("Test " + h +":");
            for (int i = 1 ; i <=n;i++) {
                for (int j = 1; j<= n;j++) System.out.print(c[i][j] + " ");
                System.out.println();
            }
        }
    }
    public static void tichmatran(int[][] c, int[][] a, int[][] b, int n , int m) {
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int k = 1; k <= m ; k++) sum = sum + (a[i][k]*b[k][j] );
                c[i][j] = sum;
            }
        }
    }
}
//1 2    1 3     5 
//3 4    2 4