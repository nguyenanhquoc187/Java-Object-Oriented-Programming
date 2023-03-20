package codeptit;
import java.util.Scanner;
class Numbers {
    public static boolean ktSnt(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n);i++) 
            if (n % i == 0 ) return false;
        return true;
    }
}
public class CodePTIT {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "123";
        if ( s.charAt(0) - s.charAt(1) == -1) {
        }
    }
    
}
