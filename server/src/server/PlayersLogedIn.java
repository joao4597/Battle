/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.List;

/**
 *class que gere os jogadores que estao com login
 * @author joao
 */
public class PlayersLogedIn {
    private List<String> playersLogedIn = null;
    
    /**
     * cronstrutor de players logedin, cria uma lista de Strings para guardar todos os jogadores que fizeram login
     */
    public PlayersLogedIn() {
        this.playersLogedIn = new ArrayList<>();
    }
    
    /**
     * verifica se o usarme que estão a tentar acrescenter já existe
     * se nao existir, acrescenta
     * @param username usarname que pretende fazer login
     * @return false se usarname ja existe, true casa contrario 
     */
    public boolean addPlayer(String username){
        if(playersLogedIn.contains(username))
            return false;
        else
            playersLogedIn.add(username);
        return true;
    }
    
    
    /**
     * metodo usado quando um jogador faz logout, remove usarname passado nos parametros da lista de jogadores logados
     * @param username usarname a remover da lista
     */
    public void removePlayer(String username){
        playersLogedIn.remove(username);
    }
}
