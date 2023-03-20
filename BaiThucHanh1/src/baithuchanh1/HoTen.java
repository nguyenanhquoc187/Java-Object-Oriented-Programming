package baithuchanh1;
import java.util.*;
public class HoTen {
    private String ten, ngaysinh;

    public String getTen() {
        return ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ten = s.substring(0, s.indexOf("*")); 
        ngaysinh = s.substring(s.indexOf("*") +1);
    }
    public boolean checkHoten() {
        String rex = "[a-zA-Z ]+";
        return ten.matches(rex);
    }
    
    public int getTuoi() {
        String s = ngaysinh.substring(ngaysinh.lastIndexOf("/")+1);
        return 2022 - Integer.parseInt(s);
    }
}
