package codeptit;
import java.util.Scanner;
public class MangDoiXung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t>0) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i =0 ; i < n ;i++) a[i] = input.nextInt();
            int check = 1;
            for (int i = 0 ; i < n ;i++) 
                if (a[i] != a[n -i -1] ) check = 0;
            if (check == 1) System.out.println("YES");
            else System.out.println("NO");
            t--;
        }
    }

}
