/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IManageMauSacService {
    List<MauSac> getAllMauSac();
    MauSac createMauSac(MauSac mauSac);
    MauSac updateMauSac(MauSac mauSac);
    String delete(String id);
}
