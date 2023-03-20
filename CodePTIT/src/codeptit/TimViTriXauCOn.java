package codeptit;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class TimViTriXauCOn {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0) {
            String a= sc.nextLine();
            String b = sc.nextLine();
            ArrayList<Integer> index = new ArrayList<>();
            int tmp = a.indexOf(b);
            while (tmp != -1) {
                index.add(tmp);
                tmp = a.indexOf(b,tmp+1);
            }
            for (Integer i : index) System.out.print(i + 1 + " ");
            System.out.println("");
        }
    }

}
