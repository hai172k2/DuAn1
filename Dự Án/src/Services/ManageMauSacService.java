/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import Repositories.IMauSacRepository;
import Repositories.MauSacRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageMauSacService implements IManageMauSacService{
    private List<MauSac> _listMauSac;
    private IMauSacRepository _iMauSacRepositoty = new MauSacRepository();
    
    @Override
    public List<MauSac> getAllMauSac() {
        _listMauSac = new ArrayList<>();
        var listMauSac = _iMauSacRepositoty.findALL();
        for (MauSac x : listMauSac) {
          _listMauSac.add(new MauSac(x.getId(), x.getMa(), x.getTen()));
        }
        return _listMauSac;
    }

    @Override
    public MauSac createMauSac(MauSac mauSac) {
        mauSac.setId(null);
        var x = _iMauSacRepositoty.save(new MauSac(mauSac.getId(), mauSac.getMa(), mauSac.getTen()));
        return new MauSac(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public MauSac updateMauSac(MauSac mauSac) {
        var x = _iMauSacRepositoty.update(new MauSac(mauSac.getId(), mauSac.getMa(), mauSac.getTen()));
        return new MauSac(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public String delete(String id) {
        return _iMauSacRepositoty.delete(id);
    }
    
}
