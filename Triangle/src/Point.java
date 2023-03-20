package codeptit;
import java.util.Scanner;
public class Point{
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
