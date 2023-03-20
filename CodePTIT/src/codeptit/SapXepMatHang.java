package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
public class SapXepMatHang {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> a = new ArrayList<>();
        for (int i = 0 ; i <n ;i++) 
            a.add(new MatHang(i, sc.nextLine(), sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine())));
        Collections.sort(a);
        for (int i = 0 ; i< n;i++) System.out.println(a.get(i));
    }

}
class MatHang implements Comparable<MatHang> {
    private String code,name, group;
    private double buyCost, sellCost, profit;

    public MatHang(int index, String name, String group, double buyCost, double sellCost) {
        if (index+ 1< 10) this.code = "MH0" + String.valueOf(index+1);
        else this.code = "MH" + String.valueOf(index+1);
        this.name = name;
        this.group = group;
        this.buyCost = buyCost;
        this.sellCost = sellCost;
        this.profit = sellCost - buyCost;
    }
    
    @Override
    public int compareTo(MatHang o) {
        return (int) (o.profit - this.profit );
    }
    
    @Override
    public String toString() {
        System.out.printf("%s %s %s %.2f",code, name, group, profit);
        return "";
    }
}