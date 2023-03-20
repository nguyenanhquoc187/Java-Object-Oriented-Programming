package codeptit;
import java.util.*;
public class LietKeSinhVienTheoNganh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<LKSV> ds = new ArrayList<>();
        while(t-->0){
            LKSV p = new LKSV(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            ds.add(p);
        }
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0){
            String s = sc.nextLine();
            String tmp = chuyenMa(s);
            System.out.println("DANH SACH SINH VIEN NGANH "+s.toUpperCase()+":");
            for(LKSV i:ds){
                 String k = i.getNganh();
                if(tmp.compareTo("DCCN")==0||tmp.compareTo("DCAT")==0){
                    String lop = i.getLop();
                    if(lop.compareTo("E")!=0){
                        if(k.contains(tmp))
                        System.out.println(i);
                    }
                }               
                else{                                                    
                    if(k.contains(tmp)){
                    System.out.println(i);
                }   
               }                         
        }
    }
    
}
    private static String chuyenMa(String s){
        if(s.compareTo("Cong nghe thong tin")==0 ) return "DCCN";
        if(s.compareTo("An toan thong tin")==0 ) return "DCAT";        
        if(s.compareTo("Ke toan")==0) return "DCKT";
        if(s.compareTo("Vien thong")==0) return "DCVT";
        if (s.compareTo("Dien tu")==0) return "DCDT";
        return null;
    }
}
class LKSV {
    private String ma,ten,lop,email;
    public LKSV(String ma,String ten,String lop,String email){
        this.ma=ma;
        this.ten=ten;
        this.lop=lop;
        this.email=email;
    }
    
    public String getNganh(){       
        return ma; 
    }
    
    public String getLop(){
        String l = lop;
        String ktra = l.substring(0,1);
        return ktra;
    }
    
    @Override
    public String toString(){
        return ma+" "+ten+" "+lop+" "+email;
    }
}