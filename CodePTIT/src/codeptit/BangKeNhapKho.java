package codeptit;
import java.util.*;
public class BangKeNhapKho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ItemManegement a = new ItemManegement();
        a.input(sc,n);
        System.out.println(a);
    }
}


class ItemManegement {
    private ArrayList<Item> a = new ArrayList<>();
    private Set<String> id = new TreeSet<>();
    public void input(Scanner sc, int n) {
        for (int i = 0 ; i < n ;i++ ) {
            String code = sc.nextLine();
            String name = code;
            long amount = Long.parseLong(sc.nextLine());
            long price = Long.parseLong(sc.nextLine());
            code = "" + code.charAt(0) + code.charAt(code.indexOf(" ") + 1) ;
            code = code.toUpperCase() + "0";
            int size = id.size(), j = 0;
            while (id.size() == size ) {
                j++;
                id.add(code + j);
            }
            code = code + j;
            Item tmp = new Item(code, name, amount, price);
            a.add(tmp);
        }
    }
    public String toString () {
        for (Item i : a) System.out.println(i);
        return "";
    }
}

class Item {
    private String code, name;
    private long amount, price, discount, total;
    
    public Item(String code,String name, long amount, long price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
        discount = (long) (getDicountPercent() * price * amount);
        total = price*amount - discount;
    }
    
    public double getDicountPercent() {
        if (amount > 10) return 0.05;
        if (amount >=8 && amount <=10) return 0.02;
        if (amount >=5 && amount < 8) return 0.01;
        return 0;
    }
    
    @Override
    public String toString() {
        return code + " " +  name + " " + discount + " " + total;
    }
    
}
