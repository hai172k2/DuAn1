/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageNSXService {
    List<NSX> getAllNSX();
    NSX createNSX(NSX nsx);
    NSX updateNSXbyID(NSX nsx);
    String delete(String id);
}
