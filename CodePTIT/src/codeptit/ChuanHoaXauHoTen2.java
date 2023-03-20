package codeptit;
import java.util.Scanner;
public class ChuanHoaXauHoTen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- >0) {
            String s = sc.nextLine();
            s = s.trim();
            while (s.contains("  ") ) {
                s = s.replace("  ", " ");
            }
            s = s.toLowerCase() ;
            String[] a = s.split(" ");
            String x = "";
            for (int i = 1 ; i< a.length ; i++) {
                x+= a[i].substring(0,1).toUpperCase() + a[i].substring(1) + " ";
            }
            x = x.substring(0 , x.length() - 1) + ", " + a[ 0].toUpperCase();
            System.out.println(x);
        }
    }

}
