package codeptit;
import java.math.BigInteger;
import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            BigInteger n = sc.nextBigInteger();
            BigInteger m = sc.nextBigInteger();
            BigInteger tong = n.add(m);
            System.out.println(tong);
    }

}
