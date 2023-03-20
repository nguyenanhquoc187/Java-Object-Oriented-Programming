package test1online;

import java.util.Scanner;

public class SoThuc {
    private double[] a;
    private int n;
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n:");
        n = sc.nextInt();
        a = new double[n+1];
        System.out.println("Nhap day: ");
        for (int i = 0 ; i< n ;i++) a[i] = sc.nextDouble();
    }
    
    public double PhanTuNhoNhat() {
        double min = a[0];
        for (int i = 1; i < n;i++  ) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
    public void SapXep() {
        for (int i = 0 ; i < n-1;i++) {
            for (int j = i+1 ; j< n ;j++) {
                if (a[i] < a[j]) {
                    double tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        System.out.println("Day so da sap xep giam dan: ");
        for (int i = 0 ; i< n;i++) System.out.print(a[i] + " ");
        System.out.println("");
    }
    
}
