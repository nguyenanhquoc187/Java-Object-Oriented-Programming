package codeptit;
import java.util.Scanner;
public class RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int check = 1;
        while(check == 1) {
            check = 0;
            for (int i = 0 ; i< s.length() - 1;i++) {
                if ( s.charAt(i) == s.charAt(i+1) ) {
                    s = s.substring(0,i) + s.substring(i+2);
                    check = 1;
                    break;
                }
            }
        }
        if (s.length() == 0) System.out.println("Empty String");
        else System.out.println(s);
    }

}
