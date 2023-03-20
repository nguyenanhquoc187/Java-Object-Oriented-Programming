package codeptit;
import java.util.*;
public class KiemTraDayNgoacDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            int check = 1;
            for (int i=0;i < s.length();i++) {
                if ( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ) st.add(s.charAt(i));
                else {
                    if (st.empty()) {
                        check = 0; break;
                    }
                    if ( s.charAt(i) == ')'  ){
                        if ( st.peek() == '(' ) st.pop(); else check  =0;
                    }
                    if ( s.charAt(i) == ']' ) {
                        if ( st.peek() == '[' ) st.pop(); else check  =0;
                    }
                    if ( s.charAt(i) == '}' ){
                        if ( st.peek() == '{' ) st.pop(); else check  =0;
                    }
                    if (check == 0 ) break;
                }
            }

            if (check == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
