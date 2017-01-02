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
 * Class Usada para adicionar vitorias
 * @author joao
 */
public class AddWinDB {
    private Connection con = null;
    
    public AddWinDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    
    /**
     * addiciona uma vitoria ao jogador passado nos parametros
     * @param username String com o useranme pretendido
     */
    public void addWin(String username){
        int oldWins=0;
        
        try (PreparedStatement st = con.prepareStatement("SELECT wins FROM users WHERE username = ?")) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next() != false)
                oldWins = rs.getInt("wins");
            rs.close();
        }catch(SQLException e){
            System.out.println("Ao ler losses da base de dados");
        }
        
        try (PreparedStatement st = con.prepareStatement("UPDATE users SET wins = ? WHERE username = ?")) {
            st.setInt(1, oldWins + 1);
            st.setString(2, username);
            st.execute();
        }catch(SQLException e){
            System.out.println("Exceção ao atualizar derrotas");
            e.printStackTrace(System.err);
        } 
        
    }
}
