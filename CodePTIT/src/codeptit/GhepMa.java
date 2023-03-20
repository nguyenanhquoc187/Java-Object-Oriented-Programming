package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class GhepMa {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<String> a = (ArrayList<String>) sc1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>) sc2.readObject();
        Set<String> s1 = new TreeSet<>(a);
        Set<Integer> s2 = new TreeSet<>(b);
        for (String i : s1) {
            for (Integer j : s2) {
                System.out.println(i + j);
            }
        }
    }

}
