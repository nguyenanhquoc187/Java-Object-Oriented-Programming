package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class HopVaGiaoCuaHaiFileVanBan {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }

}
class WordSet {
    private Set<String> set;
    public WordSet() {
        set = new TreeSet();
    }

    public WordSet(String file) throws FileNotFoundException {
        set = new TreeSet();
        Scanner sc = new Scanner(new File(file) );
        while (sc.hasNext()) {
            String x = sc.next().toLowerCase();
            set.add(x);
        }
    }
    public WordSet union(WordSet b) {
        WordSet c = new WordSet();
        c.set = new TreeSet<>(this.set);
        for (String i : b.set) c.set.add(i);
        return c;
    }
    public WordSet intersection(WordSet b) {
        WordSet c = new WordSet();
        c.set = new TreeSet<>(this.set);
        c.set.retainAll( b.set );
        return c;
    }
    
    public String toString() {
        for (String i : set) {
            System.out.print(i + " ");
        }
        return "";
    }
}