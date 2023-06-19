/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import Repositories.ChucVuRepository;
import Repositories.IChucVuRepository;
import Repositories.INSXRepository;
import Repositories.NSXRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageChucVuService implements IManageChucVuService{
    
    private List<ChucVu> _listChucVu;
    private IChucVuRepository _iChucVuRepositoty = new ChucVuRepository();

    @Override
    public List<ChucVu> getAllChucVu() {
        _listChucVu = new ArrayList<>();
        var listNSX = _iChucVuRepositoty.findALL();
        for (ChucVu x : listNSX) {
          _listChucVu.add(new ChucVu(x.getId(), x.getMa(), x.getTen()));
        }
        return _listChucVu;
    }

    @Override
    public ChucVu createChucVu(ChucVu chucVu) {
        chucVu.setId(null);
        var x = _iChucVuRepositoty.save(new ChucVu(chucVu.getId(), chucVu.getMa(), chucVu.getTen()));
        return new ChucVu(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public ChucVu updateChucVu(ChucVu chucVu) {
        var x = _iChucVuRepositoty.update(new ChucVu(chucVu.getId(), chucVu.getMa(), chucVu.getTen()));
        return new ChucVu(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public String delete(String id) {
        return _iChucVuRepositoty.delete(id);
    }

   
    
}
