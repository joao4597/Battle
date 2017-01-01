/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *class usada para criar uma ligação á base de dados
 * @author joao
 * 
 */
public class ConnectDB {
    
    static Connection con = null;
    /**
     * estabelece comunicação com a base de dados e guarda objeto numa variavel da class
     */
    ConnectDB(){
        if(con == null){
        // Load the JDBC driver
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e) {
                System.out.println("Exception Base de Dados JDBC");
            }

            // Connect to the database
            String user = "lpro1615";
            String password = "K!2056okn";
            String url = "jdbc:postgresql://dbm.fe.up.pt/lpro1615";

            try{
                con = DriverManager.getConnection( url, user, password);
            }catch (SQLException e) {
                System.out.println("Exception Base de Dados");
            }
        }
    }
    /**
     * 
     * @return (Connection), objeto com ligação á base de dados
     */
    public Connection getConn(){
        return con;
    }
}