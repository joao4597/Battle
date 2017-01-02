/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;

/**
 * Esta class permite juntar dois jogadores no mesmo NewGame, se for criada e nao existirem jogadores á espera cria um novo objeto da class NewGame, se já existir um jogador á espera então junta o segundo jogador ao objeto NewGame previamente criado;
 * quando recebe um segundo jogador inicia a thread de NewGame
 * @author joao
 */
public class WatingList {
    static boolean wating = false;
    static NewGame game = null; 
    
    WatingList(List<String> positionsList, SocketServer sock, String username){
        if(wating == false){
            game = new NewGame(positionsList, sock, username);
            wating = true;
        }else{
            game.secondPlayer(positionsList, sock, username);
            wating = false;
        }
    }
    
    /**
     * Serve para a CLientThreads saber se quando criou WatingList vai ser o jogador 1 ou o jogador 2
     * @return 1 se for o jogador 1 e portanto terá que aguardar por um segundo jogador; 2 se for o jogador 2.
     */
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
    
    /**
     * invocado pelo ClientThreads, server para a passar a thread onde está a decorrer o jogo, desta forma pode ver quando o jogo terminou
     * @return objeto da thread onde deccore o jogo.
     * @see ClientThreads
     */
    public NewGame returnThread(){
        return game;
    } 
}
