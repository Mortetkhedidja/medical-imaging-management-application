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

public class ajouterRdv extends javax.swing.JFrame {
Connection conn;
 Statement stm;
 ResultSet Rs;
 PreparedStatement pst ;
 DefaultTableModel ma = new DefaultTableModel();
   String name, prenom,telephone;
   
    public ajouterRdv() {
        initComponents();
         setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\iconne.png"));
    }
    public ajouterRdv(String val1, String val2, String val3){
        initComponents();
        this.name= val1;
        this.prenom= val2;
        this.telephone= val3;
          add();
          setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\iconne.png"));
  
    }
void add(){
    txtprenom1.setText(name);
    txtprenom3.setText(prenom);
    txtprenom2.setText(telephone);
  /*  doctor d= new doctor();
    d.rdv();
    d.afficher_rdv();*/
}
public void afficher(){
    doctor d= new doctor();
    d.afficher_rdv();
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
    
    /*
    public void afficher_rdv(){
       try{
            
           
             Connect();
             ma.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from rdv ");
        while(Rs.next()){
           ma.addRow(new Object[]{Rs.getInt("Num_RDV"),Rs.getInt("id_patient"),Rs.getString("Nom_et_Prenom")
                                   ,Rs.getDate("Date_RDV"),Rs.getTime("deb_RDV"),Rs.getTime("fin_RDV")
                                     ,Rs.getString("Commentaire")  });
        }
        }catch(Exception e){System.err.println(e);}
       //rdv_tab.setModel(ma);
   }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtdaterdv1 = new com.toedter.calendar.JDateChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtcom1 = new javax.swing.JTextArea();
        txtprenom1 = new javax.swing.JTextField();
        num_rdv = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtprenom2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtprenom3 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nouveau Rendez-vous");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel34.setText("Date RDV");
        jPanel19.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        txtdaterdv1.setBackground(new java.awt.Color(255, 255, 255));
        txtdaterdv1.setDateFormatString("yyyy-MM-dd ");
        txtdaterdv1.setMinSelectableDate(new java.util.Date(-62135769481000L));
        jPanel19.add(txtdaterdv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 180, 29));

        txtcom1.setColumns(20);
        txtcom1.setRows(5);
        jScrollPane9.setViewportView(txtcom1);

        jPanel19.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 180, 120));

        txtprenom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom1KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 180, 28));

        num_rdv.setEditable(false);
        num_rdv.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        num_rdv.setText("       Auto Générer");
        jPanel19.add(num_rdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 180, 28));

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel21.setText("N° de RDV");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setText("Téléphone");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        jLabel36.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel36.setText("Commentaire");
        jPanel19.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        jPanel19.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 190, 20));
        jPanel19.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, 20));

        txtprenom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom2KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 180, 28));

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel23.setText("                        Nom  ");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 20));
        jPanel19.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 20));

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel24.setText(" Prenom ");
        jPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 124, -1, 20));

        txtprenom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom3KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 180, 28));

        jButton21.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton21.setText("Ajouter");
        jButton21.setMaximumSize(new java.awt.Dimension(107, 29));
        jButton21.setMinimumSize(new java.awt.Dimension(107, 29));
        jButton21.setPreferredSize(new java.awt.Dimension(107, 29));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 136, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(458, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprenom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom1KeyReleased
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel13.setText(null);
        }else{
            jLabel13.setText("Entrer seleument des lettres ");
            jLabel13.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtprenom1KeyReleased

    private void txtprenom2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom2KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[0-9]{0,12}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtprenom2.getText());
        if(!match.matches()){
            jLabel9.setText("entrer suelement des numéro!");
            jLabel9.setForeground(Color.RED);
        }
        else{
            jLabel9.setText(null);
        }
    }//GEN-LAST:event_txtprenom2KeyReleased

    private void txtprenom3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom3KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel10.setText(null);
        }else{
            jLabel10.setText("Entrer seleument des alphabets ");
            jLabel10.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtprenom3KeyReleased

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        
        try{
              Connect();
            String tlf= txtprenom2.getText();//tlf
            String nom= txtprenom1.getText();
            String prenom= txtprenom3.getText();
            String  d= ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();
            
            String com = txtcom1.getText();
          
           
            if(txtprenom2.getText().length()!=0&&txtprenom1.getText().length()!=0&& txtprenom3.getText().length()!=0 ){
                 String sql = "SELECT Nom ,prenom,Date_RDV FROM rdv WHERE Nom ='"+txtprenom1.getText()+"' and prenom='"+txtprenom3.getText()+"' and Date_RDV='"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText()+"' ";
                pst = conn.prepareStatement(sql);
                Rs= pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getDate("Date_RDV").equals(((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText())|| Rs.getString("Nom").equals(txtprenom1.getText())|| Rs.getString("prenom").equals(txtprenom3.getText())){
                        JOptionPane.showMessageDialog(null,  "Ce patient est déja un rendez-vous dans la date :"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                    }
                }else{
                    pst = conn.prepareStatement("insert into rdv (Nom,prenom,telephone,Date_RDV ,Commentaire) values(?,?,?,?,?)");
                    // pst.setString(1,txtid.getText());
                    pst.setString(1,txtprenom1.getText());//nom
                    pst.setString(2,txtprenom3.getText());//prenom
                    pst.setString(3,txtprenom2.getText());//telephone
                    pst.setString(4, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                    pst.setString(5,txtcom1.getText());
                    pst.executeUpdate();
                    conn.close();
                    JOptionPane.showMessageDialog(null,  "Le rendez-vous est bien ajouter");
                     
                    afficher();
                    num_rdv.setText("Auto Générer");
                    //txtprenom2.setText("");
                   // txtprenom1.setText("");
                    txtdaterdv1.setDate(null);
                    txtcom1.setText("");
                   
                }
            }else {
                JOptionPane.showMessageDialog(null,"Veuillez vous remplir votre champs ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

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
            java.util.logging.Logger.getLogger(ajouterRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajouterRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajouterRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajouterRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajouterRdv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField num_rdv;
    private javax.swing.JTextArea txtcom1;
    private com.toedter.calendar.JDateChooser txtdaterdv1;
    private javax.swing.JTextField txtprenom1;
    private javax.swing.JTextField txtprenom2;
    private javax.swing.JTextField txtprenom3;
    // End of variables declaration//GEN-END:variables
}
