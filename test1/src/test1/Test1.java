package test1;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0 ; i < n ;i++) {
                a.add(sc.nextInt());
                if (!b.contains(a.get(i)) ) b.add(a.get(i));
            }
            ArrayList<test> x = new ArrayList<>();
            Map<Integer,Integer> m = new HashMap<>();
            for (int i = 0 ; i< n;i++) {
                int tmp = a.get(i);
                if (m.containsKey(tmp ) ) m.put(tmp,m.get(tmp)+1);
                else m.put(tmp, 1);
            }
            for (int i = 0 ; i < b.size();i++) {
                x.add(new test(b.get(i), m.get(b.get(i)),i ));
            }
            Collections.sort(x);
            for (int i = 0 ; i < b.size() ;i++) {
                for (int j = 0 ; j < x.get(i).getSolan();j++) {
                    System.out.print(x.get(i).getSo() + " ");
                }
            }
            System.out.println("");
        }
    }
}
class test implements Comparable<test>{
    private int so, solan, vitri;

    public test(int so, int solan,int vitri) {
        this.so = so;
        this.solan = solan;
        this.vitri = vitri;
    }

    public int getSo() {
        return so;
    }

    public int getSolan() {
        return solan;
    }
    
    

    @Override
    public int compareTo(test o) {
        if (solan == o.solan) return vitri - o.vitri;
        return o.solan - solan;
    }
    
    
    
}
2 4 1 2 2 5 1