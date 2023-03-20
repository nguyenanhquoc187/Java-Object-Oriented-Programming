package codeptit;
import java.util.*;
public class SapXepDanhSachGiangVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> a = new ArrayList<>();
        while(t-- >0) {
            GiangVien tmp = new GiangVien();
            tmp.input(sc);
            a.add(tmp);
        }
        Collections.sort(a);
        for (GiangVien i : a) System.out.println(i);
    }
    
    public static class GiangVien implements Comparable<GiangVien>{
        private String GvCode,name, subject;
        private static int j = 1;
        
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
        public String getLastName() {
            String[] str = name.split(" ");
            return str[str.length - 1];
        }
        public int compareTo(GiangVien o) {
            if (getLastName().equals(o.getLastName()) && GvCode.compareTo(o.GvCode) > 0 ) return 1;
            if (getLastName().compareTo(o.getLastName()) > 0) return 1;
            return -1;
        }
        public String toString() {
            return GvCode + " " + name + " " + getSubject_code();
        }
    }

}
