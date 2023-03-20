package Q4;
import java.util.*;
public class QLGV implements ChucNang{
    private List<GiangVien> lst;
    private Scanner sc = new Scanner(System.in);

    public QLGV() {
        lst = new ArrayList<>();
    }
    private int tontai(String ma) {
        for (int i = 0 ; i  < lst.size(); i++) {
            if (lst.get(i).getMa().equalsIgnoreCase(ma) ) return i;
        }
        return -1;
    }
    private GiangVien nhap() {
        System.out.print("Nhap ma: ");
        String rex = "^GV\\d{3}";
        String ma,ten, email, hocham, hocvi, diachi, sdt;
        int sogiogiangday;
        
        while (true) {
            ma = sc.nextLine().toUpperCase();
            if (ma.matches(rex) && tontai(ma) == -1) break;
            else {
                System.err.println("Nhap lai!!!");
            }
        }
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap hoc ham: ");
        hocham = sc.nextLine();
        System.out.print("Nhap hoc vi: ");
        hocvi = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        System.out.print("Nhap so gio giang day: ");
        sogiogiangday = Integer.parseInt(sc.nextLine());
        return new GiangVien(ma, ten, email, hocham, hocvi, diachi, sdt, sogiogiangday);
    }

    @Override
    public void nhapGiangVienHuuCo() {
        GiangVien tmp = nhap();
        System.out.print("Nhap luong thoa thuan: ");
        double luongthoathuan = Double.parseDouble(sc.nextLine());
        lst.add(new GiangVienHC(tmp.getMa(), tmp.getTen(), tmp.getEmail(), tmp.getHocham(), tmp.getHocvi(), tmp.getDiachi(), tmp.getDiachi(), tmp.getSogiogiangday(), luongthoathuan));
    }

    @Override
    public void nhapGiangVienThinhGiang() {
        GiangVien tmp = nhap();
        System.out.print("Nhap co quan: ");
        String coquan = sc.nextLine();
        lst.add(new GiangVienTG(tmp.getMa(), tmp.getTen(), tmp.getEmail(), tmp.getHocham(), tmp.getHocvi(), tmp.getDiachi(), tmp.getDiachi(), tmp.getSogiogiangday(), coquan));
    }

    @Override
    public void inDanhSachGiangVienHuuCo() {
        System.out.println("Danh sach giang vien huu co: ");
        for (GiangVien i : lst) {
            if (i instanceof GiangVienHC) System.out.println(i);
        }
        System.out.println("-----------------------");
    }

    @Override
    public void inDanhSachGiangVienThinhGiang() {
        System.out.println("Danh sach giang vien thinh giang: ");
        for (GiangVien i : lst) {
            if (i instanceof GiangVienTG) System.out.println(i);
        }
        System.out.println("-----------------------");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma muon xoa: ");
        String ma = sc.nextLine();
        if (tontai(ma) == -1 ) {
            System.out.println("Co dau ma xoa!!");
        } else {
            int vitri = tontai(ma);
            lst.remove(vitri);
            System.out.println("Xoa thanh cong!!");
        }
    }

    @Override
    public void sua() {
        System.out.println("Nhap ma muon sua: ");
        String ma = sc.nextLine();
        if (tontai(ma) == -1 ) {
            System.out.println("Co dau ma sua!!");
        } else {
            int vitri = tontai(ma);
            GiangVien a = lst.get(vitri);
            System.out.print("Nhap ten: ");
            String ten = sc.nextLine();
            System.out.print("Nhap email: ");
            String email = sc.nextLine();
            System.out.print("Nhap hoc ham: ");
            String hocham = sc.nextLine();
            System.out.print("Nhap hoc vi: ");
            String hocvi = sc.nextLine();
            System.out.print("Nhap dia chi: ");
            String diachi = sc.nextLine();
            System.out.print("Nhap so dien thoai: ");
            String sdt = sc.nextLine();
            System.out.print("Nhap so gio giang day: ");
            int sogiogiangday = Integer.parseInt(sc.nextLine());
            a.setTen(ten);
            a.setEmail(email);
            a.setHocham(hocham);
            a.setHocvi(hocvi);
            a.setDiachi(diachi);
            a.setSdt(sdt);
            a.setSogiogiangday(sogiogiangday);
            a.setHesoluong();
            System.out.println("Sua thanh cong!");
        }
    }

    @Override
    public void TimKiemGiangVienGanDung() {
        // tim theo ten
        System.out.print("Nhap ten giang vien can tim: ");
        String ten = sc.nextLine();
        System.out.println("Giang vien co chua ten " + ten + " la:");
        for (GiangVien i : lst) {
            if (i.getTen().contains(ten) ) System.out.println(i);
        }
    }

    @Override
    public void SapXepDSTheoTen() {
        // sap xep tang dan
        Collections.sort(lst);
        System.out.println("Sap xep thanh cong!!");
    }

    @Override
    public void TinhTongVaTrungBinhTienLuongCuaToanBoGV() {
        double tong = 0, tb = 0;
        for (GiangVien i : lst) {
            tong += ((TinhLuong) i).getLuong();
        }
        System.out.println("Tong tien luong cua toan bo giang vien la: " + tong);
        System.out.println("Trung binh tien luong cua toan bo giang vien la: " +  tong/(lst.size()));
    }

    @Override
    public void TimGiangVienCoLuongCaoNhat() {
        double max = 0;
        GiangVien a = null;
        for (GiangVien i : lst) {
            if (((TinhLuong) i).getLuong() > max) {
                max = ((TinhLuong) i).getLuong();
                a = i;
            }
        }
        System.out.println("Giang vien co luong cao nhat la: ");
        System.out.println(a);
    }
    
    
}
