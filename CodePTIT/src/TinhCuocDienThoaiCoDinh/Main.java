/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TinhCuocDienThoaiCoDinh;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TiengKeu tk = new TiengKeu();
        Pig pig = new Pig();
        tk.keu(pig);
    }
}

interface Animals {
    public void animeSound();
    public void sleep();
}

class Pig implements Animals {

    @Override
    public void animeSound() {
        System.out.println("Ỉn ỉn");
    }

    @Override
    public void sleep() {
        System.out.println("Lon ngu");
    }
    
}

class TiengKeu {
    public void keu(Animals animal) {
        animal.animeSound();
    }
}