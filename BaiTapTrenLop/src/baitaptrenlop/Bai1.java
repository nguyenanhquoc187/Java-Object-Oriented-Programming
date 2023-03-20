package baitaptrenlop;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Bai1 {  //Bai 1
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/baitaptrenlop/INput.txt") ); 
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
