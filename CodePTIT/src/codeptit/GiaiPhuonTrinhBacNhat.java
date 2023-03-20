package codeptit;
import java.util.Scanner;
public class GiaiPhuonTrinhBacNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextInt(), b = input.nextInt();
        if (a == 0 && b == 0) System.out.print("VSN");
        else if (a == 0 && b !=0) System.out.print("VN");
        else System.out.format("%.2f", -b/a);
    }
}
