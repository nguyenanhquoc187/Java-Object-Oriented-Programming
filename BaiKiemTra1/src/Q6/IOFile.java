/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.io.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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

