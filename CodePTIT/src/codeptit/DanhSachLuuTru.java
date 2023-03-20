package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DanhSachLuuTru {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("D:\\Code\\JavaOOP\\CodePTIT\\src\\codeptit\\Hello.txt"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachSan> a = new ArrayList<>();
        for (int i = 1 ; i <= n ;i++) {
            a.add(new KhachSan(i,sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine() ) );
        }
        
        Collections.sort(a);
        for (int i =0 ; i < n ;i++) System.out.print(a.get(i));
    }

}
class KhachSan implements Comparable<KhachSan> {
    private String ID, Name, roomCode, arrivalDate, leaveDate;
    private long songay;
    public KhachSan () {
        
    }
    public KhachSan(int index, String Name, String roomCode, String arrivalDate, String leaveDate) throws ParseException {
        if (index < 10) this.ID = "KH0" + String.valueOf(index);
        else this.ID = "KH" + String.valueOf(index);
        this.Name = Name;
        this.roomCode = roomCode;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        Date den = new SimpleDateFormat("dd/MM/yyyy").parse(this.arrivalDate);
        Date di = new SimpleDateFormat("dd/MM/yyyy").parse(this.leaveDate);
        this.songay = ((di.getTime() - den.getTime()) / (1000 * 60 * 60 * 24)) % 365;
    }
    
    
    @Override
    public int compareTo(KhachSan x) {
        if (this.songay <= x.songay) return 1;
        return -1;
   }
    @Override
    public String toString() {
        System.out.println(ID + " " + Name + " " + roomCode + " " + songay);
        return "";
    }
}
