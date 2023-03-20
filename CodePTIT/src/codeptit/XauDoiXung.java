package codeptit;
import java.util.Scanner;
public class XauDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            int mid = s.length()/2;
            String s1 = s.substring(0,mid);
            if (s.length() % 2 == 1) mid+=1;
            String s2= s.substring(mid);
            int check = 0;
            for (int i = 0 ; i< s1.length();i++)    if (s1.charAt(i) != s2.charAt(s2.length() -1 -i ) ) check++;
            if (check ==1 || (check == 0 && s.length() %2 == 1 ) ) System.out.println("YES");
            else System.out.println("NO");
        }
        
    }
    
}
