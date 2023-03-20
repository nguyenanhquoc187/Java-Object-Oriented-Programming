/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.IOFile;
import Controller.ValidException;
import Controller.soDienThoaiException;
import Model.DanhSachChamCong;
import Model.NhanVien;
import Model.PhongBan;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Main extends javax.swing.JFrame {

    private List<NhanVien> listNV;
    private List<PhongBan> listPB;
    private List<DanhSachChamCong> listDSCC;
    private String fNV, fPB, fDS;
    private DefaultTableModel tmNV,tmPB,tmDS, tmTK;

    public Main() {
        initComponents();
        tmNV = (DefaultTableModel) bangNV.getModel();
        tmPB = (DefaultTableModel) bangPhongBan.getModel();
        tmDS = (DefaultTableModel) bangDS.getModel();
        fNV = "src/controller/NV.DAT";
        fPB = "src/controller/PB.DAT";
        fDS = "src/controller/QLNS.DAT";
        loadNhanVien();
        loadPhongBan();
        loadDS();
        showSach(listNV);
        showPhongBan(listPB);
        showDS(listDSCC);
        eventNhanVien();
        eventPhongBan();
        eventDS();
        setButton(true);
        setButton1(true);
        thongkeBT.addActionListener(e -> { 
            Map<String, Integer> sum = listDSCC.stream().collect(
                    Collectors.groupingBy(DanhSachChamCong::vietTK,Collectors.summingInt(DanhSachChamCong::getSalary)));
        thongkeTA.setText(sum.toString());
        });
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

    private void setButton2(boolean b) {
        lammoiBt.setEnabled(b);
        themBT2.setEnabled(!b);
    }

    private void loadNhanVien() {
        File f = new File(fNV);
        if (f.exists()) {
            listNV = IOFile.doc(fNV);
        } else {
            listNV = new ArrayList();
        }
    }

    private void loadPhongBan() {
        File f = new File(fPB);
        if (f.exists()) {
            listPB = IOFile.doc(fPB);
        } else {
            listPB = new ArrayList();
        }
    }

    private void loadDS() {
        File f = new File(fDS);
        if (f.exists()) {
            listDSCC = IOFile.doc(fDS);
        } else {
            listDSCC = new ArrayList();
        }
    }

    private void showSach(List<NhanVien> lst) {
        tmNV.setRowCount(0);
        for (NhanVien i : lst) {
            tmNV.addRow(i.toObject());
        }
    }

    private void showPhongBan(List<PhongBan> lst) {
        tmPB.setRowCount(0);
        for (PhongBan i : lst) {
            tmPB.addRow(i.toObject());
        }
    }

    private void showDS(List<DanhSachChamCong> lst) {
        tmDS.setRowCount(0);
        for (DanhSachChamCong i : lst) {
            tmDS.addRow(i.toObject());
        }
    }

    private void eventNhanVien() {
        themBT.addActionListener(e -> {
            setButton(false);
            int n = listNV.size();
            maNvTF.setText(1000 + n + "");
            hotenvTF.setText("");
            dchiTF.setText("");
            sdtTF.setText("");
            hotenvTF.requestFocus();
        });

        capnhatBT.addActionListener(e -> {
            setButton(true);
            try {
                NhanVien nv = new NhanVien( Integer.parseInt(maNvTF.getText()) , hotenvTF.getText(), dchiTF.getText(), 
                        sdtTF.getText(), Integer.parseInt(bacluongCB.getSelectedItem().toString()));
                listNV.add(nv);
                tmNV.addRow(nv.toObject());
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, "Khong de trong ");
                setButton(false);
                return;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap vao so");
                setButton(false);
                return;
            } catch (soDienThoaiException ex) {
                JOptionPane.showMessageDialog(this, "So dien thoai la so");
                setButton(false);
                return;
            }
        });
        boquaBt.addActionListener(e -> {
            setButton(true);
            maNvTF.setText("");
            hotenvTF.setText("");
            dchiTF.setText("");
            sdtTF.setText("");
            hotenvTF.requestFocus();
        });
        xoaBt.addActionListener(e -> {
            int row = bangNV.getSelectedRow();
            if (row >= 0 && row < bangNV.getRowCount()) {
                listNV.remove(row);
                tmNV.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuBt.addActionListener(e -> {
            IOFile.viet(fNV, listNV);
        });
    }

    private void eventPhongBan() {
        themBT1.addActionListener(e -> {
            setButton1(false);
            int n = listPB.size();
            maphongTF.setText(1000 + n + "");
            tenphongTF.setText("");
            motaTF.setText("");
            hesocvTF.setText("");
            tenphongTF.requestFocus();
        });

        capnhatBT1.addActionListener(ex -> {
            setButton1(true);
            try {
                int ma = Integer.parseInt(maphongTF.getText());
                String ten = tenphongTF.getText();
                String mota = motaTF.getText();
                double heso = Double.parseDouble(hesocvTF.getText());
                if (heso < 1 || heso > 20) throw new NumberFormatException();
                PhongBan pb = new PhongBan(ma, ten, mota, heso);
                listPB.add(pb);
                tmPB.addRow(pb.toObject());
            } catch (ValidException e1) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                setButton1(false);
                return;
            } catch (NumberFormatException ex1) {
                JOptionPane.showMessageDialog(this, "He so phai la so hoac khong dung gia tri (1 -> 20) ");
                setButton1(false);
                return;
            }
        });
        boquaBt1.addActionListener(e -> {
            setButton1(true);
            maphongTF.setText("");
            tenphongTF.setText("");
            motaTF.setText("");
            hesocvTF.setText("");
            tenphongTF.requestFocus();
        });
        suaBt.addActionListener(e -> {
            int r = bangPhongBan.getSelectedRow();
            if (r >= 0 && r < bangPhongBan.getRowCount()) {
                try {
                    int ma = Integer.parseInt(maphongTF.getText());
                    String ten = tenphongTF.getText();
                    String dchi = motaTF.getText();
                    double heso = Double.parseDouble(hesocvTF.getText());
                    PhongBan a = new PhongBan(ma,ten, dchi, heso);
                    listPB.set(r, a);
                    tmPB.setValueAt(ten, r, 1);
                    tmPB.setValueAt(dchi, r, 2);
                    tmPB.setValueAt(heso, r, 3);

                } catch (ValidException ex) {
                    JOptionPane.showMessageDialog(this, "Khong de trong");
                    return ;
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(this, "He so phai la so hoac khong dung gia tri (1 -> 20) ");
                    setButton1(false);
                    return;
                }

            }
        });

        luuBt1.addActionListener(e -> {
            IOFile.viet(fPB, listPB);
        });
    }

    private NhanVien getNhanVien(int ma) {
        for (NhanVien i : listNV) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private PhongBan getPhongBan(int ma) {
        for (PhongBan i : listPB) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private void eventDS() {
        lammoiBt.addActionListener(e -> {
            manvCB.removeAllItems();
            maphongbanCB.removeAllItems();
            for (NhanVien i : listNV) {
                manvCB.addItem(i.getMa() + "");
            }
            for (PhongBan i : listPB) {
                maphongbanCB.addItem(i.getMa() + "");
            }
        });

        themBT2.addActionListener(e -> {
            int manv = Integer.parseInt(manvCB.getSelectedItem().toString());
            int maPb = Integer.parseInt(maphongbanCB.getSelectedItem().toString());
            int songay ;
            DanhSachChamCong a;
            try {
                songay = Integer.parseInt(songaylmTF.getText());
                a = new DanhSachChamCong(getNhanVien(manv), getPhongBan(maPb), songay);
            }  catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so");
                return;
            }
            int check = 1;
            for (DanhSachChamCong i : listDSCC) {
                if (i.getNv().getMa() == manv && i.getPb().getMa() == maPb) 
                    check = 0;
                
            }
            if (check ==1 ) {
                listDSCC.add(a);
                tmDS.addRow(a.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Du lieu khong hop le");
            }
        });
        luuBt2.addActionListener(e -> {
            IOFile.viet(fDS, listDSCC);
        });
        sapxepBt.addActionListener(e -> {
            if (jRadioButton1.isSelected()) {
                listDSCC.sort(new Comparator<DanhSachChamCong>() {
                    @Override
                    public int compare(DanhSachChamCong o1, DanhSachChamCong o2) {
                        String ten1 = o1.getNv().getHoten(), ten2 = o2.getNv().getHoten();
                        String[] a = ten1.split("\\s+"), b = ten2.split("\\s+");
                        ten1 = a[a.length - 1] + o1.getNv().getHoten();
                        ten2 = b[b.length - 1] + o2.getNv().getHoten();
                        return ten1.compareToIgnoreCase(ten2);
                    }
                });
            }
            if (jRadioButton2.isSelected()) {
                listDSCC.sort(new Comparator<DanhSachChamCong>() {
                    @Override
                    public int compare(DanhSachChamCong o1, DanhSachChamCong o2) {
                        return o2.getPb().getTenphong().compareTo( o1.getPb().getTenphong() );
                    }
                });
            }
            showDS(listDSCC);
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
        bangNV = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hotenvTF = new javax.swing.JTextField();
        dchiTF = new javax.swing.JTextField();
        maNvTF = new javax.swing.JTextField();
        bacluongCB = new javax.swing.JComboBox<>();
        sdtTF = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        themBT = new javax.swing.JButton();
        capnhatBT = new javax.swing.JButton();
        boquaBt = new javax.swing.JButton();
        xoaBt = new javax.swing.JButton();
        luuBt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tenphongTF = new javax.swing.JTextField();
        motaTF = new javax.swing.JTextField();
        maphongTF = new javax.swing.JTextField();
        hesocvTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangPhongBan = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        themBT1 = new javax.swing.JButton();
        capnhatBT1 = new javax.swing.JButton();
        boquaBt1 = new javax.swing.JButton();
        suaBt = new javax.swing.JButton();
        luuBt1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        songaylmTF = new javax.swing.JTextField();
        manvCB = new javax.swing.JComboBox<>();
        maphongbanCB = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangDS = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        themBT2 = new javax.swing.JButton();
        lammoiBt = new javax.swing.JButton();
        luuBt2 = new javax.swing.JButton();
        sapxepBt = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        thongkeBT = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        thongkeTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bangNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma nv", "Ho ten", "Dia chi", "So dien thoai", "Bac luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bangNV);

        jLabel1.setText("Ma nv");

        jLabel2.setText("Ho ten nv");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Bac luong");

        jLabel5.setText("So dien thoai");

        hotenvTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotenvTFActionPerformed(evt);
            }
        });

        dchiTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dchiTFActionPerformed(evt);
            }
        });

        maNvTF.setEditable(false);
        maNvTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNvTFActionPerformed(evt);
            }
        });

        bacluongCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maNvTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(hotenvTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dchiTF)
                                    .addComponent(bacluongCB, 0, 287, Short.MAX_VALUE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maNvTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hotenvTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dchiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bacluongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themBT.setText("Them moi");

        capnhatBT.setText("Cap nhat");

        boquaBt.setText("Bo qua");

        xoaBt.setText("Xoa");

        luuBt.setText("Luu vao file");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(luuBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xoaBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(xoaBt)
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

        jTabbedPane1.addTab("Nhan Vien", jPanel1);

        jLabel7.setText("Ma phong");

        jLabel8.setText("Ten phong");

        jLabel9.setText("Mo ta");

        jLabel11.setText("He so cong viec");

        tenphongTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenphongTFActionPerformed(evt);
            }
        });

        motaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motaTFActionPerformed(evt);
            }
        });

        maphongTF.setEditable(false);
        maphongTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maphongTFActionPerformed(evt);
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
                        .addComponent(motaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maphongTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tenphongTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(hesocvTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maphongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenphongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(motaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(hesocvTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        bangPhongBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma phong", "Ten phong", "Mo ta", "He so cong viec"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangPhongBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangPhongBanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangPhongBan);

        themBT1.setText("Them moi");

        capnhatBT1.setText("Cap nhat");

        boquaBt1.setText("Bo qua");

        suaBt.setText("Sua");

        luuBt1.setText("Luu vao file");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(luuBt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suaBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(suaBt)
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

        jTabbedPane1.addTab("Phong Ban", jPanel2);

        jLabel10.setText("Ma nv");

        jLabel12.setText("Ma phong ban");

        jLabel13.setText("So ngay lam viec");

        songaylmTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songaylmTFActionPerformed(evt);
            }
        });

        manvCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maphongbanCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Sap xep");

        jRadioButton1.setText("Theo ten nhan vien");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Theo ten phong ban");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(manvCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(songaylmTF)
                        .addComponent(maphongbanCB, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(manvCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(maphongbanCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(songaylmTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        bangDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma nv", "Ho ten nv", "Ma phong", "Ten phong", "So ngay lam viec"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangDSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bangDS);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh Sach Cham Cong", jPanel3);

        jLabel6.setText("Thong ke thu nhap:");

        thongkeBT.setText("Thong ke");
        thongkeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongkeBTActionPerformed(evt);
            }
        });

        thongkeTA.setColumns(20);
        thongkeTA.setRows(5);
        jScrollPane5.setViewportView(thongkeTA);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel6)
                    .addComponent(thongkeBT))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong ke thu nhap", jPanel10);

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

    private void bangDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangDSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bangDSMouseClicked

    private void songaylmTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songaylmTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_songaylmTFActionPerformed

    private void bangPhongBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangPhongBanMouseClicked
        int r = bangPhongBan.getSelectedRow();
        maphongTF.setText(bangPhongBan.getValueAt(r, 0) + "");
        tenphongTF.setText(bangPhongBan.getValueAt(r, 1) + "");
        motaTF.setText(bangPhongBan.getValueAt(r, 2) + "");
        hesocvTF.setText(bangPhongBan.getValueAt(r, 3) + "");
    }//GEN-LAST:event_bangPhongBanMouseClicked

    private void maphongTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maphongTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maphongTFActionPerformed

    private void motaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motaTFActionPerformed

    private void tenphongTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenphongTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenphongTFActionPerformed

    private void maNvTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNvTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNvTFActionPerformed

    private void dchiTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dchiTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dchiTFActionPerformed

    private void hotenvTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotenvTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotenvTFActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
            jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
            jRadioButton1.setSelected(false);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void thongkeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongkeBTActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_thongkeBTActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bacluongCB;
    private javax.swing.JTable bangDS;
    private javax.swing.JTable bangNV;
    private javax.swing.JTable bangPhongBan;
    private javax.swing.JButton boquaBt;
    private javax.swing.JButton boquaBt1;
    private javax.swing.JButton capnhatBT;
    private javax.swing.JButton capnhatBT1;
    private javax.swing.JTextField dchiTF;
    private javax.swing.JTextField hesocvTF;
    private javax.swing.JTextField hotenvTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoiBt;
    private javax.swing.JButton luuBt;
    private javax.swing.JButton luuBt1;
    private javax.swing.JButton luuBt2;
    private javax.swing.JTextField maNvTF;
    private javax.swing.JComboBox<String> manvCB;
    private javax.swing.JTextField maphongTF;
    private javax.swing.JComboBox<String> maphongbanCB;
    private javax.swing.JTextField motaTF;
    private javax.swing.JButton sapxepBt;
    private javax.swing.JTextField sdtTF;
    private javax.swing.JTextField songaylmTF;
    private javax.swing.JButton suaBt;
    private javax.swing.JTextField tenphongTF;
    private javax.swing.JButton themBT;
    private javax.swing.JButton themBT1;
    private javax.swing.JButton themBT2;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JTextArea thongkeTA;
    private javax.swing.JButton xoaBt;
    // End of variables declaration//GEN-END:variables
}
