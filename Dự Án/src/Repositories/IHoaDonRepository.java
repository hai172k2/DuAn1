/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IHoaDonRepository {
    List<HoaDon> findALL();
    HoaDon save(HoaDon x);
    HoaDon update(HoaDon x);
    String delete(String id);
}
