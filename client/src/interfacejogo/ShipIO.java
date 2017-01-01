package interfacejogo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import model.Ship;

public class ShipIO extends javax.swing.JPanel {
    private Game table;
    private Ship ship;
    public final int SIZE_SHIP = 40;
    
    public ShipIO(Ship ship,Game table) {
        initComponents();
        this.table = table;
        this.ship = ship;
        
        posicionarDirecao(this.ship.isRotation());
        setShipSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        verticalShip = new javax.swing.JPanel();
        horizontalShip = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(new javax.swing.border.MatteBorder(null));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        verticalShip.setBackground(new java.awt.Color(41, 206, 44));
        verticalShip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout verticalShipLayout = new javax.swing.GroupLayout(verticalShip);
        verticalShip.setLayout(verticalShipLayout);
        verticalShipLayout.setHorizontalGroup(
            verticalShipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        verticalShipLayout.setVerticalGroup(
            verticalShipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        horizontalShip.setBackground(new java.awt.Color(41, 206, 44));
        horizontalShip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout horizontalShipLayout = new javax.swing.GroupLayout(horizontalShip);
        horizontalShip.setLayout(horizontalShipLayout);
        horizontalShipLayout.setHorizontalGroup(
            horizontalShipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );
        horizontalShipLayout.setVerticalGroup(
            horizontalShipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(horizontalShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(verticalShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(horizontalShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(verticalShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if(isVisible()) {
            if(!ship.isHover()) {
                this.table.getShips().unSelectAll();
            
                selecionarBarco();
            }
            if(ship.isRotation()) {
                posicionarDirecao(!ship.isVertical());
            } ship.setRotation(!ship.isRotation());
        }
    }//GEN-LAST:event_formMouseClicked

    private void selecionarBarco() {
        verticalShip.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        horizontalShip.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        //this.table.number = ship.getNum(); 
        ship.setHover(true);
    }
    
    public void unSelectShip() {
        verticalShip.setBorder(BorderFactory.createBevelBorder(0));
        horizontalShip.setBorder(BorderFactory.createBevelBorder(0));
        //ship.setRotation(false); 
        ship.setHover(false);
    }
    
    public void disableShip() {
        horizontalShip.setVisible(false);
        verticalShip.setVisible(false);
        this.setEnabled(false);
        this.ship.setPosition(true);
    }
    
    private void posicionarDirecao(boolean v) {
        verticalShip.setVisible(v);
        horizontalShip.setVisible(!v);
        
        ship.setVertical(v);
    }

    private void setShipSize() {
        this.horizontalShip.setPreferredSize(new Dimension(this.ship.getNum() * SIZE_SHIP, SIZE_SHIP));
        this.verticalShip.setPreferredSize(new Dimension(SIZE_SHIP, this.ship.getNum() * SIZE_SHIP));
    }
    
    public Ship getShip() {
        return this.ship;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel horizontalShip;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel verticalShip;
    // End of variables declaration//GEN-END:variables
}
