/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GioHangChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManageGioHangChiTietService {
    List<GioHangChiTiet> getAll();
    GioHangChiTiet create(GioHangChiTiet x);
    GioHangChiTiet update(GioHangChiTiet x);
    String delete(String idgh,String idCTSP);
    List<GioHangChiTiet> findByIDkhach(String id);
}
