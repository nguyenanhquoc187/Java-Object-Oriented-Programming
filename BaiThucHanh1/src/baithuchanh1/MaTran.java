package baithuchanh1;
import java.util.Scanner;

public class MaTran {
    private int[][] a = new int[100][100];
    private int n, m;

    public MaTran(int n, int m) {
        this.n = n;
        this.m = m;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n va m: ");
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1 ; i <= n ;i++) {
            for (int j = 1; j <= m ; j++ ) {
                a[i][j] = sc.nextInt();
            }
        }
    }
    
    public MaTran trans() {
        MaTran b = new MaTran(m, n);
        for (int i = 1 ; i <=m;i++) {
                for (int j = 1; j<= n;j++) b.a[i][j] = this.a[j][i];
            }
        return b;
    }
    
    @Override
    public String toString() {
        for (int i = 1; i <= n;i++) {
            for (int j = 1; j <= m ;j++) System.out.print(a[i][j] + " ");
            System.out.println("");
        }
        return "";
    }
}
