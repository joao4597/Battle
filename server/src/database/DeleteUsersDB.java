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
 * Class Usada para eliminar jogadores
 * @author joao
 */
public class DeleteUsersDB {
    public int wins, losses, points;
    Connection con = null;

    /**
     * cria um novo objeto da class da class ConnectDB para obter acesso á base de dados
     */
    public DeleteUsersDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    
    /**
     * elimina da base de dados jogador com username passado nos parametros
     * @param username String com o username que pretende eliminar
     */
    public void deleteUser(String username){
        
        try (PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE username = ?")) {
            st.setString(1, username);
            st.execute();                 
        }catch(SQLException e){
                System.out.println("Exceção ao ler users");
                e.printStackTrace(System.err);
        }
    }
}
