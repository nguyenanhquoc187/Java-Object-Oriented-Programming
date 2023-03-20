package codeptit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class SoKhacNhauTrongFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Code\\JavaOOP\\CodePTIT\\src\\codeptit\\Hello.txt");
        Scanner sc = new Scanner(file);
        ArrayList<Integer> a = new ArrayList<>();
        while (sc.hasNext()) {
            a.add( sc.nextInt() );
        }
        TreeSet<Integer> set = new TreeSet<>(a);
        for (int i : set ) {
            System.out.println(i + " " + Collections.frequency(a, i));
        }
    }

}