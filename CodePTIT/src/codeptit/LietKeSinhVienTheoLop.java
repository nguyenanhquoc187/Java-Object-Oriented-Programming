package codeptit;
import java.util.*;
public class LietKeSinhVienTheoLop {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<LKSV> ds = new ArrayList<>();
        while(t-->0){
            LKSV p = new LKSV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            ds.add(p);
        }
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s= sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP "+s+":");
            for(LKSV i:ds){
                if(i.getLop().equals(s) )System.out.println(i);
            }
        }
    }
}
class LKSV {
    private String ma,ten,email, lop;

    
    public LKSV(String ma,String ten,String lop,String email){
        this.ma=ma;
        this.ten=ten;
        this.lop=lop;
        this.email=email;
    }
    
    public String getLop(){
        return lop;
    }
    
    @Override
    public String toString(){
        return ma+" "+ten+" "+lop+" "+email;
    }
    
}
