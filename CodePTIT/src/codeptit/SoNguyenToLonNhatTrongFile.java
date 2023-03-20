package codeptit;
import java.io.*;
import java.util.*;
public class SoNguyenToLonNhatTrongFile {
    
    static int[] isPrime = new int[1000005];
    public static void main(String[] args) throws Exception,FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream  in = new ObjectInputStream(new FileInputStream("DATA.in"));
        @SuppressWarnings("unchecked")
        ArrayList<Integer> a = (ArrayList<Integer>)in.readObject();
        sangnguyento();
        int used[] = new int[1000005];
        Set<Integer> b = new TreeSet<>();
        isPrime[0] = isPrime[1] = 0;  
        for (Integer i : a) {
            if (isPrime[i] == 1) {
                used[i]++;
                b.add(i);
            }
        }
        ArrayList<Integer> tmp = new ArrayList<>(b);
        Collections.reverse(tmp);
        int dem = 10;
        for (Integer i: tmp) {
            System.out.println(i + " " + used[i] );
            dem--;
            if (dem == 0) break;
        }
    }
    public static void sangnguyento() {
        Arrays.fill(isPrime,1);
        for (int i = 2 ; i <= 1000000;i++) {
            if (isPrime[i] == 1) {
                for (int j = i*2; j<=1000000; j+=i) isPrime[j] = 0;
            }
        }
    }
}
