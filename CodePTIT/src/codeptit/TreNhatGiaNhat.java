package codeptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TreNhatGiaNhat {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> a = new ArrayList<>();
        for (int i = 0 ; i < n ;i++) {
            a.add(new Person(sc.next(), sc.next()));
        }
        
        Collections.sort(a);
        System.out.println(a.get(0).getName() + '\n' + a.get(a.size() - 1).getName());
    }
        
}
class Person implements Comparable<Person> {
    private String name;
    private Date birthOfDay;

    public Person(String name, String birthOfDay) throws ParseException {
        this.name = name;
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        this.birthOfDay = fm.parse(birthOfDay);
    }

    public String getName() {
        return name;
    }
    
    public int compareTo(Person o) {
        if (birthOfDay.before(o.birthOfDay) ) return 1;
        return -1;
    }
    
}
