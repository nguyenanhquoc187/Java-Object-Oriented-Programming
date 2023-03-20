package codeptit;
import java.util.*;

public class BangXepHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Student> arrayList = new ArrayList<>();

        while(t-- > 0){
            sc.nextLine();
            arrayList.add(new Student(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arrayList, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getCorrect() == o2.getCorrect() && o1.getTotalSubmission() == o2.getTotalSubmission()){
                    return o1.getName().compareTo(o2.getName());
                }
                if (o1.getCorrect() == o2.getCorrect()) {
                    return o1.getTotalSubmission() > o2.getTotalSubmission() ? 1 : -1;
                }
                return o1.getCorrect() < o2.getCorrect() ? 1 : -1;
            }
        });

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

class Student{
    private String name;
    private int correct;
    private int totalSubmission;

    public Student(String name, int correct, int totalSubmission) {
        this.name = name;
        this.correct = correct;
        this.totalSubmission = totalSubmission;
    }

    public String getName() {
        return name;
    }

    public int getCorrect() {
        return correct;
    }

    public int getTotalSubmission() {
        return totalSubmission;
    }

    @Override
    public String toString() {
        return name + " " + correct + " " + totalSubmission;
    }
}