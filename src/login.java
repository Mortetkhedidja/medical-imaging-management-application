
import com.sun.glass.events.KeyEvent;
import com.sun.glass.events.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.*;
public class login extends javax.swing.JFrame {
Connection conn;
Statement stm;
ResultSet Rs;
PreparedStatement pst ; 
    public login() {
        initComponents();
        image();
         setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\icons8-tête-avec-cerveau-64.png"));
        
    }
  public void image(){
       ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\20220613_0858500.5285739786631404.png").getImage().getScaledInstance( 280,240, Image.SCALE_DEFAULT));
      jLabel12.setIcon(imageIcon);
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
public String hash(JPasswordField txtmdp) throws NoSuchAlgorithmException{
          
           //Reading data from user
                             //  Scanner sc = new Scanner(System.in);
                            // System.out.println("Enter the message");
                            String hashd="";
                                 String message = new String (txtmdp.getPassword());
                                 
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
                          // System.out.println("Hex format : " + hexString.toString());     
      
      }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nom_utils = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtmdp = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(420, 0, 40, 37);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(60, 30, 330, 130);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 140));

        nom_utils.setBackground(new java.awt.Color(255, 255, 255));
        nom_utils.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nom d'utilisateur :");
        nom_utils.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Mot de passe :");
        nom_utils.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nom_utils.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 210, 30));

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
        nom_utils.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 25));

        txtmdp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmdp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nom_utils.add(txtmdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_check_1930264.png"))); // NOI18N
        jButton1.setText("Se Connecter");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        nom_utils.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 150, 40));
        nom_utils.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 358, 266, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_Remove_27874_1_1.png"))); // NOI18N
        jButton2.setText("Annuler");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        nom_utils.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 150, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/male_user_1.png"))); // NOI18N
        nom_utils.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 48, 50, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_Privacy_2921800(1).png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        nom_utils.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 139, 50, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/male_user_1.png"))); // NOI18N
        nom_utils.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_Privacy_2921800(1).png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        nom_utils.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 0, 14)); // NOI18N
        jLabel13.setText("Mot de passe oblie ?");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        nom_utils.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 130, -1));

        getContentPane().add(nom_utils, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 460, 260));

        setSize(new java.awt.Dimension(459, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        /* Home hm = new Home();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();// ferme la fenetre et ouvrir la fenetre de register
        */
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            Connect();
            String user= txtuser.getText();
            String ps=hash(txtmdp);
            if(user.length()!=0 && ps.length()!=0){
                // pst = conn.prepareStatement("SELECT username FROM login where username=? and  psw=? ");
                pst = conn.prepareStatement("SELECT type FROM login where username=? and  psw=?");
                pst.setString(1, txtuser.getText().trim());

                pst.setString(2, hash(txtmdp));
                Rs = pst.executeQuery();
                if (Rs.next()) {

                    if (Rs.getString("type").equals("Médecin")) {//
                        super.dispose();

                        new doctor().setVisible(true);

                    } else if (Rs.getString("type").equals("Secrétaire")) {
                        // JOptionPane.showMessageDialog(null, "?");
                        super.dispose();
                        new Secretaire().setVisible(true);
                    }else if(Rs.getString("type").equals(" ")){
                        super.dispose();
                        new administrateur().setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "votre nom d'utilisateur ou mots de pas est incorrect ");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Les champs de saisir sont obligatoir à remplir ");
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtuser.setText("");
        txtmdp.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            txtmdp.setEchoChar((char)0);

        }
        else
        {
            txtmdp.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        forget_password f= new  forget_password();
        f.setVisible(true);

        f.pack();
        f.setLocationRelativeTo(null);
        //this.dispose();// ferme la fenetre et ouvrir la fenetre de register
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel nom_utils;
    private javax.swing.JPasswordField txtmdp;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
