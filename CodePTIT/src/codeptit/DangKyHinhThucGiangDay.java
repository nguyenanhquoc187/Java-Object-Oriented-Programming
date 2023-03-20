package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class DangKyHinhThucGiangDay {
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHocJ07073> lst = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < n ;i++) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            int sotc = Integer.parseInt(sc.nextLine());
            String lythuyet = sc.nextLine();
            String thuchanh = sc.nextLine();
            if ( !thuchanh.equalsIgnoreCase("Truc tiep") ) lst.add(new MonHocJ07073(code, name, lythuyet, thuchanh, sotc) );
        }
        Collections.sort(lst);
        for (MonHocJ07073 i : lst) System.out.println(i);
    }

}
class MonHocJ07073 implements Comparable<MonHocJ07073>{
    private String code, name, lythuyet,thuchanh;
    private int sotc;

    public MonHocJ07073() {
    }

    public MonHocJ07073(String code, String name, String lythuyet, String thuchanh, int sotc) {
        this.code = code;
        this.name = name;
        this.lythuyet = lythuyet;
        this.thuchanh = thuchanh;
        this.sotc = sotc;
    }

    @Override
    public int compareTo(MonHocJ07073 o) {
        return code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return code + " " + name + " " + sotc + " " + lythuyet + " " + thuchanh;
    }
    
    
    
}