package codeptit;
import java.util.*;
public class XauDayDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            int k = sc.nextInt();
            int len = s.length();
            TreeSet<Character> set = new TreeSet<>() ;
            for (int i = 0 ; i< len;i++) set.add(s.charAt(i));
            if (len >= 26 && k >= 26 -set.size() ) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
