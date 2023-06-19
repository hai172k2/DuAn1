/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.DongSP;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface IDongSanPhamRepository {
    List<DongSP> findALL();
    DongSP save(DongSP dongSP);
    DongSP update(DongSP dongSP);
    String delete(String id);
}
