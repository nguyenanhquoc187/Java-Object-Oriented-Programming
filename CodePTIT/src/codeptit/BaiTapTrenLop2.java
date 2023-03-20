package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class BaiTapTrenLop2 {  //Bai 1
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Code\\JavaOOP\\CodePTIT\\src\\codeptit\\Input.txt") ); 
        double sum = 0;
        for (int i = 1; i <= 5; i++) {
            double Number = sc.nextDouble();
            System.out.println("Number = " + Number );
            sum+=Number;
        }
        System.out.println("Sum = " + sum);
    }
}
