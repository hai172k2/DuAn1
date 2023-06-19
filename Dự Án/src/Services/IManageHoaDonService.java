/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageHoaDonService {
    List<HoaDon> getAll();
    HoaDon create(HoaDon x);
    HoaDon update(HoaDon x);
    String delete(String id);
}
