/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;

/**
 *
 * @author joao
 */
public class WatingList {
    static boolean wating = false;
    static NewGame game = null; 
    
    WatingList(List<String> positionsList, SocketServer sock){
        if(wating == false){
            game = new NewGame(positionsList, sock);
            wating = true;
        }else{
            game.secondPlayer(positionsList, sock);
            wating = false;
        }
    }
    
    public int returnOrder(){
        if(wating == true){
            System.out.println("Return Order-> returnou 1");
            return 1;
        }else{
            System.out.println("Return Order-> returnou 2");
            game.start();
            return 2;
        }
    }
    
    public NewGame returnThread(){
        return game;
    } 
}
