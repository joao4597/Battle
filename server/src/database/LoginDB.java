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
 * class usada para confiramar que conjunto (username, password) existem na base de dados
 */
public class LoginDB {
    public int wins, losses, points;
    Connection con = null;
    /**
     * cria um novo objeto da class ConnectDB para obter ligação á base de dados
     * @see ConnectDB
     */
    public LoginDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    /**
     * 
     * @param username
     * @param password
     * @return (boolean), true caso os dados estejam corretos, false caso contrário
     */
    public boolean confirmeLogin(String username, String password){
        try (PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next() == false)
                return false;
            points = rs.getInt("points");
            wins = rs.getInt("wins");
            losses = rs.getInt("losses");
            rs.close();
        }catch(SQLException e){
            System.out.println("Exceção ao confirmar login");
            return false;
        }
        System.out.print("confirmeLogin returnou true");
        return true;
    }
}