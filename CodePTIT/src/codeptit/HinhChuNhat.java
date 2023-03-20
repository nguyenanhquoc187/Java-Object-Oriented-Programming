package codeptit;
import java.util.Scanner;
public class HinhChuNhat {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int dai = input.nextInt();
        int rong = input.nextInt();
        if (dai <=0 || rong <=0) System.out.println(0);
        else {
            System.out.print((dai+rong)*2 + " " + dai*rong);
        }
    }
}

