/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageNhanVienService {
    List<NhanVien> getAll();
    NhanVien create(NhanVien x);
    NhanVien update(NhanVien x);
    String delete(String id);
}
