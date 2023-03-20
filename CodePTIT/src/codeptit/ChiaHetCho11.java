package codeptit;
import java.math.BigInteger;
import java.util.*;
public class ChiaHetCho11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = new BigInteger("11");
            if (a.mod(b).equals( BigInteger.valueOf(0) ) ) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
