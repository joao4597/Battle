package interfacejogo;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.SHIP_TYPE;
import model.User;

public class Game extends javax.swing.JPanel implements Observer  {

    public static final String LETRASNORMAL[] = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public static final String LETRASCONTRARIO[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", ""};
    public static final String NUMEROS[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private boolean finish = false;

    private final JLabel labLetras[] = new JLabel[11];
    private final JLabel labNumeros[] = new JLabel[10];
    
    private JLabel labelMyTurn = null;
    
    private int totalDead = 0;

    private User user;

    public IJ iJogo;
    public String modoTabuleiro;
    public Position local[][] = new Position[10][10];
    private Ships ships;
    private boolean first = true;
    public ProtoX teste = new ProtoX();
    public int number = 0;
    private boolean myTurn = false;
    private boolean quick = false;

    public Game(String modo, boolean quick, User user, boolean first,IJ ij) {
        initComponents();
        this.user = user;
        this.first = first;
        this.myTurn = first;
        this.quick = quick;
        this.ships = new Ships(this);
        this.iJogo = ij;
        this.modoTabuleiro = modo;

        switch (modo) {
            case "INIMIGO":
                for (int i = 0; i < 11; i++) {
                    labLetras[i] = new JLabel(LETRASNORMAL[i], JLabel.CENTER);
                    this.add(labLetras[i]);
                }

                for (int i = 0; i < 10; i++) {
                    labNumeros[i] = new JLabel(NUMEROS[i], JLabel.CENTER);
                    this.add(labNumeros[i]);
                    for (int j = 0; j < 10; j++) {
                        local[i][j] = new Position(modo, new Point(j, i), LETRASNORMAL[j + 1] + NUMEROS[i], this);
                        local[i][j].addObserver(this);
                    }
                }
                break;
            case "PROPRIO":
                for (int i = 0; i < 11; i++) {
                    labLetras[i] = new JLabel(LETRASCONTRARIO[i], JLabel.CENTER);
                    this.add(labLetras[i]);
                }

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        local[j][i] = new Position(modo, new Point(j, i), LETRASCONTRARIO[j] + NUMEROS[i], this);
                        local[j][i].addObserver(this);
                    }
                    labNumeros[i] = new JLabel(NUMEROS[i], JLabel.CENTER);
                    this.add(labNumeros[i]);
                }
                
                if (quick) {
                    createQuickGame();
                }
                
                break;
        }

    }

    public void setParent(JPanel parent) {
        if (this.getParent() != null) {
            this.getParent().removeAll();
        }
        parent.add(this);
        parent.revalidate();
        parent.repaint();
    }

    public Ships getShips() {
        return this.ships;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 222, 45), 3));
        setMaximumSize(new java.awt.Dimension(300, 300));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 300));
        setLayout(new java.awt.GridLayout(11, 11));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void update(Observable o, Object arg) {
        Point position = (Point) arg;
        executeClick(position);
    }

    private String[] mensagemCoordenadas(String[] posicoes, Point[] coordenadas, int inicio) {
        for (Point ponto : coordenadas) {
            posicoes[inicio++] = LETRASCONTRARIO[ponto.x] + NUMEROS[ponto.y];//local[ponto.y][ponto.x];
        }
        return posicoes;
    }

    public void executeClick(Point position) {
        //FIRE
        if (modoTabuleiro.equals("PROPRIO")) {
            if (this.ships.allPosition()) {

                finish = true;
                String[] pos = new String[17];
                mensagemCoordenadas(pos, ships.getShips().get(SHIP_TYPE.AIRCRAFT_CARRIER).getShip().getPoints(), 0);
                mensagemCoordenadas(pos, ships.getShips().get(SHIP_TYPE.WAR_SHIP).getShip().getPoints(), 5);
                mensagemCoordenadas(pos, ships.getShips().get(SHIP_TYPE.BOAT3).getShip().getPoints(), 9);
                mensagemCoordenadas(pos, ships.getShips().get(SHIP_TYPE.BOAT2).getShip().getPoints(), 12);
                mensagemCoordenadas(pos, ships.getShips().get(SHIP_TYPE.DESTROY).getShip().getPoints(), 15);
                String result = teste.newGame(pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7],
                        pos[8], pos[9], pos[10], pos[11], pos[12], pos[13], pos[14], pos[15], pos[16]);
                first = true;
                if (result.equals("##Accepted2##")) {
                    this.first = false;
                }
                
                
                IJ jogo = new IJ(this, this.quick, this.first, this.user, this.user);
                jogo.setVisible(true);


            } else if (!this.ships.allPosition()) {
                putShipInPosition(ships.getActiveShip(), position);
            }
        } else if (modoTabuleiro.equals("INIMIGO")) {
            if(myTurn && !this.finish) {
                mandarTiro(position);
            }
        }
    }

    public void mandarTiro(Point position) {
        //Need thread, without thread GUI not paint correctly
        Thread t = new Thread(new TFire(this, position,this.iJogo));
        t.start();
    }
    
    public Point calculatePositionBasedOnString(String position) {
        Point result = new Point(-1,-1);
        int i = 0;
        int j = 0;
        for(i = 0 ; i < LETRASCONTRARIO.length;i++) {
            if(LETRASCONTRARIO[i].equals(position.substring(0, 1))) {
                result.x = i;
            }
        }

        for(j = 0 ; j < NUMEROS.length;j++) {
            if(NUMEROS[j].equals(position.substring(1, position.length()))) {
                result.y = j;
            }
        }
        return result;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IJ getiJogo() {
        return iJogo;
    }

    public void setiJogo(IJ iJogo) {
        this.iJogo = iJogo;
    }

    public String getModoTabuleiro() {
        return modoTabuleiro;
    }

    public void setModoTabuleiro(String modoTabuleiro) {
        this.modoTabuleiro = modoTabuleiro;
    }

    public Position[][] getLocal() {
        return local;
    }

    public void setLocal(Position[][] local) {
        this.local = local;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public ProtoX getTeste() {
        return teste;
    }

    public void setTeste(ProtoX teste) {
        this.teste = teste;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        
        this.myTurn = myTurn;
        if(this.labelMyTurn != null) {
            String myTurnText = (myTurn) ? "Jogar" : "Aguardar";
            this.labelMyTurn.setText(myTurnText);
        }
    }

    public boolean isQuick() {
        return quick;
    }

    public void setQuick(boolean quick) {
        this.quick = quick;
    }
    
    public void setLabelMyTurn(JLabel jlabel) {
        this.labelMyTurn = jlabel;
    }

    public int getTotalDead() {
        return totalDead;
    }

    public void setTotalDead(int totalDead) {
        this.totalDead = totalDead;
    }
    
    

    private void putShipInPosition(ShipIO shipIO, Point position) {
        if (shipIO != null) {
            if (isAvailableSpace(shipIO, position)) {
                int ship_size = shipIO.getShip().getPoints().length;
                int increment_points = 0;
                if (!shipIO.getShip().isVertical()) {
                    for (int i = position.x; i < position.x + ship_size; i++) {
                        local[i][position.y].addShipIntPosition(Color.GREEN);
                        shipIO.getShip().getPoints()[increment_points++] = new Point(i, position.y);
                    }
                } else {
                    for (int j = position.y; j < position.y + ship_size; j++) {
                        local[position.x][j].addShipIntPosition(Color.GREEN);
                        shipIO.getShip().getPoints()[increment_points++] = new Point(position.x, j);

                    }
                }
                this.ships.unSelectAll();
                shipIO.disableShip();
            }
        }
    }

    private boolean isAvailableSpace(ShipIO shipIO, Point position) {
        boolean result = true;
        int ship_size = shipIO.getShip().getPoints().length;
        Position location = local[position.x][position.y];

        if (location.isEmpty()) {
            if (shipIO.getShip().isVertical() && position.y + ship_size <= NUMEROS.length) {

                for (int j = position.y; j < position.y + ship_size; j++) {
                    if (!local[position.x][j].isEmpty()) {
                        result = false;
                    }
                }
            } else if (!shipIO.getShip().isVertical() && position.x + ship_size <= NUMEROS.length) {
                for (int i = position.x; i < position.x + ship_size; i++) {
                    if (!local[i][position.y].isEmpty()) {
                        result = false;
                    }
                }
            } else {
                result = false;
            }
        }else {
            result = false;
        }
        return result;
    }

    
    private void createQuickGame() {
        Random generator = new Random();
        int i = generator.nextInt(9);
        int j = generator.nextInt(9);
        for (ShipIO shipIO : this.ships.getShips().values()) {
            Point position = new Point(i, j);
            boolean isVertical = (generator.nextInt(2) > 0);
            shipIO.getShip().setVertical(isVertical);

            while (!isAvailableSpace(shipIO, position)) {
                i = generator.nextInt(9);
                j = generator.nextInt(9);
                position = new Point(i, j);
            }

            putShipInPosition(shipIO, position);
            i = generator.nextInt(9);
            j = generator.nextInt(9);
        }
    }
}
