package codeptit;
import java.util.*;

public class SapXepKetQuaXetTuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < t; i++){
            sc.nextLine();
            arrayList.add(new Person(i + 1, sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }

        Collections.sort(arrayList, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getTotalPoint() == o2.getTotalPoint()) {
                    return o1.getId().compareTo(o2.getId());
                }
                return o1.getTotalPoint() < o2.getTotalPoint() ? 1 : -1;
            }
        });

        for (Person person : arrayList) {
            System.out.println(person);
        }
    }
}

class Person {
    private final int id;
    private String name;
    private String dob;
    private double pointA, pointB;

    public Person(int id, String name, String dob, double pointA, double pointB) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public String getId() {
        return String.format("PH%02d", id);
    }

    public int getAge(){
        return 2021 - Integer.parseInt(dob.substring(6,10));
    }

    public double getBonusPoint(){
        if (pointA >= 8 && pointB >= 8) return 1;
        if (pointA >= 7.5 && pointB >= 7.5) return 0.5;
        return 0;
    }

    public int getTotalPoint(){
        double totalPoint = (pointA + pointB)/2 + getBonusPoint();
        if (totalPoint > 10) return 10;
        return (int) Math.round(totalPoint);
    }

    public String getClassification(){

        if (getTotalPoint() < 5) return "Truot";
        if (getTotalPoint() <= 6) return "Trung binh";
        if (getTotalPoint() == 7) return "Kha";
        if (getTotalPoint() == 8) return "Gioi";
        return "Xuat sac";
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + getAge() + " " + getTotalPoint() + " " + getClassification();
    }
}