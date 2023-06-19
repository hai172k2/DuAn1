/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface INSXRepository {
    List<NSX> findALL();
    NSX save(NSX nsx);
    NSX update(NSX nsx);
    String delete(String id);
}
