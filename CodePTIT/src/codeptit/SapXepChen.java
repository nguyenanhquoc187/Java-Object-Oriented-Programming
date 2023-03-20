package codeptit;
import java.util.ArrayList;
import java.util.Scanner;
public class SapXepChen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        int buoc = 0;
        for (int i = 0 ; i < n;i++) {
            int x = sc.nextInt();
            if (i == 0 ) a.add(x);
            else {
                int check = 0;
                for (int j = 0 ; j < a.size();j++) {
                    if ( x < a.get(j) ) {
                        a.add(j,x);
                        check = 1;
                        break;
                    }
                }
                if (check ==0) a.add(x);
            }
            System.out.print("Buoc " + (buoc++) +": "   );
            for (int j : a) System.out.print(j+ " ");
            System.out.println();
        }
    }

}
