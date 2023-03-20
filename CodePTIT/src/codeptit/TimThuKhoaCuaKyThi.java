package codeptit;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TimThuKhoaCuaKyThi {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        ArrayList<thukhoa> ds = new ArrayList<>();
        int n = Integer.parseInt(input.nextLine());
        float max = 0;
        for(int i = 0;i<n;i++){
            thukhoa a = new thukhoa(i, input.nextLine(), input.nextLine(), Float.parseFloat(input.nextLine()),Float.parseFloat(input.nextLine()),Float.parseFloat(input.nextLine()));
            if(a.tong()>max){
                max = a.tong();
            }
            ds.add(a);
        }
        for(thukhoa i:ds){
            if(i.tong() == max){
                System.out.println(i);
            }
        }
    }
}
class thukhoa {
    private int id;
    private String name,ngaysinh;
    private float mon1,non2,mon3;

    public thukhoa(int id, String name, String ngaysinh, float mon1, float non2, float mon3) throws ParseException {
        this.id = id+1;
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.mon1 = mon1;
        this.non2 = non2;
        this.mon3 = mon3;
    }
    public float tong(){
        return mon1+non2+mon3;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+ngaysinh+" "+tong();
    }
}