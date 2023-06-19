/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


import DomainModels.DongSP;
import Repositories.DongSanPhamRpository;
import Repositories.IDongSanPhamRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageDongSanPhamService implements IManageDongSanPhamService{
    private List<DongSP> _listDongSanPham;
    private IDongSanPhamRepository _iDongSanPhamRepositoty = new DongSanPhamRpository();

    @Override
    public List<DongSP> getAll() {
        _listDongSanPham = new ArrayList<>();
        var listDongSanPham = _iDongSanPhamRepositoty.findALL();
        for (DongSP x : listDongSanPham) {
          _listDongSanPham.add(new DongSP(x.getId(), x.getMa(), x.getTen()));
        }
        return _listDongSanPham;
    }

    @Override
    public DongSP create(DongSP dongSP) {
        dongSP.setId(null);
        var x = _iDongSanPhamRepositoty.save(new DongSP(dongSP.getId(), dongSP.getMa(), dongSP.getTen()));
        return new DongSP(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public DongSP update(DongSP dongSP) {
        var x = _iDongSanPhamRepositoty.update(new DongSP(dongSP.getId(), dongSP.getMa(), dongSP.getTen()));
        return new DongSP(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public String delete(String id) {
        return _iDongSanPhamRepositoty.delete(id);
    }
    
}
