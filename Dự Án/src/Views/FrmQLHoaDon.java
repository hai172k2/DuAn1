/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.DongSP;
import DomainModels.GioHangChiTiet;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import Services.IManageChiTietSPService;
import Services.IManageDongSanPhamService;
import Services.IManageHoaDonChiTietService;
import Services.IManageHoaDonService;
import Services.IManageKhachHangService;
import Services.IManageMauSacService;
import Services.IManageNSXService;
import Services.IManageNhanVienService;
import Services.IManageSanPhamService;
import Services.ManageChiTietSPService;
import Services.ManageDongSanPhamService;
import Services.ManageHoaDonChiTietService;
import Services.ManageHoaDonService;
import Services.ManageKhachHangService;
import Services.ManageMauSacService;
import Services.ManageNSXService;
import Services.ManageNhanVienService;
import Services.ManageSanPhamService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cuong
 */
public class FrmQLHoaDon extends javax.swing.JFrame {
    IManageHoaDonService _iManageHoaDonService = new ManageHoaDonService();
    IManageChiTietSPService _iManageChiTietSPService = new ManageChiTietSPService();
    IManageHoaDonChiTietService _iManageHoaDonChiTietService = new ManageHoaDonChiTietService();
    IManageSanPhamService _iManageSanPhamService = new ManageSanPhamService();
    IManageNSXService _iManageNSXService = new ManageNSXService();
    IManageMauSacService _iManageMauSacService = new ManageMauSacService();
    IManageDongSanPhamService _iManageDongSPService = new ManageDongSanPhamService();
    IManageKhachHangService _iManageKhachHangService = new ManageKhachHangService();
    IManageNhanVienService _iManageNhanVienService = new ManageNhanVienService();
    /**
     * Creates new form FrmQLHoaDon
     */
    public FrmQLHoaDon() {
        initComponents();
        loadDataToTable();
    }
    private void loadDataToTable() {
        List<HoaDon> ds = _iManageHoaDonService.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tbHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDon x : ds) {
            Object[] rowData = {
                x.getId(),
                checkTen(x.getIdKH(),4),
                checkTen(x.getIdNV(),5),
                x.getNgayTao(),
                x.getTenNguoiNhan(),
                x.getDiaChi(),
                x.getSdt()
            };   
            dtm.addRow(rowData);
        }
    }
    private void showTableCT(String idGH) {
        List<HoaDonChiTiet> ds = _iManageHoaDonChiTietService.getAll(idGH);
        DefaultTableModel dtm = (DefaultTableModel) this.tbHoaDonCT.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTiet x : ds) {
                Object[] rowData = {
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdCTSP()).getSanPham(),0),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdCTSP()).getNxs(),1),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdCTSP()).getMauSac(),2),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdCTSP()).getDongSP(),3),
                    x.getSoLuong(),
                    x.getDonGia()
                };   
                dtm.addRow(rowData);
            }
    }

    private String checkTen(String tencheck, Integer index){
        String ten="";
        if(index==0){
            List<SanPham> ds = _iManageSanPhamService.getAll();
            for (SanPham d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }else if(index==1){
            List<NSX> ds = _iManageNSXService.getAllNSX();
            for (NSX d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }
        else if(index==2){
            List<MauSac> ds = _iManageMauSacService.getAllMauSac();
            for (MauSac d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }
        else if(index==3){
            List<DongSP> ds = _iManageDongSPService.getAll();
            for (DongSP d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }else if(index==4){
            List<KhachHang> ds = _iManageKhachHangService.getAll();
            for (KhachHang d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }else if(index==5){
            List<NhanVien> ds = _iManageNhanVienService.getAll();
            for (NhanVien d : ds) {
                if(d.getId().equals(tencheck)){
                    ten = d.getTen();
                }
            }
        }
        
        return ten;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDonCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Khách Hàng", "Nhân Viên", "Ngày Mua", "Tên Người Nhận", "Địa Chỉ", "SĐT"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Chi Tiết Đơn Hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Quản Lý Hóa Đơn");

        tbHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sản Phẩm", "NSX", "Dòng SP", "Màu Sắc", "Số Lượng", "Đơn Giá"
            }
        ));
        jScrollPane2.setViewportView(tbHoaDonCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(283, 283, 283))))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
         int row = this.tbHoaDon.getSelectedRow();
        if (row == -1) {
            return;
        }
        showTableCT(this.tbHoaDon.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tbHoaDonMouseClicked

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
            java.util.logging.Logger.getLogger(FrmQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbHoaDonCT;
    // End of variables declaration//GEN-END:variables
}
