package codeptit;
import java.util.Scanner;
import java.util.*;

public class SoDep2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            if (check1(s) && check2(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    public static boolean check1(String s) {
        return (s.charAt(0) =='8' && s.charAt(s.length() - 1) =='8');
    }
    public static boolean check2(String s) {
        int sum = 0;
        for (int i = 0 ; i< s.length();i++) sum= sum + s.charAt(i) - '0';
        return (sum%10 == 0);
    }

}
