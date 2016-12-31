package interfacejogo;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfilProprio extends javax.swing.JPanel {

    public PerfilProprio(JPanel parent, String nome, String ranking, String pontos, String vitorias) {
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
        imagemPessoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmyTurn = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 229, 39), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPerfil.setText("Perfil");
        add(labelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        labelRanking.setText("Ranking");
        add(labelRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        labelVitorias.setText("Vitórias");
        add(labelVitorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        labelNome.setText("Gonçalo Dias");
        add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        labelVit.setText("24");
        add(labelVit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        labelLugar.setText("50º");
        add(labelLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        labelPontos.setText("Pontos");
        add(labelPontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        labelPoints.setText("12");
        add(labelPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        imagemPessoa.setEnabled(false);
        add(imagemPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 114, 78));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 370, -1));

        jTextField1.setToolTipText("Escreva uma mensagem");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 300, -1));

        jButton1.setText("Enviar");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 70, 20));

        jLabel1.setText("myTurn");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jmyTurn.setText("jLabel2");
        add(jmyTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getMyTurnLabel() {
        return this.jmyTurn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imagemPessoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jmyTurn;
    private javax.swing.JLabel labelLugar;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelPoints;
    private javax.swing.JLabel labelPontos;
    private javax.swing.JLabel labelRanking;
    private javax.swing.JLabel labelVit;
    private javax.swing.JLabel labelVitorias;
    // End of variables declaration//GEN-END:variables
}
