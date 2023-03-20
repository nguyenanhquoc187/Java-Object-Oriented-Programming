package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ThoiGianOnlineLientuc {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Online> a = new ArrayList<>();
        for (int i = 0 ; i < t ; i++) {
            Online tmp = new Online();
            tmp.input(sc);  
            a.add(tmp);
        }
        Collections.sort(a);
        for (Online it: a) System.out.println(it);
    }

}
class Online implements Comparable<Online>{
    private String name;
    private Date timeStart, timeEnd;
    public void input(Scanner sc) throws ParseException {
        name = sc.nextLine();
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        timeStart = fm.parse(sc.nextLine());
        timeEnd = fm.parse(sc.nextLine());
    }
    public long getMinute() {
        return (timeEnd.getTime() - timeStart.getTime()) / (1000*60);
    }
    @Override
    public int compareTo(Online o) {
        
        if (this.getMinute() == o.getMinute() && this.name.compareTo(o.name) > 0) return 1;
        if (this.getMinute() < o.getMinute() ) return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return name + " " + getMinute();
    }
    
}