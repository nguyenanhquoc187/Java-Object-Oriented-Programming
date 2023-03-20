package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ThongKeTuKhacNhautrongFileVanBan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/codeptit/input.txt"));
        int n = Integer.parseInt(sc.nextLine());
        String s = "";
        for (int i = 0 ; i< n ; i++) {
            s+= sc.nextLine() + " ";
        }
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