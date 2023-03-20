package codeptit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class GiaTriNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) in.readObject(); 
        for (int i = 0 ; i < a.size(); i++) {
            String tmp = "";
            for (int j = 0 ; j < a.get(i).length(); j++) {
                if (a.get(i).charAt(j) == '0' || a.get(i).charAt(j) == '1' ) tmp+=a.get(i).charAt(j);
            }
            System.out.println(tmp + " " + Long.parseLong(tmp,2) );
        }
    }

}
