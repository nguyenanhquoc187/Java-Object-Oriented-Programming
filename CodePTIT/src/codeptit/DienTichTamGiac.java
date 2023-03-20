package codeptit;

import java.util.Scanner;
import java.text.DecimalFormat;
public class DienTichTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.printf("%.2f \n", a.getArea());
            }
        }
        sc.close();
    }
}
class Triangle{
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(){
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 0);
        this.p3 = new Point(0, 0);
    }

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public  boolean valid(){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p1, p3);
        return (a + b > c && a + c > b && b + c > a);
    }
    public String getPerimeter(){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p1, p3);
        DecimalFormat df = new DecimalFormat("#.###");
        double res = a + b + c;
        return df.format(res);
    }
    public double getArea() {
        double d1 = p1.distance(p2);
        double d2 = p2.distance(p3);
        double d3 = p1.distance(p3);
        double p = (d1+d2+d3)/2;
        double area = Math.sqrt(p*(p-d1) * (p-d2) * (p-d3) );
        return area;
    }
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
    }
}
