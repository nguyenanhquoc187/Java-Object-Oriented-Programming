package codeptit;
import java.text.DecimalFormat;
public class Triangle{
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

    public boolean valid(){
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p1.distance(p3);
        return (a + b > c && a + c > b && b + c > a);
    }
    public String getPerimeter(){
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p1.distance(p3);
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
    public double getAreaOf​​Circumcircle() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p1.distance(p3);
        double s = getArea();
        double r = (a*b*c)/(4*s);
        return Math.PI*r*r;
    }
}