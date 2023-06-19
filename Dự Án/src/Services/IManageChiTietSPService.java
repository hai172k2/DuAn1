package Services;
import DomainModels.ChiTietSP;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cuong
 */
public interface IManageChiTietSPService {
    List<ChiTietSP> getAll();
    ChiTietSP create(ChiTietSP x);
    ChiTietSP update(ChiTietSP x);
    String delete(String id);
    ChiTietSP findbyid(String id);
}
