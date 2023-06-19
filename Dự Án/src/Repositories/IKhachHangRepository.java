/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.KhachHang;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface IKhachHangRepository {
    List<KhachHang> findALL();
    KhachHang save(KhachHang x);
    KhachHang update(KhachHang x);
    String delete(String id);
}
