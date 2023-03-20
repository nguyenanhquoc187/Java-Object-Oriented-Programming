package codeptit;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
public class So0VaSo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(9);
            while(true) {
                int x = q.element();
                if (x % n ==0) {
                    System.out.println(x);
                    break;
                }
                q.remove();
                q.offer(x*10);
                q.offer(x*10 + 9);
            }
        }
    }

}