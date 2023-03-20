package codeptit;

import java.util.*;
import java.text.Format;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String n = sc.nextLine();
            String s = sc.nextLine();
            Stack<String> st = new Stack<>();
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                
                if (s.charAt(i) == ' ' && !res.isEmpty()) {
                    st.push(res);
                    res = "";
                } else {
                    if ((s.charAt(i) == '-' && s.charAt(i+1)  != ' ') || (s.charAt(i) >= '0' && s.charAt(i) <= '9') ) {
                        res += s.charAt(i);
                    } else {
                        long ans = 0;
                        String x = st.pop();
                        String y = st.pop();
                        if (s.charAt(i) == '+') {
                            ans = Long.parseLong(y) + Long.parseLong(x);
                        }
                        if (s.charAt(i) == '-') {
                            ans = Long.parseLong(y) - Long.parseLong(x);
                        }
                        if (s.charAt(i) == '*') {
                            ans = Long.parseLong(y) * Long.parseLong(x);
                        }
                        if (s.charAt(i) == '/') {
                            ans = Long.parseLong(y) / Long.parseLong(x);
                        }
                        String tmp = "";
                        if (ans < 0) {
                            ans *= -1;
                            tmp = tmp + "-" + ans;
                        } else {
                            tmp = ans +"";
                        }
                        st.push(tmp);
                    }
                }
//                else {
//                    long ans = 0;
//                    String x = st.pop();
//                    String y = st.pop();
//                    if (s.charAt(i) == '+') {
//                        ans = Long.parseLong(y) + Long.parseLong(x);
//                    }
//                    if (s.charAt(i) == '-') {
//                        ans = Long.parseLong(y) - Long.parseLong(x);
//                    }
//                    if (s.charAt(i) == '*') {
//                        ans = Long.parseLong(y) * Long.parseLong(x);
//                    }
//                    if (s.charAt(i) == '/') {
//                        ans = Long.parseLong(y) / Long.parseLong(x);
//                    }
//                    String tmp = "";
//                    if (ans < 0) {
//                        ans *= -1;
//                        tmp = tmp + "-" + ans;
//                    } else {
//                        tmp = ans + "";
//                    }
//                    st.push(tmp);
//                }
            }
            System.out.println(st.peek());
        }
    }

}
