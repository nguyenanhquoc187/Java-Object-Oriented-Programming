package codeptit;
import java.util.*;
public class XuLyVanBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine()) {
            s+= sc.nextLine();
        }
        s = s.replaceAll("\\s+", " ");
        String cau = "";
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
                cau = cau.trim().toLowerCase();
                cau = cau.substring(0,1).toUpperCase() + cau.substring(1);
                System.out.println(cau);
                cau = "";
            } else {
                cau+=s.charAt(i);
            }
        }
    }

}
