/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test1;

/**
 *
 * @author ADMIN
 */
public class NewClass {
    public static void main(String[] args) {
        DecimalFomat df = new DecimalFomat("#.###");
        double x = 1.2377;
        System.out.println(df.format(x));
    }
}
