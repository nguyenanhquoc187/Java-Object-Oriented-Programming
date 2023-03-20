package codeptit;
import java.util.*;

public class LietKeXuatNhapHangTheoNhom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Product> arrayList = new ArrayList<>();

        while(t-- > 0) {
            arrayList.add(new Product(sc.next(), sc.nextInt()));
        }

        Collections.sort(arrayList, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getTariff() < o2.getTariff() ? 1 : -1;
            }
        });

        String s = sc.next();
        for (int i = 0; i < arrayList.size(); i++) {
            String tmp = arrayList.get(i).getId().substring(0,1);
            if (s.equals(tmp)){
                System.out.println(arrayList.get(i));
            }
        }
    }
}

class Product{
    private String id;
    private int importQuantity;

    public Product(String id, int importQuantity) {
        this.id = id;
        this.importQuantity = importQuantity;
    }

    public String getId() {
        return id;
    }

    public int getExportQuantity(){
        if(id.startsWith("A")) return (int) Math.round(0.6 * importQuantity);
        if(id.startsWith("B")) return (int) Math.round(0.7 * importQuantity);
        return 0;
    }

    public int getUnitPrice(){
        if(id.endsWith("Y")) return 110000;
        if(id.endsWith("N")) return 135000;
        return 0;
    }

    public int getTotalPrice(){
        return getExportQuantity() * getUnitPrice();
    }

    public int getTariff(){
        if(id.startsWith("A") && id.endsWith("Y")) return (int) Math.round(0.08 * getTotalPrice());
        if(id.startsWith("A") && id.endsWith("N")) return (int) Math.round(0.11 * getTotalPrice());
        if(id.startsWith("B") && id.endsWith("Y")) return (int) Math.round(0.17 * getTotalPrice());
        if(id.startsWith("B") && id.endsWith("N")) return (int) Math.round(0.22 * getTotalPrice());
        return 0;
    }

    @Override
    public String toString() {
        return id + " " + importQuantity + " " + getExportQuantity() + " " + getUnitPrice() + " " + getTotalPrice() + " " + getTariff();
    }
}