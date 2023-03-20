package codeptit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class ThongKeTuKhacNhauTrongFileNhiPhan {
    public static void main(String[] args) {
        List<String> lst = IOFile.doc("DATA.in");
        String s = "";
        for (String i : lst) s = s + i + " ";
        s = s.replaceAll("\\W", " ").toLowerCase();
        s = s.replaceAll("\\s+", " ");
        ArrayList<String> tmp = new ArrayList<>(Arrays.asList(s.split(" ")));
        Set<String> set = new TreeSet<>();
        set.addAll(tmp);
        ArrayList<Words> a = new ArrayList<>();
        for (String i : set) {
            a.add(new Words(i, Collections.frequency(tmp, i)));
        }
        Collections.sort(a);
        for (Words i : a) System.out.println(i);
    }

}

class Words implements Comparable<Words> {
    private int solanXh;
    private String tu;

    public Words(String tu,int solanXh ) {
        this.solanXh = solanXh;
        this.tu = tu;
    }
    @Override
    public int compareTo(Words o) {
        if (solanXh == o.solanXh) return tu.compareTo(o.tu);
        return o.solanXh- solanXh;
    }

    @Override
    public String toString() {
        return tu + " " + solanXh;
    }
    
}

class IOFile {
    
    public static <T> List<T> doc(String fname) {
        List<T> lst = new ArrayList<>();
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(fname));
            lst = (List<T>) o.readObject();
            o.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return lst;
    }
    
    public static <T> void viet(String fname, List<T> arr) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fname));
            o.writeObject(arr);
            o.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}