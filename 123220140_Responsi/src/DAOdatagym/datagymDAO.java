/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatagym;
import java.sql.*;
import java.util*;
import koneksi.connector;
import model.*;
import DAOImplement.datagymimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lab Informatika
 */
public class datagymDAO implements datagymimplement{
    Connection connection;
    
    final String select = "select * from data;";
    final String insert = "INSERT INTO data (NamaPemilik, NamaAlat, NomerTelepon, WaktuSewa, BiayaSewa)VALUES(?,?,?,?,?);";
    final String update = "update data set NamaAlat=?, NomerTelepon=?, WaktuSewa=?, BiayaSewa=? where NamaPemilik=?";
    final String delete = "delete from data where Nama Alat=?";
    private datagym data;
    
    public datagymDAO(){
    connection = connector.connection();
    }
    
    @Override
    public void insert(datagym g){
    PreparedStatement = null;
    try{
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, g.getNamaPemilik());
        statement.setString(2, g.getNamaAlat());
        statement.setString(3, g.getNomerTelepon());
        statement.setDouble(4, g.getWaktuSewa());
        statement.setDouble(5, g.hitungNilai());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while(rs.next()){
        g.setNama Pemilik(rs.getString(1));
        }
    } catch(SQLException ex){
        ex.printStackTrace();
    }finally{
        try{
        statement.close();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    }
    
    @Override
    public void update(datagym g){
    PreparedStatement = null;
    try{
        statement = connection.prepareStatement(update);
        statement.setString(1, g.getNamaPemilik());
        statement.setString(2, g.getNamaAlat());
        statement.setString(3, g.getNomerTelepon());
        statement.setDouble(4, g.getWaktuSewa());
        statement.setDouble(5, g.hitungNilai());
        statement.executeUpdate();
    } catch(SQLException ex){
        ex.printStackTrace();
    }finally{
        try{
        statement.close();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    }
    
    @Override
    public void delete(String NamaPemilik){
    PreparedStatement = null;
    try{
        statement = connection.prepareStatement(delete);
        statement.setString(1,NamaPemilik);
        statement.executeUpdate();
    } catch(SQLException ex){
        ex.printStackTrace();
    }finally{
        try{
        statement.close();
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    }
    
    @Override
    public List<datagym> getAll(){
    List<datagym> dtg = null;
    try{
        dtg = new ArrayList<datagym>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
        datagym gym = new datagym();
        gym.setNamaPemilik(rs.getString("Nama Pemilik"));
                gym.setNamaAlat(rs.getString("Nama Alat"));
                        gym.setNomerTelepon(rs.getString("Nomer Telepon"));
                                gym.setWaktuSewa(rs.getDouble("Waktu Sewa"));
                                        gym.setBiayaSewa(rs.getDouble("Biaya Sewa"));
                                        dtg.add(gym);
                                        
        }catch(SQLException ex){
                Logger.getLogger(datagymDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        return dtg;
    }
    
    
    }
}
