package codeptit;
import java.util.*;
import java.text.*;

public class SapXepDanhSachNhanVien {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<NhanVien> ds = new ArrayList<>();
        sc.nextLine();
        for(int i = 1;i<=t;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            String d=sc.nextLine();
            String e=sc.nextLine();
            String f=sc.nextLine();
            NhanVien p = new NhanVien(i,a,b,c,d,e,f);
            ds.add(p);
            
        }
        Collections.sort(ds);
        for(NhanVien i:ds){
            System.out.println(i);
        }
    }
    
}

class NhanVien implements Comparable<NhanVien>{
    private String ma,ten ,gtinh,diachi,msthue;
    private Date ns,nkhd;
    public NhanVien(int n,String ten,String gtinh,String ns,String diachi,String msthue,String nkhd) throws ParseException{
        this.ma = "000"+String.format("%02d", n);
        this.ten = ten;
        this.gtinh= gtinh;
        this.ns = new SimpleDateFormat("dd/MM/yyyy").parse(ns);
        this.diachi=diachi;
        this.msthue = msthue;
        this.nkhd = new SimpleDateFormat("dd/MM/yyyy").parse(nkhd);
    }

    @Override
    public int compareTo(NhanVien o) {
        if(this.ns.before(o.ns)) return -1;
        if(this.ns.after(o.ns)) return 1;
        return 0;
    }
    @Override
    public String toString(){
        return ma+" "+ten+" "+gtinh+" "+new SimpleDateFormat("dd/MM/yyyy").format(ns)+" "+diachi+" "+msthue+" "+new SimpleDateFormat("dd/MM/yyyy").format(nkhd);
    }
}