package baikiemtra1;
import java.util.Scanner;


public class MaTran {
    private int[][] a ;
    private int n;
    
    public void input() {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        a = new int[n+1][n+1];
        for (int i = 1; i <=n;i++) {
            for (int j = 1; j <=n ;j++) a[i][j] = sc.nextInt();
        }
    }
    public void Hangsoduongchan() {
        for (int i = 1 ; i<= n;i++ ) {
            int dem = 0;
            for (int j = 1 ; j <=n;j++) {
                if (a[i][j] % 2 == 0 && a[i][j] >0) dem++;
            }
            if (dem == n) {
                for (int j = 1; j <=n;j++) System.out.print(a[i][j] + " ");
                System.out.println();
            }
        }
    }
}
