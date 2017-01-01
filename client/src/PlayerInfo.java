/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * class que contem informação do jogador, vitorias, derrotas, pontos
 * @author joao
 */
public class PlayerInfo {
    public static int wins=0, losses=0, points=0;
    
    /**
     * metodo que incrementa os pontos do jogador
     * @param points pontos
     */
    public void addPoints(int points){
        PlayerInfo.points = PlayerInfo.points + points;
    }
    
    /**
     * metodo que incrementa as vitorias do jogador
     * @param wins vitorias
     */
    public void addWins(int wins){
        PlayerInfo.wins = PlayerInfo.wins + wins;
    }
    
    /**
     * metodo que incrementa as derrotas do jogador
     * @param losses derrotas
     */
    public void addLosses(int losses){
        PlayerInfo.losses = PlayerInfo.losses + losses;
    }
}
