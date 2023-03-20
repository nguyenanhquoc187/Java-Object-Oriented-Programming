package codeptit;
import java.util.Scanner;
public class LietKeToHop1 {
    static int n,k, dem = 0;
    static int[] a = new int[25];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ToHop(1);
        System.out.print("Tong cong co " + dem + " to hop");
    }
    
    public static void in() {
        dem++;
        for (int i = 1 ; i<= k;i++) System.out.print(a[i] + " ");
        System.out.println();
    }
    
    public static void ToHop(int i) {
        for (int j = a[i-1] + 1; j <= n-k+i; j++) {
            a[i] = j;
            if (i == k ) in(); else ToHop(i+1);
        }
    }
}
