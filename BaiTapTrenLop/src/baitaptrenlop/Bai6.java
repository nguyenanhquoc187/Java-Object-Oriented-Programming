package baitaptrenlop;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Bai6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/baitaptrenlop/number.dat"));
        while (sc.hasNext()) {
            System.out.println(sc.nextInt());
        }
    }
}