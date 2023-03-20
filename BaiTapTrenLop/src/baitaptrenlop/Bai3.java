package baitaptrenlop;
import java.io.*; // for File, FileNotFoundException
import java.util.Scanner;
public class Bai3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Code\\JavaOOP\\BaiTapTrenLop\\src\\baitaptrenlop\\input.txt"));
        double sum = 0.0;
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                double next = sc.nextDouble();
                System.out.println("number = " + next);
                sum += next;
            } else {
                sc.next(); 
            }

        }
        System.out.println("Sum = " + sum);
    }
}