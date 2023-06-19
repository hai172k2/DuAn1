/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageChucVuService {
    List<ChucVu> getAllChucVu();
    ChucVu createChucVu(ChucVu chucVu);
    ChucVu updateChucVu(ChucVu chucVu);
    String delete(String id);
}
