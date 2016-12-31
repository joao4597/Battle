/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacejogo;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author plima
 */
public class TFire implements Runnable{
    private Game game = null;
    private Point position = null;
    private IJ allGame = null;
    
    public TFire(Game gameAdversary,Point point,IJ allGame) {
        this.game = gameAdversary;
        this.position = point;
        this.allGame = allGame;
    }
    
    @Override
    public void run() {

        String resultado = game.getTeste().sendShot(game.LETRASCONTRARIO[position.x] + game.NUMEROS[position.y]);
        
        game.setMyTurn(false);

        Position destination = game.getLocal()[position.y][position.x];
        destination.jButtonPosition.setOpaque(true);

        if (resultado.equals("blue")) {
            destination.jButtonPosition.setBackground(Color.blue);
        } else {
            destination.jButtonPosition.setBackground(Color.RED);
            if (!resultado.equals("red")) {
                destination.jButtonPosition.setText("FF");
            }
        }

        destination.jButtonPosition.setEnabled(false);

        if (!game.getTeste().gameState().equals("GAMEOVER")) {
            //iJogo.adversarioJoga();
        } else {
            System.out.println("GANHOU!!!!");
        }
        
        paintReceiveShot(game.getTeste().receiveShot(),game.getTeste().getPosition());
        game.getTeste().gameState();
        game.setMyTurn(true);
        
    }
    
    public void paintReceiveShot(String color,String position) {
        if(allGame != null) {
           allGame.updateMyTable(color, position);
        }
        
    }
}
