package codeptit;
import java.util.*;
import java.io.File;
import java.io.IOException;
public class LopPairGeneric {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
    

}
class Pair<T1, T2> {
    private T1 n;
    private T2 m;
    public Pair(T1 n, T2 m) {
        this.n = n;
        this.m = m;
    }
    public boolean isPrime() {
        if (ktSnt(n) && ktSnt(m) ) return true;
        return false;
    }
    public static <T1> boolean ktSnt(T1 y) {
        Integer n = (Integer) y;
        if (n ==  0 || n == 1) return false;
        for (int i = 2; i <=  Math.sqrt(n);i++) 
            if (n % i == 0 ) return false;
        return true;
    }
    @Override
    public String toString() {
        System.out.print(n + " " + m);
        return "";
    }
}
