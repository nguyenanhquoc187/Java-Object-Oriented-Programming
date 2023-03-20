/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.IOFile;
import Controller.SodienthoaiException;
import Controller.ValidException;
import Model.MatHang;
import Model.KhachHang;
import Model.DanhSachMuaHang;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Main extends javax.swing.JFrame {

    private List<MatHang> listMatHang;
    private List<KhachHang> listKhachHang;
    private List<DanhSachMuaHang> listDSMH;
    private String fmathang, fkhachhang, fdsmh;
    private DefaultTableModel tmMH, tmKH, tmDSMH;

    public Main() {
        initComponents();
        tmMH = (DefaultTableModel) bangMH.getModel();
        tmKH = (DefaultTableModel) bangKH.getModel();
        tmDSMH = (DefaultTableModel) bangDSMH.getModel();
        fmathang = "src/controller/MH.DAT";
        fkhachhang = "src/controller/K-hang.DAT";
        fdsmh = "src/controller/BDSMH.DAT";
        loadMatHang();
        loadKhachHang();
        loadDS();
        showMatHang(listMatHang);
        showKhachHang(listKhachHang);
        showDS(listDSMH);
        eventMatHang();
        eventKhachHang();
        eventDS();
        setButton(true);
        setButton1(true);
    }

    private void setButton(boolean b) {
        themBT.setEnabled(b);
        capnhatBT.setEnabled(!b);
        boquaBt.setEnabled(!b);
    }

    private void setButton1(boolean b) {
        themBT1.setEnabled(b);
        capnhatBT1.setEnabled(!b);
        boquaBt1.setEnabled(!b);
    }

    private void loadMatHang() {
        File f = new File(fmathang);
        if (f.exists()) {
            listMatHang = IOFile.doc(fmathang);
        } else {
            listMatHang = new ArrayList();
        }
    }

    private void loadKhachHang() {
        File f = new File(fkhachhang);
        if (f.exists()) {
            listKhachHang = IOFile.doc(fkhachhang);
        } else {
            listKhachHang = new ArrayList();
        }
    }

    private void loadDS() {
        File f = new File(fdsmh);
        if (f.exists()) {
            listDSMH = IOFile.doc(fdsmh);
        } else {
            listDSMH = new ArrayList();
        }
    }

    private void showMatHang(List<MatHang> lst) {
        tmMH.setRowCount(0);
        for (MatHang i : lst) {
            tmMH.addRow(i.toObject());
        }
    }

    private void showKhachHang(List<KhachHang> lst) {
        tmKH.setRowCount(0);
        for (KhachHang i : lst) {
            tmKH.addRow(i.toObject());
        }
    }

    private void showDS(List<DanhSachMuaHang> lst) {
        tmDSMH.setRowCount(0);
        for (DanhSachMuaHang i : lst) {
            tmDSMH.addRow(i.toObject());
        }
    }

    private void eventMatHang() {
        themBT.addActionListener(e -> {
            setButton(false);
            int n = listMatHang.size();
            maMHTF.setText(1000 + n + "");
            tenhangTF.setText("");
            giabanTF.setText("");
            tenhangTF.requestFocus();
        });

        capnhatBT.addActionListener(e -> {
            setButton(true);
            try {
                MatHang mh = new MatHang(Integer.parseInt(maMHTF.getText()), tenhangTF.getText(), 
                        nhomhangCB.getSelectedItem().toString(), Double.parseDouble(giabanTF.getText()) );
                listMatHang.add(mh);
                tmMH.addRow(mh.toObject());
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                setButton(false);
                return;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap vao so");
                setButton(false);
                return;
            }
        });
        boquaBt.addActionListener(e -> {
            setButton(true);
            maMHTF.setText("");
            tenhangTF.setText("");
            giabanTF.setText("");
            tenhangTF.requestFocus();
        });
        suaBt.addActionListener(e -> {
            
            int r = bangMH.getSelectedRow();
            if (r >= 0 && r < bangMH.getRowCount()) {
                try {
                    int ma = Integer.parseInt(maMHTF.getText());
                    String tenhang = tenhangTF.getText();
                    String nhomhang = nhomhangCB.getSelectedItem().toString();
                    double giaban = Double.parseDouble(giabanTF.getText());
                    MatHang a = new MatHang(ma, tenhang, nhomhang, giaban);
                    listMatHang.set(r, a);
                    tmMH.setValueAt(tenhang, r, 1);
                    tmMH.setValueAt(nhomhang, r, 2);
                    tmMH.setValueAt(giaban, r, 3);

                } catch (ValidException ex) {
                    JOptionPane.showMessageDialog(this, "Khong de trong");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Gia ban khong dung dinh dang");
                    return;
                }

            }
        });

        luuBt.addActionListener(e -> {
            IOFile.viet(fmathang, listMatHang);
        });
    }

    private void eventKhachHang() {
        themBT1.addActionListener(e -> {
            setButton1(false);
            int n = listKhachHang.size();
            makhTF.setText(10000 + n + "");
            hotenTF.setText("");
            sdtTF.setText("");
            tiencoTF.setText("");
            hotenTF.requestFocus();
        });

        capnhatBT1.addActionListener(ex -> {
            setButton1(true);
            try {
                int ma = Integer.parseInt(makhTF.getText());
                String ten = hotenTF.getText();
                if (ten.isEmpty()) throw new ValidException();
                Double tienco = Double.parseDouble(tiencoTF.getText());
                String sdt = sdtTF.getText();
                KhachHang a = new KhachHang(ma, ten, sdt, tienco);
                listKhachHang.add(a);
                tmKH.addRow(a.toObject());
            } catch (ValidException e1) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                setButton1(false);
                return;
            } catch (SodienthoaiException ex1) {
                JOptionPane.showMessageDialog(this, "So dien thoai khong dung dinh dang");
                setButton1(false);
                return;
            } catch (NumberFormatException ex2) {
                JOptionPane.showMessageDialog(this, "Nhap vao so");
                setButton1(false);
                return;
            }
        });
        boquaBt1.addActionListener(e -> {
            setButton1(true);
            makhTF.setText("");
            hotenTF.setText("");
            sdtTF.setText("");
            tiencoTF.setText("");
            hotenTF.requestFocus();
        });
        xoaBt.addActionListener(e -> {
            int row = bangKH.getSelectedRow();
            if (row >= 0 && row < bangKH.getRowCount()) {
                listKhachHang.remove(row);
                tmKH.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuBt1.addActionListener(e -> {
            IOFile.viet(fkhachhang, listKhachHang);
        });
    }

    private MatHang getMatHang(int ma) {
        for (MatHang i : listMatHang) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private KhachHang getKhachHang(int ma) {
        for (KhachHang i : listKhachHang) {
            if (i.getMaKh() == ma) {
                return i;
            }
        }
        return null;
    }

    private void eventDS() {
        lammoiBt.addActionListener(e -> {
            makhCB.removeAllItems();
            maMHCB.removeAllItems();
            for (KhachHang i : listKhachHang) {
                makhCB.addItem(i.getMaKh() + "");
            }
            for (MatHang i : listMatHang) {
                maMHCB.addItem(i.getMa() + "");
            }
        });

        themBT2.addActionListener(e -> {
            int maMatHang = Integer.parseInt(maMHCB.getSelectedItem().toString());
            int maKhachHang = Integer.parseInt(makhCB.getSelectedItem().toString());
            DanhSachMuaHang a;
            int soluong;
            try {
                soluong = Integer.parseInt(soLuongTF.getText());
                a = new DanhSachMuaHang(getMatHang(maMatHang),getKhachHang(maKhachHang), soluong);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so");
                return;
            }
            int check = 1;
            for (DanhSachMuaHang i : listDSMH) {
                if (i.getKh().getMaKh() == maKhachHang && i.getMh().getMa() == maMatHang) {
                    check = 0;
                }
                
            }
            if (getKhachHang(maKhachHang).getTienco() < soluong*getMatHang(maMatHang).getGiaban() ) check = 0;
            if (check ==1 ) {
                listDSMH.add(a);
                tmDSMH.addRow(a.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Du lieu khong hop le(Trung hoac khong du tien mua)");
            }
            
        });
        luuBt2.addActionListener(e -> {
            IOFile.viet(fdsmh, listDSMH);
        });
        sapxepBt.addActionListener(e -> {
            int index = sapxepCB.getSelectedIndex();
            if (index == 0) {
                listDSMH.sort(new Comparator<DanhSachMuaHang>() {
                    @Override
                    public int compare(DanhSachMuaHang o1, DanhSachMuaHang o2) {
                        String ten1 = o1.getKh().getHoten(), ten2 = o2.getKh().getHoten();
                        String[] a = ten1.split("\\s+"), b = ten2.split("\\s+");
                        ten1 = a[a.length - 1] + o1.getKh().getHoten();
                        ten2 = b[b.length - 1] + o2.getKh().getHoten();
                        return ten1.compareToIgnoreCase(ten2);
                    }
                });
            }
            
            if (index == 1) {
                listDSMH.sort(new Comparator<DanhSachMuaHang>() {
                    @Override
                    public int compare(DanhSachMuaHang o1, DanhSachMuaHang o2) {
                       return o2.getSoluong() - o1.getSoluong();
                    }
                });
            }
            showDS(listDSMH);
        });
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangMH = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tenhangTF = new javax.swing.JTextField();
        maMHTF = new javax.swing.JTextField();
        nhomhangCB = new javax.swing.JComboBox<>();
        giabanTF = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        themBT = new javax.swing.JButton();
        capnhatBT = new javax.swing.JButton();
        boquaBt = new javax.swing.JButton();
        suaBt = new javax.swing.JButton();
        luuBt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hotenTF = new javax.swing.JTextField();
        sdtTF = new javax.swing.JTextField();
        makhTF = new javax.swing.JTextField();
        tiencoTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangKH = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        themBT1 = new javax.swing.JButton();
        capnhatBT1 = new javax.swing.JButton();
        boquaBt1 = new javax.swing.JButton();
        xoaBt = new javax.swing.JButton();
        luuBt1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        soLuongTF = new javax.swing.JTextField();
        makhCB = new javax.swing.JComboBox<>();
        maMHCB = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        sapxepCB = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangDSMH = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        themBT2 = new javax.swing.JButton();
        lammoiBt = new javax.swing.JButton();
        luuBt2 = new javax.swing.JButton();
        sapxepBt = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        thongkeBT = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        thongkeTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bangMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma", "Ten hang", "Nhom hang", "Gia ban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangMH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangMHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangMH);

        jLabel1.setText("Ma hang");

        jLabel2.setText("Ten hang");

        jLabel4.setText("Nhom hang");

        jLabel6.setText("Gia ban");

        tenhangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenhangTFActionPerformed(evt);
            }
        });

        maMHTF.setEditable(false);
        maMHTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maMHTFActionPerformed(evt);
            }
        });

        nhomhangCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hàng thời trang", "Hàng tiêu dùng", "Hàng điện máy", "Hàng gia dụng" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maMHTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(tenhangTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nhomhangCB, 0, 287, Short.MAX_VALUE)
                            .addComponent(giabanTF))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maMHTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenhangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nhomhangCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giabanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        themBT.setText("Them moi");

        capnhatBT.setText("Cap nhat");

        boquaBt.setText("Bo qua");

        suaBt.setText("Sua");

        luuBt.setText("Luu vao file");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(luuBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suaBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boquaBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themBT)
                .addGap(39, 39, 39)
                .addComponent(capnhatBT)
                .addGap(34, 34, 34)
                .addComponent(boquaBt)
                .addGap(37, 37, 37)
                .addComponent(suaBt)
                .addGap(34, 34, 34)
                .addComponent(luuBt)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Mat Hang", jPanel1);

        jLabel7.setText("Ma KH");

        jLabel8.setText("Ho ten");

        jLabel9.setText("So dien thoai");

        jLabel11.setText("Tien co");

        hotenTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotenTFActionPerformed(evt);
            }
        });

        sdtTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtTFActionPerformed(evt);
            }
        });

        makhTF.setEditable(false);
        makhTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makhTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(makhTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hotenTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(tiencoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(makhTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tiencoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        bangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma khach hang", "Ho ten", "So dien thoai", "Tien co"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangKH);

        themBT1.setText("Them moi");

        capnhatBT1.setText("Cap nhat");

        boquaBt1.setText("Bo qua");

        xoaBt.setText("Xoa");

        luuBt1.setText("Luu vao file");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(luuBt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xoaBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boquaBt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatBT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themBT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themBT1)
                .addGap(39, 39, 39)
                .addComponent(capnhatBT1)
                .addGap(50, 50, 50)
                .addComponent(boquaBt1)
                .addGap(46, 46, 46)
                .addComponent(xoaBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(luuBt1))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Khach Hang", jPanel2);

        jLabel10.setText("Ma KH");

        jLabel12.setText("Ma MH");

        jLabel14.setText("So luong");

        makhCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maMHCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Sap xep");

        sapxepCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo họ tên khách hàng", "Theo số lượng hàng mua" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(76, 76, 76)))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(makhCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maMHCB, 0, 287, Short.MAX_VALUE)
                    .addComponent(soLuongTF, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(sapxepCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(makhCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(maMHCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(soLuongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(sapxepCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        bangDSMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma KH", "Ho ten", "Ma MH", "Ten MH", "So luong", "Thanh tien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangDSMH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangDSMHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bangDSMH);

        themBT2.setText("Them moi");

        lammoiBt.setText("Lam moi 2 ma");
        lammoiBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiBtActionPerformed(evt);
            }
        });

        luuBt2.setText("Luu vao file");

        sapxepBt.setText("Sap xep");
        sapxepBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sapxepBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sapxepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lammoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(themBT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuBt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themBT2)
                .addGap(45, 45, 45)
                .addComponent(lammoiBt)
                .addGap(31, 31, 31)
                .addComponent(luuBt2)
                .addGap(48, 48, 48)
                .addComponent(sapxepBt)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sach mua hang", jPanel3);

        jLabel16.setText("Thong ke thu nhap:");

        thongkeBT.setText("Thong ke");
        thongkeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongkeBTActionPerformed(evt);
            }
        });

        thongkeTA.setEditable(false);
        thongkeTA.setColumns(20);
        thongkeTA.setRows(5);
        jScrollPane5.setViewportView(thongkeTA);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(thongkeBT)
                .addContainerGap(656, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(thongkeBT))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong ke", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sapxepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sapxepBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sapxepBtActionPerformed

    private void lammoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lammoiBtActionPerformed

    private void bangDSMHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangDSMHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bangDSMHMouseClicked

    private void bangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangKHMouseClicked
       
    }//GEN-LAST:event_bangKHMouseClicked

    private void makhTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makhTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makhTFActionPerformed

    private void sdtTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtTFActionPerformed

    private void hotenTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotenTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotenTFActionPerformed

    private void maMHTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maMHTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maMHTFActionPerformed

    private void tenhangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenhangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenhangTFActionPerformed

    private void thongkeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongkeBTActionPerformed
        // TODO add your handling code here:
        
        Map<String, Integer> sum = listDSMH.stream().collect(Collectors.groupingBy(DanhSachMuaHang::vietTk, 
                Collectors.summingInt(DanhSachMuaHang::getSoluong)));
        thongkeTA.setText(sum.toString());
    }//GEN-LAST:event_thongkeBTActionPerformed

    private void bangMHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangMHMouseClicked
        // TODO add your handling code here:
        
        int r = bangMH.getSelectedRow();
        maMHTF.setText(bangMH.getValueAt(r, 0) + "");
        tenhangTF.setText(bangMH.getValueAt(r, 1) + "");
        giabanTF.setText(bangMH.getValueAt(r, 3) + "");
        for (int i = 0 ; i < nhomhangCB.getItemCount(); i++) {
            if (bangMH.getValueAt(r, 2).toString().equals(nhomhangCB.getItemAt(i))) {
                nhomhangCB.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_bangMHMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangDSMH;
    private javax.swing.JTable bangKH;
    private javax.swing.JTable bangMH;
    private javax.swing.JButton boquaBt;
    private javax.swing.JButton boquaBt1;
    private javax.swing.JButton capnhatBT;
    private javax.swing.JButton capnhatBT1;
    private javax.swing.JTextField giabanTF;
    private javax.swing.JTextField hotenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoiBt;
    private javax.swing.JButton luuBt;
    private javax.swing.JButton luuBt1;
    private javax.swing.JButton luuBt2;
    private javax.swing.JComboBox<String> maMHCB;
    private javax.swing.JTextField maMHTF;
    private javax.swing.JComboBox<String> makhCB;
    private javax.swing.JTextField makhTF;
    private javax.swing.JComboBox<String> nhomhangCB;
    private javax.swing.JButton sapxepBt;
    private javax.swing.JComboBox<String> sapxepCB;
    private javax.swing.JTextField sdtTF;
    private javax.swing.JTextField soLuongTF;
    private javax.swing.JButton suaBt;
    private javax.swing.JTextField tenhangTF;
    private javax.swing.JButton themBT;
    private javax.swing.JButton themBT1;
    private javax.swing.JButton themBT2;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JTextArea thongkeTA;
    private javax.swing.JTextField tiencoTF;
    private javax.swing.JButton xoaBt;
    // End of variables declaration//GEN-END:variables
}
