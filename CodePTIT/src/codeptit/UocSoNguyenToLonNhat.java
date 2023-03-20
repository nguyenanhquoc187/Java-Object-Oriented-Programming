package codeptit;
import java.util.Scanner;
public class UocSoNguyenToLonNhat {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while (t-- >0){
            long n = s.nextLong();
            for(int i=2;i<=Math.sqrt(n);i++){
                while (n%i==0){
                    n/=i;
                }
                if(n==1) System.out.println(i);
            }
            if(n>2) System.out.println(n);
        }
    }
}