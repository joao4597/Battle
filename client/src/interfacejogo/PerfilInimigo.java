package interfacejogo;

import javax.swing.JPanel;

public class PerfilInimigo extends javax.swing.JPanel {
    
    public PerfilInimigo(JPanel parent, String nome, String ranking, String pontos, String vitorias) {
        initComponents();
        setOpaque(false);
        
        labelNome.setText(nome);
        labelLugar.setText(ranking);
        labelPoints.setText(pontos);
        labelVit.setText(vitorias);
        
        parent.add(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPerfil = new javax.swing.JLabel();
        labelRanking = new javax.swing.JLabel();
        labelVitorias = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelVit = new javax.swing.JLabel();
        labelLugar = new javax.swing.JLabel();
        labelPontos = new javax.swing.JLabel();
        labelPoints = new javax.swing.JLabel();
        saveGame = new javax.swing.JButton();
        replayGame = new javax.swing.JButton();
        muteOponent = new javax.swing.JButton();
        imagemPessoa = new javax.swing.JButton();
        barcosOponente = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 234, 51), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPerfil.setText("Perfil");
        add(labelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        labelRanking.setText("Ranking");
        add(labelRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        labelVitorias.setText("Vitórias");
        add(labelVitorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        labelNome.setText("Gonçalo Dias");
        add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        labelVit.setText("24");
        add(labelVit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        labelLugar.setText("50º");
        add(labelLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        labelPontos.setText("Pontos");
        add(labelPontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        labelPoints.setText("12");
        add(labelPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        saveGame.setText("Save");
        saveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameActionPerformed(evt);
            }
        });
        add(saveGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 70, 54));

        replayGame.setText("Replay");
        add(replayGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 70, 54));

        muteOponent.setText("Mute");
        muteOponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteOponentActionPerformed(evt);
            }
        });
        add(muteOponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 70, 54));

        imagemPessoa.setEnabled(false);
        add(imagemPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 114, 78));

        barcosOponente.setOpaque(false);
        barcosOponente.setLayout(new java.awt.GridLayout(1, 1));
        add(barcosOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 480, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void saveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveGameActionPerformed

    private void muteOponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteOponentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_muteOponentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barcosOponente;
    private javax.swing.JButton imagemPessoa;
    private javax.swing.JLabel labelLugar;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelPoints;
    private javax.swing.JLabel labelPontos;
    private javax.swing.JLabel labelRanking;
    private javax.swing.JLabel labelVit;
    private javax.swing.JLabel labelVitorias;
    private javax.swing.JButton muteOponent;
    private javax.swing.JButton replayGame;
    private javax.swing.JButton saveGame;
    // End of variables declaration//GEN-END:variables
}
