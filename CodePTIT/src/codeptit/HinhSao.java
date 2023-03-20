package codeptit;
import java.util.Scanner;
public class HinhSao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100001];
        int check = 1;
        for (int i = 0 ; i< n-1;i++) {
            int u,v ;
            u = sc.nextInt(); v = sc.nextInt();
            a[u]++;
            a[v]++;
        }
        for (int i =1 ; i<=n ; i++)    if (a[i] >1 && a[i] < n-1 ) check =0;
        if (check == 1) System.out.println("Yes");
        else System.out.println("No");
    }
}
