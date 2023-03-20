package codeptit;
import java.util.Scanner;
public class TinhTong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            long tong = (long) n*(1 + n) /2;
            
            System.out.println(tong);
            t--;
        }
    }
}