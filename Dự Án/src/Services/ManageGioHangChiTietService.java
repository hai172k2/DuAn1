/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GioHangChiTiet;
import Repositories.GioHangChiTietRepository;
import Repositories.IGioHangChiTietRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageGioHangChiTietService implements IManageGioHangChiTietService{
    private List<GioHangChiTiet> _list;
    private IGioHangChiTietRepository _iRepositoty = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTiet> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (GioHangChiTiet x : list) {
          _list.add(new GioHangChiTiet(x.getIdGioHang(), x.getIdChiTietSP(), x.getSoLuong(), x.getDonGia(), x.getDonGiaKhiGiam()));
        }
        return _list;
    }

    @Override
    public GioHangChiTiet create(GioHangChiTiet x) {
        var y = _iRepositoty.save(new GioHangChiTiet(x.getIdGioHang(), x.getIdChiTietSP(), x.getSoLuong(), x.getDonGia(), x.getDonGiaKhiGiam()));
        return new GioHangChiTiet(y.getIdGioHang(), y.getIdChiTietSP(), y.getSoLuong(), y.getDonGia(), y.getDonGiaKhiGiam());
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet x) {
        var y = _iRepositoty.update(new GioHangChiTiet(x.getIdGioHang(), x.getIdChiTietSP(), x.getSoLuong(), x.getDonGia(), x.getDonGiaKhiGiam()));
        return new GioHangChiTiet(y.getIdGioHang(), y.getIdChiTietSP(), y.getSoLuong(), y.getDonGia(), y.getDonGiaKhiGiam());
    }

    @Override
    public String delete(String idgh,String idCTSP) {
        return _iRepositoty.delete(idCTSP,idgh); 
    }

    @Override
    public List<GioHangChiTiet> findByIDkhach(String id) {
        _list = new ArrayList<>();
        var list = _iRepositoty.findByIDkhach(id);
        for (GioHangChiTiet x : list) {
          _list.add(new GioHangChiTiet(x.getIdGioHang(), x.getIdChiTietSP(), x.getSoLuong(), x.getDonGia(), x.getDonGiaKhiGiam()));
        }
        return _list;
    }


    
}
