package interfacejogo;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JOptionPane;

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
    
    /**
     * Thread para verificar o resultado de um tiro realizado pelo próprio jogador
     * 
     * Envia-se uma mensagem ao servidor como se mandou um tiro e o servidor retorna a mensagem com a cor que se deve colocar nessa posição
     * Blue e a posição fica azul, logo a pessoa nao acertou em nenhum barco
     * Red e a posição fica vermelha, logo a pessoa acertou num barco
     */
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
                    this.game.setTotalDead(this.game.getTotalDead() + 1);
                    destination.jButtonPosition.setText("DEAD");
                }
        }

        destination.jButtonPosition.setEnabled(false);

        String gameState = game.getTeste().gameState();
        verifySate(gameState);
        
        paintReceiveShot(game.getTeste().getPosition());
        verifySate(game.getTeste().gameState());
        game.setMyTurn(true);
        
    }
    
    /**
     * Verificar se o jogo terminou ou nao
     * @param message mensagem que o servidor envia ao jogador depois de qualquer ação de tiro
     */
    public void verifySate(String message) {
        if (message.equals("##GameOver##")) {
            if (this.game.getTotalDead() == 5) {
                message = "Ganhou!!!!";
            }else {
                message = "Perdeu!!!!!";
            }
            JOptionPane.showMessageDialog(null, message, "Status: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void paintReceiveShot(String position) {
        if(allGame != null) allGame.updateMyTable(position);
    }
}
