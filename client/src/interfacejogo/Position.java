package interfacejogo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Position extends Observable{
    
    public JButton jButtonPosition;
    private static Color padrao;
    private boolean retiro = false;
    private Point point;
    
     
    public Position(String pessoa, Point point, String position, Game parent) {
        jButtonPosition = new JButton();
        jButtonPosition.setOpaque(false);
        jButtonPosition.setContentAreaFilled(false);
        jButtonPosition.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        padrao = jButtonPosition.getBackground();
        this.point = point;
        
        jButtonPosition.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(point);
//            if(!jButtonPosition.getBackground().equals(padrao) && pai.number!=-1) {
//                if(retiro) retirarBarcoNaPosicao();
//                else retiro = true;
//            }
//            else {
//                boolean estado = false;
//                
//                switch(pai.number) {
//                case -1: mandarTiro(); break;
//                case 1: estado = atribuirPortaAvioes(pai.conjuntoBarcos.portaAvioes); break;
//                case 2: estado = atribuirNavioGuerra(pai.conjuntoBarcos.navioGuerra); break;
//                case 3: estado = atribuirBarco3(pai.conjuntoBarcos.barcos3[0]); break;
//                case 4: estado = atribuirBarco3(pai.conjuntoBarcos.barcos3[1]); break;
//                case 5: estado = atribuirBarco2(pai.conjuntoBarcos.destruidor); break; 
//            }
                
//                if(estado) pai.number = 0;
//            }
        });
        
        parent.add(jButtonPosition);
    }
    
    public void addShipIntPosition(Color cor) {
        jButtonPosition.setOpaque(true);
        jButtonPosition.setBackground(cor);
    }
    
    public boolean isEmpty() {
        return jButtonPosition.getBackground().equals(padrao); //se tiver padrao, retorna que nao inclui
    }
}
