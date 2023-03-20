package codeptit;
import java.util.Scanner;
public class MaTranNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+2][];
        int count =0;
        for (int i = 1 ; i <=n;i++) {
            a[i] = new int[4];
            int dem = 0;
            for (int j = 1; j <=3 ;j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] ==1) dem++;
            }
            if (dem >= 2) count++;
        }
        System.out.println(count);
    }

}
