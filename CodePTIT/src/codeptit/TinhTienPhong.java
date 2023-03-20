package codeptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TinhTienPhong {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang1> a = new ArrayList<>();
        for (int i = 0 ; i < n;i++) 
            a.add(new KhachHang1(i+1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine() )));
        Collections.sort(a);
        for (int i = 0 ; i < n;i++)
            System.out.println(a.get(i));
    }

}
class KhachHang1 implements Comparable<KhachHang1> {
    private String code,name, roomNumber, arriveDay, leaveDay;
    private long seviceChange, liveDay;

    public KhachHang1(int index,String name, String roomNumber, String arriveDay, String leaveDay, long seviceChange) throws ParseException {
        if (index < 10) code = "KH0" + String.valueOf(index);
        else code = "KH" + String.valueOf(index);
        this.name = chuanhoa(name);
        this.roomNumber = roomNumber;
        this.arriveDay = chuanHoaNgay(arriveDay);
        this.leaveDay = chuanHoaNgay(leaveDay);
        this.seviceChange = seviceChange;
        Date arriveTime = new SimpleDateFormat("dd/MM/yyyy").parse(arriveDay);
        Date leaveTime = new SimpleDateFormat("dd/MM/yyyy").parse(leaveDay);
        this.liveDay = ((leaveTime.getTime() - arriveTime.getTime()) / (1000*60*60*24) ) + 1;
    }
    
    public char getFloor() {
        return roomNumber.charAt(0);
    }
    public int getFloorPrice(char Floor) {
        switch (Floor) {
            case '1': return 25;
            case '2': return 34;
            case '3': return 50;
            case '4': return 80;
        }
        return 0;
    }
    public long getPay() {
        return getFloorPrice(getFloor() )*liveDay + seviceChange;
    }
    
    
    public static String chuanHoaNgay(String ngay) {
        if (ngay.charAt(2) != '/' ) ngay = "0" + ngay;
        if (ngay.charAt(5) != '/') ngay = ngay.substring(0,3) + "0" + ngay.substring(3);
        return ngay;
    }
    public static String chuanhoa(String s) {
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        s = s.toLowerCase();
        String[] a = s.split(" ");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        return s2;
    }
    
    @Override
    public int compareTo(KhachHang1 o) {
        if (this.getPay() <= o.getPay() ) return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " + roomNumber + " " +liveDay + " " + getPay();
    }
    
}
