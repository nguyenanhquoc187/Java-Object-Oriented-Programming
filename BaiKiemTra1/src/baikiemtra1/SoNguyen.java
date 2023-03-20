package baikiemtra1;

import java.util.Scanner;

public class SoNguyen {
    private int n;
    public void intput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }        
    public boolean ktSnt(int y) {
        if (y ==  0 || y == 1) return false;
        for (int i = 2; i <=  Math.sqrt(y);i++) 
            if (y % i == 0 ) return false;
        return true;
    }
    public void Fibonaci() {
        int f1 = 0, f2 = 1;
        int fn = 1;
        while (fn < n) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;     
            if ( ktSnt(fn) && fn < n) System.out.print(fn + " ");
        }
    }
    public String KTthuannghich() {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        String s2 = String.valueOf(n);
        s.reverse();
        if (s.toString().equals(s2)  ) return "Co la so thuan nghich";
        return "Khong la so thuan nghich";
    }
}
