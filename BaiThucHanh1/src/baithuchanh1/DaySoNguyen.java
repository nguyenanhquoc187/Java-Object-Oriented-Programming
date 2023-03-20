package baithuchanh1;

import java.util.Scanner;

public class DaySoNguyen {
    private int[] a ;
    private int n, k;

    public void setK(int k) {
        this.k = k;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        a = new int[n+1];
        System.out.print("Nhap mang: ");
        for (int i = 0 ; i < n ;i++) a[i] = sc.nextInt();
    }
    
    public void tryNhiPhan(int i, int[] arr) {
        for (int j = 0;j <= 1; j++) {
            arr[i] = j;
            if (i == n - 1 ) check(arr);
            else tryNhiPhan(i+1, arr);
        }
    }
    
    public void check(int[] arr) {
        int sum = 0;
        for (int i = 0 ; i < n; i++) {
             sum = sum + arr[i]*a[i];
        }
        if (sum == k) {
            for (int i = 0 ; i < n ;i++) {
                if (arr[i] == 1) {
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println("");
        }
    }
    public void TimDayConCoTongBangK() {
        int[] b = new int[n+1];
        System.out.println("Day con co tong bang " + k + " la: ");
        tryNhiPhan(0, b);
    }
    @Override
    public String toString() {
        for (int i = 0 ; i < n ;i++) System.out.print(a[i] + " ");
        return "";
    }
}
