package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class SoNguyenToTrongFileNhiPhan {
    
    static int[] isPrime = new int[10005];
    public static void main(String[] args) throws Exception,FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        @SuppressWarnings("unchecked")
        ArrayList<Integer> a = (ArrayList<Integer>) sc.readObject();
        sangnguyento();
        int used[] = new int[10005];
        Set<Integer> b = new TreeSet<>();
        isPrime[0] = isPrime[1] = 0;  
        for (Integer i : a) {
            if (isPrime[i] == 1) {
                used[i]++;
                b.add(i);
            }
        }
        for (Integer i: b) 
            System.out.println(i + " " + used[i] );
    }
    public static void sangnguyento() {
        Arrays.fill(isPrime,1);
        for (int i = 2 ; i <= 10000;i++) {
            if (isPrime[i] == 1) {
                for (int j = i*2; j<=10000; j+=i) isPrime[j] = 0;
            }
        }
    }
}
