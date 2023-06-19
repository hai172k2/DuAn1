/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.ChiTietSP;
import Repositories.IChiTietSPRepository;
import Repositories.ChiTietSPRepository;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cuong
 */
public class ManageChiTietSPService implements IManageChiTietSPService{
    private List<ChiTietSP> _list;
    private IChiTietSPRepository _iRepositoty = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (ChiTietSP x : list) {
          _list.add(new ChiTietSP(x.getId(), x.getSanPham(),x.getNxs(),x.getMauSac(),x.getDongSP(),x.getNamBH(),x.getMoTa(),x.getSoLuongTon(),x.getGiaNhap(),x.getGiaBan()));
        }
        return _list;
    }

    @Override
    public ChiTietSP create(ChiTietSP x) {
        x.setId(null);
        var y = _iRepositoty.save(new ChiTietSP(x.getId(), x.getSanPham(),x.getNxs(),x.getMauSac(),x.getDongSP(),x.getNamBH(),x.getMoTa(),x.getSoLuongTon(),x.getGiaNhap(),x.getGiaBan()));
        return new ChiTietSP(y.getId() , y.getSanPham(),y.getNxs(),y.getMauSac(),y.getDongSP(),y.getNamBH(),y.getMoTa(),y.getSoLuongTon(),y.getGiaNhap(),y.getGiaBan());
    }

    @Override
    public ChiTietSP update(ChiTietSP x) {
        var y = _iRepositoty.update(new ChiTietSP(x.getId(), x.getSanPham(),x.getNxs(),x.getMauSac(),x.getDongSP(),x.getNamBH(),x.getMoTa(),x.getSoLuongTon(),x.getGiaNhap(),x.getGiaBan()));
        return new ChiTietSP(y.getId(), y.getSanPham(),y.getNxs(),y.getMauSac(),y.getDongSP(),y.getNamBH(),y.getMoTa(),y.getSoLuongTon(),y.getGiaNhap(),y.getGiaBan());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id); 
    }

    @Override
    public ChiTietSP findbyid(String id) {
        return  _iRepositoty.findbyid(id);
    }
}
