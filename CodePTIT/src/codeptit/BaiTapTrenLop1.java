package codeptit;
import java.util.*;
public class BaiTapTrenLop1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ListBill a = new ListBill();
        while (true) {
            System.out.println("Chon so 0: Thoat");
            System.out.println("Chon so 1: Nhap hoa don");
            System.out.println("Chon so 2: In danh sach");
            System.out.println("Chon so 3: Tim kiem hoa don theo ma");
            System.out.println("Chon so 4: Tim kiem hoa don theo ten");
            System.out.println("Chon so 5: Sua hoa don khi nhap ma");
            System.out.println("Chon so 6: Sap xep hoa don theo tien thanh toan(tang dan): ");
            int x = Integer.parseInt(sc.nextLine() );
            
            switch (x) {
                
                case 0:
                    System.out.println("Bye!!");
                    System.exit(0);
                case 1:
                    System.out.println("Da chon so 1: Nhap so hoa don ");
                    a.input();
                    break;
                case 2:
                    System.out.println("Da chon so 2:Ds hoa don");
                    a.showlist();
                    break;
                case 3:
                    System.out.println("Da chon so 3: Nhap ma hoa don: ");
                    String ma = sc.nextLine();
                    System.out.println("Hoa don: ");
                    for (int i = 0 ; i < n ;i++) {
                        if (i.getCode().equals(ma) ) System.out.println(i);
                    }
                    break;
                case 4:
                    System.out.println("Da chon so 4: Nhap ten KH: ");
                    String ten = sc.nextLine();
                    System.out.println("Hoa don: ");
                    for (Bill i : a) {
                        if (i.getName().equals(ten) ) System.out.println(i);
                    }
                    break;
                case 5:
                    System.out.println("Da cho so 5: Nhap ma hoa don can sua: ");
                    ma = sc.nextLine();
                    for (Bill i : a) {
                        if (i.getCode().equals(ma) ) {
                            System.out.println("Nhap ngay xuat: ");
                            i.setDate(sc.nextLine());
                            System.out.println("Nhap ten: ");
                            i.setName(sc.nextLine());
                            System.out.println("Nhap tien thanh toan: ");
                            i.setCost(Long.parseLong(sc.nextLine()));
                        }
                    }
                    break;
                case 6:
                    System.out.println("Da chon so 6:");
                    Collections.sort(a);
                    System.out.println("Da sap xep");
                    break;
            }
        }
    }
}

class ListBill {
    private Bill[] lst ;
    private int n;
    public ListBill() {
        n = 0;
    }
    public void input() {
        lst[n++].input();
    }
    public void showlist() {
        for (int i =0 ; i < n ;i++) System.out.println(lst[i]);
    }
    
    
}
class Bill {
    private String code, date, name;
    private long cost;

    public String getName() {
        return name;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        code = sc.nextLine();
        date = sc.nextLine();
        name = sc.nextLine();
        cost = Long.parseLong(sc.nextLine());
    }
    @Override
    public String toString() {
        return code + " " + date + " " + name + " " + cost;
    }
    
}