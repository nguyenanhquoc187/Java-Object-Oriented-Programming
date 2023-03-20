package codeptit;
import java.util.Scanner;
public class ChuSo4VaChuSo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int dem = 0;
        for (int i = 0 ; i<s.length();i++) {
            if (s.charAt(i) == '4' || s.charAt(i) == '7' ) dem++;
        }
        if (dem == 4 || dem == 7) System.out.print("YES");
        else System.out.print("NO");
    }

}
