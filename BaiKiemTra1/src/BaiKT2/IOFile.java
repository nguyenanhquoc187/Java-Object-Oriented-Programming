package BaiKT2;
import java.util.*;
import java.io.*;
public class IOFile {
    
    public static <T> List<T> doc(String fname) {
        List<T> lst = new ArrayList<>();
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(fname));
            lst = (List<T>) o.readObject();
            o.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return lst;
    }
    
    public static <T> void viet(String fname, List<T> arr) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fname));
            o.writeObject(arr);
            o.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

