package codeptit;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class GiaoCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> u1 = new TreeSet() ;
        Set<Integer> u2 = new TreeSet();
        for (int i = 0 ; i < n;i++) u1.add(sc.nextInt());
        for (int i = 0 ; i < m;i++) u2.add(sc.nextInt());
        u1.retainAll(u2);
        for (int i : u1) System.out.print(i + " ");
    }

}
