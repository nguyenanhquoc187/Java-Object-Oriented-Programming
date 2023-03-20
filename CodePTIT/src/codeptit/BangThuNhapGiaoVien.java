package codeptit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangThuNhapGiaoVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Teacher> teachers = new ArrayList<>();
        while (t-- > 0) {
            scanner.nextLine();
            teachers.add(new Teacher(scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
        }

        int ht = 0, hp = 0;
        for (Teacher teacher : teachers) {
            if (teacher.getPosition().equals("HT")){
                ht++;
                if (ht <= 1) {
                    System.out.println(teacher);
                }
            } else if (teacher.getPosition().equals("HP")){
                hp++;
                if (hp <= 2) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println(teacher);
            }
        }
    }
}


class Teacher{
    private String id;
    private String name;
    private int basicSalary;

    public Teacher(String id, String name, int basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getSalaryLevel() {
        return Integer.parseInt(id.substring(2,4));
    }

    public String getPosition() {
        return id.substring(0,2);
    }

    public int getAllowance() {
        String position = id.substring(0,2);
        if (position.equals("HT")) return 2000000;
        if (position.equals("HP")) return 900000;
        if (position.equals("GV")) return 500000;
        return 0;
    }

    public long getNetIncome() {
        return basicSalary * getSalaryLevel() + getAllowance();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getSalaryLevel() + " " + getAllowance() + " " + getNetIncome();
    }
}