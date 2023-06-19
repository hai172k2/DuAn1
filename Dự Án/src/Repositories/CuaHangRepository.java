/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.CuaHang;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author cuong
 */
public class CuaHangRepository implements ICuaHangRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[CuaHang] ([Ma],[Ten],[DiaChi],[ThanhPho],[QuocGia])VALUES(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[CuaHang] SET [Ma] = ?, [Ten] =? , [DiaChi] =?, [ThanhPho] =?, [QuocGia] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[CuaHang] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM CuaHang";
    private List<CuaHang> _listCuaHang;
    private List<CuaHang> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listCuaHang.add(new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
          }
          return _listCuaHang;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }
    @Override
    public List<CuaHang> findALL() {
        _listCuaHang = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public CuaHang save(CuaHang cuaHang) {
        DBConnection.Excute(INSERT_SQL, cuaHang.getMa(),cuaHang.getTen(),cuaHang.getDiaChi(),cuaHang.getThanhPho(),cuaHang.getQuocGia());
        return cuaHang;
    }

    @Override
    public CuaHang update(CuaHang cuaHang) {
        DBConnection.Excute(UPDATE_SQL, cuaHang.getMa(),cuaHang.getTen(),cuaHang.getDiaChi(),cuaHang.getThanhPho(),cuaHang.getQuocGia(),cuaHang.getId());
        return cuaHang;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
}
