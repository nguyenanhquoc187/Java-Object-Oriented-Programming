package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class LietKeVaDem {
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String s ="";
        while (sc.hasNextLine()) {
            s+= sc.nextLine() + " ";
        }
        String[] a = s.split("\\s+");
        Map<String,Integer> m = new LinkedHashMap<>();
        for (String i : a) {
            if (checkSoKG(i) ) {
                if ( !m.containsKey(i) ) m.put(i, 1);
                else m.put(i, m.get(i) +1);
            }
        }
        List<Map.Entry<String,Integer> > ds = new LinkedList<>(m.entrySet() );
        Collections.sort(ds, new Comparator<Map.Entry<String, Integer> > () {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String,Integer> it : ds) {
            System.out.println(it.getKey() + " " + it.getValue());
        }
    }
    
    public static boolean checkSoKG(String s) {
        for (int i = 0 ; i < s.length()-1 ;i++) {
            if (s.charAt(i+1) < s.charAt(i) ) return false;
        }
        return true;
    }

}
