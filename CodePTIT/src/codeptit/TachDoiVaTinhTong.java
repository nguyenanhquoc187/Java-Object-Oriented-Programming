package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
public class TachDoiVaTinhTong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
//        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        BigInteger so9 = new BigInteger("9");
        BigInteger sum = new BigInteger(s) ;
        while (sum.compareTo(so9) == 1 ) {
            sum = BigInteger.valueOf(0);
            String n1 = s.substring(0, s.length()/2);
            String n2 = s.substring( s.length()/2);
            BigInteger a = new BigInteger(n1);
            BigInteger b = new BigInteger(n2);
            sum = sum.add(a);
            
            sum  = sum.add(b);
            s = sum.toString();
            System.out.println(sum);
        }
    }

}
