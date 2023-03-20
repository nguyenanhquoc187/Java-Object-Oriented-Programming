package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class DanhSachSanPham2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0 ; i <n ;i++) a.add(new SanPham(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()) );
        Collections.sort(a);
        for (int i = 0 ; i < n;i++) System.out.println(a.get(i));
    }

}
class SanPham implements Comparable<SanPham> {
    private String code, name,  insurance;
    private int price;

    public SanPham(String code, String name, String price, String insurance) {
        this.code = code;
        this.name = name;
        this.price = Integer.parseInt(price);
        this.insurance = insurance;
    }
    
    @Override
    public int compareTo(SanPham x) {
        if ( this.price == x.price && this.code.compareTo(x.code) > 0) return 1;
        if (x.price > this.price) return 1;
        return -1;
    }
   
    @Override
    public String toString() {
        return code + " " + name +  " " + price + " " + insurance; 
    }
}