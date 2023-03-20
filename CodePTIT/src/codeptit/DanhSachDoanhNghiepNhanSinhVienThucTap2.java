package codeptit;
import java.util.*;
public class DanhSachDoanhNghiepNhanSinhVienThucTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<DoanhNghiep> ds = new ArrayList<>();
        ArrayList<Khoang> kh = new ArrayList<>();
        while(t-->0){
           String name=sc.nextLine();
           String ma=sc.nextLine();
           int so=sc.nextInt();
            DoanhNghiep p = new DoanhNghiep(name,ma,so);
            ds.add(p);
            sc.nextLine();
        }
        Collections.sort(ds);
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            int dau = sc.nextInt();
            int cuoi = sc.nextInt();
            Khoang p =new Khoang(dau, cuoi);
            kh.add(p);
        }
        
        for(Khoang i:kh){
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU "+i.getDau()+" DEN "+i.getCuoi()+" SINH VIEN:");                                    
            for(DoanhNghiep j:ds){
           if(j.getIndex()>=i.getDau()&&i.getCuoi()>=j.getIndex()){
               System.out.println(j);
           }
        }
        
    }
    }

}
class DoanhNghiep implements Comparable<DoanhNghiep>{
    private String ma,ten;
    private int sv;
    public DoanhNghiep(String ma,String ten,int sv){
        this.ma = ma;
        this.ten = ten;
        this.sv =sv;
    }
    
    @Override
    public int compareTo(DoanhNghiep o){
        if(this.sv==o.sv){
            if(this.ma.compareTo(o.ma)==0){
                return 0;
            }else return (this.ma.compareTo(o.ma)>0) ?1:-1;
        }
        else return (this.sv > o.sv) ?-1:1;
    }
    
    public int getIndex(){
        return sv;
    }
    
    @Override
    public String toString(){
        return ma+" "+ten+" "+sv;
    }
}
class Khoang {
      private int dau,cuoi;
    public Khoang(int dau,int cuoi){
        this.dau=dau;
        this.cuoi=cuoi;
    }

    public int getDau() {
        return dau;
    }

    public int getCuoi() {
        return cuoi;
    } 
}