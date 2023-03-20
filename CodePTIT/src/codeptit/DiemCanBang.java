package codeptit;
import java.util.Scanner;
import java.util.ArrayList;
public class DiemCanBang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            int n = sc.nextInt();
            int left = 0, right = 0;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0 ; i< n;i++)  a.add(sc.nextInt());
            for (int i = 2; i < n;i++) right+=a.get(i);
            left += a.get(0);
            for (int i = 1; i <n-1 ;i++) {
                if (left == right) {
                    System.out.println(i+1); 
                    break;
                }
                else {
                    left+=a.get(i);
                    right-=a.get(i+1);
                }
            }
            if (left != right) System.out.println(-1);
            a.clear();
        }
        sc.close();
    }

}
