package codeptit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DiaChiEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        while (t-- > 0) {
            String s = sc.nextLine();
            String a = s.trim();
            a = a.toLowerCase();
            while (a.contains("  ") == true) {
                a = a.replace("  ", " ");
            }
            String arr[] = a.split(" ");
            a = "";
            a = a + arr[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                a = a + arr[i].charAt(0);
            }
            list.add(a);
            if (Collections.frequency(list, a) > 1) {
                a = a + Collections.frequency(list, a);
            } 
            a = a + "@ptit.edu.vn";
            System.out.println(a);
        }
    }
}