package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class CapSoNguyenToTrongFile2 {
    
    static int[] isPrime = new int[1000005];
    public static void main(String[] args) throws Exception,FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> data1 = (ArrayList<Integer>) sc.readObject();
        ArrayList<Integer> data2 = (ArrayList<Integer>) sc2.readObject();
        sangnguyento();
        Set<Integer> set = new TreeSet<>(data1);
        for (Integer i : set) {
            if (isPrime[i] == 1 && i < 1000000-i && isPrime[1000000 - i] == 1 && data1.contains(1000000-i) &&  !data2.contains(i) &&  !data2.contains(1000000-i)  ) {
                System.out.println(i + " " + (1000000-i) );
            } 
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
