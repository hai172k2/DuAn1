/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.GioHang;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IGioHangRepository {
    List<GioHang> findALL();
    GioHang save(GioHang x);
    GioHang update(GioHang x);
    String delete(String id);
    GioHang findBYid(String id);
}
