/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joao
 * class usada para efetuar o registo de um visitante na base de dados
 */
public class RegisterDB {
    Connection con = null;
    /**
     * Construtor de RegisterDB usa ConnectDB para obter conecção á base de dados
     * @see ConnectDB
     */
    public RegisterDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    /**
     * 
     * @param username username pretendido
     * @param password 
     * @return (boolean), true se nome de utilizador não estiver em uso, fase caso contrário
     */
    public boolean register(String username, String password){
        try (PreparedStatement st = con.prepareStatement("INSERT INTO Users (username, password, points, wins, losses) VALUES (?, ?, 0, 0, 0)")) {
            st.setString(1, username);
            st.setString(2, password);
            st.execute();
            return true;
        }catch(SQLException e){
            System.out.println("Exceção ao registar na base de dados");
            e.printStackTrace(System.err);
            return false;
        }      
        //return true;
    }
    
}
