package codeptit;
import java.util.*;
public class DanhSachThucTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SVTT> ds = new ArrayList<>();
        int i = 0;
        while(t-->0){
            i++;
            SVTT p = new SVTT(i,sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            ds.add(p);
        }
        Collections.sort(ds);
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s = sc.nextLine();
            for(SVTT j:ds){
                if(j.getCty().compareTo(s)==0){
                    System.out.println(j);
                }
            }
        }
        
    }

}
class SVTT implements Comparable<SVTT>{
    private String ma,ten,lop,email,cty;
    private int stt;
    public SVTT(int n,String ma,String ten,String lop,String email,String cty){
        this.stt = n;
        this.ma=ma;
        this.ten=ten;
        this.lop = lop;
        this.email=email;
        this.cty = cty;
    }
    
    public String getCty(){
        return cty;
    }
    
    
    @Override
    public int compareTo(SVTT o){
        if (ma.compareTo(o.ma) > 0) return 1;
        return -1;
    }
    
    @Override
    public String toString(){
        return stt+" "+ma+" "+ten+" "+lop+" "+email+" "+cty;
    }
}