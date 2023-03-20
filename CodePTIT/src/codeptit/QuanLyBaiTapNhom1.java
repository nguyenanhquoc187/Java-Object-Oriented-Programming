package codeptit;
import java.util.*;
public class QuanLyBaiTapNhom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ListAssignment a = new ListAssignment();
        a.input(sc, n, m);
        int q = sc.nextInt();
        for (int i = 0 ; i  < q ;i++) {
            int teamNumber = sc.nextInt();
            System.out.println("DANH SACH NHOM " + teamNumber + ":");
            a.search(teamNumber);
        }
    }

}


class ListAssignment {
    private ArrayList<Student6003> lst = new ArrayList<>();
    private ArrayList<String> asm = new ArrayList<>();
    
    public void input(Scanner sc, int n, int m) {
        for (int i =0 ; i < n ;i++) {
            String code = sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.nextLine();
            int teamNumber = Integer.parseInt(sc.nextLine());
            Student6003 std = new Student6003(code, name, phone, teamNumber);
            lst.add(std);
        }
        
        for (int i = 0; i < m ;i++) asm.add(sc.nextLine());
    }
    
    public void search(int teamNumber) {
        for (Student6003 i : lst) {
            if (i.getTeamNumber() == teamNumber ) System.out.println(i );
        }
        System.out.println("Bai tap dang ky: " + getAssignment(teamNumber) );
    }
    
    public String getAssignment(int teamNumber) {
        return asm.get(teamNumber - 1);
    }
    
}

class Student6003 {
    private String code, name , phone_number;
    private int teamNumber;
    
    public Student6003(String code, String name, String phone_number, int teamNumber) {
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
        return code + " " + name + " " + phone_number ;
    }
    
}
