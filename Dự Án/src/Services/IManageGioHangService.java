/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GioHang;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageGioHangService {
    List<GioHang> getAll();
    GioHang create(GioHang x);
    GioHang update(GioHang x);
    String delete(String id);
    GioHang findBYid(String id);
}
