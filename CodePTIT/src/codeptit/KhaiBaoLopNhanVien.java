package codeptit;
import java.util.Scanner;
public class KhaiBaoLopNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien a = new NhanVien();
        a.nextNv(sc);
        a.display();
    }
}
class NhanVien {
    private String maNv,hoTen,gioitinh,ngaysinh,diachi,msthue,ngaykyhd;
    public NhanVien() {
        maNv = "00001";
    }
    public Scanner nextNv(Scanner sc) {
        hoTen = sc.nextLine();
        gioitinh = sc.nextLine();
        ngaysinh = sc.nextLine();
        diachi = sc.nextLine();
        msthue = sc.nextLine();
        ngaykyhd = sc.nextLine();
        return sc;
    }
    public void display() {
        System.out.println(maNv + " " + hoTen + " " + gioitinh + " " + ngaysinh + " " + diachi + " " + msthue + " " + ngaykyhd);
    }
    
}