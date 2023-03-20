package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class TongChuSo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) in.readObject();
        for (int i = 0 ; i < a.size(); i++) {
            String tmp = "";
            long sum = 0;
            for (int j = 0 ; j < a.get(i).length(); j++) {
                if ( a.get(i).charAt(j) >= '0' && a.get(i).charAt(j)<='9' ) {
                    tmp+=a.get(i).charAt(j);
                    sum= sum + a.get(i).charAt(j) - '0';
                }
            }
            while(tmp.charAt(0) == '0' && tmp.length() > 1) tmp = tmp.substring(1);
            System.out.println(tmp + " " + sum);
        }
    }
}
