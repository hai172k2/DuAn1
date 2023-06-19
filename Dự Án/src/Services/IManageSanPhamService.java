/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageSanPhamService {
    List<SanPham> getAll();
    SanPham create(SanPham sanPham);
    SanPham update(SanPham sanPham);
    String delete(String id);
}
