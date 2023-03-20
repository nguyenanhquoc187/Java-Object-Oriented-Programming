package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ChuanHoaVaSapXep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));  
        ArrayList<String> a = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            s = chuanhoa(s);
            a.add(s);
        }
        
        
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String  o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                int n = s1.length, m = s2.length;
                String ans1 = s1[n-1], ans2 = s2[m-1];
                for (int i = 0 ; i < n -1 ;i++) ans1+= " " + s1[i];
                for (int i = 0 ; i < m -1 ;i++) ans2+= " " + s2[i];
                return ans1.compareTo(ans2);
            }
        });
        for (String i : a) System.out.println(i);
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
