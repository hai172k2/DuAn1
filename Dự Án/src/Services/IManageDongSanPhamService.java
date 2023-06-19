/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageDongSanPhamService {
    List<DongSP> getAll();
    DongSP create(DongSP dongSP);
    DongSP update(DongSP dongSP);
    String delete(String id);
}
