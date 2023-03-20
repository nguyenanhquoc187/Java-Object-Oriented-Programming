package codeptit;
import java.util.Scanner;
public class KhaiBaoLopHinhChuNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rectange a = new Rectange();
        a.nextRectange(input);
        if ( !a.valid() ) System.out.println("INVALID");
        else {
            System.out.printf( "%d %d %s" ,(int) a.findPerimeter(), (int) a.findArea(), a.getColor().substring(0,1).toUpperCase() + a.getColor().substring(1).toLowerCase());
        }
    }
}
class Rectange {
    private double width, height;
    private String color;
    public Rectange() {
        this.width = this.height = 1;
    }
    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public Scanner nextRectange(Scanner input) {
        width = input.nextDouble();
        height = input.nextDouble();
        color = input.next();
        return input;
    }
    public boolean valid() {
        return !(width <= 0 || height <=0);
    }
    public double getWidth() {
        return this.width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double findArea() {
        return width*height;
    }
    public double findPerimeter() {
        return (width + height)*2;
    }
}