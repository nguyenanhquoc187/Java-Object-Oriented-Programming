package tinhgiaban1;
import java.util.*;
public class Merchandise {
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
        trans_fee =  Math.round((double) (import_price * quanity )*0.05 ) ;
        into_price = Math.round(((double) import_price*quanity + trans_fee)  ) ;
        price_sell =  Math.round((double) into_price*1.02);
    }
    public String toString() {
        return code + " " + name + " " +unit + " " +trans_fee + " " +into_price + " " + price_sell;
    }
}