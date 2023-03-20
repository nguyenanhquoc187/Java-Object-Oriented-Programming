package codeptit;
import java.util.*;
public class CapSoCoTongBangK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            Map<Long,Long> m = new LinkedHashMap<>();
            for (int i = 0 ; i < n ;i++) {  
                long x = sc.nextLong();
                if (m.get(x) == null) m.put(x, (long)1);
                else m.put(x, m.get(x) + 1);
            }
            long dem = 0;
            for (Map.Entry<Long,Long> i : m.entrySet() ) {
                if (m.get(k - i.getKey() ) != null) {
                    if (k -i.getKey() != i.getKey()) dem += i.getValue()*m.get(k-i.getKey()) ;
                    else {
                        long u = i.getValue()-1;
                        dem+= u*(1 +u);
                    }
                }
            }
            System.out.println(dem/2);
        }
    }

}
