/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[HoaDonChiTiet] ( IdHoaDon, IdChiTietSP, SoLuong, DonGia) values ((SELECT top 1 id from HoaDon order by NgayThanhToan desc),?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDonChiTiet set  IdHoaDon=?, IdChiTietSP=?, SoLuong=?, DonGia=? where Id=?";
    final String DELETE_SQL = "DELETE FROM [dbo].[HoaDonChiTiet] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM HoaDonChiTiet where IdHoaDon=?";
    private List<HoaDonChiTiet> _list;
    private List<HoaDonChiTiet> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBigDecimal(4)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }
    @Override
    public List<HoaDonChiTiet> getAll(String idHD) {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL,idHD);
    }

    @Override
    public HoaDonChiTiet create(HoaDonChiTiet x) {
        DBConnection.Excute(INSERT_SQL,x.getIdCTSP(),x.getSoLuong(),x.getDonGia());
        return x;
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet x) {
        DBConnection.Excute(UPDATE_SQL, x.getIdHD(),x.getIdCTSP(),x.getSoLuong(),x.getDonGia());
        return x;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    
}
