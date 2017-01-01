package interfacejogo;

import java.awt.Rectangle;
import model.User;

public class PreparacaoEmbarcacao extends javax.swing.JFrame {
    private final Game table;
    private final User user;
    
    public PreparacaoEmbarcacao(User user,boolean quickGame) {
        initComponents();
        this.user = user;
        this.setBounds(new Rectangle(900,450));
        table = new Game("PROPRIO",quickGame,user,true,null);
        table.setParent(preparacao);
        preparacao.add(table.getShips());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preparacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        preparacao.setBackground(new java.awt.Color(87, 96, 85));
        preparacao.setLayout(new java.awt.GridLayout(1, 2));
        getContentPane().add(preparacao);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel preparacao;
    // End of variables declaration//GEN-END:variables
}
