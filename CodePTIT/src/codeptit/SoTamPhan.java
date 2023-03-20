package codeptit;
import java.util.Scanner;
public class SoTamPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            String s = sc.next();
            System.out.println(check(s));
        }
    }
    public static String check(String s ) {
        for (int i = 0 ; i<  s.length();i++) {
            if ( s.charAt(i) <'0' || s.charAt(i) >'2' ) return "NO"; 
        }
        return "YES";
    }

}
