/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class HoaDonRepository implements IHoaDonRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[HoaDon] ( IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt) values (?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDon set IdKH=?, IdNV=?, Ma=?, NgayTao=?, NgayThanhToan=?, NgayShip=?, NgayNhan=?, TinhTrang=?, TenNguoiNhan=?, DiaChi=?, Sdt=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[HoaDon] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    private List<HoaDon> _list;
    private List<HoaDon> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }

    @Override
    public List<HoaDon> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon save(HoaDon x) {
        DBConnection.Excute(INSERT_SQL, x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayThanhToan(),x.getNgayShip(),x.getNgayNhan(),x.getTinhTrang(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt());
        return x;
    }

    @Override
    public HoaDon update(HoaDon x) {
        DBConnection.Excute(UPDATE_SQL, x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayThanhToan(),x.getNgayShip(),x.getNgayNhan(),x.getTinhTrang(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getId());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
}
