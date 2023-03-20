package codeptit;
import java.util.*;
public class GoBanPhim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        String tmp = "";
        for (int i = 0 ; i < s.length(); i++) {
            char x = s.charAt(i);
            if(x == '<'){
                if(!st.empty()){
                    st2.push(st.pop());
                }
            }
            else if(x == '>'){
                if(!st2.empty()){
                    st.push(st2.pop());
                }
            }
            else if(x == '-'){
                if(!st.empty()){
                    st.pop();
                }
            }
            else{
                st.push(x);
            }
        }
        while (!st.empty()) {
            st2.push(st.pop());
        }
        while(!st2.empty()){
            System.out.print(st2.pop());
        }
    }

}
