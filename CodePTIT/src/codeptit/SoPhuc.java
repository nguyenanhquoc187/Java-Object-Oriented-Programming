package codeptit;
import java.util.*;
public class SoPhuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            Complex A = new Complex(a,b);
            Complex B = new Complex(c, d);
            Complex C = A.add(B).mul(A);
            Complex D = A.add(B).mul( A.add(B) );
            System.out.print(C + ", " + D + "\n");
        }
    }

}
class Complex {
    private int real, imag;

    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }
    
    public Complex add(Complex b) {
        return new Complex(real+ b.real, imag + b.imag);
    }
    
    public Complex mul(Complex b) {
        return new Complex(real*b.real - imag*b.imag, real*b.imag + imag*b.real);
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }
    
    @Override
    public String toString() {
        if (imag < 0) return real + " - " + -imag + "i";
        return real + " + " + imag +"i";
    }
}
