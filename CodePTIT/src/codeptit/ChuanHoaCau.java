package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ChuanHoaCau {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (true) {
           try {
                String x = sc.nextLine();
                char c = x.charAt(x.length() -1);
                if (c != '.' && c!= '!' && c!= '?') s+= x + '.';
                else s+=x;
           } catch (Exception e) {
               break;
           }
        }
        s = s.toLowerCase().replaceAll("\\s+", " ");
        String tmp = "";
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == '?' || s.charAt(i) == '!' ){
                if (tmp.charAt(tmp.length() - 1) == ' ') tmp = tmp.substring(0, tmp.length() -1);
                tmp+=s.charAt(i);
                tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
                System.out.println(tmp);
                tmp = "";
            }
            else tmp+= s.charAt(i);
        }
    }

}
