package codeptit;
import java.util.Scanner;
public class CatDoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            char[] a = s.toCharArray();
            for (int i = 0 ; i < a.length ;i++) {
                if (a[i] == '8' || a[i] == '9') a[i] = '0';
                else if (a[i] == '0' || a[i] == '1') continue;
                else {
                    a[i] = 'i';
                }
            }
            long sum = 0;
            int check = 1, dem =0;
            for (int i = 0 ; i< a.length;i++) {
                if ( a[i] == 'i') check = 0;
                if (a[i] == '0' ) dem++;
                sum = sum*10 + (a[i] - '0');
            }
            if (dem == a.length) check = 0;
            if (check == 1) System.out.println(sum);
            else System.out.println("INVALID");
        }
    }

}
