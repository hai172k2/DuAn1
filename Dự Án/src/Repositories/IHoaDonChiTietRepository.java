/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IHoaDonChiTietRepository {
    List<HoaDonChiTiet> getAll(String idHD);
    HoaDonChiTiet create(HoaDonChiTiet x);
    HoaDonChiTiet update(HoaDonChiTiet x);
    String delete(String id);
}
