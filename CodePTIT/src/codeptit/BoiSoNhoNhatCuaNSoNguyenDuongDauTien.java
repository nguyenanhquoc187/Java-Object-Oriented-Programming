package codeptit;
import java.util.Scanner;
public class BoiSoNhoNhatCuaNSoNguyenDuongDauTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while (t-- >0) {
            int n = sc.nextInt();
            long kq = 1;
            for ( int i =1 ; i <= n;i++) {
                kq = PhanSo.lcm(kq, i);
            }
            
            System.out.println(kq);
        }
    }

}
