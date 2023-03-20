package codeptit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class List_goods{
    private ArrayList<goods> lst = new ArrayList<>();

    public List_goods(){

    }
    public void input(int n, Scanner sc){
        
       
        for(int i = 0;i <  n;i ++){
            
            String name = sc.nextLine();
            String type = sc.nextLine();
            Double price_sale = sc.nextDouble();
            Double price_buy = sc.nextDouble();
            goods gd =  new goods(i+1, price_sale, price_buy, name, type);
            lst.add(gd);
            sc.nextLine();
            
        }
        
    }
    public void Sort_array(){
        Collections.sort(lst);
    }
    public void output(){
        for(goods i : lst)
            System.out.println(i);
    }
}
class goods implements Comparable<goods>{
    private int code;
    private double price_sale,price_buy,profit;
    private String name,type;
    public double getProfit(){
        return profit;
    }
    public void setProfit(double profit){
        this.profit = profit;
    }
    public goods(int code, double price_sale, double price_buy, String name, String type) {
        this.code = code;
        this.price_sale = price_sale;
        this.price_buy = price_buy;
        this.name = name;
        this.type = type;
        this.profit = price_buy-price_sale;
    }
    @Override
    public String toString() {
       return code+" "+name+" "+type+" "+String.format("%.2f",profit);
    }
    @Override
    public int compareTo(goods o) {
        if(this.profit < o.profit) return 1;
        return -1;
    }
}
public class J05010_sort_list_goods {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List_goods lstg = new List_goods();
       
        lstg.input(n,sc);
        lstg.Sort_array();
        lstg.output();
        sc.close();
    }
}
