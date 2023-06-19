/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NSX;
import Repositories.INSXRepository;
import Repositories.NSXRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuong
 */
public class ManageNSXService implements IManageNSXService{

    private List<NSX> _listNSX;
    private INSXRepository _iNSXRepositoty = new NSXRepository();
    @Override
    public List<NSX> getAllNSX() {
        _listNSX = new ArrayList<>();
        var listNSX = _iNSXRepositoty.findALL();
        for (NSX x : listNSX) {
          _listNSX.add(new NSX(x.getId(), x.getMa(), x.getTen()));
        }
        return _listNSX;
    }

    @Override
    public NSX createNSX(NSX nsx) {
        nsx.setId(null);
        var x = _iNSXRepositoty.save(new NSX(nsx.getId(), nsx.getMa(), nsx.getTen()));
        return new NSX(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public NSX updateNSXbyID(NSX nsx) {
        var x = _iNSXRepositoty.update(new NSX(nsx.getId(), nsx.getMa(), nsx.getTen()));
        return new NSX(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public String delete(String id) {
       return _iNSXRepositoty.delete(id);
    }
    
}
