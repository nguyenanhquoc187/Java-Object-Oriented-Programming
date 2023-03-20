package codeptit;
import java.util.Scanner;
public class SoLienKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            String s = sc.next();
            int check = 1;
            for (int i = 1 ; i< s.length();i++) {
                if ( Math.abs( s.charAt(i) - s.charAt(i-1) ) != 1 ) {
                    check = 0;
                    break;
                }
            }
            if (check == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
