package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.*;
public class LietKeTheoThuTuXuatHien {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<String> res = new ArrayList<>();
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        try {
            ObjectInputStream np = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
            Scanner sc = new Scanner(new File("VANBAN.in"));
            res = (List<String>) np.readObject();
            while (sc.hasNext()) {
                String tmp = sc.next();
                lst2.add(tmp);
            }
        } catch(IOException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        for (String i : res) {
            String[] tmp = i.split("\\s+");
            ArrayList<String> x= new ArrayList<>(Arrays.asList(tmp));
            lst1.addAll(x);
        }
        Map<String,Integer> m = new HashMap<>();
        for (String i : lst2) {
            String s = i.toLowerCase();
            if (!m.containsKey(s) ) {
                m.put(s,1);
                System.out.println(s);
            }
        }
        for (String i : lst1) {
            String s = i.toLowerCase();
            if (!m.containsKey(s) ) {
                m.put(s,1);
                System.out.println(s);
            }
        }
    }
    

}
//1 2 3   c: 3 4 5
//
//
//romove  1 2
//retain 3