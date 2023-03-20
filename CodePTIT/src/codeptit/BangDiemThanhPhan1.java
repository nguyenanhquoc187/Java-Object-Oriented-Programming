package codeptit;
import java.util.*;
public class BangDiemThanhPhan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Sv> a = new ArrayList<>();
        while(t-- >0) {
            Sv tmp = new Sv();
            tmp.input(sc);
            a.add(tmp);
        }
        Collections.sort(a);
        for (int i = 0 ; i < a.size(); i++) System.out.println((i+1) + " " + a.get(i));
    }
    
    public static class Sv implements Comparable<Sv> {
        private String code, name, cLass;
        private double p1,p2,p3;
        
        public void input(Scanner sc) {
            code = sc.nextLine();
            name = sc.nextLine();
            cLass = sc.nextLine();
            p1 = sc.nextDouble();
            p2 = sc.nextDouble();
            p3 = sc.nextDouble();
            sc.nextLine();
        }
        
        @Override
        public int compareTo(Sv o) {
            if (code.compareTo(o.code) > 0) return 1;
            return -1;
        }
        
        @Override
        public String toString() {
            return code + " " + name + " " + cLass + " " + String.format("%.1f", p1) + " " + String.format("%.1f", p2) + " " + String.format("%.1f", p3);
        }
    }
 
}