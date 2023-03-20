package codeptit;
import java.text.ParseException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HoaDonKhachSan {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<KhachSan> ds = new ArrayList<>();
        for ( int i = 0 ; i < t ; i++) {
            KhachSan a = new KhachSan(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            ds.add(a);
        }
        Collections.sort(ds);
        for ( KhachSan a : ds) {
            System.out.println(a);
        }
    }
    
}
class KhachSan implements Comparable<KhachSan>{
    private String name , sophong,ma;
    private Date nnp,ntp;
    private long money,thanhtien;
    private int songayo,gtt;

    public KhachSan(int ma ,String name, String sophong, String nnp ,String ntp, long money) throws ParseException {
        this.ma = "KH" + String.format("%02d", ma);
        this.name = name;
        this.name = this.name.trim();
        this.sophong = sophong.trim();
        this.nnp = new SimpleDateFormat("dd/MM/yyyy").parse(nnp);
        this.ntp = new SimpleDateFormat("dd/MM/yyyy").parse(ntp);
        this.money = money;
        this.songayo = sno(this.nnp,this.ntp);
        this.gtt = GTT(sophong);
        this.thanhtien =gtt*songayo + money;
    }

    private int sno(Date nnp, Date ntp) {
        Long value = ntp.getTime() - nnp.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diff = time.convert(value, TimeUnit.MILLISECONDS);
        return (int)diff + 1;
    }

    private int GTT(String sophong) {
        if (sophong.startsWith("1")) return 25;
        else if(sophong.startsWith("2")) return 34;
        else if(sophong.startsWith("3")) return 50;
        return 80;
    }
    @Override
    public String toString() {
        return ma + " " + name + " " +  sophong + " " + songayo + " " + thanhtien;
    }

    @Override
    public int compareTo(KhachSan o) {
        return (this.thanhtien < o.thanhtien) ? 1 : -1;
    }
}