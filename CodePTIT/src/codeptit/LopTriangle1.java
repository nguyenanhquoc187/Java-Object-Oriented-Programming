package codeptit;

import java.util.Scanner;
import java.text.DecimalFormat;
public class LopTriangle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
    public static Point nextPoint(Scanner ip){
        Point p = new Point(0, 0);
        p.x = ip.nextDouble();
        p.y = ip.nextDouble();
        return p;
    }
}