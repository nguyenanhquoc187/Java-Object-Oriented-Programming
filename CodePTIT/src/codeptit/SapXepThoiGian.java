package codeptit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class SapXepThoiGian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Time> a = new ArrayList();
        for (int i =0 ; i< t; i++) {
            Time x = new Time();
            x.nextTime(sc);
            a.add(x);
        }
        Collections.sort(a, (Time t1, Time t2) -> {
            if(t1.getGio() != t2.getGio()){
                return t1.getGio() - t2.getGio();
            }
            if(t1.getPhut() != t2.getPhut()){
                return t1.getPhut() - t2.getPhut();
            }
            return t1.getGiay() - t2.getGiay();
        });
        for (int i = 0 ; i < a.size();i++) {
            a.get(i).display();
        }
    }
}
class Time {
    private int gio,phut,giay;
    public Time() {
        gio = 0;
        phut = 0;
        giay = 0;
    }
    public Time(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }
    public Scanner nextTime(Scanner sc) {
        gio = sc.nextInt();
        phut = sc.nextInt();
        giay = sc.nextInt();
        return sc;
    }
    public int getGio() {
        return gio;
    }
    public int getPhut() {
        return phut;
    }
    public int getGiay() {
        return giay;
    }
    public void display() {
        System.out.println(gio + " " + phut + " " + giay);
    }
}