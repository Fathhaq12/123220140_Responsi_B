/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatagym.datagymDAO;
import DAOimplement.datagymimplement;
import model.*;
Import view.MainView;

/**
 *
 * @author Lab Informatika
 */
public class datagymcontroller {
    MainView frame;
    datagymimplement impldatagym;
    List<datagym> dtg;
    
    public datagymcontroller(MainView frame){
    this.frame = frame;
    impldatagym = new datagymDAO();
    dtg = impldatagym.getAll();
    }
    
    public void isitabel(){
    dtg = impldatagym.getAll();
    modeltabeldatagym mg = new modeltabeldatagym(dtg);
    frame.getTabelDatagym().setModel(mg);
    }
    
    public void insert(){
    datagym dtg = new datagym();
    dtg.setNamaPemilik(frame.getTNamaPemilik().getText());
    dtg.setNamaAlat(frame.getTNamaAlat().getText());
    dtg.setNomerTelepon(frame.getTNomerTelepon().getText());
    dtg.setWaktuSewa(frame.getTWaktuSewa().getText());
    dtg.setBiayaSewa(frame.getTBiayaSewa().getText());
    }
    
    public void update(){
    datagym dtg = new datagym();
    dtg.setNamaPemilik(frame.getTNamaPemilik().getText());
    dtg.setNamaAlat(frame.getTNamaAlat().getText());
    dtg.setNomerTelepon(frame.getTNomerTelepon().getText());
    dtg.setWaktuSewa(frame.getTWaktuSewa().getText());
    dtg.setBiayaSewa(frame.getTBiayaSewa().getText());
    }
    
    public void delete(String NamaPemilik){
        impldatagym.delete(NamaPemilik);
        isitabel();
    }
}
