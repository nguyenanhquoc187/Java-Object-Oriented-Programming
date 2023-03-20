package codeptit;
import java.util.Scanner;
public class TongUocSo1 {
    static Scanner sc = new Scanner(System.in);
    static boolean NguyenTo[];
    static int n, Max ,arr[] , res[];
    public static void main(String[] args) {
        n = sc.nextInt();
        Max = 0;
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            Max = Math.max(arr[i], Max);
        }
        NguyenTo = new boolean[Max+1];
        res = new int [Max +1];
        solve();
        sc.close();
    }
    public static void SangNguyenTo(){
        for(int i = 2; i <= Max; i++) NguyenTo[i] = true;
        for(int i = 2; i <= Max; i++){
            if(NguyenTo[i]){
                res[i] = i;
                for(int j = 2*i; j <= Max; j+=i){
                    NguyenTo[j] = false;
                    int tmp = j;
                    while(tmp % i == 0){
                        res[j] += i;
                        tmp /= i;
                    }
                }
            }
        }
    }
    public static void solve(){
        SangNguyenTo();
        long result = 0;
        for(int i = 0; i < n; i++){
            result += res[arr[i]];
        }
        System.out.println(result);
    }
}