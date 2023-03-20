package codeptit;
import java.util.*;
public class ChuViTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            Point p1 = new Point();
            Point p2 = new Point();
            Point p3 = new Point();
            p1 = Point.nextPoint(sc);
            p2 = Point.nextPoint(sc);
            p3 = Point.nextPoint(sc);
            double d1 = Point.distance(p1, p2);
            double d2 = Point.distance(p1, p3);
            double d3 = Point.distance(p2, p3);
            if ( d1 + d2 <= d3 || d1 + d3 <= d2 || d2 + d3 <= d1 ) System.out.println("INVALID");
            else {
                double p = (d1+d2+d3)/2;
                double chuvi = d1 + d2 + d3;
                System.out.printf("%.3f\n", chuvi);
            }
        }
    }

}

class Point{
    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public static Point nextPoint(Scanner sc){
        Point p = new Point(0, 0);
        p.x = sc.nextDouble();
        p.y = sc.nextDouble();
        return p;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public double distance(double x, double y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
    @Override
    public String toString() {
        return "(+" + this.x + "," + this.y + ")";
    }
}
