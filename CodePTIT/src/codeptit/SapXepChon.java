package codeptit;

import java.util.Scanner;

public class SapXepChon {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int buoc = 1;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
            System.out.print("Buoc " + (buoc++) + ": ");
            for (int x = 0; x < n; x++) {
                System.out.print(a[x] + " ");
            }
            System.out.println("");
        }
    }
}