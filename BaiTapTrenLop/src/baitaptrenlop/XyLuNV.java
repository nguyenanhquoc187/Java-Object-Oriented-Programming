package baitaptrenlop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class XyLuNV {
   private NhanVien[] nv;
   private int n;

    public XyLuNV() {
        n = 0;
        nv = new NhanVien[100];
    }

    public void setNv(NhanVien[] nv) {
        this.nv = nv;
    }

    public NhanVien[] getNv() {
        return nv;
    }
    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        String name = sc.nextLine();
        long salary = sc.nextLong();
        nv[n] = new NhanVien(code, name, salary);
        n++;
    }
    public void doc() {
        NhanVien[] nv = new NhanVien[100];
        int n = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/baitaptrenlop/input.txt"));
            String line = "";
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void viet() {
        PrintWriter p = null;
        String st = "";
        int i ;
        for (i = 0 ; i< n-1; i++) {
            try {
                p = new PrintWriter("src/baitaptrenlop/output.txt");
                st+= nv[i].getCode() + "," + nv[i].getName() + "," + nv[i].getSalary() + "\n";
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        st+= nv[i].getCode() + "," + nv[i].getName() + "," + nv[i].getSalary() ;
        p.print(st);
        p.close();
    }
}
