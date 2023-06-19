/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class DongSanPhamRpository implements IDongSanPhamRepository{
    final String INSERT_SQL = "INSERT INTO [dbo].[DongSP] ([ma],[ten])VALUES(?,?)";
    final String UPDATE_SQL = "UPDATE [dbo].[DongSP] SET [ma] = ?, [ten] =? WHERE [id] = ?";
    final String DELETE_SQL = "DELETE FROM [dbo].[DongSP] WHERE [Id] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM DongSP";
    
    private List<DongSP> _listdongSP;

    @Override
    public List<DongSP> findALL() {
         _listdongSP = new ArrayList<>();
        return getSelectSql(SELECT_ALL_SQL);
    }

    @Override
    public DongSP save(DongSP dongSP) {
        DBConnection.Excute(INSERT_SQL, dongSP.getMa(),dongSP.getTen());
        return dongSP;
    }

    @Override
    public DongSP update(DongSP dongSP) {
        DBConnection.Excute(UPDATE_SQL, dongSP.getMa(),dongSP.getTen(),dongSP.getId());
        return dongSP;
    }

    @Override
    public String delete(String id) {
        DBConnection.Excute(DELETE_SQL, id);
        return id;
    }
    
    private List<DongSP> getSelectSql(String sql, Object... args) {
        try {
          ResultSet rs = DBConnection.getDataFromQuery(sql, args);
          while (rs.next()) {      
            _listdongSP.add(new DongSP(rs.getString(1), rs.getString(2), rs.getString(3)));
          }
          return _listdongSP;
        } catch (SQLException ex) {
          throw new RuntimeException();
        }
    }
    
}
