package codeptit;
import java.util.*;
public class QuanLyBaiTapNhom2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ListAssignment a = new ListAssignment();
        a.input(sc, n, m);
        a.sort();
        System.out.println(a);
    }

}


class ListAssignment {
    private ArrayList<Student6004> lst = new ArrayList<>();
    private ArrayList<String> asm = new ArrayList<>();
    
    public void input(Scanner sc, int n, int m) {
        for (int i =0 ; i < n ;i++) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int teamNumber = Integer.parseInt(sc.nextLine());
            Student6004 std = new Student6004(code, name, phone, teamNumber);
            lst.add(std);
        }
        
        for (int i = 0; i < m ;i++) asm.add(sc.nextLine());
    }
    public void sort() {
        Collections.sort(lst);
    }
    public void search(int teamNumber) {
        for (Student6004 i : lst) {
            if (i.getTeamNumber() == teamNumber ) System.out.println(i );
        }
        System.out.println("Bai tap dang ky: " + getAssignment(teamNumber) );
    }
    
    public String getAssignment(int teamNumber) {
        return asm.get(teamNumber - 1);
    }
    @Override
    public String toString() {
        for (Student6004 i : lst) System.out.println(i + " " + getAssignment(i.getTeamNumber()) );
        return "";
    }
}

class Student6004 implements Comparable<Student6004>{
    private String code, name , phone_number;
    private int teamNumber;
    
    public Student6004(String code, String name, String phone_number, int teamNumber) {
        this.code = code;
        this.name = name;
        this.phone_number = phone_number;
        this.teamNumber = teamNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " + phone_number + " " + teamNumber ;
    }
    
    public int compareTo(Student6004 o) {
        if (code.compareTo(o.code) > 0) return 1;
        return -1;
    }
}

