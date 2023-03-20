package codeptit;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class NguyenToVaThuanNghich {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream sc1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream sc2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) sc1.readObject();
        ArrayList<Integer> b = (ArrayList<Integer>) sc2.readObject();
//        ArrayList<Integer> a = new ArrayList<>();
//        ArrayList<Integer> b = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0 ; i < 5; i++) a.add(sc.nextInt());
//        for (int i = 0 ; i < 5; i++) b.add(sc.nextInt());
        
        int[] isPrime = new int[10005];
        
        sangNguyenTo(isPrime);
//        for (int i = 2 ; i <= 10000; i++)
//            System.out.print(isPrime[i] + " ");
        
        
        int[] used1 = new int[10005];
        int[] used2 = new int[10005];
        for (int i = 0 ; i< a.size() ; i++) {
            if (isPrime[a.get(i)] == 1 && isThuanNghich(a.get(i)) ) {
                used1[a.get(i)]++;
            }
        }
        for (int i = 0 ; i< b.size() ; i++) {
            if (isPrime[b.get(i)] == 1 && isThuanNghich(b.get(i)) ) {
                used2[b.get(i)]++;
            }
        }
        for (int i = 2 ; i <= 10000 ;i++) {
            if (used1[i] > 0 && used2[i] > 0) {
                System.out.println(i + " " + used1[i] + " " + used2[i]);
            }
        }
    }
    
    public static void sangNguyenTo(int[] isPrime) {
        Arrays.fill(isPrime,1);
        isPrime[0] = isPrime[1] = 0;
        for (int i = 2; i  <= 10000 ; i++) {
            if (isPrime[i] == 1 ) {
                for (int j = 2*i; j <= 10000; j+=i ) isPrime[j] = 0;
            } 
        }
    }
    
    public static boolean isThuanNghich(int s) {
        StringBuilder tmp = new StringBuilder(s+"");
        return tmp.reverse().toString().equals(s+"");
    }

}
