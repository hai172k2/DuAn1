/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.CuaHang;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface IManageCuaHangService {
    List<CuaHang> getAll();
    CuaHang create(CuaHang cuaHang);
    CuaHang update(CuaHang cuaHang);
    String delete(String id);
}
