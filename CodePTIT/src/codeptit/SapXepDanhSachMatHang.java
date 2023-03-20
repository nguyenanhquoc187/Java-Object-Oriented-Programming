package codeptit;
import java.util.*;
public class SapXepDanhSachMatHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Hang> ds = new ArrayList<>();
        int n = 0;
        while(t-->0){
            n++;
            Hang p = new Hang(n,sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine()));
            ds.add(p);
            
        }
        Collections.sort(ds);
        for(Hang i:ds){
            System.out.println(i);
        }
    }

}

class Hang implements Comparable<Hang>{
    private String ten,loai;
    private int ma;
    private double giamua,giaban,loinhuan;
    public Hang(int ma,String ten,String loai,double giamua,double giaban){
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.giamua = giamua;
        this.giaban = giaban;
        this.loinhuan = giaban - giamua;
        
    }
    
    @Override
    public int compareTo(Hang o ){
        if(this.loinhuan == o.loinhuan) return 0;
        else return (this.loinhuan>o.loinhuan) ?-1:1;
    }
    
    @Override
    public String toString(){
        return ma+" "+ten+" "+loai+" "+String.format("%.2f", loinhuan);
    }
    
}