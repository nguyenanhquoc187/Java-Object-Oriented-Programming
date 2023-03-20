package test1online;

import java.util.Scanner;

public class VanBan {
    public String s;
    public void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
    }
    public int getSoCau() {
        String rex = "[?.!]";
        String[] cau = s.split(rex);
        return cau.length;
    }
    public String chuanHoa() {
        String rex = "\\s+";
        String[] tu = s.split(rex);
        String ans ="";
        for (int i = 0 ; i< tu.length ; i++) {
            ans = ans + " " + tu[i];
        }
        ans = ans.trim();
        return ans;
    }
}
