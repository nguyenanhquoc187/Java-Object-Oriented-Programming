/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.IOFile;
import Controller.SodienthoaiException;
import Controller.ValidException;
import Model.BanDoc;
import Model.QuanLyMuonSach;
import Model.Sach;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Main extends javax.swing.JFrame {

    private List<Sach> listSach;
    private List<BanDoc> listBdoc;
    private List<QuanLyMuonSach> listQLMS;
    private String fsach, fbdoc, fql;
    private DefaultTableModel tmSach, tmbDoc, tmQl;

    public Main() {
        initComponents();
        tmSach = (DefaultTableModel) bangSach.getModel();
        tmbDoc = (DefaultTableModel) bangBandoc.getModel();
        tmQl = (DefaultTableModel) bangQl.getModel();
        fsach = "src/controller/SACH.DAT";
        fbdoc = "src/controller/BD.DAT";
        fql = "src/controller/QLMS.DAT";
        loadSach();
        loadBanDoc();
        loadQl();
        showSach(listSach);
        showBanDoc(listBdoc);
        showQl(listQLMS);
        eventSach();
        eventBanDoc();
        eventQl();
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

    private void loadSach() {
        File f = new File(fsach);
        if (f.exists()) {
            listSach = IOFile.doc(fsach);
        } else {
            listSach = new ArrayList();
        }
    }

    private void loadBanDoc() {
        File f = new File(fbdoc);
        if (f.exists()) {
            listBdoc = IOFile.doc(fbdoc);
        } else {
            listBdoc = new ArrayList();
        }
    }

    private void loadQl() {
        File f = new File(fql);
        if (f.exists()) {
            listQLMS = IOFile.doc(fql);
        } else {
            listQLMS = new ArrayList();
        }
    }

    private void showSach(List<Sach> lst) {
        tmSach.setRowCount(0);
        for (Sach i : lst) {
            tmSach.addRow(i.toObject());
        }
    }

    private void showBanDoc(List<BanDoc> lst) {
        tmbDoc.setRowCount(0);
        for (BanDoc i : lst) {
            tmbDoc.addRow(i.toObject());
        }
    }

    private void showQl(List<QuanLyMuonSach> lst) {
        tmQl.setRowCount(0);
        for (QuanLyMuonSach i : lst) {
            tmQl.addRow(i.toObject());
        }
    }

    private void eventSach() {
        themBT.addActionListener(e -> {
            setButton(false);
            int n = listSach.size();
            masachTF.setText(10000 + n + "");
            tensachTF.setText("");
            tacgiaTF.setText("");
            nxbTF.setText("");
            soluongTF.setText("");
            tensachTF.requestFocus();
        });

        capnhatBT.addActionListener(e -> {
            setButton(true);
            try {
                Sach sach = new Sach(Integer.parseInt(masachTF.getText()), tensachTF.getText(), tacgiaTF.getText(),
                        cnganhCB.getSelectedItem().toString(), nxbTF.getText(), Integer.parseInt(soluongTF.getText()));
                listSach.add(sach);
                tmSach.addRow(sach.toObject());
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
            masachTF.setText("");
            tensachTF.setText("");
            tacgiaTF.setText("");
            nxbTF.setText("");
            soluongTF.setText("");
            tensachTF.requestFocus();
        });
        xoaBt.addActionListener(e -> {
            int row = bangSach.getSelectedRow();
            if (row >= 0 && row < bangSach.getRowCount()) {
                listSach.remove(row);
                tmSach.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuBt.addActionListener(e -> {
            IOFile.viet(fsach, listSach);
        });
    }

    private void eventBanDoc() {
        themBT1.addActionListener(e -> {
            setButton1(false);
            int n = listBdoc.size();
            mabdocTF.setText(10000 + n + "");
            hotenTF.setText("");
            diachiTF.setText("");
            sdtTF.setText("");
            hotenTF.requestFocus();
        });

        capnhatBT1.addActionListener(ex -> {
            setButton1(true);
            try {
                int ma = Integer.parseInt(mabdocTF.getText());
                String ten = hotenTF.getText();
                String dchi = diachiTF.getText();
                String sdt = sdtTF.getText();
                BanDoc a = new BanDoc(ten, dchi, sdt);
                listBdoc.add(a);
                tmbDoc.addRow(a.toObject());
            } catch (ValidException e1) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                setButton1(false);
                return;
            } catch (SodienthoaiException ex1) {
                JOptionPane.showMessageDialog(this, "So dien thoai khong dung dinh dang");
                setButton1(false);
                return;
            }
        });
        boquaBt1.addActionListener(e -> {
            setButton1(true);
            mabdocTF.setText("");
            hotenTF.setText("");
            diachiTF.setText("");
            sdtTF.setText("");
            hotenTF.requestFocus();
        });
        suaBt.addActionListener(e -> {
            int r = bangBandoc.getSelectedRow();
            if (r >= 0 && r < bangBandoc.getRowCount()) {
                try {
                    String ten = hotenTF.getText();
                    String dchi = diachiTF.getText();
                    String sdt = sdtTF.getText();
                    BanDoc a = new BanDoc(ten, dchi, sdt);
                    listBdoc.set(r, a);
                    tmbDoc.setValueAt(ten, r, 1);
                    tmbDoc.setValueAt(dchi, r, 2);
                    tmbDoc.setValueAt(sdt, r, 3);

                } catch (ValidException ex) {
                    JOptionPane.showMessageDialog(this, "Khong de trong");
                } catch (SodienthoaiException ex) {
                    JOptionPane.showMessageDialog(this, "So dien thoai khong dung dinh dang");
                    return;
                }

            }
        });

        luuBt1.addActionListener(e -> {
            IOFile.viet(fbdoc, listBdoc);
        });
    }

    private Sach getSach(int ma) {
        for (Sach i : listSach) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private BanDoc getBanDoc(int ma) {
        for (BanDoc i : listBdoc) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private void eventQl() {
        lammoiBt.addActionListener(e -> {
            mabdocCB.removeAllItems();
            masachCB.removeAllItems();
            for (BanDoc i : listBdoc) {
                mabdocCB.addItem(i.getMa() + "");
            }
            for (Sach i : listSach) {
                masachCB.addItem(i.getMa() + "");
            }
        });

        themBT2.addActionListener(e -> {
            int mabdoc = Integer.parseInt(mabdocCB.getSelectedItem().toString());
            int masach = Integer.parseInt(masachCB.getSelectedItem().toString());
            String tinhtrang = tinhtrangTF.getText();
            QuanLyMuonSach a;
            int soluong;
            try {
                soluong = Integer.parseInt(soLuongTF.getText());
                a = new QuanLyMuonSach(getSach(masach), getBanDoc(mabdoc), tinhtrang, soluong);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, "Khong de trong");
                return;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so");
                return;
            }
            int check = 1, check1 = 1, check2 = 1, count = 0;
            for (QuanLyMuonSach i : listQLMS) {
                if (i.getBandoc().getMa() == mabdoc && i.getSach().getMa() == masach) {
                    check = 0;
                }
                if (i.getBandoc().getMa() == mabdoc) {
                    count++;
                }
            }
            if (count + 1 > 5) {
                check1 = 0;
            }
            if (soluong > 3) {
                check2 = 0;
            }
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Trung du lieu");
            } else if (check1 == 0) {
                JOptionPane.showMessageDialog(this, "Muon qua nhieu chua tra");
            } else if (check2 == 0) {
                JOptionPane.showMessageDialog(this, "Khong duoc muon qua 3 quyen");
            } else {
                listQLMS.add(a);
                tmQl.addRow(a.toObject());
            }
        });
        luuBt2.addActionListener(e -> {
            IOFile.viet(fql, listQLMS);
        });
        sapxepBt.addActionListener(e -> {
            if (jRadioButton1.isSelected()) {
                listQLMS.sort(new Comparator<QuanLyMuonSach>() {
                    @Override
                    public int compare(QuanLyMuonSach o1, QuanLyMuonSach o2) {
                        String ten1 = o1.getBandoc().getHoten(), ten2 = o2.getBandoc().getHoten();
                        String[] a = ten1.split("\\s+"), b = ten2.split("\\s+");
                        ten1 = a[a.length - 1] + o1.getBandoc().getHoten();
                        ten2 = b[b.length - 1] + o2.getBandoc().getHoten();
                        return ten1.compareToIgnoreCase(ten2);
                    }
                });
            }
            if (jRadioButton2.isSelected()) {
                listQLMS.sort(new Comparator<QuanLyMuonSach>() {
                    @Override
                    public int compare(QuanLyMuonSach o1, QuanLyMuonSach o2) {
                        return o2.getSoluong() - o1.getSoluong();
                    }
                });
            }
            showQl(listQLMS);
        });
        
        timkiemBT.addActionListener(e -> { 
            String key = timkiemTF.getText();
            List<QuanLyMuonSach> list = new ArrayList<>();
            for (QuanLyMuonSach i : listQLMS) 
                if (i.getBandoc().getHoten().toLowerCase().contains(key.toLowerCase())) list.add(i);
            showQl(list);
        } );
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
        bangSach = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tensachTF = new javax.swing.JTextField();
        tacgiaTF = new javax.swing.JTextField();
        masachTF = new javax.swing.JTextField();
        cnganhCB = new javax.swing.JComboBox<>();
        nxbTF = new javax.swing.JTextField();
        soluongTF = new javax.swing.JTextField();
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
        hotenTF = new javax.swing.JTextField();
        diachiTF = new javax.swing.JTextField();
        mabdocTF = new javax.swing.JTextField();
        sdtTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangBandoc = new javax.swing.JTable();
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
        jLabel14 = new javax.swing.JLabel();
        tinhtrangTF = new javax.swing.JTextField();
        soLuongTF = new javax.swing.JTextField();
        mabdocCB = new javax.swing.JComboBox<>();
        masachCB = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        timkiemTF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangQl = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        themBT2 = new javax.swing.JButton();
        lammoiBt = new javax.swing.JButton();
        luuBt2 = new javax.swing.JButton();
        sapxepBt = new javax.swing.JButton();
        timkiemBT = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        thongkeBT = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        thongkeTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bangSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ten sach", "Ten tac gia", "Chuyen nganh", "Nam xuat ban", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bangSach);

        jLabel1.setText("Ma sach:");

        jLabel2.setText("Ten sach:");

        jLabel3.setText("Ten tac gia");

        jLabel4.setText("Chuyen nganh");

        jLabel5.setText("Nam xuat ban:");

        jLabel6.setText("So luong");

        tensachTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tensachTFActionPerformed(evt);
            }
        });

        tacgiaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tacgiaTFActionPerformed(evt);
            }
        });

        masachTF.setEditable(false);
        masachTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masachTFActionPerformed(evt);
            }
        });

        cnganhCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa học tự nhiên", "Văn học – Nghệ thuật, Điện tử", "Viễn thông", "Công nghệ thông tin" }));

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
                        .addComponent(masachTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tensachTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tacgiaTF)
                            .addComponent(cnganhCB, 0, 287, Short.MAX_VALUE)
                            .addComponent(nxbTF)
                            .addComponent(soluongTF))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(masachTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tensachTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tacgiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnganhCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nxbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soluongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
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

        jTabbedPane1.addTab("Sach", jPanel1);

        jLabel7.setText("Ma ban doc");

        jLabel8.setText("Ho ten");

        jLabel9.setText("Dia chi");

        jLabel11.setText("So dien thoai");

        hotenTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotenTFActionPerformed(evt);
            }
        });

        diachiTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diachiTFActionPerformed(evt);
            }
        });

        mabdocTF.setEditable(false);
        mabdocTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mabdocTFActionPerformed(evt);
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
                        .addComponent(diachiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mabdocTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hotenTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mabdocTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(diachiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sdtTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        bangBandoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma ban doc", "Ho ten", "Dia chi", "So dien thoai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangBandoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangBandocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangBandoc);

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

        jTabbedPane1.addTab("Ban doc", jPanel2);

        jLabel10.setText("Ma ban doc");

        jLabel12.setText("Ma sach");

        jLabel13.setText("Tinh trang");

        jLabel14.setText("So luong muon");

        tinhtrangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhtrangTFActionPerformed(evt);
            }
        });

        mabdocCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        masachCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Sap xep");

        jRadioButton1.setText("Theo ten ban doc");
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

        jRadioButton2.setText("Theo so luong cuon sach duoc muon");
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

        jLabel17.setText("Tim kiem theo ten");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(timkiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
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
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mabdocCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tinhtrangTF)
                                .addComponent(masachCB, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(soLuongTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(mabdocCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(masachCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tinhtrangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(soLuongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(timkiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        bangQl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma ban doc", "Ho ten", "Ma sach", "Ten sach", "Tinh trang", "So luong muon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangQl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangQlMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bangQl);

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

        timkiemBT.setText("Tim kiem");

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
                        .addComponent(luuBt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(timkiemBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(timkiemBT)
                .addGap(17, 17, 17))
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

        jTabbedPane1.addTab("Quan ly muon sach", jPanel3);

        jLabel16.setText("Thong ke thu nhap:");

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

    private void bangQlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangQlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bangQlMouseClicked

    private void tinhtrangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhtrangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinhtrangTFActionPerformed

    private void bangBandocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangBandocMouseClicked
        int r = bangBandoc.getSelectedRow();
        mabdocTF.setText(bangBandoc.getValueAt(r, 0) + "");
        hotenTF.setText(bangBandoc.getValueAt(r, 1) + "");
        diachiTF.setText(bangBandoc.getValueAt(r, 2) + "");
        sdtTF.setText(bangBandoc.getValueAt(r, 3) + "");
    }//GEN-LAST:event_bangBandocMouseClicked

    private void mabdocTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mabdocTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mabdocTFActionPerformed

    private void diachiTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diachiTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diachiTFActionPerformed

    private void hotenTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotenTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotenTFActionPerformed

    private void masachTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masachTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masachTFActionPerformed

    private void tacgiaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tacgiaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tacgiaTFActionPerformed

    private void tensachTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tensachTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tensachTFActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangBandoc;
    private javax.swing.JTable bangQl;
    private javax.swing.JTable bangSach;
    private javax.swing.JButton boquaBt;
    private javax.swing.JButton boquaBt1;
    private javax.swing.JButton capnhatBT;
    private javax.swing.JButton capnhatBT1;
    private javax.swing.JComboBox<String> cnganhCB;
    private javax.swing.JTextField diachiTF;
    private javax.swing.JTextField hotenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JComboBox<String> mabdocCB;
    private javax.swing.JTextField mabdocTF;
    private javax.swing.JComboBox<String> masachCB;
    private javax.swing.JTextField masachTF;
    private javax.swing.JTextField nxbTF;
    private javax.swing.JButton sapxepBt;
    private javax.swing.JTextField sdtTF;
    private javax.swing.JTextField soLuongTF;
    private javax.swing.JTextField soluongTF;
    private javax.swing.JButton suaBt;
    private javax.swing.JTextField tacgiaTF;
    private javax.swing.JTextField tensachTF;
    private javax.swing.JButton themBT;
    private javax.swing.JButton themBT1;
    private javax.swing.JButton themBT2;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JTextArea thongkeTA;
    private javax.swing.JButton timkiemBT;
    private javax.swing.JTextField timkiemTF;
    private javax.swing.JTextField tinhtrangTF;
    private javax.swing.JButton xoaBt;
    // End of variables declaration//GEN-END:variables
}
