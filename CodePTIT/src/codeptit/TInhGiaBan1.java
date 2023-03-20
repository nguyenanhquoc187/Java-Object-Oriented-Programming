package codeptit;
import java.util.*;
public class TInhGiaBan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Merchandise> a = new ArrayList<>();
        while(t-- >0) {
            Merchandise tmp = new Merchandise();
            tmp.input(sc);
            a.add(tmp);
        }
        for (Merchandise i : a) System.out.println(i);
    }
}
class Merchandise {
    private String code, name, unit;
    private long trans_fee, into_price, price_sell, import_price, quanity;
    private static int j = 1;

    public void input(Scanner sc) {
        code = "MH" + String.format("%02d", j);
        j++;
        name = sc.nextLine();
        unit = sc.nextLine();
        import_price = sc.nextLong();
        quanity = sc.nextLong();
        sc.nextLine();
        trans_fee =  Math.round((import_price * quanity )*0.05 ) ;
        into_price = Math.round(((double) import_price*quanity + trans_fee)  ) ;
        price_sell =  Math.round(into_price*1.02);
    }
    @Override
    public String toString() {
        return code + " " + name + " " +unit + " " +trans_fee + " " +into_price + " " + price_sell;
    }
}
