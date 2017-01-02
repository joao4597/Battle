package interfacejogo;

import java.awt.Point;
import java.awt.Rectangle;
import model.User;

public class IJ extends javax.swing.JFrame {
    private Game tabuleiroInimigo, tabuleiroProprio;
    private PerfilInimigo inimigo;
    private PerfilProprio proprio;
    
    public IJ() { }
    
    /**
     * class que constoi todo o JFrame final, meu tabuleiro, tabuleiro do enimigo e informação de ambos
     * @param Proprio objeto do tipo Game com o tabuleiro anteriormente preenchido
     * @param quickGame true se for um quick gmae
     * @param comecaProprio true se for o primeiro a mandar tiro, false se o primeiro for o adeversario
     * @param user objeto com a informaçao do jogaodr (tipo User)
     * @param adversary objeto com a informacao do adversario (tipo UUser)
     */
    public IJ(Game Proprio, boolean quickGame,boolean comecaProprio,User user,User adversary) {
        initComponents();
        this.setBounds(new Rectangle(1200,1000));
        tabuleiroInimigo = new Game("INIMIGO",quickGame, user,comecaProprio,this); 
        tabuleiroInimigo.setParent(jogo);
        inimigo = new PerfilInimigo(jogo, user.getUsername(), "", user.getWins() + "", user.getLosses() + "");
        proprio = new PerfilProprio(jogo, adversary.getUsername(), "", adversary.getWins() + "", adversary.getLosses() + "");
        tabuleiroProprio = Proprio; 
        tabuleiroInimigo.setLabelMyTurn(proprio.getMyTurnLabel());
        tabuleiroProprio.setLabelMyTurn(proprio.getMyTurnLabel());
        tabuleiroProprio.setMyTurn(!comecaProprio);
        tabuleiroInimigo.setMyTurn(comecaProprio);

                
        tabuleiroProprio.setParent(jogo);
        
        if(!comecaProprio) adversarioJoga();
        //else tabuleiroInimigo.number = -1;
    }
    
    /**
     * Recebe tiro de adversario
     */
    public void adversarioJoga() {
        System.out.println("Mandar tiro " + tabuleiroProprio.isFirst());
        if (!this.tabuleiroProprio.isFirst()) {
            updateMyTable(tabuleiroProprio.getTeste().receiveShot(),tabuleiroProprio.getTeste().getPosition());
            tabuleiroProprio.getTeste().gameState();
            tabuleiroProprio.setMyTurn(true);
            tabuleiroInimigo.setMyTurn(true);
        }
//        tabuleiroInimigo.number = -2;
//        String resultado = tabuleiroProprio.teste.receiveShot();
//        
//        for(int i = 0; i < 10; i++) {
//            for(int j = 0; j < 10; j++) {
//                JButton sitio = tabuleiroProprio.local[i][j].jButtonPosition;
//                if(tabuleiroProprio.local[i][j].posicao.equals(tabuleiroProprio.teste.position)) {
//                    if(resultado.equals("blue")) sitio.setBackground(Color.blue);
//                    else sitio.setBackground(Color.RED);
//                    
//                    break;
//                }
            //}
        //}
        
        //tabuleiroInimigo.number = -1;
    }

    /**
     * atualiza o tabuleiro com os barcos do jogador e coloca um X na posição em que foi atingido
     * @param color cor
     * @param stPosition posiçao em que foi atingido 
     */
    public void updateMyTable(String color, String stPosition) {
        Point position = tabuleiroProprio.calculatePositionBasedOnString(stPosition);
        if(position.x != -1 && position.y != -1){
            tabuleiroProprio.getLocal()[position.x][position.y].jButtonPosition.setText("X");
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jogo = new javax.swing.JPanel();
        publicidade = new javax.swing.JPanel();
        Publicidade1 = new javax.swing.JButton();
        Publicidade2 = new javax.swing.JButton();
        Publicidade3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setSize(new java.awt.Dimension(1000, 1000));
        setState(1);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jogo.setBackground(new java.awt.Color(87, 96, 85));
        jogo.setLayout(new java.awt.GridLayout(2, 2));
        getContentPane().add(jogo);

        publicidade.setLayout(new java.awt.GridLayout(3, 1));

        Publicidade1.setText("Publicidade");
        publicidade.add(Publicidade1);

        Publicidade2.setText("Publicidade");
        publicidade.add(Publicidade2);

        Publicidade3.setText("Publicidade");
        publicidade.add(Publicidade3);

        getContentPane().add(publicidade);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Publicidade1;
    private javax.swing.JButton Publicidade2;
    private javax.swing.JButton Publicidade3;
    private javax.swing.JPanel jogo;
    private javax.swing.JPanel publicidade;
    // End of variables declaration//GEN-END:variables

}