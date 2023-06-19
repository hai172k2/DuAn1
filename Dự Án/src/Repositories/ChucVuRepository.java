/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author cuong
 */
public class ChucVuRepository implements IChucVuRepository{

    final String INSERT_SQL = "INSERT INTO [dbo].[ChucVu] ([ma],[ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[ChucVu] SET [ma] = ?, [ten] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[ChucVu] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ChucVu";
    
    private List<ChucVu> _listChucVu;
    
    @Override
    public List<ChucVu> findALL() {
        _listChucVu = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public ChucVu save(ChucVu chucVu) {
        DBConnection.Excute(INSERT_SQL, chucVu.getMa(),chucVu.getTen());
        return chucVu;
    }

    @Override
    public ChucVu update(ChucVu chucVu) {
        DBConnection.Excute(UPDATE_SQL, chucVu.getMa(),chucVu.getTen(),chucVu.getId());
        return chucVu;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    private List<ChucVu> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listChucVu.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3)));
          }
          return _listChucVu;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }
    
}
