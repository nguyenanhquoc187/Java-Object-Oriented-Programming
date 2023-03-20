package baitaptrenlop;
import java.io.*; // for File, FileNotFoundException
import java.util.Scanner;
public class Bai2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Code\\JavaOOP\\BaiTapTrenLop\\src\\baitaptrenlop\\input.txt"));
        double sum = 0.0;
        while (sc.hasNextDouble()) {
            double next = sc.nextDouble();
            System.out.println("number = " + next);
            sum += next;
        }   
        System.out.println("Sum = " + sum);
    }
}