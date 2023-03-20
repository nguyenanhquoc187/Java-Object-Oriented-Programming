package codeptit;
import java.util.*;
public class BienDoiST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Queue<Data> q = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            q.add(new Data(n, 0)) ;
            while (true) {
                Data x = q.poll();
                set.add(x.getFi());
                if ( x.getFi() == m) {
                    System.out.println(x.getSe());
                    break;
                }
                if (x.getFi()*2 <= 10000 && !set.contains(x.getFi() * 2) )  q.add(new Data(x.getFi()*2 , x.getSe()+1 ) );
                if (x.getFi()- 1 <= 10000 && !set.contains(x.getFi() -1)  ) q.add(new Data(x.getFi()- 1 , x.getSe()+1 ) );
            }
        }
    }

}
class Data {
    private int fi, se;

    public Data(int fi, int se) {
        this.fi = fi;
        this.se = se;
    }

    public int getFi() {
        return fi;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public int getSe() {
        return se;
    }

    public void setSe(int se) {
        this.se = se;
    }
    
}
