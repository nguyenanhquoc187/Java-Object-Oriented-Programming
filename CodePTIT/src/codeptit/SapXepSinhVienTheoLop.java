package codeptit;
import java.util.*;
public class SapXepSinhVienTheoLop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien05020> ds = new ArrayList<>();
        for(int i=1;i<=t;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            
            SinhVien05020 p = new SinhVien05020(a,b,c,d);
            ds.add(p);
        }
        Collections.sort(ds);
        for(SinhVien05020 i:ds){
            System.out.println(i);
        }
    }

}

 class SinhVien05020 implements Comparable<SinhVien05020>{
    private String masv,ten,lop,email;
    public SinhVien05020(String masv,String ten,String lop,String email){
        this.masv=masv;
        this.ten= ten;
        this.lop= lop;
        this.email=email;
        
    }

    @Override
    public String toString(){
        return masv+" "+ten+" "+lop+" "+email;
    }
    @Override
    public int compareTo(SinhVien05020 o){
        if(this.lop.compareTo(o.lop) == 0){
            if(this.masv.compareTo(o.masv)>0) return 1;
            if(this.masv.compareTo(o.masv)<0) return -1;
            else return 0;
        }
        else if(this.lop.compareTo(o.lop)>0) return 1;
        else return -1;
        
        
    }   
    

}
