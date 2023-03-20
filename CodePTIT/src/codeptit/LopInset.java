package codeptit;
import java.util.*;
public class LopInset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }

}
class IntSet {
    private Set<Integer> set;

    public IntSet() {
        set = new TreeSet<>();
    }

    public IntSet(int[] a) {
        set = new TreeSet<>();
        for (int i : a) set.add(i);
    }
    
    public IntSet union(IntSet b) {
        IntSet c = new IntSet();
        for (int i : this.set) c.set.add(i);
        for (int i : b.set) c.set.add(i);
        return c;
    }

    @Override
    public String toString() {
        for (int i : set) System.out.print(i + " ");
        return "";
    }
    
    
}
