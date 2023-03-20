package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class DanhSachDoanhNghiep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in") );
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<DoanhNghiep> listDn = new ArrayList<>();
        for (int i = 0 ; i< n;i++ ) {
            DoanhNghiep tmp = new DoanhNghiep();
            tmp.nextDN(sc);
            listDn.add(tmp);
        }
        Collections.sort(listDn, (DoanhNghiep o1, DoanhNghiep o2) ->  {
            return o1.getMaDN().compareTo(o2.getMaDN() ) ;
        });
        for (int i = 0 ; i< n ;i++) listDn.get(i).display();
    }

}
class DoanhNghiep {
    private String maDN, tenDN;
    private String amountInter;
    public void nextDN(Scanner sc) {
        maDN = sc.nextLine();
        tenDN = sc.nextLine();
        amountInter = sc.nextLine();
    }
    public void display() {
        System.out.println(maDN + " " + tenDN + " " + amountInter);
    }

    public String getMaDN() {
        return maDN;
    }
    
}
