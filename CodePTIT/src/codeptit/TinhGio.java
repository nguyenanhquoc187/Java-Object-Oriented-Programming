package codeptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TinhGio {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Gamer> a = new ArrayList<>();
        for (int i = 0 ; i < t; i++) {
            Gamer tmp = new Gamer();
            tmp.input(sc);
            a.add(tmp);
        }
        Collections.sort(a);
        for (Gamer it : a) System.out.println(it);
    }
}
class Gamer implements Comparable<Gamer>{
    private String code, name;
    private Date timeIn, timeOut;
    public void input(Scanner sc) throws ParseException {
        code = sc.nextLine();
        name = sc.nextLine();
        SimpleDateFormat fm = new SimpleDateFormat("hh:mm");
        timeIn = fm.parse(sc.nextLine());
        timeOut = fm.parse(sc.nextLine());
    }
    
    public long getMinuteUse() {
        return (timeOut.getTime() - timeIn.getTime()) / (1000*60);
    }
    public int compareTo(Gamer o) {
        if (this.getMinuteUse() < o.getMinuteUse() ) return 1;
        return -1;
    }
    
    public String toString() {
        return code + " " + name + " " + (int) (getMinuteUse()/60) + " gio " + getMinuteUse()%60  + " phut"   ;
    }
}
