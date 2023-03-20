package codeptit;
import java.io.File;
import java.util.*;
public class LietKeTuKhacNhau {
    public static void main(String[] args) throws IOException {
        WordSet1 ws = new WordSet1("VANBAN.IN");
        System.out.println(ws);
    }
    
    
}
class WordSet1 {
        TreeSet<String> setA = new TreeSet<>();
        public WordSet1(String tenfile) throws FileNotFoundException, java.io.FileNotFoundException {
            Scanner sc = new Scanner(new File(tenfile));
            while( sc.hasNext() ) {
                String s = sc.next().toLowerCase();
                setA.add(s);
            }
        }
        @Override
        public String toString() {
            for (String str : setA)
                System.out.println(str);
            return "";
        }
    }