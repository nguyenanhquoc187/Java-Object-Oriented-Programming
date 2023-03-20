package codeptit;
import java.util.Scanner;
public class UocSoChiaHetCho2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while (t-->0){
            int n=scan.nextInt();
            int count=0;
            for(int i=1;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    if(i%2==0)count++;
                    if((n/i)%2==0&&i!=n/i)count++;
                }
            }
            System.out.println(count);
        }
    }
}