package codeptit;
import java.util.Scanner;
public class ChuanHoaXauHoTen1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while(t-- > 0) {
            String s = input.nextLine();
            s = chuanhoa(s);
            System.out.println(s);
        }
    }
    public static String chuanhoa(String s) {
        s = s.trim().toLowerCase();
        String[] a = s.split("\\s+");
        String s2 = "";
        for (String i : a) {
            s2+= i.substring(0,1).toUpperCase() + i.substring(1) + " ";
        }
        return s2;
    }
}
