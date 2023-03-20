package codeptit;
import java.util.*;
public class SapXepTheoMaSinhVien {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien05021> ds = new ArrayList<>();
        while (sc.hasNext()) {
            SinhVien05021 p = new SinhVien05021(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            ds.add(p);
        }
        Collections.sort(ds);
        for(SinhVien05021 i:ds){
            System.out.println(i);
        }
    }

}

 class SinhVien05021 implements Comparable<SinhVien05021>{
    private String masv,ten,lop,email;
    public SinhVien05021(String masv,String ten,String lop,String email){
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
    public int compareTo(SinhVien05021 o){
        if (this.masv.compareTo(o.masv) > 0) return 1;
        return -1;
    }   
    

}
