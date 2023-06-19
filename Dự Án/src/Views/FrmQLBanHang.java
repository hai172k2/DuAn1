/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Services.IManageChiTietSPService;
import Services.IManageDongSanPhamService;
import Services.IManageGioHangChiTietService;
import Services.IManageGioHangService;
import Services.IManageHoaDonChiTietService;
import Services.IManageHoaDonService;
import Services.IManageKhachHangService;
import Services.IManageMauSacService;
import Services.IManageNSXService;
import Services.IManageSanPhamService;
import Services.ManageChiTietSPService;
import Services.ManageDongSanPhamService;
import Services.ManageGioHangChiTietService;
import Services.ManageGioHangService;
import Services.ManageHoaDonChiTietService;
import Services.ManageHoaDonService;
import Services.ManageKhachHangService;
import Services.ManageMauSacService;
import Services.ManageNSXService;
import Services.ManageSanPhamService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmQLBanHang extends javax.swing.JFrame {
    
    IManageSanPhamService _iManageSanPhamService = new ManageSanPhamService();
    IManageNSXService _iManageNSXService = new ManageNSXService();
    IManageMauSacService _iManageMauSacService = new ManageMauSacService();
    IManageDongSanPhamService _iManageDongSPService = new ManageDongSanPhamService();
    IManageChiTietSPService _iManageChiTietSPService = new ManageChiTietSPService();
    IManageGioHangService _iManageGioHangService = new ManageGioHangService();
    IManageGioHangChiTietService _iManageGioHangChiTietService = new ManageGioHangChiTietService();
    IManageKhachHangService _iManageKhachHangService = new ManageKhachHangService();
    IManageHoaDonService _iManageHoaDonService = new ManageHoaDonService();
    IManageHoaDonChiTietService _iManageHoaDonChiTietService = new ManageHoaDonChiTietService();
    /**
     * Creates new form FrmQLGioHangChiTiet
     */
    public FrmQLBanHang() {
        initComponents();
        showFull();
        setLocationRelativeTo(null);
    }
    
    private void showFull(){
        showSanPham();
        showGioHang();
        showGioHangChiTiet();
        sumPrice();
    }
    
    private void showSanPham(){
        List<ChiTietSP> ds = _iManageChiTietSPService.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tbChiTietSP.getModel();
        dtm.setRowCount(0);
        for (ChiTietSP x : ds) {
            Object[] rowData = {
                x.getId(),
                checkTen(x.getSanPham(),0),
                checkTen(x.getNxs(),1),
                checkTen(x.getMauSac(),2),
                checkTen(x.getDongSP(),3),
                x.getSoLuongTon(),
                x.getGiaBan(),
                x.getMoTa()
            };   
            dtm.addRow(rowData);
        }
    }
    private void showGioHangChiTiet(){
        if(cbbGioHang.getSelectedIndex()!=-1){
            String id=_iManageGioHangService.getAll().get(cbbGioHang.getSelectedIndex()).getId();
            System.out.println(id);
            List<GioHangChiTiet> ds = _iManageGioHangChiTietService.findByIDkhach(id);
            DefaultTableModel dtm = (DefaultTableModel) this.tbGioHang.getModel();
            dtm.setRowCount(0);
            for (GioHangChiTiet x : ds) {
                Object[] rowData = {
                    x.getIdChiTietSP(),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdChiTietSP()).getSanPham(),0),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdChiTietSP()).getNxs(),1),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdChiTietSP()).getMauSac(),2),
                    checkTen(_iManageChiTietSPService.findbyid(x.getIdChiTietSP()).getDongSP(),3),
                    x.getSoLuong(),
                    x.getDonGia(),
                };   
                dtm.addRow(rowData);
            }
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
        }
        
        return ten;
    }
    
    private void showGioHang(){
        cbbGioHang.removeAllItems();
        List<GioHang> ds = _iManageGioHangService.getAll();
        if(ds.size()!=0){
            for (GioHang d : ds) {
            cbbGioHang.addItem(checkTen(d.getIdKH(),4));
            }
        }else{
            cbbGioHang.setSelectedIndex(-1);
        }
        
    }
    
    private void sumPrice(){
        if(cbbGioHang.getSelectedIndex()!=-1){
            Integer sum = 0;
            for (int i = 0; i < tbGioHang.getRowCount(); i++) {
                System.out.println(i+1);
                Integer soLuong =Integer.parseInt(this.tbGioHang.getValueAt(i, 5).toString()); 
                Integer donGia =Integer.parseInt(this.tbGioHang.getValueAt(i, 6).toString()); 
                sum+=soLuong*donGia;
            }

            jlbTongTien.setText(sum+"");
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietSP = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbbGioHang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jlbTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bán Hàng");

        tbChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Sản Phẩm", "NSX", "Màu Sắc", "Dòng SP", "Số Lượng Tồn", "Giá Bán", "Mô Tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChiTietSP);

        jLabel2.setText("giỏ hàng của khách ");

        cbbGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGioHangActionPerformed(evt);
            }
        });

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Sản Phẩm", "NSX", "Màu Sắc", "Dòng SP", "Số Lượng", "Đơn Giá"
            }
        ));
        tbGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbGioHang);

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Tổng Tiền");

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thanh Toán");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbbGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(jButton3)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbbGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChiTietSPMouseClicked
        // TODO add your handling code here:
        int row = this.tbChiTietSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        String idCTSanPham = this.tbChiTietSP.getValueAt(row, 0).toString();
        String idgh=_iManageGioHangService.getAll().get(cbbGioHang.getSelectedIndex()).getId();
        String giaBan = this.tbChiTietSP.getValueAt(row, 6).toString();
        GioHangChiTiet x = new GioHangChiTiet(idgh, idCTSanPham, 1, new BigDecimal(Double.parseDouble(giaBan)), null);
        _iManageGioHangChiTietService.create(x);
        showGioHangChiTiet();
        sumPrice();
    }//GEN-LAST:event_tbChiTietSPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FrmQLGioHang().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tbGioHang.getSelectedRow();
        String idctsp = (String) this.tbGioHang.getValueAt(selectedRowIndex, 0);
         String idgh=_iManageGioHangService.getAll().get(cbbGioHang.getSelectedIndex()).getId();
        _iManageGioHangChiTietService.delete(idctsp,idgh);
        showGioHangChiTiet();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGioHangActionPerformed
        // TODO add your handling code here:
        showGioHangChiTiet();
        showGioHang();
        sumPrice();
    }//GEN-LAST:event_cbbGioHangActionPerformed

    private void tbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGioHangMouseClicked
        // TODO add your handling code here:
        int row = this.tbGioHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        GioHangChiTiet x = new GioHangChiTiet();
        String idCTSanPham = this.tbGioHang.getValueAt(row, 0).toString();
        String idgh=_iManageGioHangService.getAll().get(cbbGioHang.getSelectedIndex()).getId();
        Integer soLuong =Integer.parseInt(this.tbGioHang.getValueAt(row, 5).toString()); 
        x.setSoLuong(soLuong);
        x.setIdChiTietSP(idCTSanPham);
        x.setIdGioHang(idgh);
        _iManageGioHangChiTietService.update(x);
        sumPrice();
    }//GEN-LAST:event_tbGioHangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String idGH = _iManageGioHangService.getAll().get(cbbGioHang.getSelectedIndex()).getId();
        GioHang y = _iManageGioHangService.findBYid(idGH);
        
        HoaDon x= new HoaDon();
        x.setId(null);
        x.setIdKH(y.getIdKH());
        x.setIdNV(y.getIdNV());
        x.setMa(y.getMa());
        x.setNgayTao(new Date());
        x.setNgayThanhToan(new Date());
        x.setNgayShip(new Date());
        x.setNgayNhan(new Date());
        x.setTinhTrang(0);
        x.setTenNguoiNhan(y.getTenNguoiNhan());
        x.setDiaChi(y.getDiaChi());
        x.setSdt(y.getSdt());
      
        _iManageHoaDonService.create(x);
        for (int i = 0; i < tbGioHang.getRowCount(); i++) {
            String idstsp =this.tbGioHang.getValueAt(i, 0).toString(); 
            Integer soLuong =Integer.parseInt(this.tbGioHang.getValueAt(i, 5).toString()); 
            BigDecimal donGia = new BigDecimal(Integer.parseInt(this.tbGioHang.getValueAt(i, 6).toString())); 
            ChiTietSP ctsp =_iManageChiTietSPService.findbyid(idstsp);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon()-soLuong);
            _iManageChiTietSPService.update(ctsp);
            _iManageHoaDonChiTietService.create(new HoaDonChiTiet(null, idstsp, soLuong, donGia));
             _iManageGioHangChiTietService.delete(idstsp, idGH);
            
        }
        _iManageGioHangService.delete(idGH);
        showFull();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbGioHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JTable tbChiTietSP;
    private javax.swing.JTable tbGioHang;
    // End of variables declaration//GEN-END:variables
}
