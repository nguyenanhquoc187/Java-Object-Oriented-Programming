package codeptit;
import java.util.Scanner;
import java.util.*;

public class SoDep1 {
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
        for (int i = 0; i < s.length();i++) {
            if ( s.charAt(i) %2 != 0) return false;
        }
        return true;
    }
    public static boolean check2(String s) {
        String a ="";
        for (int i = s.length()-1; i >=0;i--) a+=s.charAt(i);
        return a.equals(s);
    }

}
