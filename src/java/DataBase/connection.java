/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Logic.client;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abelricardo
 */
public class connection {
    
    private Connection connect = null;
    private CallableStatement statement = null;

    public void con(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
           connect=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/WebServerCrud","root","abel1989"); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createClient(String nameclient,String ruc,String addressclient,String phoneclient){
        
        try {
            statement = connect.prepareCall("{call InsertClient(?,?,?,?)}");
            statement.setString("nameclient", nameclient);
            statement.setString("ruc", ruc);
            statement.setString("addressclient", addressclient);
            statement.setString("phoneclient", phoneclient);
            statement.executeQuery();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<client> getClientList(){
        
         try {
             ArrayList<client> cleinteList= new ArrayList<client>();
            statement = connect.prepareCall("{call getListOfClients()}");
            ResultSet rs = statement.executeQuery();           
            while (rs.next()) {
                client uClient = new client();
                uClient.setAddressCleint(rs.getString("addressClient")); 
                 uClient.setIdcliente(rs.getInt("idClient")); 
                 uClient.setNamecliente(rs.getString("nameclient")); 
                  uClient.setPhonecleinte(rs.getString("phoneClient")); 
                   uClient.setRuc(rs.getString("RUC")); 
                   cleinteList.add(uClient);
            }
             statement.close();
            return cleinteList   ; 
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void updateClient(int clienteID,String nameclient,String ruc,String addressclient,String phoneclient){
        
        try {
            statement = connect.prepareCall("{call updateClient(?,?,?,?,?)}");
            statement.setInt("idcliente",clienteID );
            statement.setString("nameclient", nameclient);
            statement.setString("ruc", ruc);
            statement.setString("addressclient", addressclient);
            statement.setString("phoneclient", phoneclient);
            statement.executeQuery();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public client getspecificlient(int clienteID){
        try {
            client uClient = new client();
            statement = connect.prepareCall("{call getSpecificClient(?)}");
            statement.setInt("cliente",clienteID );
            ResultSet rs = statement.executeQuery();
             while (rs.next()) {
                
                uClient.setAddressCleint(rs.getString("addressClient")); 
                 uClient.setIdcliente(rs.getInt("idClient")); 
                 uClient.setNamecliente(rs.getString("nameclient")); 
                  uClient.setPhonecleinte(rs.getString("phoneClient")); 
                   uClient.setRuc(rs.getString("RUC")); 
             }
             return uClient;
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public void deleteClient(int clienteID){
        try {
            client uClient = new client();
            statement = connect.prepareCall("{call deleteClient(?)}");
            statement.setInt("cliente",clienteID );
            statement.executeQuery();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
