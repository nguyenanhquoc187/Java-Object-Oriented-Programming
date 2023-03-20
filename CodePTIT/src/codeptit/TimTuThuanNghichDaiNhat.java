package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TimTuThuanNghichDaiNhat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> a = new ArrayList<>();
        while (sc.hasNext()) {
            String s= sc.next();
            a.add(s);
        }
        int max = 0;
        ArrayList<String> b = new ArrayList<>();
        for (String i : a ) {
            if (thuanNghich(i) ) {
                if (!b.contains(i)) b.add(i);
                if (i.length() > max ) max = i.length();
            }
        }
        for (String i : b) {
            if (i.length() == max) {
                System.out.println(i + " " + Collections.frequency(a, i));
            }
        }
    }
    public static boolean thuanNghich(String s) {
       StringBuilder s2 = new StringBuilder(s);
       s2.reverse();
       return s2.toString().equals(s);
    }
}
