package codeptit;
import java.util.ArrayList;
import java.util.Scanner;

public class TraCuuDonHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<MatHang> arrayList = new ArrayList<>();
        while (t-- > 0){
            sc.nextLine();
            arrayList.add(new MatHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (MatHang matHang : arrayList){
            System.out.println(matHang);
        }
    }
}

class MatHang{
    private String tenHang;
    private String maDonHang;
    private int donGia;
    private int soLuong;

    public MatHang(String tenHang, String maDonHang, int donGia, int soLuong) {
        this.tenHang = tenHang;
        this.maDonHang = maDonHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getSoThuTu(){
        return maDonHang.substring(1,4);
    }

    public int getGiamGia(){
        if(maDonHang.endsWith("1")) return (int) Math.round(0.5 * donGia * soLuong);
        if(maDonHang.endsWith("2")) return (int) Math.round(0.3 * donGia * soLuong);
        return 0;
    }

    public int getThanhTien(){
        return soLuong * donGia - getGiamGia();
    }

    @Override
    public String toString() {
        return tenHang + " " + maDonHang + " " + getSoThuTu() + " " + getGiamGia() + " " + getThanhTien();
    }
}