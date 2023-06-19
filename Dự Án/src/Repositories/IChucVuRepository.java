/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IChucVuRepository {
    List<ChucVu> findALL();
    ChucVu save(ChucVu chucVu);
    ChucVu update(ChucVu chucVu);
    String delete(String id);
}
