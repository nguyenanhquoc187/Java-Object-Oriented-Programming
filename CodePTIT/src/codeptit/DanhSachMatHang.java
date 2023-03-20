package codeptit;
import java.util.*;
public class DanhSachMatHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList<MatHang> a = new ArrayList<>();
            for (int i = 1 ; i<= n;i++) {
                MatHang e = new MatHang();
                e.nextMh(sc,i);
                a.add( e );
            }
            Collections.sort(a, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang a1, MatHang b) {
                if (a1.getLoinhuan() == b.getLoinhuan()) {
                    return a1.getMamh().compareTo(b.getMamh()) ;
                }
                return b.getLoinhuan() - a1.getLoinhuan();
            }
        });
            for (int i = 0 ; i<n;i++)  System.out.print(a.get(i));
    }

}

class MatHang {
    private String maMh;
    private String tenMh,donvi;
    private int giamua,giaban;
    public Scanner nextMh(Scanner sc, int i) {
        if ( i < 10) maMh = "MH00" + String.valueOf(i);
        else maMh = "MH0" + String.valueOf(i);
        sc.nextLine();
        tenMh = sc.nextLine();
        donvi = sc.next();
        giamua = sc.nextInt();
        giaban = sc.nextInt();
        return sc;
    }
    public String getMamh() {
        return maMh;
    }
    public int getGiamua() {
        return giamua;
    }
    public int getGiaban() {
        return giaban;
    }
    public int getLoinhuan() {
        return giaban - giamua;
    }
    @Override
    public String toString() {
        System.out.println(maMh + " " + tenMh + " " + donvi + " " + giamua + " " + giaban + " " + (giaban - giamua) );
        return "";
    }
}