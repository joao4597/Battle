
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joao
 */
public class visi extends javax.swing.JFrame {

    /**
     * Creates new form visi
     */
    public visi() {
        initComponents();
    }
    
    void getImagesFromUrl(){
        List<URL> urls;
        ProtoX proto = new ProtoX();
        urls = proto.getImagesUrl();
        int i;
        
        List<String> pubListClient = new ArrayList<>();
        pubListClient.add("mainr.jpg");
        pubListClient.add("pqueno1.jpeg");
        pubListClient.add("pequeno2.jpeg");
        pubListClient.add("pqueno3.jpeg");
        pubListClient.add("pqueno4.PNG");
        pubListClient.add("pequeno5.jpg");
        pubListClient.add("quick1.png");
        pubListClient.add("quick2.jpg");
        pubListClient.add("quick3.jpg");
        File targetFile = new File("src/images");
        
        if(!targetFile.exists() && !targetFile.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + targetFile);
        }
        
        for(i=0; i<9; i++){

            try(InputStream is = urls.get(i).openStream();
            OutputStream os = new FileOutputStream("src/images/" + pubListClient.get(i));){

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
            }catch(IOException e){
                System.out.println("Erro ao receber as imagens dos urls");
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        LogUser = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LogPass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        RegUser = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        RegPass = new javax.swing.JPasswordField();
        RegRet = new javax.swing.JButton();
        RegPassConf = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(389, 428));

        jPanel1.setMaximumSize(new java.awt.Dimension(377, 32767));

        ImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images.jpeg"))); // NOI18N

        jPanel2.setLayout(new java.awt.CardLayout());

        LogUser.setText("Username");
        LogUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogUserMouseClicked(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 21, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("I Don't Have An Account");

        jButton10.setText("Creat Account");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 6, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        LogPass.setText("Password"); // NOI18N
        LogPass.setToolTipText("");
        LogPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39))
                    .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(50, 50, 50))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LogPass, LogUser});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(LogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(21, 21, 21))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LogPass, LogUser});

        jPanel2.add(jPanel4, "card2");

        RegUser.setText("Username");
        RegUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegUserMouseClicked(evt);
            }
        });

        jButton8.setText("Register");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 27, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        RegPass.setText("Password");
        RegPass.setToolTipText("Confirm Password");
        RegPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        RegPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegPassMouseClicked(evt);
            }
        });

        RegRet.setFont(new java.awt.Font("Linux Libertine Mono O", 0, 13)); // NOI18N
        RegRet.setForeground(new java.awt.Color(1, 1, 1));
        RegRet.setText("Return");
        RegRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegRetActionPerformed(evt);
            }
        });

        RegPassConf.setText("Password");
        RegPassConf.setToolTipText("");
        RegPassConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegPassConfMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RegRet))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RegPassConf)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RegPass)
                                    .addComponent(RegUser, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {RegPass, RegUser});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(RegUser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegPassConf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegRet)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {RegPass, RegPassConf, RegUser});

        jPanel2.add(jPanel3, "card2");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loging.jpeg"))); // NOI18N
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ImageLabel)))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegUserMouseClicked
        // TODO add your handling code here:
        if(RegUser.getText().equals("Username")) 
            RegUser.setText("");
    }//GEN-LAST:event_RegUserMouseClicked

    private void LogUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogUserMouseClicked
        // TODO add your handling code here:
        if(LogUser.getText().equals("Username"))
            LogUser.setText("");
    }//GEN-LAST:event_LogUserMouseClicked

    private void LogPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogPassMouseClicked
        // TODO add your handling code here:
        //if(LogPass.getPassword().equals("Password")){
            System.out.println(LogPass.getPassword());
            LogPass.selectAll();
        //}
    }//GEN-LAST:event_LogPassMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        
        jPanel2.add(jPanel3);
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void RegPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegPassMouseClicked
        // TODO add your handling code here:
        RegPass.selectAll();
    }//GEN-LAST:event_RegPassMouseClicked

    private void RegRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegRetActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        
        jPanel2.add(jPanel4);
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_RegRetActionPerformed

    private void RegPassConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegPassConfMouseClicked
        // TODO add your handling code here:
        RegPassConf.selectAll();
    }//GEN-LAST:event_RegPassConfMouseClicked

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        int returned;
        char[] pass_char = LogPass.getPassword();
        String pass = String.copyValueOf(pass_char);
        ProtoX proto = new ProtoX();
        if((LogUser.getText()).length()>=1 && pass.length()>=1){
            returned=proto.login(LogUser.getText(), pass);
            if(returned == 0){
                jLabel2.setForeground(new java.awt.Color(30, 148, 116));
                jLabel2.setText("Login Accepted");
                getImagesFromUrl();
                dispose();
                MainPanel mainPanel = new MainPanel(proto.getUser());
                mainPanel.setVisible(rootPaneCheckingEnabled);
            }else if(returned == 2)
                jLabel2.setText("Wrong Username");
            else if(returned == 1){
                jLabel2.setForeground(new java.awt.Color(255, 27, 0));
                jLabel2.setText("Wrong PassWord");
            }
        }else if((LogUser.getText()).length()<1){
            jLabel2.setText("Invalid Username");
        }else if(pass.length()<1){
            jLabel2.setText("Invalid Password");
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int returned;
        ProtoX proto = new ProtoX();
        String user = RegUser.getText();
        char[] pass_char = RegPassConf.getPassword();
        char[] passconf_char = RegPass.getPassword();
        String pass = String.copyValueOf(pass_char);
        String passconf = String.copyValueOf(passconf_char);
        
        if(pass.length()<1 || user.length()<1){
            jLabel3.setForeground(new java.awt.Color(255, 27, 0));
            jLabel3.setText("Fields incomplete");
        }else if(!(pass.equals(passconf))){
            jLabel3.setForeground(new java.awt.Color(255, 27, 0));
            jLabel3.setText("Passwords don't match!");
        }else{
            jLabel3.setForeground(new java.awt.Color(32, 148, 114));
            jLabel3.setText("Loading...");
            returned=proto.register(user, passconf);
            if(returned==0){
                jLabel3.setForeground(new java.awt.Color(32, 148, 114));
                jLabel3.setText("Accepted");
            }else if(returned==1){
                jLabel3.setForeground(new java.awt.Color(255, 27, 0));
                jLabel3.setText("Username already exist's");
            }
        }      
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(visi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new visi().setVisible(true); 
            }
        });
        System.out.println("Yeye pickayei madafaca!");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JPasswordField LogPass;
    private javax.swing.JTextField LogUser;
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField RegPass;
    private javax.swing.JPasswordField RegPassConf;
    private javax.swing.JButton RegRet;
    private javax.swing.JTextField RegUser;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}