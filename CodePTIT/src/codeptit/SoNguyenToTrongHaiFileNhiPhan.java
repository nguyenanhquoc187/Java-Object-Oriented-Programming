package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class SoNguyenToTrongHaiFileNhiPhan {
    public static int[] isPrime = new int[10005];
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) sc1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) sc2.readObject();
        isPrime[0] = isPrime[1] = 0;  
        sangnguyento();
        int[] d1 = new int[10005];
        int[] d2 = new int[10005];
        for (Integer i: a1) {
            if (isPrime[i] == 1) d1[i]++;
        }
        for (Integer i : a2) {
            if (isPrime[i] == 1) d2[i]++;
        }
        for (int i = 2; i <=10000;i++) {
            if (d1[i] > 0 && d2[i] >0) System.out.println(i + " " + d1[i] + " " + d2[i]);
        }
    }
    
    public static void sangnguyento() {
        Arrays.fill(isPrime,1);
        for (int i = 2 ; i <= 10000;i++) {
            if (isPrime[i] == 1) {
                for (int j = i*2; j<=10000; j+=i) isPrime[j] =0;
            } 
        }
    }

}
