package codeptit;
import java.math.BigInteger;
import java.util.Scanner;
public class UocSoChungLonNhatCuaSoNguyenLon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            BigInteger n = sc.nextBigInteger();
            BigInteger m = sc.nextBigInteger();
            BigInteger ucln = n.gcd(m);
            System.out.println(ucln);
        }
    }

}
