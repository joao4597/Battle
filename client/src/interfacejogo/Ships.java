package interfacejogo;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import model.SHIP_TYPE;
import model.Ship;

public class Ships extends javax.swing.JPanel {
    private Map<SHIP_TYPE,ShipIO> ships;
    private IJ jogo;
    private Game table;
    
    public Ships(Game table) {
        initComponents();
        this.jButton1.setText("Começar jogar");
        this.table = table;
        
        this.ships = new HashMap<SHIP_TYPE,ShipIO>();

        
        ShipIO ship1 = new ShipIO(new Ship("Destruidor", 2,new Point[2]),table);
        this.ships.put(SHIP_TYPE.DESTROY, ship1);
        this.add(ship1); 
        
        
        ShipIO ship2 = new ShipIO(new Ship("Cruzador 2", 3,new Point[3]),table);
        this.ships.put(SHIP_TYPE.BOAT2, ship2);
        this.add(ship2); 
        
        ShipIO ship3 = new ShipIO(new Ship("Cruzador", 3,new Point[3]),table);
        this.ships.put(SHIP_TYPE.BOAT3, ship3);
        this.add(ship3);
        
        ShipIO ship4 = new ShipIO(new Ship("Navio Guerra", 4, new Point[4]), table);
        this.ships.put(SHIP_TYPE.WAR_SHIP,ship4);
        this.add(ship4);
        
        ShipIO ship5 = new ShipIO(new Ship("Porta aviões", 5,new Point[5]),table);
        this.ships.put(SHIP_TYPE.AIRCRAFT_CARRIER,ship5);
        this.add(ship5);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 222, 45), 3));
        setMaximumSize(new java.awt.Dimension(132, 202));
        setOpaque(false);
        setLayout(new java.awt.GridLayout(3, 2));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton1.setText("A aguardar...");
        this.table.executeClick(new Point(0,0));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean allPosition() {
        boolean result = true;
        for(ShipIO shipIO : this.ships.values()) {
            if(!shipIO.getShip().isPosition()) {
                result = false;
            }
        }
        return result;
    }
    
    public ShipIO getActiveShip() {
        ShipIO result = null;
        
        for(ShipIO shipIO : this.ships.values()) {
            if(shipIO.getShip().isHover()) {
                result = shipIO;
            }
        }
        return result;
    }
    
   
    
    public void unSelectAll() {
        for(ShipIO shipIO : ships.values()) {
            shipIO.unSelectShip();
        }
    }
    
    public Map<SHIP_TYPE,ShipIO> getShips() {
        return this.ships;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
