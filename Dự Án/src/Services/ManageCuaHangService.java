/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.CuaHang;
import Repositories.CuaHangRepository;
import Repositories.ICuaHangRepository;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cuong
 */
public class ManageCuaHangService implements IManageCuaHangService{
    private List<CuaHang> _list;
    private ICuaHangRepository _iRepositoty = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (CuaHang x : list) {
          _list.add(new CuaHang(x.getId(), x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia()));
        }
        return _list;
    }

    @Override
    public CuaHang create(CuaHang cuaHang) {
        cuaHang.setId(null);
        var x = _iRepositoty.save(new CuaHang(cuaHang.getId(), cuaHang.getMa(), cuaHang.getTen(),cuaHang.getDiaChi(),cuaHang.getThanhPho(),cuaHang.getQuocGia()));
        return new CuaHang(x.getId(), x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia());
    }

    @Override
    public CuaHang update(CuaHang cuaHang) {
        var x = _iRepositoty.update(new CuaHang(cuaHang.getId(), cuaHang.getMa(), cuaHang.getTen(),cuaHang.getDiaChi(),cuaHang.getThanhPho(),cuaHang.getQuocGia()));
        return new CuaHang(x.getId(), x.getMa(), x.getTen(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id);
    }
    
    
}
