package codeptit;
import java.util.*;
public class BangDiemHocSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = Integer.parseInt(sc.nextLine());
        ArrayList<BangDiem> ds = new ArrayList<>();
        for (int i = 0 ;  i< t; i++) {
            BangDiem d = new BangDiem();
            d.input(sc);
            ds.add(d);
            
        }
        Collections.sort(ds);
        for(BangDiem i:ds){
            System.out.println(i);
        }
    }
}
class BangDiem implements Comparable<BangDiem>{
    private String ten,ma,xeploai;
    private double tb;
    private double[] arr = new double[11];
    private static int j = 1;
    
    public void input(Scanner sc) {
        ma = "HS" + String.format("%02d", j);
        j++;
        ten = sc.nextLine();
        for (int i = 0 ; i < 10 ; i++ ) {
            arr[i] = sc.nextDouble();
            if ( i < 2) tb = tb + arr[i]*2;
            else tb  = tb + arr[i];
        }
        sc.nextLine();
        tb = (double) Math.round((tb/12)*10)/10;
        xeploai = getXeploai();
    }
    
    private String getXeploai(){
        if(tb>=9) return "XUAT SAC";
        if(tb>=8 && tb<=8.9) return "GIOI";
        if(tb>=7 && tb <= 7.9) return "KHA";
        if(tb>=5 && tb <= 6.9) return "TB";
        return "YEU";
    }
    @Override
    public String toString(){
        return ma+" "+ten+" "+String.format("%.1f", tb)+" "+xeploai;
                
    }
    
    @Override
    public int compareTo(BangDiem o){
        if(this.tb<o.tb) return 1;
        if (this.tb == o.tb && this.ma.compareTo(o.ma) > 0 ) return 1;
        return -1;
    }   
}
