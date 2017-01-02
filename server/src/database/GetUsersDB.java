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
import java.util.ArrayList;
import java.util.List;

/**
 * Class usada para ver todos os utilizadores incritos na base de dados
 * @author joao
 */
public class GetUsersDB {
    
    public int wins, losses, points;
    Connection con = null;

    /**
     * cria um novo objeto da class da class ConnectDB para obter acesso á base de dados
     */
    public GetUsersDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    
    /**
     * acede á base de dados para obter todos os jogadores
     * @return List(String) com todos os jogadores na base de dados
     */
    public List<String> getUsers(){
        int i;
        String aux;
        List<String> users = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement("SELECT username FROM Users")) {
            ResultSet rs = st.executeQuery();
            while(rs.next() != false){
                aux = rs.getArray("username").toString();
                users.add(aux);
            }                   
        }catch(SQLException e){
                System.out.println("Exceção ao ler users");
                e.printStackTrace(System.err);
                return null;
        }
        return users;
    }
    
}
