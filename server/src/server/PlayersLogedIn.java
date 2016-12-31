/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class PlayersLogedIn {
    private List<String> playersLogedIn = null;

    public PlayersLogedIn() {
        this.playersLogedIn = new ArrayList<>();
    }

    public boolean addPlayer(String username){
        if(playersLogedIn.contains(username))
            return false;
        else
            playersLogedIn.add(username);
        return true;
    }
    
    public void removePlayer(String username){
        playersLogedIn.remove(username);
    }
}
