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
 * Class Usada para incermentar as derrotas de um jogador
 * @author joao
 */
public class AddLosseDB {
    
    private Connection con = null;
    
    public AddLosseDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    /**
     * metodo usado para incrementar as derrotas de um jogador, usa AddLossesDB
     * @param username username do jgador que perdeu
     * @see AddLosseDB
     */
    public void addLossse(String username){
        int oldLosses=0;
        
        try (PreparedStatement st = con.prepareStatement("SELECT losses FROM users WHERE username = ?")) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next() != false)
                oldLosses = rs.getInt("losses");
            rs.close();
        }catch(SQLException e){
            System.out.println("Ao ler losses da base de dados");
        }
        
        try (PreparedStatement st = con.prepareStatement("UPDATE users SET losses = ? WHERE username = ?")) {
            st.setInt(1, oldLosses + 1);
            st.setString(2, username);
            st.execute();
        }catch(SQLException e){
            System.out.println("Exceção ao atualizar derrotas");
            e.printStackTrace(System.err);
        } 
        
    }
    
}
