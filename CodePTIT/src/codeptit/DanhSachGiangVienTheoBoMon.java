package codeptit;
import java.util.*;
public class DanhSachGiangVienTheoBoMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> a = new ArrayList<>();
        while(t-- >0) {
            GiangVien tmp = new GiangVien();
            tmp.input(sc);
            a.add(tmp);
        }
        int n = Integer.parseInt(sc.nextLine());
        while (n-- >0) {
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN BO MON " + xuly(s) +":");
            for (GiangVien i : a) 
                if (i.getSubject().equals(s) ) System.out.println(i);
        }
        
    }
    
    public static String xuly(String s) {
        String code ="";
        code += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' ) code+= s.charAt(i+1);
        }
        return code.toUpperCase();
    }
    
    public static class GiangVien {
        private String GvCode,name, subject;
        private static int j = 1;

        public String getSubject() {
            return subject;
        }
        
        public void input(Scanner sc) {
            GvCode = "GV" + String.format("%02d", j);
            j++;
            name = sc.nextLine();
            subject = sc.nextLine();
        }
        
        public String getSubject_code() {
            String code ="";
            code += subject.charAt(0);
            for (int i = 1; i < subject.length(); i++) {
                if (subject.charAt(i) == ' ' ) code+= subject.charAt(i+1);
            }
            return code.toUpperCase();
        }
        public String toString() {
            return GvCode + " " + name + " " + getSubject_code();
        }
    }

}

