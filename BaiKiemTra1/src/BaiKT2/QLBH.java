package BaiKT2;

import java.util.*;
import java.util.stream.Collectors;

public class QLBH implements IChucNang {

    private ArrayList<HoaDon> list;
    private Scanner sc = new Scanner(System.in);

    public QLBH() {
        list = new ArrayList<>();
    }

    public QLBH(ArrayList<HoaDon> list) {
        this.list = list;
    }

    private HoaDon nhap() {
        String ma ="", hoten="";
        int soluong = 0;
        double dongia = 0;
        while (true) {
            System.out.print("Nhap ma: ");
            ma = sc.nextLine().toUpperCase();
            String re = "^[NX]\\d{3}";
            if (ma.matches(re) && timvitri(ma) == -1) {
                break;
            } else {
                System.err.println("Ma khong dung dinh dang hoac da ton tai!!!");
            }
        }
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("Nhap so luong: ");
        while (true) {
            try {
                soluong = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
                System.err.println("Nhao lai!!!");
            }
        }
        System.out.print("Nhap don gia: ");
        while (true) {
            try {
                dongia = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e);
                System.err.println("Nhap lai!!!");
            }
        }
        return new HoaDon(ma, hoten, soluong, dongia);
    }

    public int timvitri(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void doc(String fname) {
        list = (ArrayList) IOFile.doc(fname);
    }

    @Override
    public void nhapHoaDonBanSi() {
        HoaDon tmp = nhap();
        System.out.print("Nhap tra truoc hay tra sau:(true or false): ");
        String tra = sc.nextLine();
        boolean tra2;
        if (tra.equalsIgnoreCase("true") ) tra2 = true;
        else tra2= false;
        list.add(new HoaDoanBanSi(tmp.getMa(), tmp.getHoten(), tmp.getSoluong(), tmp.getDongia(), tra2));
    }

    @Override
    public void nhapHoaDonBanLe() {
        HoaDon tmp = nhap();
        System.out.print("Nhap ngay ban: ");
        String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
        String ngayban;
        while (true) {
            ngayban = sc.nextLine();
            if (ngayban.matches(re)) break;
            else {
                System.err.println("Ngay khong dung dinh dang!!! Nhap lai!!");
            }
        }
        list.add(new HoaDonBanLe(tmp.getMa(), tmp.getHoten(), tmp.getSoluong(), tmp.getDongia(), ngayban));
    }

    @Override
    public void inDS() {
        System.out.println("Danh sach hoa don ban si: ");
        for (HoaDon i : list) {
            if ( i instanceof HoaDoanBanSi ) System.out.println(i);
        }
        System.out.println("Danh sach hoa don ban le: ");
        for (HoaDon i : list) {
            if ( i instanceof HoaDonBanLe ) System.out.println(i);
        }
        System.out.println("So luong: " + list.size());
        System.out.println("-------------------------------------");
    }

    @Override
    public void luu(String fname) {
        IOFile.viet(fname, list);
    }

    @Override
    public void timHDBLTheoNam() {
        int check = 0;
        ArrayList<HoaDonBanLe> le = new ArrayList<>();
        for (HoaDon i : list) {
            if (i instanceof HoaDonBanLe) le.add((HoaDonBanLe) i);
        }
        System.out.print("Nhap nam bat dau: ");
        int nambd = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap nam ket thuc: ");
        int namkt = Integer.parseInt(sc.nextLine());
        for (HoaDonBanLe i : le) {
            if (i.getNam() >= nambd && i.getNam()<=namkt) {
                check = 1;
                System.out.println(i);
            }
        }
        if (check == 0) System.out.println("Khong co");
    }

    @Override
    public void sapXepDSTheoTen() {
        Collections.sort(list);
        inDS();
    }

    @Override
    public void duaRaTongSoTienTheoTungNamCuaHDBL() {
        ArrayList<HoaDonBanLe> le = new ArrayList<>();
        for (HoaDon i : list) {
            if (i instanceof HoaDonBanLe) le.add((HoaDonBanLe) i);
        }
        Map<Integer,Double> sum = le.stream().collect(Collectors.groupingBy(HoaDonBanLe::getNam,Collectors.summingDouble(HoaDonBanLe::getTienTT)));
        System.out.println(sum);
    }

}
