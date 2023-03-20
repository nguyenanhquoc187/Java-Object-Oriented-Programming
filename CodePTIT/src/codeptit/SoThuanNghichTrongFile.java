package codeptit;
import java.util.*;
import java.io.*;
public class SoThuanNghichTrongFile {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> data1 = (ArrayList<Integer>) sc1.readObject();
        ArrayList<Integer> data2 = (ArrayList<Integer>) sc2.readObject();
        Set<Integer> set1 = new TreeSet<>(data1);
        Set<Integer> set2 = new TreeSet<>(data2);
        set1.retainAll(set2);
        int dem = 10;
        for( Integer i : set1 ) {
            if ( thuannghich(i) && check2(i) ) {
                System.out.println(i + " " + (Collections.frequency(data1, i) + Collections.frequency(data2, i)  )  );
                dem--;
                if (dem == 0) break;
            } 
        }
        
    }
    public static boolean thuannghich(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        String s2 = String.valueOf(n);
        s.reverse();
        if (s.toString().equals(s2)  ) return true;
        return false;
    }
    public static boolean check2(int n) {
        if (n < 10) return false;
        String s = String.valueOf(n);
        if (s.length() % 2 == 0) return false;
        for (int i = 0 ; i< s.length(); i++) {
            if (s.charAt(i) % 2 == 0) return false;
        }
        return true;
    }
}
