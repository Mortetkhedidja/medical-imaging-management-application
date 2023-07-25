import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class ChangePassword extends javax.swing.JFrame {

     Connection conn;
    Statement stm;
    ResultSet Rs;
    PreparedStatement pst ; 
    public ChangePassword() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\icons8-locked-with-pen-96.png"));
    
    }

    
     public void Connect(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/univ","root","");
             //System.out.println("Connection Etablie");
        }catch(Exception e){
            System.out.println("Erreur de connection");
            e.printStackTrace();
        }
    }
      public String hash(JPasswordField psdo) throws NoSuchAlgorithmException{
          
           //Reading data from user
                             
                            
                            String hashd="";
                                 String message = new String(psdo.getPassword()) ;
                              //Creating the MessageDigest object  
                                MessageDigest md = MessageDigest.getInstance("SHA-256");

                                   //Passing data to the created MessageDigest Object
                              md.update(message.getBytes());
      
                               //Compute the message digest
                                  byte[] digest = md.digest();      
                              //   System.out.println(digest);  
     
                                  //Converting the byte array in to HexString format
                                StringBuffer hexString = new StringBuffer();
      
                                for (int i = 0;i<digest.length;i++) {
                                   hexString.append(Integer.toHexString(0xFF & digest[i]));
                                     }
                                hashd=hexString.toString();
                                return hashd;
                        
      
      }
        public String hash1(JPasswordField psdn) throws NoSuchAlgorithmException{
          
           //Reading data from user
                            
                            String hashd="";
                                 String message =new String(psdn.getPassword()) ;
                              //Creating the MessageDigest object  
                                MessageDigest md = MessageDigest.getInstance("SHA-256");

                                   //Passing data to the created MessageDigest Object
                              md.update(message.getBytes());
      
                               //Compute the message digest
                                  byte[] digest = md.digest();      
                              //   System.out.println(digest);  
     
                                  //Converting the byte array in to HexString format
                                StringBuffer hexString = new StringBuffer();
      
                                for (int i = 0;i<digest.length;i++) {
                                   hexString.append(Integer.toHexString(0xFF & digest[i]));
                                     }
                                hashd=hexString.toString();
                                return hashd;
                        
      
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        psdo = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        psdn = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        psdc = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Changer le mot de passe ");
        setPreferredSize(new java.awt.Dimension(570, 365));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Nom d'utilisateur :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(76, 69, 143, 18);

        txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername);
        txtUsername.setBounds(241, 68, 248, 24);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Ancien mot de passe :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(48, 111, 171, 18);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eyes-48.png"))); // NOI18N
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(460, 110, 29, 20);

        psdo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(psdo);
        psdo.setBounds(241, 110, 248, 24);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Nouveau mot de passe :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(32, 153, 187, 18);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eyes-48.png"))); // NOI18N
        jCheckBox2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox2StateChanged(evt);
            }
        });
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(460, 150, 30, 20);

        psdn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        psdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psdnActionPerformed(evt);
            }
        });
        jPanel1.add(psdn);
        psdn.setBounds(241, 152, 248, 24);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Confirmez le mot de passe :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(2, 195, 216, 18);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eyes-48.png"))); // NOI18N
        jCheckBox3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox3StateChanged(evt);
            }
        });
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(460, 190, 29, 25);

        psdc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(psdc);
        psdc.setBounds(241, 194, 248, 24);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_check_1930264.png"))); // NOI18N
        jButton1.setText("Sauvgardez");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 260, 150, 36);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Remove_27874_1_1.png"))); // NOI18N
        jButton2.setText("Annuler");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(340, 260, 150, 36);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(516, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void psdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psdnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psdnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connect();
            //String Newpass=String.valueOf(psdn.getText());
            String Newpass=new String(psdn.getPassword());
            //String ConfPass=String.valueOf(psdc.getText());
            String ConfPass=new String(psdc.getPassword());
            //String OldPass=String.valueOf(psdo.getText());
            String OldPass=new String(psdo.getPassword());
            String pswa=hash(psdo);
            String pswn =hash1(psdn);
            String uName=txtUsername.getText();
            if (uName.equals("")) {

                JOptionPane.showMessageDialog( this, "entrer votre nom d'utilisateur");
                //return;

            } else if (OldPass.equals("")) {

                JOptionPane.showMessageDialog( this, "entrer votre ancien mot de passe");
                //return;

            } else if (Newpass.equals("")) {

                JOptionPane.showMessageDialog( this, "entrer un nouveau mot de passe");
               // return;

            }else if (Newpass.length()< 8) {

                JOptionPane.showMessageDialog(this,"Le nouveau mot de passe doit comporter au moins 8 caracteres");
                //return;
            }else if ((Newpass).equals(OldPass)) {

                JOptionPane.showMessageDialog(this, "entrer un nouveau mot de passe");//même
                psdn.setText("");
                //return;
            }else if (ConfPass.equals("")) {

                JOptionPane.showMessageDialog( this, "Confirmé votre mot de passe !");
                //return;
            }
            else if (!(Newpass).equals(ConfPass)) {

                JOptionPane.showMessageDialog(this,"Le mot de passe confirmé ne correspond pas au nouveau mot de passe !");
                psdc.setText("");
                //return;
            }else if(txtUsername.getText().length()!=0){

            String sql= "select username,psw from login where username='" + txtUsername.getText() + "' and psw= '" + pswa + "'";
            pst=conn.prepareStatement(sql);
            Rs= pst.executeQuery();
           if(Rs.next()){
              /*  String usrname = Rs.getString("username").trim();
                String passwd = Rs.getString("psw").trim();*/
                if(Rs.getString("username").equals(txtUsername.getText()) || Rs.getString("psw").equals(pswa)){

                    String sql1= "update login set psw= '" + pswn + "' where username= '" + uName + "' and psw = '" + pswa + "'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(sql1.toString());
                    stmt.close();
                    JOptionPane.showMessageDialog(this,"le mot de passe est bien changer");
                    this.dispose();
                   return;
                }
            } else {
                     JOptionPane.showMessageDialog(this,"le nom d'utilisateur ou le mot de passe est non valide !");
                    txtUsername.setText("");
                    psdo.setText("");
                    psdn.setText("");
                    psdc.setText("");
                    return;
                }}
        }catch(SQLException | HeadlessException ex){
            JOptionPane.showMessageDialog(this,ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtUsername.setText("");
        psdo.setText("");
        psdn.setText("");
        psdc.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            psdo.setEchoChar((char)0);

        }
        else
        {
            psdo.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected())
        {
           psdn.setEchoChar((char)0);

        }
        else
        {
            psdn.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox3StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3StateChanged

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected())
        {
           psdc.setEchoChar((char)0);

        }
        else
        {
            psdc.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField psdc;
    private javax.swing.JPasswordField psdn;
    private javax.swing.JPasswordField psdo;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
