package Q6;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class QLGD implements ChucNang {

    private List<GiaoDich> lst;
    private Scanner sc = new Scanner(System.in);

    public QLGD() {
        lst = new ArrayList<>();
    }

    public int tontai(String ma) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public GiaoDich nhap() {
        String ma;
        String ngaygd;
        double dongia;
        int soluong;
        System.out.print("Nhap ma: ");
        while (true) {
            ma = sc.nextLine().toUpperCase();
            String rex = "^GD\\d{3}";
            if (ma.matches(rex) && tontai(ma) == -1) {
                break;
            } else {
                System.err.println("Nhap lai!!! ");
            }
        }
        System.out.print("Nhap ngay giao dich: ");
        String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while (true) {
            ngaygd = sc.nextLine();
            if (ngaygd.matches(re)) {
                break;
            } else {
                System.err.println("Ngay giao dich khong dung dinh dang");
            }
        }
        System.out.print("Nhap don gia: ");
        dongia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        soluong = Integer.parseInt(sc.nextLine());
        return new GiaoDich(ma, ngaygd, dongia, soluong);
    }

    @Override
    public void nhapGiaoDichVang() {
        String loaivang;
        GiaoDich gd = nhap();
        System.out.print("Nhap loai vang: ");
        loaivang = sc.nextLine();
        lst.add(new GiaoDichVang(gd.getMa(), gd.getNgaygd(), gd.getDongia(), gd.getSoluong(), loaivang));
    }

    @Override
    public void nhapGiaoDichTienTe() {
        GiaoDich gd = nhap();
        System.out.print("Nhap ti gia: ");
        double tigia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap loai tien te: ");
        String loaitiente = sc.nextLine();
        lst.add(new GiaoDichTienTe(gd.getMa(), gd.getNgaygd(), gd.getDongia(), gd.getSoluong(), tigia, loaitiente));
    }

    @Override
    public void hienthiDs() {
        System.out.println("Danh sach giao dich vang: ");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichVang) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich tien te: ");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichTienTe) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich dat: ");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichDat) {
                System.out.println(i);
            }
        }
        System.out.println("------------------------------");
    }

    @Override
    public void sua() {
        System.out.println("Nhap ma muon sua: ");
        String ma = sc.nextLine();
        if (tontai(ma) == -1) {
            System.out.println("Co dau ma sua!!");
        } else {
            int vitri = tontai(ma);
            GiaoDich tmp = lst.get(vitri);
            System.out.print("Nhap ngay giao dich: ");
            String ngaygd ;
            String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
            while (true) {
                ngaygd = sc.nextLine();
                if (ngaygd.matches(re)) {
                    break;
                } else {
                    System.err.println("Ngay giao dich khong dung dinh dang");
                }
            }
            System.out.print("Nhap don gia: ");
            Double dongia = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap so luong: ");
            int soluong = Integer.parseInt(sc.nextLine());
            tmp.setNgaygd(ngaygd);
            tmp.setDongia(dongia);
            tmp.setSoluong(soluong);
            System.out.println("Sua thanh cong!");
        }
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma muon xoa: ");
        String ma = sc.nextLine();
        if (tontai(ma) == -1) {
            System.out.println("Co dau ma xoa!!");
        } else {
            int vitri = tontai(ma);
            lst.remove(vitri);
            System.out.println("Xoa thanh cong!!");
        }
    }

    @Override
    public void tongsoluongGiaoDichVang() {
        int tong = 0;
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichVang) {
                tong += i.getSoluong();
            }
        }
        System.out.println("Tong so luong giao dich vang: " + tong);

    }

    @Override
    public void tongsoluongGiaoDichTienTe() {
        int tong = 0;
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichTienTe) {
                tong += i.getSoluong();
            }
        }
        System.out.println("Tong so luong giao dich tien te: " + tong);
    }

    @Override
    public void tongsoluongGiaoDichDat() {
        int tong = 0;
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichDat) {
                tong += i.getSoluong();
            }
        }
        System.out.println("Tong so luong giao dich dat: " + tong);
    }

    @Override
    public void hienThiDanhSachTheoNgay() {
        System.out.print("Nhap ngay: ");
        String ngaygd ;
        String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while (true) {
            ngaygd = sc.nextLine();
            if (ngaygd.matches(re)) break;
            else {
                System.err.println("Ngay khong dung dinh dang");
            }
        }
        System.out.println("Danh sach giao dich vang ngay " + ngaygd + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichVang && i.getNgaygd().compareTo(ngaygd) == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich tien te ngay " + ngaygd + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichTienTe && i.getNgaygd().compareTo(ngaygd) == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich dat ngay " + ngaygd + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichDat && i.getNgaygd().compareTo(ngaygd) == 0) {
                System.out.println(i);
            }
        }
        System.out.println("------------------------------");
    }

    @Override
    public void hienthiDanhSachCoChuaNgay() {
        System.out.println("Nhap ngay: "); // 1-31
        int ngay = Integer.parseInt(sc.nextLine());
        System.out.println("Danh sach giao dich vang chua ngay " + ngay + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichVang && i.getNgay() == ngay ) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich tien te chua ngay " + ngay + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichTienTe && i.getNgay() == ngay) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich dat chua ngay " + ngay + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichDat && i.getNgay() == ngay ) {
                System.out.println(i);
            }
        }
        System.out.println("------------------------------");
    }

    @Override
    public void hienthiDanhSachTuNamDenNam() {
        System.out.println("Nhap nam bat dau: ");
        int namBd = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap nam ket thuc: ");
        int namKt = Integer.parseInt(sc.nextLine());

        System.out.println("Danh sach giao dich vang tu nam " + namBd + " den nam " + namKt + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichVang && i.getNam() >= namBd && i.getNam() <= namKt) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich vang tu nam " + namBd + " den nam " + namKt + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichTienTe && i.getNam() >= namBd && i.getNam() <= namKt) {
                System.out.println(i);
            }
        }
        System.out.println("Danh sach giao dich vang tu nam " + namBd + " den nam " + namKt + ":");
        for (GiaoDich i : lst) {
            if (i instanceof GiaoDichDat && i.getNam() >= namBd && i.getNam() <= namKt) {
                System.out.println(i);
            }
        }
        System.out.println("------------------------------");
    }

    @Override
    public void ghirafile(String fname) {
        IOFile.viet(fname, lst);
    }

    @Override
    public void docfile(String fname) {
        lst = IOFile.doc(fname);
        for (GiaoDich i : lst) {
            System.out.println(i);
        }
    }

    public void sapxep2TT() {

        lst.sort(new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich o1, GiaoDich o2) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    @Override
    public void thongke1() {
        List<GiaoDichVang> vang = new ArrayList<>();
        for (GiaoDich i : lst)
            if (i instanceof GiaoDichVang) vang.add((GiaoDichVang ) i);
        Map<String, Long> count = vang.stream().collect(Collectors.groupingBy(GiaoDichVang::getLoaivang, Collectors.counting()));
        System.out.println(count);
    }

    @Override
    public void thongke2() {
        List<GiaoDichVang> vang = new ArrayList<>();
        for (GiaoDich i : lst)
            if (i instanceof GiaoDichVang) vang.add((GiaoDichVang ) i);
        Map<String, Integer> sum = vang.stream().collect(Collectors.groupingBy(GiaoDichVang::getLoaivang, Collectors.summingInt(GiaoDichVang::getSoluong)));
        System.out.println(sum);
    }

}
