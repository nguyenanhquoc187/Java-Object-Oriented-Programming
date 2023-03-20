package codeptit;
import java.util.*;
public class DayConCoTongLe {
    public static ArrayList<ArrayList> arr = new ArrayList<>();
    public static ArrayList<Integer> a = new ArrayList<>();
    public static int n ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            n = sc.nextInt();
            for (int i = 0 ; i< n;i++) a.add(sc.nextInt());
            Collections.sort(a,(o1, o2) -> o2 - o1);
            int[] b = new int[n+5];
            nhiphan(0, b);
            
//            Collections.sort(arr, (ArrayList o1, ArrayList o2) -> {
//                String s1 = "", s2 = "";
//                for (int i = 0 ; i < o1.size(); i++ ) s1 += o1.get(i).toString();
//                for (int i = 0 ; i < o2.size(); i++ ) s2 += o2.get(i).toString();
//                return s1.compareTo(s2);
//            });
            for (int i = 0; i< arr.size(); i++) {
                for (int j = 0 ; j< arr.get(i).size(); j++) System.out.print(arr.get(i).get(j) + " ");
                System.out.println();
            }
            a.clear();
            arr.clear();
        }
    }
    public static void innhiphan(int[] b) {
        ArrayList<Integer> c = new ArrayList<>();
        int sum = 0;
        for (int i = 0 ; i<n ;i++) {
            if (b[i] == 1) {
                c.add(a.get(i));
                sum += a.get(i);
            }
            
        }
        if (sum % 2 == 1) arr.add(c);
    }
    
    public static void nhiphan(int j, int[] b) {
        for (int i = 0 ; i <=1 ; i++) {
            b[j] = i;
            if (j == n - 1 ) innhiphan(b)  ; else nhiphan(j+1, b);
        }
    }
}
