package codeptit;
import java.util.Scanner;
public class KhaiBaoLopPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            double[] a = new double[4];
            for (int i = 0 ; i < 4; i++) a[i] = input.nextDouble();
            Point p1 = new Point(a[0],a[1]);
            Point p2 = new Point(a[2],a[3]);
            double distance = p1.distance(p2);
            System.out.printf("%.4f\n",distance);
            t--;
        }
    }
}
class Point {
    private double x;
    private double y;
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point p) {
        
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double distance(Point p2) {
        double d = Math.sqrt( (p2.x -this.x)*(p2.x -this.x)  + (p2.y -this.y)*(p2.y -this.y)  );
        return d;
    }
    public double distance(Point p1, Point p2) {
        double d = Math.sqrt( (p2.x -p1.x)*(p2.x -p1.x)  + (p2.y -p1.y)*(p2.y -p1.y)  );
        return d;
    }
}
