package Q1;

import java.util.*;

public class PhoneBook implements ChucNang{
    private List<PhoneNumber> lst ;
    private Scanner sc = new Scanner(System.in);
    public PhoneBook() {
        lst = new ArrayList<>();
    }
    
    public PhoneNumber nhap() {
        System.out.print("Nhap ma vung: ");
        String rex = "^\\d{3,4}";
        String mavung;
        while (true) {
            mavung = sc.nextLine() ;
            if (mavung.matches(rex)) break;
            else {
                System.err.println("Nhap laij!!!");
            }
        }
        System.out.print("Nhap so noi vung: ");
        String noivung ;
        rex = "[0-9]+";
        while (true) {
            noivung = sc.nextLine() ;
            if (noivung.matches(rex)) break;
            else {
                System.err.println("Nhap laij!!!");
            }
        }
        return new PhoneNumber(mavung, noivung);
    }

    @Override
    public void nhapSoTrongNuoc() {
        lst.add(nhap() );
    }

    @Override
    public void nhapSoQuocTe() {
        System.out.print("Nhap ma quoc gia: ");
        String maquocgia = sc.nextLine();
        PhoneNumber tmp = nhap();
        lst.add(new IntlPhoneNumber(maquocgia,tmp.getMavung() , tmp.getNoivung()));
    }

    @Override
    public void timTheoMaVung() {
        System.out.print("Nhap ma vung can tim: ");
        String mavung = sc.nextLine();
        System.out.println("So dien thoai co ma vung " + mavung + " la: ");
        for (PhoneNumber i : lst) {
            if (i.getMavung().equals(mavung) ) System.out.println(i);
        }
    }

    @Override
    public void lietKeSoTrongNuoc() {
        System.out.println("Danh sach so trong nuoc: ");
        for (PhoneNumber i : lst) {
            if (!(i instanceof IntlPhoneNumber)) System.out.println(i);
        }
        System.out.println("---------------");
    }

    @Override
    public void lietKeSoQuocTe() {
        System.out.println("Danh sach so quoc te: ");
        for (PhoneNumber i : lst) {
            if (i instanceof IntlPhoneNumber) System.out.println(i);
        }
        System.out.println("---------------");
    }

    @Override
    public void tinhTongSoDienThoaiTheoTungVung() {
        System.out.print("Nhap ma vung can tinh tong: ");
        String mavung = sc.nextLine();
        int dem = 0;
        for (PhoneNumber i : lst) {
            if (i.getMavung().equals(mavung) ) dem++;
        }
        System.out.println("Tong so dien thoai co ma vung " + mavung + " la: " + dem);
    }

    @Override
    public void timKiemSoTheoDuoi() {
        System.out.print("Nhap duoi so dien thoai can tim: ");
        String duoi = sc.nextLine();
        System.out.println("So dien thoai co duoi " + duoi + " la: " );
        for (PhoneNumber i : lst) {
            if (i.getNoivung().endsWith(duoi) ) System.out.println(i);
        }
    }

    @Override
    public void SapXep() {
        Collections.sort(lst);
    }
}
