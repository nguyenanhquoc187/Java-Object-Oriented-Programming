package codeptit;
import java.util.Scanner;
public class BienSoDep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            s = s.substring(5);
            s = s.replace(".", "");
            if (check1(s) || check2(s) || check3(s) || check4(s)) 
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean check1(String s) {
        for (int i=0;i<s.length() - 1;i++) if (s.charAt(i) >=s.charAt(i+1) ) return false;
	return true;
    } 
    public static boolean check2(String s) {
        for (int i=0;i<s.length() - 1;i++) if (s.charAt(i)!=s.charAt(i+1)) return false;
	return true;
    } 
    public static boolean check3(String s) {
	return s.charAt(0) == s.charAt(1) && s.charAt(1)==s.charAt(2) && s.charAt(3)==s.charAt(4);
    } 
    public static boolean check4(String s) {
        int dem=0;
	for (int i=0;i<s.length();i++) if (s.charAt(i)=='6' || s.charAt(i)=='8') dem++;
	return (dem == 5);
    } 
}