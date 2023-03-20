package codeptit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ChuanHoaXauHoTenTrongFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("END")) break;
            s = chuanhoa(s);
            System.out.println(s);
        }
    }
    
    public static String chuanhoa(String s) {
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        s = s.toLowerCase();
        String[] a = s.split(" ");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        return s2;
    }

}

