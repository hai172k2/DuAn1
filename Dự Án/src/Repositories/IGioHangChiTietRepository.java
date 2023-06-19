/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.GioHangChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGioHangChiTietRepository {
    List<GioHangChiTiet> findALL();
    GioHangChiTiet save(GioHangChiTiet x);
    GioHangChiTiet update(GioHangChiTiet x);
    String delete(String idgh,String idCTSP);
    List<GioHangChiTiet> findByIDkhach(String id);
}
