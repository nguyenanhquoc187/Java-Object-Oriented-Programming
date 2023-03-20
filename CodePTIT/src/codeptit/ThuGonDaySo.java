package codeptit;
import java.util.Scanner;
import java.util.ArrayList;
public class ThuGonDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0 ; i< n;i++) a.add(sc.nextInt());
        int i = 0;
        while ( i < a.size() -1) {
            if ( ( a.get(i) + a.get(i+1)) %2 == 0 ) {
                a.remove(i+1);
                a.remove(i);
                if (i!=0) i-=1;
            }
            else i+=1;
        }
        System.out.println(a.size());
    }

}
