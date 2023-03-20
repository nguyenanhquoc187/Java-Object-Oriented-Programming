package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA.in") );
        @SuppressWarnings("unchecked")
        ArrayList<Pair> a = (ArrayList<Pair>) sc.readObject();
        ArrayList<Pair> b = new ArrayList<>();
        Collections.sort(a);
        for (Pair i : a) {
            if (i.getFirst()  < i.getSecond() && !b.contains(i)) {
                b.add(i);
                System.out.println(i);
            }
        }
    }

}
