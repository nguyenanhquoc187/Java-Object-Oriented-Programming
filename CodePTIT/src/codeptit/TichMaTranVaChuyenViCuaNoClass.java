package codeptit;
import java.util.*;
public class TichMaTranVaChuyenViCuaNoClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
    }
}
class Matrix {
    private int[][] a;
    private int row, col;
    public Matrix(int row, int col) {
        a = new int[row+1][col +1];
        this.row = row ;
        this.col = col;
    }
    public void nextMatrix(Scanner sc) {
        for (int i = 1; i <= row;i++) 
            for (int j = 1; j <= col; j++) a[i][j] = sc.nextInt();
    }
    public Matrix trans() {
        Matrix b = new Matrix(col, row);
        for (int i = 1 ; i <=col;i++) {
                for (int j = 1; j<= row;j++) b.a[i][j] = this.a[j][i];
            }
        return b;
    }
    public Matrix mul(Matrix b) {
        Matrix c = new Matrix(row, row);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                int sum = 0;
                for (int k = 1; k <= col ; k++) sum = sum + (this.a[i][k]*b.a[k][j] );
                c.a[i][j] = sum;
            }
        }
        return c;
    }
    public String toString() {
        for (int i= 1;  i <= row; i++) {
            for  (int j =1 ; j <= col;j++) System.out.print(a[i][j] + " ");
            System.out.println("");
        }
        return "";
    }
}