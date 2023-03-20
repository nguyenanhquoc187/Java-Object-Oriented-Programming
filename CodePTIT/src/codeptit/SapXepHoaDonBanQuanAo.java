package codeptit;
import java.util.*;
public class SapXepHoaDonBanQuanAo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListProduct6002 lst1 = new ListProduct6002();
        lst1.input(sc);
        Management_Bils6002 lst2 = new Management_Bils6002();
        lst2.input(sc,lst1);
        lst2.sort();
        System.out.println(lst2);
    }
}

class Product6002 {
    private String code, name; 
    private long price_type1, price_type2;

    public Product6002(String code, String name, long price_type1, long price_type2) {
        this.code = code;
        this.name = name;
        this.price_type1 = price_type1;
        this.price_type2 = price_type2;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getPrice_type1() {
        return price_type1;
    }

    public long getPrice_type2() {
        return price_type2;
    }
    
}
class ListProduct6002 {
    private ArrayList<Product6002> a = new ArrayList<>();
    private int n;
    public void input(Scanner sc) {
        n = Integer.parseInt(sc.nextLine());
        for (int i =0 ; i < n ;i++ ) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            long type1 = Long.parseLong(sc.nextLine());
            long type2 = Long.parseLong(sc.nextLine());
            Product6002 tmp = new Product6002(code, name, type1, type2);
            a.add(tmp);
        }
    }
    
    public String findNameProduct(String code) {
        for (Product6002 i : a) {
            if (i.getCode().equals(code) ) return i.getName();
        }
        return "";
    }
    public long findPriceProduct(String code, String type) {
        for (Product6002 i : a) {
            if (i.getCode().equals(code) ) {
                if ("1".equals(type)) return i.getPrice_type1();
                else return i.getPrice_type2();
            }
        }
        return 0;
    }
}
class Bills6002 implements Comparable<Bills6002> {
    private String code;
    private long amount;
    private static ListProduct6002 lst;
    
    public Bills6002(String code, long amount) {
        this.code = code;
        this.amount = amount;
    }
    
    public static void setLst(ListProduct6002 lst) {
        Bills6002.lst = lst;
    }
    
    public String getCode() {
        return code;
    }
    
    public double getBounusPercent() {
        if (amount >= 150) return 0.5;
        if (amount >= 100) return 0.3;
        if (amount >= 50 ) return 0.15;
        return 0;
    }
    public String getNameProduct() {
        String tmp = "" + code.charAt(0) + code.charAt(1);
        return lst.findNameProduct(tmp);
    }
    
    public long getTotalnotDiscount() {
        String tmp = "" + code.charAt(0) + code.charAt(1);
        return amount*lst.findPriceProduct(tmp, "" + code.charAt(2));
    }
    
    public long getDiscount() {
        return (long) ( getBounusPercent()* getTotalnotDiscount() );
    }
    public long getTotal() {
        return getTotalnotDiscount() - getDiscount();
    }
    
    @Override
    public int compareTo(Bills6002 o) {
        if ( getTotal() < o.getTotal() ) return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return getCode() + " " + getNameProduct() + " " + getDiscount() + " " + getTotal();
    }
}

class Management_Bils6002 {
    private ArrayList<Bills6002> a = new ArrayList<>();
    private int n;
    
    public void input(Scanner sc, ListProduct6002 lst) {
        n = Integer.parseInt(sc.nextLine());
        Bills6002.setLst(lst);
        for (int i =0 ; i < n ;i++ ) {
            String s = sc.nextLine();
            String code = s.substring(0,3);
            code += "-" + String.format("%03d", i+1);
            long amount = Long.parseLong(s.substring(4));
            Bills6002 tmp = new Bills6002(code, amount);
            a.add(tmp);
        }
    }
    
    @Override
    public String toString() {
        for (Bills6002 i : a) {
            System.out.println(i);
        }
        return "";
    }
    
    public void sort() {
        Collections.sort(a);
    }
}
