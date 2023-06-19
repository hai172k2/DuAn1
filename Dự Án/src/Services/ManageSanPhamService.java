/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Repositories.SanPhamRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageSanPhamService implements IManageSanPhamService{
    private List<SanPham> _listSanPham;
    private ISanPhamRepository _iSanPhamRepositoty = new SanPhamRepository();
    @Override
    public List<SanPham> getAll() {
        _listSanPham = new ArrayList<>();
        var listSanPham = _iSanPhamRepositoty.findALL();
        for (SanPham x : listSanPham) {
          _listSanPham.add(new SanPham(x.getId(), x.getMa(), x.getTen()));
        }
        return _listSanPham;
    }

    @Override
    public SanPham create(SanPham sanPham) {
        sanPham.setId(null);
        var x = _iSanPhamRepositoty.save(new SanPham(sanPham.getId(), sanPham.getMa(), sanPham.getTen()));
        return new SanPham(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public SanPham update(SanPham sanPham) {
        var x = _iSanPhamRepositoty.update(new SanPham(sanPham.getId(), sanPham.getMa(), sanPham.getTen()));
        return new SanPham(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public String delete(String id) {
         return _iSanPhamRepositoty.delete(id);
    }
    
}
