/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author cuong
 */
public class NSXRepository implements INSXRepository{

    final String INSERT_SQL = "INSERT INTO [dbo].[NSX] ([ma],[ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[NSX] SET [ma] = ?, [ten] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[NSX] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NSX";
    
    private List<NSX> _listNSX;
   
    public NSXRepository() {
        _listNSX = new ArrayList<>();
        
    }
    
    @Override
    public List<NSX> findALL() {
        _listNSX = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public NSX save(NSX nsx) {
        DBConnection.Excute(INSERT_SQL, nsx.getMa(),nsx.getTen());
        return nsx;
    }

   
    
    private List<NSX> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listNSX.add(new NSX(rs.getString(1), rs.getString(2), rs.getString(3)));
          }
          return _listNSX;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }

    @Override
    public NSX update(NSX nsx) {
        DBConnection.Excute(UPDATE_SQL, nsx.getMa(),nsx.getTen(),nsx.getId());
        return nsx;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    
}
