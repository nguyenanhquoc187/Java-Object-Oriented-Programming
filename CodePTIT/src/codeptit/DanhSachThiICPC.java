package codeptit;
import java.util.*;
public class DanhSachThiICPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLTeam lst1 = new QLTeam();
        DsThiSinhICPC lst2 = new DsThiSinhICPC();
        lst1.input(sc);
        lst2.input(sc);
        lst2.Sort();
        lst2.display(lst1);
    }

}


class QLTeam {
    private ArrayList<Team> a = new ArrayList<>();
    private int n;
    
    public void input(Scanner sc) {
        n = Integer.parseInt(sc.nextLine());
        for (int i =0  ; i< n ;i++) {
            String name = sc.nextLine();
            String uni = sc.nextLine();
            Team tmp = new Team(name, uni);
            a.add(tmp);
        }
    }
    public String findTeam(String teamCode) {
        for (Team i : a) {
            if (i.getCode().equals(teamCode )) {
                return i.getName() +" " +  i.getUni();
            }
        }
        return "";
    }
    
}

class DsThiSinhICPC {
    private ArrayList<ThiSinhICPC> lst = new ArrayList<>();
    private int n ;
    public void input(Scanner sc) {
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i< n;i++) {
            String name = sc.nextLine();
            String Teamcode = sc.nextLine();
            ThiSinhICPC tmp = new ThiSinhICPC(name, Teamcode);
            lst.add(tmp);
        }
    }
    
    public void Sort() {
        Collections.sort(lst);
    }
    
    public String display(QLTeam lst1) {
        for (ThiSinhICPC i : lst) {f
            System.out.println(i.getCode() + " " + i.getName() + " " + lst1.findTeam(i.getTeamCode()));
        }
        return "";
    }
}
class Team {
    private String code, name, uni;
    private static int j = 1;
    public Team(String name, String uni) {
        this.code = "Team"  + String.format("%02d", j);
        j++;
        this.name = name;
        this.uni = uni;
    }

    public String getName() {
        return name;
    }

    public String getUni() {
        return uni;
    }

    public String getCode() {
        return code;
    }
    
}

class ThiSinhICPC implements Comparable<ThiSinhICPC>{
    private String code, name, teamCode;
    private static int j = 1;

    public ThiSinhICPC(String name, String teamCode) {
        this.code = "C" + String.format("%03d", j);
        j++;
        this.name = name;
        this.teamCode = teamCode;
    }
    
    @Override
    public int compareTo(ThiSinhICPC o) {
        if (name.compareTo(o.name) > 0) return 1;
        return -1;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getTeamCode() {
        return teamCode;
    }
}
