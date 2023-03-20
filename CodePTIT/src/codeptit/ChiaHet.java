package codeptit;
import java.math.BigInteger;
import java.util.*;
public class ChiaHet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            if (a.mod(b).equals( BigInteger.valueOf(0) ) ||  b.mod(a).equals( new BigInteger("0") )  ) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
