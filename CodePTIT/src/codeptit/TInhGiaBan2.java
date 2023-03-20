package codeptit;
import java.util.*;
public class TInhGiaBan2 {
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
        Collections.sort(a);
        for (Merchandise i : a) System.out.println(i);
    }

}
class Merchandise implements Comparable<Merchandise>{
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
        trans_fee =  (long) Math.ceil((double) (import_price * quanity )*0.05 ) ;
        into_price = (long) Math.ceil(((double) import_price*quanity + trans_fee)  ) ;
        price_sell = (long) ( Math.ceil( (double) into_price*1.02 / quanity / 100)  ) * 100;
    }
    
    @Override
    public int compareTo(Merchandise o) {
        if (price_sell < o.price_sell ) return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " +unit + " " +trans_fee + " " +into_price + " " + price_sell;
    }
}
