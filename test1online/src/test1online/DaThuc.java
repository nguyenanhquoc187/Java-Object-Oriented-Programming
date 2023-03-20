package test1online;

import java.util.Scanner;

public class DaThuc {
    private int[] p = new int[100];
    private int bac;
    public void input() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a[] = s.split("\\s+");
        bac = a.length;
        for (int i = 0 ; i< bac ;i++ ) {
            p[i] = Integer.parseInt(a[i]);
        }
    }
    public int getBac() {
        return bac;
    }
    public DaThuc TongDaThuc(DaThuc q) {
        DaThuc c = new DaThuc();
        int max = Math.max(bac, q.bac);
        c.bac = max;
        for (int i = 0 ; i< c.bac ; i++) {
            c.p[i] = p[i] + q.p[i];
        }
        return c;
    }
    
    @Override
    public String toString() {
        for (int i = 0 ; i< bac-1 ; i++ ) {
            if (p[i]!= 0 )  System.out.print(p[i] + "x^" + i + "+");
        }
        System.out.print(p[bac-1] + "x^" + (bac-1) );
        return "";
    }
}
