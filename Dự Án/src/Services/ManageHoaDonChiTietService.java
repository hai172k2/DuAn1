/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepository;
import Repositories.IHoaDonChiTietRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageHoaDonChiTietService implements IManageHoaDonChiTietService{
    private List<HoaDonChiTiet> _list;
    private IHoaDonChiTietRepository _iRepositoty = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll(String idGH) {
        _list = new ArrayList<>();
        var list = _iRepositoty.getAll(idGH);
        for (HoaDonChiTiet x : list) {
          _list.add(new HoaDonChiTiet(x.getIdHD(),x.getIdCTSP(),x.getSoLuong(),x.getDonGia()));
        }
        return _list;
    }

    @Override
    public HoaDonChiTiet create(HoaDonChiTiet x) {
        var y = _iRepositoty.create(new HoaDonChiTiet(x.getIdHD(),x.getIdCTSP(),x.getSoLuong(),x.getDonGia()));
        return new HoaDonChiTiet();
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet x) {
         var y = _iRepositoty.update(new HoaDonChiTiet(x.getIdHD(),x.getIdCTSP(),x.getSoLuong(),x.getDonGia()));
        return new HoaDonChiTiet(y.getIdHD(),y.getIdCTSP(),y.getSoLuong(),y.getDonGia());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id); 
    }
    
    
    
}
