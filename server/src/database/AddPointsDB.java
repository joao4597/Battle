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
 * class usada para adicionar pontos a um jogador
 * @author joao
 */
public class AddPointsDB {
    
    private Connection con = null;
    
    public AddPointsDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    
    /**
     * adiciona pontos ao jugador passado nos argumentos
     * @param username username
     * @param points pontos a adicionar
     */
    public void addPoints(String username, int points){
        int oldpoints=0;
        
        try (PreparedStatement st = con.prepareStatement("SELECT points FROM users WHERE username = ?")) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next() != false)
                oldpoints = rs.getInt("points");
            rs.close();
        }catch(SQLException e){
            System.out.println("Ao ler pontos da base de dados");
        }
        
        try (PreparedStatement st = con.prepareStatement("UPDATE users SET points = ? WHERE username = ?")) {
            st.setInt(1, oldpoints + points);
            st.setString(2, username);
            st.execute();
        }catch(SQLException e){
            System.out.println("Exceção ao atualizar pontos");
            e.printStackTrace(System.err);
        } 
        
    }
    
}
