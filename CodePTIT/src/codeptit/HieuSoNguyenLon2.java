package codeptit;
import java.math.BigInteger;
import java.util.Scanner;
public class HieuSoNguyenLon2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();
        System.out.println(n.subtract(m));
    }

}
