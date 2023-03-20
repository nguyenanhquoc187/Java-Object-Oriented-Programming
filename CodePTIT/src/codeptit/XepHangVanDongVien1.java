package codeptit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class XepHangVanDongVien1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VanDongVien> a = new ArrayList<>();
        for (int i = 0 ; i < n ;i++) a.add(new VanDongVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        ArrayList<VanDongVien> b = (ArrayList<VanDongVien>) a.clone();
        Collections.sort(b);
        b.get(0).setRank(1);
        for (int i = 1 ; i < b.size(); i++ ) {
            if (b.get(i).getTTXH().compareTo(b.get(i-1).getTTXH()) == 0) b.get(i).setRank(b.get(i-1).getRank() );
            else b.get(i).setRank(i+1);
        }
        for (VanDongVien i : a) System.out.println(i);
    }

}
class VanDongVien implements Comparable<VanDongVien>{
    private String ma, hoten, ngaysinh;
    private LocalTime batdau, ketthuc;
    private int rank;
    private static int sma = 1;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public VanDongVien() {
        
    }

    public VanDongVien( String hoten, String ngaysinh, String batdau, String ketthuc) {
        this.ma = String.format("VDV%02d", sma++);
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.batdau = LocalTime.parse(batdau, DateTimeFormatter.ISO_LOCAL_TIME);
        this.ketthuc = LocalTime.parse(ketthuc, DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.rank = 0;
    }
    public int getTuoi() {
        return 2021 - Integer.parseInt(ngaysinh.substring(6) );
    }
    public LocalTime getUuTien() {
        int tuoi = getTuoi();
        if (tuoi >= 18 && tuoi < 25) return LocalTime.of(0, 0, 1);
        if (tuoi >= 25 && tuoi <=32) return LocalTime.of(0, 0, 2);
        if (tuoi > 32) return LocalTime.of(0, 0, 3);
        return LocalTime.of(0, 0, 0);
    }
    
    public LocalTime getThanhTich() {
        LocalTime tmp = ketthuc;
        tmp = tmp.minusHours(batdau.getHour());
        tmp = tmp.minusMinutes(batdau.getMinute());
        tmp = tmp.minusSeconds(batdau.getSecond());
        return tmp;
    }
    
    public LocalTime getTTXH() {
        LocalTime x = getUuTien();
        LocalTime y = getThanhTich();
        y = y.minusHours(x.getHour());
        y = y.minusMinutes(x.getMinute());
        y = y.minusSeconds(x.getSecond());
        return y;
    }

    @Override
    public String toString() {
        return ma + " " +  hoten +" " + getThanhTich().format(DateTimeFormatter.ISO_LOCAL_TIME) + " " +
                getUuTien().format(DateTimeFormatter.ISO_LOCAL_TIME ) + " " +getTTXH().format(DateTimeFormatter.ISO_LOCAL_TIME ) + " " + rank; 
    }

    @Override
    public int compareTo(VanDongVien o) {
        return getTTXH().compareTo(o.getTTXH());
    }
    
}
