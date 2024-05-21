/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;

import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface datagymimplement {
    public void insert(datagym g);
    public void update(datagym g);
    public void delete(String judul);
    public List<datagym> getAll();
}
