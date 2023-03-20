package codeptit;
import java.io.*;
import java.util.Scanner;
public class HelloFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Hello.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(s);
        }
    }

}
