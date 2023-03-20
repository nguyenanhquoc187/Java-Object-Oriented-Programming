package codeptit;
import java.util.Scanner;
public class DaoTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0) {
            String s = sc.nextLine();
            String[] a = s.split(" ");
            for (int i = 0 ; i< a.length;i++) {
                a[i] = reverse(a[i]);
            }
            for (String i : a) System.out.print(i + " ");
            System.out.println();
        }
    }
    
    public static String reverse(String s) {
        String a = "";
        for (int i = s.length()- 1; i>=0;i--) a+=s.charAt(i);
        return a;
    }
}
