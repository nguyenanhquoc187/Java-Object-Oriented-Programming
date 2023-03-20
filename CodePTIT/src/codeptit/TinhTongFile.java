package codeptit;
import java.io.File;
import java.util.Scanner;
public class TinhTongFile {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);
        long sum = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            int n = 0;
            try {
                n = Integer.valueOf(s);
            } catch (NumberFormatException ex) {
            } finally {
                sum += n;
            }
        }
        System.out.println(sum);
    }

}
