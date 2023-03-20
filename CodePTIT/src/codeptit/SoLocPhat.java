package codeptit;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            int x = (int) (Math.pow(2,n+1) -2);
            System.out.println(x);
            ArrayDeque<Long> q = new ArrayDeque<>();
            q.add((long) 6); q.add((long) 8);
            ArrayList<Long> a = new ArrayList<>();
            while (a.size() < x) {
                long y = q.element();
                q.remove();
                a.add(y);
                q.add(y*10 + 6);
                q.add(y*10 +8);
            }
            for (int i = x-1 ; i>= 0 ;i--) System.out.print(a.get(i) + " ");
            System.out.println();
        }
    }

}
