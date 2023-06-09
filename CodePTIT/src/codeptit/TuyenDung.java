package codeptit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class TuyenDung {

    private String ma, hoTen, xepLoai;
    private double diemLT, diemTH, diemTB;

    public TuyenDung(int ma, String hoTen, double diemLT, double diemTH) {
        this.ma = "TS" + String.format("%02d", ma);
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public void setDiemTB() {
        this.diemTB = (diemLT + diemTH) / 2;
    }

    public void setXepLoai() {
        if (diemTB < 5) {
            this.xepLoai = "TRUOT";
        } else if (diemTB < 8) {
            this.xepLoai = "CAN NHAC";
        } else if (diemTB <= 9.5) {
            this.xepLoai = "DAT";
        } else if (diemTB > 9.5) {
            this.xepLoai = "XUAT SAC";
        }
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + String.format("%.02f", diemTB) + " " + xepLoai;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TuyenDung[] a = new TuyenDung[n];
        for (int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            double diemLT = sc.nextDouble();
            if (diemLT > 10) {
                diemLT = diemLT / 10;
            }
            double diemTH = sc.nextDouble();
            if (diemTH > 10) {
                diemTH = diemTH / 10;
            }
            sc.nextLine();
            a[i] = new TuyenDung(i + 1, hoTen, diemLT, diemTH);
            a[i].setDiemTB();
            a[i].setXepLoai();
        }

        Arrays.sort(a, new Comparator<TuyenDung>() {
            @Override
            public int compare(TuyenDung t, TuyenDung t1) {
                return Double.compare(t1.diemTB, t.diemTB);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
