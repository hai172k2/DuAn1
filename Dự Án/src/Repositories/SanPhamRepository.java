/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author cuong
 */
public class SanPhamRepository implements ISanPhamRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[SanPham] ([ma],[ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[SanPham] SET [ma] = ?, [ten] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[SanPham] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    
    private List<SanPham> _listSanPham;
    @Override
    public List<SanPham> findALL() {
        _listSanPham = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham save(SanPham sanPham) {
        DBConnection.Excute(INSERT_SQL, sanPham.getMa(),sanPham.getTen());
        return sanPham;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        DBConnection.Excute(UPDATE_SQL, sanPham.getMa(),sanPham.getTen(),sanPham.getId());
        return sanPham;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    
    private List<SanPham> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
          }
          return _listSanPham;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }
    
}
