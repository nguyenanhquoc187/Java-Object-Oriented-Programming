package codeptit;
import java.util.*;
public class DayUuThe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0) {
            String s = sc.nextLine();
            String[] a = s.split("\\s+");
            int n = a.length;
            int chan = 0;
            for (int i = 0 ; i< n;i++) {
                if (Integer.parseInt(a[i]) % 2 == 0) chan++;
            }
            if ( (chan > n -chan && n%2 == 0)  || (chan < n - chan && n%2 == 1) ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
