package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SapXepMaTran {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int col = sc.nextInt();
            int[][] a = new int[n+1][m+1];
            for (int i = 1; i <= n;i++){
                for (int j = 1 ; j <=m;j++) a[i][j] = sc.nextInt();
            }
            int[] b = new int[n+1];
            for (int i = 1 ; i <= n;i++) b[i] = a[i][col];
            Arrays.sort(b);
            for (int i = 1; i <=n ;i++) a[i][col] = b[i];
            for (int i = 1; i <= n;i++){
                for (int j = 1 ; j <=m;j++) System.out.print(a[i][j] + " ");
                System.out.println("");
            }
        }
    }

}
