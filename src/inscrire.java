import java.awt.Color;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.Toolkit;
import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class inscrire extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet Rs;
    PreparedStatement pst ; 
    public inscrire() {
        initComponents();
         this.setLocationRelativeTo(null);// center form in screen
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\nouveau.png"));
 
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
    public String hash(JPasswordField pass_field) throws NoSuchAlgorithmException{
          
           //Reading data from user
                             //  Scanner sc = new Scanner(System.in);
                            // System.out.println("Enter the message");
                            String hashd="";
                                char[] message = pass_field.getPassword();
                                String mo = new String(message);
                              //Creating the MessageDigest object  
                                MessageDigest md = MessageDigest.getInstance("SHA-256");

                                   //Passing data to the created MessageDigest Object
                              md.update(mo.getBytes());
      
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

        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonRegister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        pass_field = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        pass_field2 = new javax.swing.JPasswordField();
        txtuser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttype = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        reponse = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        txtuser11 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtmail1 = new javax.swing.JTextField();
        jButtonRegister1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelRegister1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pass_field1 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        pass_field3 = new javax.swing.JPasswordField();
        txtuser1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        txttype1 = new javax.swing.JComboBox<String>();
        jLabel21 = new javax.swing.JLabel();
        securiteq1 = new javax.swing.JComboBox<String>();
        jLabel22 = new javax.swing.JLabel();
        reponse1 = new javax.swing.JPasswordField();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtuser12 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        securiteq = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nauveau utilisateur");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Nouveau compte");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 389, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jButtonRegister.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_check_1930264.png"))); // NOI18N
        jButtonRegister.setText(" Créer");
        jButtonRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRegister);
        jButtonRegister.setBounds(240, 420, 150, 40);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(53, 710, 0, 0);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Mot de passe :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(90, 130, 117, 22);

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
        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(530, 120, 29, 25);

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
        jPanel2.add(jCheckBox2);
        jCheckBox2.setBounds(530, 180, 30, 25);

        pass_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pass_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass_fieldKeyReleased(evt);
            }
        });
        jPanel2.add(pass_field);
        pass_field.setBounds(230, 120, 330, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Retaper le mot de passe :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 190, 220, 22);

        pass_field2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_field2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pass_field2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_field2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass_field2KeyReleased(evt);
            }
        });
        jPanel2.add(pass_field2);
        pass_field2.setBounds(230, 180, 330, 30);

        txtuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuserKeyReleased(evt);
            }
        });
        jPanel2.add(txtuser);
        txtuser.setBounds(230, 70, 330, 29);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nom Complete :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(80, 20, 129, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Type :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(150, 350, 60, 22);

        txttype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médecin", "Secrétaire", " " }));
        txttype.setBorder(null);
        txttype.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });
        jPanel2.add(txttype);
        txttype.setBounds(230, 340, 330, 35);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Question de securite :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 240, 173, 22);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Réponse :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(119, 300, 90, 22);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eyes-48.png"))); // NOI18N
        jCheckBox7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox7StateChanged(evt);
            }
        });
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox7);
        jCheckBox7.setBounds(530, 290, 30, 30);

        reponse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reponse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(reponse);
        reponse.setBounds(230, 290, 330, 35);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Nom d'utilisateur :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(60, 72, 145, 30);

        txtuser11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtuser11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuser11KeyReleased(evt);
            }
        });
        jPanel2.add(txtuser11);
        txtuser11.setBounds(230, 20, 330, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        txtmail1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmail1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtmail1);
        txtmail1.setBounds(230, 160, 269, 30);

        jButtonRegister1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRegister1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRegister1.setText("Créer");
        jButtonRegister1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegister1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonRegister1);
        jButtonRegister1.setBounds(380, 647, 147, 45);
        jPanel4.add(jLabel4);
        jLabel4.setBounds(53, 710, 0, 0);

        jLabelRegister1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRegister1.setText("      Cliquez ici pour se connecter");
        jLabelRegister1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegister1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabelRegister1);
        jLabelRegister1.setBounds(0, 647, 226, 29);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Nouveau compte");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(0, 0, 537, 47);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Mot de passe :");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(100, 310, 117, 22);

        pass_field1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_field1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(pass_field1);
        pass_field1.setBounds(230, 300, 270, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Retaper le mot de passe :");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(10, 396, 203, 22);

        pass_field3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_field3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(pass_field3);
        pass_field3.setBounds(231, 394, 269, 30);

        txtuser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtuser1);
        txtuser1.setBounds(230, 260, 269, 29);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Date de naissance :");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(60, 110, 160, 22);

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Nom Complete :");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(84, 55, 129, 22);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox4StateChanged(evt);
            }
        });
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox4);
        jCheckBox4.setBounds(510, 300, 21, 25);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox5StateChanged(evt);
            }
        });
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox5);
        jCheckBox5.setBounds(510, 400, 21, 25);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Type :");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(40, 557, 51, 22);

        txttype1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médecin", "Secrétaire" }));
        txttype1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txttype1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttype1ActionPerformed(evt);
            }
        });
        jPanel4.add(txttype1);
        txttype1.setBounds(50, 585, 364, 35);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Question de securite :");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(10, 442, 173, 22);

        securiteq1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        securiteq1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "quel est votre code bancaire ?", "m" }));
        securiteq1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        securiteq1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        securiteq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securiteq1ActionPerformed(evt);
            }
        });
        jPanel4.add(securiteq1);
        securiteq1.setBounds(219, 442, 269, 35);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Réponse :");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(32, 483, 79, 22);

        reponse1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reponse1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(reponse1);
        reponse1.setBounds(105, 511, 368, 35);

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox6StateChanged(evt);
            }
        });
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox6);
        jCheckBox6.setBounds(479, 521, 21, 25);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Numéro de telphone :");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(40, 210, 180, 22);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Nom d'utilisateur :");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(70, 260, 145, 22);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("              E-mail :");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(70, 160, 145, 22);

        txtuser12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtuser12);
        txtuser12.setBounds(231, 53, 269, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 0, 0);

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
        jPanel2.add(jButton2);
        jButton2.setBounds(420, 420, 150, 40);

        securiteq.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        securiteq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "quel est l'anniversaire de ton pére ?", "quel est le nom de votre école prémaire?" }));
        securiteq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        securiteq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        securiteq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securiteqActionPerformed(evt);
            }
        });
        jPanel2.add(securiteq);
        securiteq.setBounds(220, 230, 340, 35);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 50, 330, 20);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(230, 100, 330, 20);
        jPanel2.add(jLabel8);
        jLabel8.setBounds(230, 150, 330, 20);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(230, 210, 330, 20);
        jPanel2.add(jLabel26);
        jLabel26.setBounds(230, 170, 330, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 465, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed

        try {
            Connect();

            String user= txtuser.getText();
            char[] pswone= pass_field.getPassword();
            char[] pswtwo= pass_field2.getPassword();
            char[] rep=reponse.getPassword() ;
            if (txtuser11.getText().length()!=0&&txtuser.getText().length()!=0&&new String(pass_field.getPassword()).length()!=0&&new String(pass_field2.getPassword()).length()!=0&&new String(reponse.getPassword()).length()!=0){

                String sql = "SELECT username FROM login WHERE username ='"+txtuser.getText()+"' ";
                pst = conn.prepareStatement(sql);
                Rs= pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getString("username").equals(txtuser.getText())){
                        JOptionPane.showMessageDialog(null,  "le nom d'utilisateur est déja utiliser","Information",JOptionPane.INFORMATION_MESSAGE);
                    }
                }/*else if(pswtwo == null ? pswone != null : !pswtwo.equals(pswone)){

                    JOptionPane.showMessageDialog(null, "Entrer un correct mots de passe!");
                    pass_field2.setText("");
                }*/else{
                    pst = conn.prepareStatement("INSERT INTO login(username, psw, type,Nom_complet,question_de_securité,reponse) VALUES (?,?,?,?,?,?)");
                    pst.setString(1, txtuser.getText().trim());
                    pst.setString(2, hash(pass_field));
                    pst.setString(3,  txttype.getSelectedItem().toString());
                    pst.setString(4, txtuser11.getText().trim());

                    pst.setString(5,  securiteq.getSelectedItem().toString());
                    pst.setString(6,  new String(reponse.getPassword()));
                    pst.executeUpdate();
                    conn.close();
                    JOptionPane.showMessageDialog(null,  "Vous avez créer un compte avec sucèss","Information",JOptionPane.INFORMATION_MESSAGE);

                    txtuser.setText("");
                    txtuser11.setText("");
                    pass_field.setText("");
                    pass_field2.setText("");
                    //txttype.setSelectedItem("");

                    //securiteq.setSelectedItem("");
                    reponse.setText("");

                }
            }else{
                JOptionPane.showMessageDialog(null, " Vous veuillez remplie tous les champs!","Information",JOptionPane.INFORMATION_MESSAGE);

            }
        }catch (Exception ex) {
            Logger.getLogger(inscrire.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "non enregistrer","Information",JOptionPane.INFORMATION_MESSAGE);

        }
        // Logger.getLogger(inscrire.class.getName()).log(Level.SEVERE, null, ex);
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            pass_field.setEchoChar((char)0);

        }
        else
        {
            pass_field.setEchoChar('*');

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected())
        {
            pass_field2.setEchoChar((char)0);

        }
        else
        {
            pass_field2.setEchoChar('*');

        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void pass_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_fieldKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^,;+&$=]{8,40}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(new String(pass_field.getPassword()));
        if(!match.matches()){
            jLabel8.setText("le mots de passe doit contenir au moins 8 caractères");
            jLabel8.setForeground(Color.RED);
            jLabel26.setText("\n des alphabets et des numéro");
            jLabel26.setForeground(Color.RED);
        }
        else{
            jLabel8.setText(null);
            jLabel26.setText(null);
        }
    }//GEN-LAST:event_pass_fieldKeyReleased

    private void pass_field2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_field2KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pass_field2KeyPressed

    private void txtuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^@,.;*+&$=^]{0,30}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtuser.getText());
        if(!match.matches()){
            jLabel1.setText("Entrer un correct nom d'utilisateur");
            jLabel1.setForeground(Color.RED);
        }
        else{
            jLabel1.setText(null);
        }
    }//GEN-LAST:event_txtuserKeyReleased

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttypeActionPerformed

    private void jCheckBox7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox7StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7StateChanged

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if(jCheckBox7.isSelected())
        {
            reponse.setEchoChar((char)0);

        }
        else
        {
            reponse.setEchoChar('*');

        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void txtuser11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuser11KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel3.setText(null);
        }else{
            jLabel3.setText("Entrer seleument des alphabets ");
            jLabel3.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtuser11KeyReleased

    private void jButtonRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegister1ActionPerformed

    private void jLabelRegister1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegister1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelRegister1MouseClicked

    private void jCheckBox4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox4StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4StateChanged

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox5StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5StateChanged

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void txttype1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttype1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttype1ActionPerformed

    private void securiteq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securiteq1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securiteq1ActionPerformed

    private void jCheckBox6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox6StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6StateChanged

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtuser.setText("");
        txtuser11.setText("");

        txtuser.setText("");
        pass_field.setText("");
        reponse.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void securiteqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securiteqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securiteqActionPerformed

    private void pass_field2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_field2KeyReleased
        // TODO add your handling code here:
        if (new String(pass_field2.getPassword()).equals(new String(pass_field.getPassword()))){
            jLabel13.setText("");
        }else{
            jLabel13.setText("Votre mots de passe est incorrecte");
            jLabel13.setForeground(Color.RED);
        }
    }//GEN-LAST:event_pass_field2KeyReleased

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
            java.util.logging.Logger.getLogger(inscrire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inscrire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inscrire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inscrire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inscrire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JButton jButtonRegister1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRegister1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField pass_field;
    private javax.swing.JPasswordField pass_field1;
    private javax.swing.JPasswordField pass_field2;
    private javax.swing.JPasswordField pass_field3;
    private javax.swing.JPasswordField reponse;
    private javax.swing.JPasswordField reponse1;
    private javax.swing.JComboBox<String> securiteq;
    private javax.swing.JComboBox<String> securiteq1;
    private javax.swing.JTextField txtmail1;
    private javax.swing.JComboBox<String> txttype;
    private javax.swing.JComboBox<String> txttype1;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtuser1;
    private javax.swing.JTextField txtuser11;
    private javax.swing.JTextField txtuser12;
    // End of variables declaration//GEN-END:variables
}
