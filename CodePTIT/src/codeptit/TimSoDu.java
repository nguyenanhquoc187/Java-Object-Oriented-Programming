package codeptit;
import java.util.*;
import java.math.*;
public class TimSoDu {
    public static void main(String[] main) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
           BigInteger a = in.nextBigInteger();
           BigInteger b = new BigInteger("4");
           BigInteger k = a.mod(b);
           if(k.intValue() == 0){
               System.out.println(4);
           }
           else{
               System.out.println(0);
           }

        }
    }
}