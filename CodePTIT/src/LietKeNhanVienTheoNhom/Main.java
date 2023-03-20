package LietKeNhanVienTheoNhom;

/**
 *
 * @author ADMIN
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> m = new LinkedHashMap<>();
        m.put("PP", 0); m.put("TP", 0);
        for (int i = 0 ; i < n ;i++) {
            NhanVien tmp = new NhanVien(sc.next(), sc.nextLine().trim());
            if (tmp.getChucvu().equals("GD") ) {
                if (m.get("GD") == null) {a.add(tmp);
                    m.put("GD", 1);
                } else {
                    tmp.setChucvu("NV");
                }
            }
            else if (tmp.getChucvu().equals("PP") ) {
                if (m.get("PP") < 3) {
                    m.put("PP", m.get("PP") + 1);
                } else {
                    tmp.setChucvu("NV");
                }
            }
            else if (tmp.getChucvu().equals("TP") ) {
                if (m.get("TP") < 3) {
                    m.put("TP", m.get("TP") + 1);
                } else {
                    tmp.setChucvu("NV");
                } 
            } else tmp.setChucvu("NV");
            a.add(tmp);
        }
        Collections.sort(a);
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < k ;i++) {
            String cv = sc.nextLine();
            for (NhanVien j : a) {
                if (j.getChucvu().equals(cv) ) System.out.println(j);
            }
            System.out.println("");
        }
    }
}