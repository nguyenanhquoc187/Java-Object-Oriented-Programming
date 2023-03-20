package codeptit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Long> a = new ArrayList<>();
            for (int i = 0 ; i < n ;i++) a.add(sc.nextLong());
            ArrayList<Long> b = (ArrayList<Long>) a.clone();
            Collections.sort(a);
            int k = 0;
            while (true) {
                if (a.equals(b)) break;
                Collections.rotate(a, 1);
                k++;
            }
            System.out.println(k);
        }
    }
}

