package Services;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cuong
 */
public interface IManageHoaDonChiTietService {
    List<HoaDonChiTiet> getAll(String idGH);
    HoaDonChiTiet create(HoaDonChiTiet x);
    HoaDonChiTiet update(HoaDonChiTiet x);
    String delete(String id);
}
