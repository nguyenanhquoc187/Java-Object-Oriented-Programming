package codeptit;
import java.util.*;
public class DienTichHinhTronNgoaiTiepTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if ( !a.valid() ) {
                System.out.println("INVALID");
            }
            else {
                System.out.printf("%.3f \n" , a.getAreaOf​​Circumcircle() );
            }
        }
    }

}
