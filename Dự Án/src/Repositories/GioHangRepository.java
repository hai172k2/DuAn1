/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.GioHang;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class GioHangRepository implements IGioHangRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[GioHang] ( IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) values (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE GioHang set IdKH=?, IdNV=?, Ma=?, NgayTao=?, NgayThanhToan=?, TenNguoiNhan=?, DiaChi=?, Sdt=?, TinhTrang=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[GioHang] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM GioHang";
    final String FIND_BY_ID = "SELECT * FROM GioHang where Id =?";
    private List<GioHang> _list;
    
    private List<GioHang> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
              System.out.println(rs);
            _list.add(new GioHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }

    @Override
    public List<GioHang> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public GioHang save(GioHang x) {
        DBConnection.Excute(INSERT_SQL, x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayTao(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getTinhTrang());
        return x;
    }

    @Override
    public GioHang update(GioHang x) {
        DBConnection.Excute(UPDATE_SQL, x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayTao(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getTinhTrang(),x.getId());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }

    @Override
    public GioHang findBYid(String id) {
        _list = new ArrayList<>();
        return getSelectSql(FIND_BY_ID,id).get(0);
    }
}
