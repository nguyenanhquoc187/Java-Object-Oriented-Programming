/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.IOFile;
import Controller.SodienthoaiException;
import Controller.ValidException;
import Model.BangDatTour;
import Model.KhachHang;
import Model.Tour;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ADMIN
 */
public class Main extends javax.swing.JFrame {

    private List<Tour> listTour;
    private List<KhachHang> listKH;
    private List<BangDatTour> listBDT;
    private String ftour, fKH, fBDT;
    private DefaultTableModel tmTour, tmKH, tmBDT;

    public Main() {
        
        initComponents();
        tmTour = (DefaultTableModel) bangTour.getModel();
        tmKH = (DefaultTableModel) bangKH.getModel();
        tmBDT = (DefaultTableModel) bangDatTour.getModel();
        ftour = "src/controller/TOUR.DAT";
        fKH = "src/controller/KH.DAT";
        fBDT = "src/controller/DATTOUR.DAT";
        loadTour();
        loadKhachHang();
        loadBangdatTour();
        showTour(listTour);
        showKhachHang(listKH);
        showBangDat(listBDT);
        eventTour();
        eventKhachHang();
        eventBDT();
        setButton(true);
        setButton1(true);
        setButton2(true);
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

    private void loadTour() {
        File f = new File(ftour);
        if (f.exists()) {
            listTour = IOFile.doc(ftour);
        } else {
            listTour = new ArrayList();
        }
    }

    private void loadKhachHang() {
        File f = new File(fKH);
        if (f.exists()) {
            listKH = IOFile.doc(fKH);
        } else {
            listKH = new ArrayList();
        }
    }

    private void loadBangdatTour() {
        File f = new File(fBDT);
        if (f.exists()) {
            listBDT = IOFile.doc(fBDT);
        } else {
            listBDT = new ArrayList();
        }
    }

    private void showTour(List<Tour> lst) {
        tmTour.setRowCount(0);
        for (Tour i : lst) {
            tmTour.addRow(i.toObject());
        }
    }

    private void showKhachHang(List<KhachHang> lst) {
        tmKH.setRowCount(0);
        for (KhachHang i : lst) {
            tmKH.addRow(i.toObject());
        }
    }

    private void showBangDat(List<BangDatTour> lst) {
        tmBDT.setRowCount(0);
        for (BangDatTour i : lst) {
            tmBDT.addRow(i.toObject());
        }
    }

    private void eventTour() {
        themBT.addActionListener(e -> {
            setButton(false);
            int n = listTour.size();
            maTourTF.setText(1000 + n + "");
            thongtinTA.setText("");
            dongiaTF.setText("");
        });

        capnhatBT.addActionListener(e -> {
            setButton(true);
            try {
                Tour a = new Tour(Integer.parseInt(maTourTF.getText()), kieuTourCB.getSelectedItem().toString(),
                        thongtinTA.getText(), Double.parseDouble(dongiaTF.getText()));
                listTour.add(a);
                tmTour.addRow(a.toObject());
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
            maTourTF.setText("");
            thongtinTA.setText("");
            dongiaTF.setText("");
        });
        xoaBt.addActionListener(e -> {
            int row = bangTour.getSelectedRow();
            if (row >= 0 && row < bangTour.getRowCount()) {
                listTour.remove(row);
                tmTour.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuBt.addActionListener(e -> {
            IOFile.viet(ftour, listTour);
        });
    }

    private void eventKhachHang() {
        themBT1.addActionListener(e -> {
            setButton1(false);
            int n = listKH.size();
            maKHTF.setText(100 + n + "");
            hotenTF.setText("");
            hotenTF.requestFocus();
        });

        capnhatBT1.addActionListener(ex -> {
            setButton1(true);
            try {
                int ma = Integer.parseInt(maKHTF.getText());
                String ten = hotenTF.getText();
                String kieu = kieuKHCB.getSelectedItem().toString();
                KhachHang a = new KhachHang(ma, ten, kieu);
                listKH.add(a);
                tmKH.addRow(a.toObject());
            } catch (ValidException e1) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                setButton1(false);
                return;
            } 
        });
        boquaBt1.addActionListener(e -> {
            setButton1(true);
            maKHTF.setText("");
            hotenTF.setText("");
            kieuKHCB.setSelectedIndex(0);
            hotenTF.requestFocus();
        });
        suaBt.addActionListener(e -> {
            int r = bangKH.getSelectedRow();
            if (r >= 0 && r < bangKH.getRowCount()) {
                try {
                    int ma = Integer.parseInt(maKHTF.getText());
                    String ten = hotenTF.getText();
                    String kieu = kieuKHCB.getSelectedItem().toString();
                    KhachHang a = new KhachHang(ma, ten, kieu);
                    listKH.set(r, a);
                    tmKH.setValueAt(ten, r, 1);
                    tmKH.setValueAt(kieu, r, 2);

                } catch (ValidException ex) {
                    JOptionPane.showMessageDialog(this, "Khong de trong");
                } 

            }
        });

        luuBt1.addActionListener(e -> {
            IOFile.viet(fKH, listKH);
        });
    }

    private Tour getTour(int ma) {
        for (Tour i : listTour) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private KhachHang getKhachHang(int ma) {
        for (KhachHang i : listKH) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private void eventBDT() {
        lammoiBt.addActionListener(e -> {
            maKHCB.removeAllItems();
            matourCB.removeAllItems();
            for (KhachHang i : listKH) {
                maKHCB.addItem(i.getMa() + "");
            }
            for (Tour i : listTour) {
                matourCB.addItem(i.getMa() + "");
            }
            setButton2(false);
        });

        themBT2.addActionListener(e -> {
            setButton2(true);
            int maKH = Integer.parseInt(maKHCB.getSelectedItem().toString());
            int matour = Integer.parseInt(matourCB.getSelectedItem().toString());
            String ngaybd = ngayBdTF.getText();
            BangDatTour a;
            int songuoidk;
            try {
                songuoidk = Integer.parseInt(songuoidkTF.getText());
                a = new BangDatTour(getKhachHang(maKH), getTour(matour), songuoidk, ngaybd);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                return;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so");
                return;
            }
            int check = 1;
            for (BangDatTour i : listBDT) {
                if (i.getKh().getMa()== maKH && i.getTour().getMa() == matour && ngaybd.equals(i.getNgaybd()) ) {
                    check = 0;
                    JOptionPane.showMessageDialog(this, "Trung ngay");
                }
            }
            if (check == 1 ) {
                listBDT.add(a);
                tmBDT.addRow(a.toObject());
            }
        });
        luuBt2.addActionListener(e -> {
            IOFile.viet(fBDT, listBDT);
        });
        sapxepBt.addActionListener(e -> {
            if (jRadioButton1.isSelected()) {
                listBDT.sort(new Comparator<BangDatTour>() {
                    @Override
                    public int compare(BangDatTour o1, BangDatTour o2) {
                        return o1.getTour().getKieu().compareTo(o2.getTour().getKieu());
                    }
                });
            }
            if (jRadioButton2.isSelected()) {
                listBDT.sort(new Comparator<BangDatTour>() {
                    @Override
                    public int compare(BangDatTour o1, BangDatTour o2) {
                        return o1.getKh().getKieu().compareTo(o2.getKh().getKieu());
                    }
                });
            }
            showBangDat(listBDT);
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
        bangTour = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        maTourTF = new javax.swing.JTextField();
        kieuTourCB = new javax.swing.JComboBox<>();
        dongiaTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        thongtinTA = new javax.swing.JTextArea();
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
        hotenTF = new javax.swing.JTextField();
        maKHTF = new javax.swing.JTextField();
        kieuKHCB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangKH = new javax.swing.JTable();
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
        jLabel14 = new javax.swing.JLabel();
        songuoidkTF = new javax.swing.JTextField();
        maKHCB = new javax.swing.JComboBox<>();
        matourCB = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        ngayBdTF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangDatTour = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        themBT2 = new javax.swing.JButton();
        lammoiBt = new javax.swing.JButton();
        luuBt2 = new javax.swing.JButton();
        sapxepBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        bangTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma tour", "Kieu ", "Thong tin", "Don gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bangTour);

        jLabel1.setText("Ma tour:");

        jLabel4.setText("Kieu");

        jLabel6.setText("Don gia");

        maTourTF.setEditable(false);
        maTourTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maTourTFActionPerformed(evt);
            }
        });

        kieuTourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 ngày", "Dưới 5 ngày", "Dưới 7 ngày", "Dài ngày" }));

        jLabel16.setText("Thong tin");

        thongtinTA.setColumns(20);
        thongtinTA.setRows(5);
        jScrollPane4.setViewportView(thongtinTA);

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
                        .addComponent(maTourTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kieuTourCB, 0, 287, Short.MAX_VALUE)
                            .addComponent(dongiaTF)
                            .addComponent(jScrollPane4))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maTourTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kieuTourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dongiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(80, Short.MAX_VALUE))
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

        jTabbedPane1.addTab("Tour", jPanel1);

        jLabel7.setText("Ma");

        jLabel8.setText("Ho ten");

        jLabel9.setText("Kieu");

        hotenTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotenTFActionPerformed(evt);
            }
        });

        maKHTF.setEditable(false);
        maKHTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKHTFActionPerformed(evt);
            }
        });

        kieuKHCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca nhan", "Tap the" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(maKHTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hotenTF, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(kieuKHCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maKHTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(kieuKHCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma ", "Ho ten", "Kieu Khach hang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
                        .addGap(0, 38, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Khach Hang", jPanel2);

        jLabel10.setText("Ma Khach Hang");

        jLabel12.setText("Ma tour");

        jLabel14.setText("So nguoi dang ky");

        songuoidkTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                songuoidkTFMouseClicked(evt);
            }
        });

        maKHCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maKHCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                maKHCBItemStateChanged(evt);
            }
        });
        maKHCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maKHCBMouseClicked(evt);
            }
        });

        matourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Sap xep");

        jRadioButton1.setText("Theo loai tour");
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

        jRadioButton2.setText("Theo loai khach hang");
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

        jLabel2.setText("Ngay bat dau");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(42, 42, 42)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maKHCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(matourCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(songuoidkTF)
                            .addComponent(ngayBdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(maKHCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(matourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(songuoidkTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ngayBdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        bangDatTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma KH", "Ho ten", "Ma Tour", "Thong tin tour", "So nguoi dk", "Ngay bat dau"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangDatTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangDatTourMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bangDatTour);

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

        jTabbedPane1.addTab("Bang Dat Tour", jPanel3);

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

    private void bangDatTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangDatTourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bangDatTourMouseClicked

    private void bangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangKHMouseClicked
        int r = bangKH.getSelectedRow();
        maKHTF.setText(bangKH.getValueAt(r, 0) + "");
        hotenTF.setText(bangKH.getValueAt(r, 1) + "");
        for (int i = 0 ; i< kieuKHCB.getItemCount(); i++) {
            if (bangKH.getValueAt(r, 2).equals(kieuKHCB.getItemAt(i) ) )  {
                kieuKHCB.setSelectedIndex(i);
                break;
            }
        }
        
    }//GEN-LAST:event_bangKHMouseClicked

    private void maKHTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKHTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKHTFActionPerformed

    private void hotenTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotenTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotenTFActionPerformed

    private void maTourTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maTourTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maTourTFActionPerformed

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

    private void maKHCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maKHCBMouseClicked

        // TODO add your handling code here:
        
    }//GEN-LAST:event_maKHCBMouseClicked

    private void maKHCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_maKHCBItemStateChanged
        // TODO add your handling code here:
//        int ma = Integer.parseInt(maKHCB.getSelectedItem().toString());
//        int check = 1;
//        for (KhachHang i : listKH) {
//            if (i.getMa() == ma) {
//                check = 0;
//                songuoidkTF.setText("1");
//                break;
//            }
//        }
//        if (check == 1) songuoidkTF.setText("");
    }//GEN-LAST:event_maKHCBItemStateChanged

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void songuoidkTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songuoidkTFMouseClicked
        // TODO add your handling code here:
        
        if (getKhachHang(Integer.parseInt(maKHCB.getSelectedItem().toString())).getKieu().equalsIgnoreCase("Ca nhan") ) {
            songuoidkTF.setText("1");
            songuoidkTF.setEditable(false);
        } else {
            songuoidkTF.setText("");
            songuoidkTF.setEditable(true);
        }
    }//GEN-LAST:event_songuoidkTFMouseClicked

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
    private javax.swing.JTable bangDatTour;
    private javax.swing.JTable bangKH;
    private javax.swing.JTable bangTour;
    private javax.swing.JButton boquaBt;
    private javax.swing.JButton boquaBt1;
    private javax.swing.JButton capnhatBT;
    private javax.swing.JButton capnhatBT1;
    private javax.swing.JTextField dongiaTF;
    private javax.swing.JTextField hotenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> kieuKHCB;
    private javax.swing.JComboBox<String> kieuTourCB;
    private javax.swing.JButton lammoiBt;
    private javax.swing.JButton luuBt;
    private javax.swing.JButton luuBt1;
    private javax.swing.JButton luuBt2;
    private javax.swing.JComboBox<String> maKHCB;
    private javax.swing.JTextField maKHTF;
    private javax.swing.JTextField maTourTF;
    private javax.swing.JComboBox<String> matourCB;
    private javax.swing.JTextField ngayBdTF;
    private javax.swing.JButton sapxepBt;
    private javax.swing.JTextField songuoidkTF;
    private javax.swing.JButton suaBt;
    private javax.swing.JButton themBT;
    private javax.swing.JButton themBT1;
    private javax.swing.JButton themBT2;
    private javax.swing.JTextArea thongtinTA;
    private javax.swing.JButton xoaBt;
    // End of variables declaration//GEN-END:variables
}
