package codeptit;
import java.util.Scanner;
import java.util.TreeSet;
public class HopCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0 ; i< n+m;i++) {
            set.add( sc.nextInt());
        }
        for (int i : set ) System.out.print(i+" ");
    }

}