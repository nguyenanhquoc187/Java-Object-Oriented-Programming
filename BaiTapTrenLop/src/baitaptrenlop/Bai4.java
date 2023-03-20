package baitaptrenlop;
import java.io.*;
import java.util.*;
public class Bai4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/baitaptrenlop/number.dat"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(">" + line);
        }
        sc.close();
    }
}