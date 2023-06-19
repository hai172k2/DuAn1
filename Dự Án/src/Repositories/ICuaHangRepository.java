/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.CuaHang;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface ICuaHangRepository {
    List<CuaHang> findALL();
    CuaHang save(CuaHang cuaHang);
    CuaHang update(CuaHang cuaHang);
    String delete(String id);
}
