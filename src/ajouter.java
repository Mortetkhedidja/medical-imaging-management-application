import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class ajouter extends javax.swing.JFrame {
Connection conn;
 Statement stm;
 ResultSet Rs;
 PreparedStatement pst ;
 DefaultTableModel model = new DefaultTableModel();
  
    public ajouter() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\plus.png"));
 
    }
public void Connect(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/univ","root","");
             System.out.println("Connection Etablie");
        }catch(Exception e){
            System.out.println("Erreur de connection");
            e.printStackTrace();
        }
    }
public void afficher(){
         try{
             Connect();
        model.setRowCount(0);
        //stm= con.obtenirconnexion().createStatement();
         stm = conn.createStatement();
            
        ResultSet Rs= stm.executeQuery("Select * from medecin2");
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt("id"),Rs.getString("nom"),
           Rs.getString("prenom"),Rs.getString("date_naiss"), Rs.getString("adresse")
            , Rs.getInt("telephone"), Rs.getString("sex")});
        }
        }catch(Exception e){System.err.println(e);}
        //pat_tab.setModel(model); 
        //id_tab.setModel(model);
    }
    private void actualiser(){
    
    txtnom1.setText("");
    txtpre1.setText("");
    txtdate1.setDate(null);
    txtadrss1.setText("");
    txttlf1.setText("");
   
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtnom1 = new javax.swing.JTextField();
        txtpre1 = new javax.swing.JTextField();
        txtadrss1 = new javax.swing.JTextField();
        txttlf1 = new javax.swing.JTextField();
        txtdate1 = new com.toedter.calendar.JDateChooser();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nouveaux patient");

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "info patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Nom");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 45, -1, 20));

        jLabel39.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel39.setText("Prénom");
        jPanel24.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 94, -1, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Adresse");
        jPanel24.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Télephone");
        jPanel24.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Sexe");
        jPanel24.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Date de naissance");
        jPanel24.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, -1, 30));

        txtnom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnom1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnom1KeyReleased(evt);
            }
        });
        jPanel24.add(txtnom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 199, 28));

        txtpre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpre1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpre1KeyReleased(evt);
            }
        });
        jPanel24.add(txtpre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 199, 28));

        txtadrss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadrss1ActionPerformed(evt);
            }
        });
        txtadrss1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtadrss1KeyReleased(evt);
            }
        });
        jPanel24.add(txtadrss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 199, 28));

        txttlf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttlf1ActionPerformed(evt);
            }
        });
        txttlf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttlf1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttlf1KeyReleased(evt);
            }
        });
        jPanel24.add(txttlf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 199, 28));

        txtdate1.setBackground(new java.awt.Color(255, 255, 255));
        txtdate1.setDateFormatString("yyyy-MM-dd");
        jPanel24.add(txtdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 199, 27));
        jPanel24.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 200, 20));
        jPanel24.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 20));
        jPanel24.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 200, 20));

        jComboBox1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femme", "Male" }));
        jPanel24.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 199, 28));
        jPanel24.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 200, 30));

        jButton4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton4.setText("Ajouter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 136, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(454, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{  Connect();
            String nom= txtnom1.getText();
            String prenom= txtpre1.getText();
            String dl=  ((JTextField)txtdate1.getDateEditor().getUiComponent()).getText();
            String adresse =txtadrss1.getText();
            String tlf =txttlf1.getText();
            if(nom.length()!=0&& prenom.length()!=0&&dl.length()!=0&& adresse.length()!=0&& tlf.length()!=0 ){
                String phone = "SELECT nom, prenom, date_naiss FROM medecin2 WHERE nom ='"+txtnom1.getText()+"' and prenom='"+txtpre1.getText()+"' and date_naiss= '"+((JTextField)txtdate1.getDateEditor().getUiComponent()).getText()+"' ";
                pst = conn.prepareStatement(phone);
                Rs= pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getString("nom").equals(txtnom1.getText())||Rs.getString("prenom").equals(txtpre1.getText())||Rs.getString("date_naiss").equals(((JTextField)txtdate1.getDateEditor().getUiComponent()).getText())){
                        JOptionPane.showMessageDialog(null,  "Patient est déjà  ajouter");
                    }
                }else{
                    pst = conn.prepareStatement("INSERT INTO medecin2 (nom,prenom,date_naiss,adresse,telephone,sex) values(?,?,?,?,?,?)");
                    pst.setString(1,txtnom1.getText());
                    pst.setString(2,txtpre1.getText());
                    pst.setString(3, ((JTextField)txtdate1.getDateEditor().getUiComponent()).getText());
                    pst.setString(4,txtadrss1.getText());
                    pst.setString(5,txttlf1.getText());
                    pst.setString(6,jComboBox1.getSelectedItem().toString());
                    pst.executeUpdate();
                    conn.close();
                    JOptionPane.showMessageDialog(null,  "Patient est bien ajouter");
                    afficher();
                    actualiser();
                }
            }else {
                JOptionPane.showMessageDialog(null,"Veuillez vous remplir tous les champs  ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txttlf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttlf1KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[0-9]{0,12}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txttlf1.getText());
        if(!match.matches()){
            label2.setText("entrer suelement des numéro!");
            label2.setForeground(Color.RED);
        }
        else{
            label2.setText(null);
        }
    }//GEN-LAST:event_txttlf1KeyReleased

    private void txttlf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttlf1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttlf1KeyPressed

    private void txttlf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttlf1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txttlf1ActionPerformed

    private void txtadrss1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadrss1KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^@,.;*+&= $^]{0,30}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtadrss1.getText());
        if(!match.matches()){
            jLabel8.setText("Entrer un correcte adresse");
            jLabel8.setForeground(Color.RED);
        }
        else{
            jLabel8.setText(null);
        }
    }//GEN-LAST:event_txtadrss1KeyReleased

    private void txtadrss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadrss1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadrss1ActionPerformed

    private void txtpre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpre1KeyReleased
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel2.setText(null);
        }else{
            jLabel2.setText("Entrer seleument des alphabet");
            jLabel2.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtpre1KeyReleased

    private void txtpre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpre1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpre1KeyPressed

    private void txtnom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnom1KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            label.setText(null);
        }else{
            label.setText("Entrer seleument des alphabet");
            label.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtnom1KeyReleased

    private void txtnom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnom1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom1KeyPressed

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
            java.util.logging.Logger.getLogger(ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajouter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField txtadrss1;
    private com.toedter.calendar.JDateChooser txtdate1;
    private javax.swing.JTextField txtnom1;
    private javax.swing.JTextField txtpre1;
    private javax.swing.JTextField txttlf1;
    // End of variables declaration//GEN-END:variables
}
