package codeptit;
import java.math.BigInteger;
import java.util.Scanner;
public class HieuSoNguyenLon1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            BigInteger n = sc.nextBigInteger();
            BigInteger m = sc.nextBigInteger();
            BigInteger a = n.subtract(m);
            String x = n.toString();
            String y = m.toString();
            a = a.abs();
            String z = a.toString();
            int Max = Math.max( x.length() , y.length());
            while ( z.length() < Max) {
                z = "0" + z;
            }
            System.out.println(z);
        }
    }

}
