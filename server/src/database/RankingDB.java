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
 */
public class RankingDB {
    
    public int wins, losses, points;
    Connection con = null;

    public RankingDB(){
        ConnectDB connectDB = new ConnectDB();
        con = connectDB.getConn();
    }
    
    
    public String getRanking(){
        int i;
        String complete, info;
        complete = "##Ranking##";
        info = "##";
        try (PreparedStatement st = con.prepareStatement("SELECT * FROM Users ORDER BY points")) {
            ResultSet rs = st.executeQuery();
            for(i=0; rs.next() != false; i++){
                info = info + rs.getArray("username").toString() + "##";
                info = info + Integer.toString(rs.getInt("points")) + "##";
                info = info + Integer.toString(rs.getInt("wins")) + "##";
                info = info + Integer.toString(rs.getInt("losses")) + "##";
            }                   
        }catch(SQLException e){
                System.out.println("Exceção ao confirmar login");
                e.printStackTrace(System.err);
                return null;
        }
        complete = complete + Integer.toString(i) + info;
        return complete;
    }
}
