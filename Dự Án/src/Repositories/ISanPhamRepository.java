/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface ISanPhamRepository {
    List<SanPham> findALL();
    SanPham save(SanPham sanPham);
    SanPham update(SanPham sanPham);
    String delete(String id);
}
