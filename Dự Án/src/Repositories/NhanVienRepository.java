/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author cuong
 */
public class NhanVienRepository implements INhanVienRepository{
    
    final String INSERT_SQL = "INSERT INTO [dbo].[NhanVien] (Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien set Ma=?, Ten=?, TenDem=?, Ho=?, GioiTinh=?, NgaySinh=?, DiaChi=?, Sdt=?, MatKhau=?, IdCH=?, IdCV=?, TrangThai=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[NhanVien] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    private List<NhanVien> _list;
    private List<NhanVien> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),rs.getInt(13)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }

    @Override
    public List<NhanVien> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien save(NhanVien x) {
        DBConnection.Excute(INSERT_SQL, x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getGioiTinh(),x.getNgaySinh(),x.getDiaChi(),x.getSdt(),x.getMatKhau(),x.getIdCH(),x.getIdCV(),x.getTrangThai());
        return x;
    }

    @Override
    public NhanVien update(NhanVien x) {
        DBConnection.Excute(UPDATE_SQL, x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getGioiTinh(),x.getNgaySinh(),x.getDiaChi(),x.getSdt(),x.getMatKhau(),x.getIdCH(),x.getIdCV(),x.getTrangThai(),x.getId());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
}
