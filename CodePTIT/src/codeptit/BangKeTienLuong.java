package codeptit;
import java.util.*;
public class BangKeTienLuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List_Employee a = new List_Employee();
        a.input(sc,n);
        System.out.println(a);
    }

}

class List_Employee {
    private ArrayList<Employee> lst = new ArrayList<>();
    private long total;
    public void input(Scanner sc, int n) {
        for (int i = 0 ; i < n ;i++) {
            String name = sc.nextLine();
            long salary = Long.parseLong(sc.nextLine());
            long workDay = Long.parseLong(sc.nextLine());
            String position = sc.nextLine();
            Employee e = new Employee(name, position, salary, workDay);
            lst.add(e);
            total+= e.getIncome();
        }
    }
    @Override
    public String toString() {
        for (Employee i : lst) System.out.println(i);
        return "Tong chi phi tien luong: " + total;
    }
}

class Employee {
    private String code, name, position;
    private long salary, workDay;
    private static int j = 1;
    public Employee(String name, String position, long salary, long workDay) {
        this.code = "NV" + String.format("%02d", j);    
        j++;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.workDay = workDay;
        this.salary*=workDay;
    }

    public long getSalary() {
        return salary;
    }
    
    public long getBonus() {
        if (workDay >= 25) return (long) (0.2*salary);
        if (workDay >= 22 ) return (long) (0.1*salary );
        return 0;
    }
    
    public long getAllowance() {
        if (position.equals("GD") ) return 250000;
        if (position.equals("PGD")) return 200000;
        if (position.equals("TP")) return 180000;
        return 150000;
    }
    
    public long getIncome() {
        return getSalary() + getBonus() + getAllowance();
    }
    @Override
    public String toString() {
        return code + " " + name + " " + salary + " " + getBonus() + " " + getAllowance() + " " + getIncome() ;
    }
}
