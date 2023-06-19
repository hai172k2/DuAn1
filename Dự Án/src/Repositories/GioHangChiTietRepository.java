/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.GioHangChiTiet;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GioHangChiTietRepository implements IGioHangChiTietRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[GioHangChiTiet] ( IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) values (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE GioHangChiTiet set SoLuong=? WHERE [IdChiTietSP] = ? AND [IdGioHang] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[GioHangChiTiet] WHERE [IdChiTietSP] = ? AND [IdGioHang] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM GioHangChiTiet";
    final String FIND_BY_ID_GIOHANG = "SELECT * FROM GioHangChiTiet where IdGioHang=?";
    private List<GioHangChiTiet> _list;
    private List<GioHangChiTiet> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _list.add(new GioHangChiTiet(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBigDecimal(4), rs.getBigDecimal(5)));
          }
          return _list;
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
    }

    @Override
    public List<GioHangChiTiet> findALL() {
        _list = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public GioHangChiTiet save(GioHangChiTiet x) {
        DBConnection.Excute(INSERT_SQL, x.getIdGioHang(),x.getIdChiTietSP(),x.getSoLuong(),x.getDonGia(),x.getDonGiaKhiGiam());
        return x;
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet x) {
        DBConnection.Excute(UPDATE_SQL,x.getSoLuong(),x.getIdChiTietSP(),x.getIdGioHang());
        return x;
    }

    @Override
    public String delete(String idgh,String idCTSP) {
        DBConnection.Excute(DELETE_SQL, idCTSP,idgh);
        return idgh;
    }

    @Override
    public List<GioHangChiTiet> findByIDkhach(String id) {
        _list = new ArrayList<>();
        return getSelectSql(FIND_BY_ID_GIOHANG,id);
    }


}
