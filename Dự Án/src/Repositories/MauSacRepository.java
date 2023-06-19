/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author cuong
 */
public class MauSacRepository implements IMauSacRepository{
    
    final String INSERT_SQL = "INSERT INTO [dbo].[MauSac] ([ma],[ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[MauSac] SET [ma] = ?, [ten] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[MauSac] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM MauSac";
    
    private List<MauSac> _listMauSac;

    @Override
    public List<MauSac> findALL() {
        _listMauSac = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public MauSac save(MauSac mauSac) {
        DBConnection.Excute(INSERT_SQL, mauSac.getMa(),mauSac.getTen());
        return mauSac;
    }

    @Override
    public MauSac update(MauSac mauSac) {
        DBConnection.Excute(UPDATE_SQL, mauSac.getMa(),mauSac.getTen(),mauSac.getId());
        return mauSac;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    
    private List<MauSac> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listMauSac.add(new MauSac(rs.getString(1), rs.getString(2), rs.getString(3)));
          }
          return _listMauSac;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }
    
    
}
