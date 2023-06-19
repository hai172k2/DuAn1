/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;
import DomainModels.ChiTietSP;
import java.util.List;
/**
 *
 * @author cuong
 */
public interface IChiTietSPRepository {
    List<ChiTietSP> findALL();
    ChiTietSP save(ChiTietSP x);
    ChiTietSP update(ChiTietSP x);
    String delete(String id);
    ChiTietSP findbyid(String id);
}
