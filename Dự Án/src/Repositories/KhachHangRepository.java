/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author cuong
 */
public class KhachHangRepository implements IKhachHangRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[KhachHang] ( Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) values (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhachHang set Ma = ?, Ten =?, TenDem=?, Ho=?, NgaySinh=?, Sdt=?, DiaChi=?, ThanhPho=?, QuocGia=?, MatKhau=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[KhachHang] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    private List<KhachHang> _list;
    private List<KhachHang> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }

    @Override
    public List<KhachHang> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang save(KhachHang x) {
        DBConnection.Excute(INSERT_SQL, x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getSdt(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia(),x.getMatKhau());
        return x;
    }

    @Override
    public KhachHang update(KhachHang x) {
        DBConnection.Excute(UPDATE_SQL, x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getSdt(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia(),x.getMatKhau(),x.getId());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
}
