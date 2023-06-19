/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GioHang;
import Repositories.GioHangRepository;
import Repositories.IGioHangRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageGioHangService implements IManageGioHangService{
    private List<GioHang> _list;
    private IGioHangRepository _iRepositoty = new GioHangRepository();

    @Override
    public List<GioHang> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (GioHang x : list) {
          _list.add(new GioHang(x.getId(), x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayTao(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getTinhTrang()));
        }
        return _list;
    }

    @Override
    public GioHang create(GioHang x) {
        x.setId(null);
        x.setNgayTao(new Date());
        x.setNgayThanhToan(null);
        x.setTinhTrang(0);
        var y = _iRepositoty.save(new GioHang(x.getId(), x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayTao(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getTinhTrang()));
        return new GioHang(y.getId() , y.getIdKH(),y.getIdNV(),y.getMa(),y.getNgayTao(),y.getNgayTao(),y.getTenNguoiNhan(),y.getDiaChi(),y.getSdt(),y.getTinhTrang());
    }

    @Override
    public GioHang update(GioHang x) {
        var y = _iRepositoty.update(new GioHang(x.getId(), x.getIdKH(),x.getIdNV(),x.getMa(),x.getNgayTao(),x.getNgayTao(),x.getTenNguoiNhan(),x.getDiaChi(),x.getSdt(),x.getTinhTrang()));
        return new GioHang(y.getId() , y.getIdKH(),y.getIdNV(),y.getMa(),y.getNgayTao(),y.getNgayTao(),y.getTenNguoiNhan(),y.getDiaChi(),y.getSdt(),y.getTinhTrang());
    }

    @Override
    public String delete(String id) {
         return _iRepositoty.delete(id); 
    }

    @Override
    public GioHang findBYid(String id) {
        return _iRepositoty.findBYid(id); 
    }
    
    
}
