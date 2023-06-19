/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Repositories.KhachHangRepository;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cuong
 */
public class ManageKhachHangService implements IManageKhachHangService{
    private List<KhachHang> _list;
    private IKhachHangRepository _iRepositoty = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
         _list = new ArrayList<>();
        var list = _iRepositoty.findALL();
        for (KhachHang x : list) {
          _list.add(new KhachHang(x.getId(), x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getSdt(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia(),x.getMatKhau()));
        }
        return _list;
    }

    @Override
    public KhachHang create(KhachHang x) {
        x.setId(null);
        var y = _iRepositoty.save(new KhachHang(x.getId(), x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getSdt(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia(),x.getMatKhau()));
        return new KhachHang(y.getId(), y.getMa(),y.getTen(),y.getTenDem(),y.getHo(),y.getNgaySinh(),y.getSdt(),y.getDiaChi(),y.getThanhPho(),y.getQuocGia(),y.getMatKhau());
    }

    @Override
    public KhachHang update(KhachHang x) {
         var y = _iRepositoty.update(new KhachHang(x.getId(), x.getMa(),x.getTen(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getSdt(),x.getDiaChi(),x.getThanhPho(),x.getQuocGia(),x.getMatKhau()));
        return new KhachHang(y.getId(), y.getMa(),y.getTen(),y.getTenDem(),y.getHo(),y.getNgaySinh(),y.getSdt(),y.getDiaChi(),y.getThanhPho(),y.getQuocGia(),y.getMatKhau());
    }

    @Override
    public String delete(String id) {
        return _iRepositoty.delete(id);
    }
}
