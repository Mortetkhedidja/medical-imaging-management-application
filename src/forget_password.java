import java.awt.Color;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class forget_password extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet Rs;
    PreparedStatement pst ;
    public forget_password() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\icons8-forgot-password-96 (2).png"));
 
    }
public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/univ","root","");
            System.out.println("Connection Etablie");
          
        } catch (Exception e) {
            System.out.println("Erreur de connection");
            e.printStackTrace();
        }
    }
    public String hash(JPasswordField newmotdepasse) throws NoSuchAlgorithmException{
          
           //Reading data from user
                             //  Scanner sc = new Scanner(System.in);
                            // System.out.println("Enter the message");
                            String hashd="";
                                 String message = new String(newmotdepasse.getPassword());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        nom = new javax.swing.JTextField();
        txttype = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        newmotdepasse = new javax.swing.JPasswordField();
        qtSc = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oblier le mots de passe");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nom Utilisateur :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(65, 27, 115, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Question de securite :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 150, 150, 27);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" Reponse :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(107, 198, 73, 27);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" nouveau mot de passe :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 260, 180, 27);

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
        jCheckBox1.setBounds(540, 260, 30, 30);

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });
        jPanel1.add(nom);
        nom.setBounds(198, 20, 370, 35);

        txttype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médecin", "Secrétaire" }));
        txttype.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });
        jPanel1.add(txttype);
        txttype.setBounds(198, 85, 370, 35);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText(" Type:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(137, 85, 43, 27);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_check_1930264.png"))); // NOI18N
        jButton1.setText("Enregistrer");
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
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 340, 136, 36);

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
        jPanel1.add(jButton2);
        jButton2.setBounds(430, 340, 136, 36);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(200, 60, 310, 20);
        jPanel1.add(answer);
        answer.setBounds(200, 200, 370, 34);

        newmotdepasse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newmotdepasse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newmotdepasseKeyReleased(evt);
            }
        });
        jPanel1.add(newmotdepasse);
        newmotdepasse.setBounds(200, 260, 370, 30);

        qtSc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qtSc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "quel est l'anniversaire de ton pére ?", "quel est le nom de votre école prémaire?" }));
        jPanel1.add(qtSc);
        qtSc.setBounds(200, 150, 370, 35);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 310, 350, 20);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 290, 350, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(607, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            newmotdepasse.setEchoChar((char)0);

        }
        else
        {
            newmotdepasse.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^@,.;*+&$^]{0,30}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(nom.getText());
        if(!match.matches()){
            jLabel6.setText("Utilisez seulement les numéros et les lettres ");
            jLabel6.setForeground(Color.RED);
        }
        else{
            jLabel6.setText(null);
        }
    }//GEN-LAST:event_nomKeyReleased

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttypeActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username=nom.getText();
        String typ =txttype.getSelectedItem().toString();
        String q= qtSc.getSelectedItem().toString();
        String reponce=answer.getText();
        //String newpassword=(String) hash(newmotdepasse);
        try{
            Connect();
            if(nom.getText().length()!=0 && answer.getText().length()!=0 && new String(newmotdepasse.getPassword()).length()!=0){
                String sql = "SELECT username, type,reponse FROM login where username='"+nom.getText()+"' and type='"+txttype.getSelectedItem().toString()+"' and reponse='"+answer.getText()+"' " ;
              //  String d= "SELECT reponse FROM login where reponse='"+answer.getText()+"' ";
                /*stm =conn.prepareStatement(d);
                Rs = stm.executeQuery(d);*/
                stm =conn.prepareStatement(sql);
                Rs = stm.executeQuery(sql);
                if(Rs.next()){
                    if(Rs.getString("username").equals(nom.getText())||Rs.getString("type").equals(txttype.getSelectedItem().toString())||Rs.getString("reponse").equals(answer.getText())){
                        //JOptionPane.showMessageDialog(null,  "Patient est déjà  ajouter");
                         pst=conn.prepareStatement("UPDATE login SET psw=?  where username=?  and type=?  and reponse=?");
                         // stm.executeUpdate(d);//username='"+username+"' and
                          pst.setString(1,hash(newmotdepasse));
                          pst.setString(2,nom.getText());
                          pst.setString(3,txttype.getSelectedItem().toString());
                         // pst.setString(4,qtSc.getSelectedItem().toString());
                          pst.setString(4, answer.getText());
                          pst.execute();
                           conn.close();
                          JOptionPane.showMessageDialog(null, "Votre mots de passe est modifier");
                
                    }
                }else{ 
                     JOptionPane.showMessageDialog(null,  "Votre informations sont incorrecte");
                     }
                /*else if(Rs.next()){
                    if(Rs.getString("reponse").equals(answer.getText())){
                        // JOptionPane.showMessageDialog(null, "taper le correct code bancaire!");
                    }else{
                        JOptionPane.showMessageDialog(null, "taper le correct code bancaire!");
                    }
                }else{
                    // String newpassword=(String) hash(newmotdepasse);
                    pst.executeUpdate("UPDATE login SET psw=?  where username=? and reponse=? and type=? ");
                    // stm.executeUpdate(d);//username='"+username+"' and
                    pst.setString(1,hash(newmotdepasse));
                    pst.setString(2,nom.getText());
                    pst.setString(3, answer.getText());
                    pst.setString(4,txttype.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null, "Votre mots de passe est modifier");
                }*/
            }else{
                JOptionPane.showMessageDialog(null, "Vous veuillez remplir tous les champs");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        /*String username=nom.getText();
        String typ =(String) txttype.getSelectedItem();
        String q=(String) qtSc.getSelectedItem();

      /* try {
            String newpassword =(String) hash(newmotdepasse);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(forget_password.class.getName()).log(Level.SEVERE, null, ex);
        }*/

       /* String reponce=newmotdepasse.getText();
        try {
            Connect();
            if(nom.getText().length()!=0 &&answer.getText().length()!=0 ){
                
            String sql = "SELECT username,reponse,type From login where username='"+username+"' and reponse='"+reponce+"' and type='"+typ+"'" ;

            stm =conn.prepareStatement(sql);
            Rs = stm.executeQuery(sql);

            if(Rs.next()){
                String newpassword=(String) hash(newmotdepasse);
                String d ="UPDATE login SET psw='"+newpassword+"'  where username='"+username+"' and reponse='"+reponce+"' and type='"+typ+"' ";
                stm.executeUpdate(d);//username='"+username+"' and
                JOptionPane.showMessageDialog(null, "Votre mots de passe est modifier");

            }else{
                JOptionPane.showMessageDialog(null, "taper le correct code bancaire!");
            }}else{
                JOptionPane.showMessageDialog(null," Vous veuillez remplir tous les champs ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nom.setText("");
        answer.setText("");
        newmotdepasse.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void newmotdepasseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newmotdepasseKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^,;+&$=]{8,100}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(new String(newmotdepasse.getPassword()));
        if(!match.matches()){
          jLabel7.setText("le mots de passe doit contenir au moins 8 caractères,");
            jLabel7.setForeground(Color.RED);
            jLabel8.setText("des alphabets et des numéro");
            jLabel8.setForeground(Color.RED);
        }
        else{
            jLabel7.setText(null);
            jLabel8.setText(null);
            
        }
    }//GEN-LAST:event_newmotdepasseKeyReleased

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
            java.util.logging.Logger.getLogger(forget_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forget_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forget_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forget_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forget_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newmotdepasse;
    private javax.swing.JTextField nom;
    private javax.swing.JComboBox qtSc;
    private javax.swing.JComboBox<String> txttype;
    // End of variables declaration//GEN-END:variables
}
