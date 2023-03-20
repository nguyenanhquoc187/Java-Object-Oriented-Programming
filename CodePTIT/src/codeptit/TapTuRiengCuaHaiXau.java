package codeptit;
import java.util.*;
public class TapTuRiengCuaHaiXau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            TreeSet<String> x = new TreeSet<>(Arrays.asList( s1.split(" ")) );
            TreeSet<String> y = new TreeSet<>(Arrays.asList( s2.split(" ")));
            x.removeAll(y);
            for (String i : x) System.out.print(i+ " ");
            System.out.println();
            
        }
    }

}
