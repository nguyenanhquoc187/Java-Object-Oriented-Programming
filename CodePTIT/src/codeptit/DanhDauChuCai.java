package codeptit;
import java.util.*;
public class DanhDauChuCai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<Character> a = new TreeSet<>();
        for (int i = 0 ; i< s.length();i++) a.add( s.charAt(i));
        System.out.println(a.size());
    }

}
