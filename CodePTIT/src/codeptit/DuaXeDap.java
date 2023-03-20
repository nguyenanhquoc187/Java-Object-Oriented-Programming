package codeptit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class DuaXeDap {
    private String hoTen,diaChi,thoiGian,Ma;
    private double thoiDiem;

    public DuaXeDap(String hoTen, String diaChi, String thoiGian) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.thoiGian = thoiGian;
        String arr1[]=hoTen.split("\\s+");
        String arr2[]=diaChi.split("\\s+");
        String ma="";
        for(int i=0;i<arr2.length;i++){
            ma+=Character.toUpperCase(arr2[i].charAt(0));
        }
        for(int i=0;i<arr1.length;i++){
            ma+=Character.toUpperCase(arr1[i].charAt(0));
        }
        Ma=ma;
        String a=thoiGian.substring(0,1);
        double gio=Integer.parseInt(a);
        String b=thoiGian.substring(2,4);
        double phut=Integer.parseInt(b);
        thoiDiem=(double)(120/(gio+(phut/60)-6));
    }
    @Override
    public String toString(){
        return this.Ma+" "+this.hoTen+" "+this.diaChi+" "+String.format("%.0f", this.thoiDiem)+" Km/h";
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<DuaXeDap> list = new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String ten=sc.nextLine();
            String diachi=sc.nextLine();
            String tg=sc.nextLine();
            DuaXeDap x = new DuaXeDap(ten,diachi,tg);
            list.add(x);
        }
        Collections.sort(list, new Comparator<DuaXeDap> (){
            @Override
            public int compare(DuaXeDap o1, DuaXeDap o2) {
                if(o1.thoiDiem>o2.thoiDiem)
                        return -1;
                else return 1;
            }
        });
        for(DuaXeDap x : list ){
            System.out.println(x);
        }
    }
}