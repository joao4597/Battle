/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class PlayerInfo {
    public static int wins=0, losses=0, points=0;
    
    public void addPoints(int points){
        PlayerInfo.points = PlayerInfo.points + points;
    }
    
    public void addWins(int wins){
        PlayerInfo.wins = PlayerInfo.wins + wins;
    }
    
    public void addLosses(int losses){
        PlayerInfo.losses = PlayerInfo.losses + losses;
    }
}
