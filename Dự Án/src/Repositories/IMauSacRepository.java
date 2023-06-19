/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author cuong
 */
public interface IMauSacRepository {
    List<MauSac> findALL();
    MauSac save(MauSac nsx);
    MauSac update(MauSac nsx);
    String delete(String id);
}
