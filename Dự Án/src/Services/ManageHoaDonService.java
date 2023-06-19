/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Repositories.IHoaDonRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageHoaDonService implements IManageHoaDonService{
    private List<HoaDon> _list;
    private IHoaDonRepository _iRepositoty = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (HoaDon x : list) {
          _list.add(new HoaDon(x.getId(), x.getIdKH(), x.getIdNV(), x.getMa(), x.getNgayTao(), x.getNgayThanhToan(), x.getNgayShip(), x.getNgayNhan(), x.getTinhTrang(), x.getTenNguoiNhan(), x.getDiaChi(), x.getSdt()));
        }
        return _list;
    }

    @Override
    public HoaDon create(HoaDon x) {
        x.setId(null);
        var y = _iRepositoty.save(new HoaDon(x.getId(), x.getIdKH(), x.getIdNV(), x.getMa(), x.getNgayTao(), x.getNgayThanhToan(), x.getNgayShip(), x.getNgayNhan(), x.getTinhTrang(), x.getTenNguoiNhan(), x.getDiaChi(), x.getSdt()));
        return new HoaDon(y.getId(), y.getIdKH(), y.getIdNV(), y.getMa(), y.getNgayTao(), y.getNgayThanhToan(), y.getNgayShip(), y.getNgayNhan(), y.getTinhTrang(), y.getTenNguoiNhan(), y.getDiaChi(), y.getSdt());
    }

    @Override
    public HoaDon update(HoaDon x) {
        var y = _iRepositoty.update(new HoaDon(x.getId(), x.getIdKH(), x.getIdNV(), x.getMa(), x.getNgayTao(), x.getNgayThanhToan(), x.getNgayShip(), x.getNgayNhan(), x.getTinhTrang(), x.getTenNguoiNhan(), x.getDiaChi(), x.getSdt()));
        return new HoaDon(y.getId(), y.getIdKH(), y.getIdNV(), y.getMa(), y.getNgayTao(), y.getNgayThanhToan(), y.getNgayShip(), y.getNgayNhan(), y.getTinhTrang(), y.getTenNguoiNhan(), y.getDiaChi(), y.getSdt());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id); 
    }
    
}
