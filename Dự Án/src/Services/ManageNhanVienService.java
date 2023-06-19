/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.NhanVien;
import Repositories.INhanVienRepository;
import Repositories.NhanVienRepository;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cuong
 */
public class ManageNhanVienService implements IManageNhanVienService{
    private List<NhanVien> _list;
    private INhanVienRepository _iRepositoty = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (NhanVien x : list) {
          _list.add(new NhanVien(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getMatKhau(), x.getIdCH(), x.getIdCV(), x.getTrangThai()));
        }
        return _list;
    }

    @Override
    public NhanVien create(NhanVien x) {
        x.setId(null);
        var y = _iRepositoty.save(new NhanVien(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getMatKhau(), x.getIdCH(), x.getIdCV(), x.getTrangThai()));
        return new NhanVien(y.getId(), y.getMa(), y.getTen(), y.getTenDem(), y.getHo(), y.getGioiTinh(), y.getNgaySinh(), y.getDiaChi(), y.getSdt(), y.getMatKhau(), y.getIdCH(), x.getIdCV(), y.getTrangThai());
    }

    @Override
    public NhanVien update(NhanVien x) {
        var y = _iRepositoty.update(new NhanVien(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getMatKhau(), x.getIdCH(), x.getIdCV(), x.getTrangThai()));
        return new NhanVien(y.getId(), y.getMa(), y.getTen(), y.getTenDem(), y.getHo(), y.getGioiTinh(), y.getNgaySinh(), y.getDiaChi(), y.getSdt(), y.getMatKhau(), y.getIdCH(), x.getIdCV(), y.getTrangThai());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id);
    }
    
}
