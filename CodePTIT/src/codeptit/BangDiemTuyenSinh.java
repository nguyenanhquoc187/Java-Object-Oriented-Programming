package codeptit;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BangDiemTuyenSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Student> arrayList = new ArrayList<>();
        while (t-- > 0){
            sc.nextLine();
            arrayList.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextDouble(),sc.nextDouble(), sc.nextDouble()));
        }

        for (Student i : arrayList) {
            System.out.println(i);
        }
    }
}

class Student{
    private String id;
    private String name;
    private double math;
    private double physic;
    private double chemistry;

    public Student(String id, String name, double math, double physic, double chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public double sumMark(){
        return math * 2 + physic + chemistry;
    }

    public double diemUuTien(){
        String s = id.substring(0, 3);
        if(s.equals("KV1")) return 0.5;
        if(s.equals("KV2")) return 1.0;
        if(s.equals("KV3")) return 2.5;
        return 0;
    }

    public String status(){
        if(sumMark() + diemUuTien() >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }

    public static String removeZero(double number) {
        DecimalFormat format = new DecimalFormat("#.###########");
        return format.format(number);
    }

    @Override
    public String toString(){
        return id + " " + name + " " + removeZero(diemUuTien()) + " " + removeZero(sumMark()) + " " + status();
    }
}