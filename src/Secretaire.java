import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Image;
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
import java.awt.Toolkit;
public class Secretaire extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet Rs;
    PreparedStatement pst ;
    DefaultTableModel ma = new DefaultTableModel();
  
    public Secretaire() {
        initComponents();
       ma.addColumn("Numero_de_RDV");
        ma.addColumn("Nom");
        ma.addColumn("prenom");
        ma.addColumn("telephone");
        ma.addColumn("Date_RDV");
        ma.addColumn("Commentaire");
        
        try{
            Connect();
           stm = conn.createStatement();
           ResultSet Rs= stm.executeQuery("Select * from rdv");
           while(Rs.next()){
            ma.addRow(new Object[]{Rs.getInt("Numero_de_RDV"),Rs.getString("Nom"),Rs.getString("prenom"),
                       Rs.getInt("telephone"),Rs.getDate("Date_RDV")
                        ,Rs.getString("Commentaire")});
        }
        }catch(Exception e){
            System.err.println(e);
        }
        sec_tab.setModel(ma);
           image();
           setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\icons8-tête-avec-cerveau-64.png"));
           setTitle("MiroudMed");
    }
    public void image(){
       ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\catt.jpg").getImage().getScaledInstance(1344, 643, Image.SCALE_DEFAULT));
       jLabel11.setIcon(imageIcon);
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
  public void afficher_rdv(){
       try{
            
             Connect();
             ma.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from rdv ");
        while(Rs.next()){
          ma.addRow(new Object[]{Rs.getInt("Numero_de_RDV"),Rs.getString("Nom"),Rs.getString("prenom"),
                       Rs.getInt("telephone"),Rs.getDate("Date_RDV")
                        ,Rs.getString("Commentaire")});
        }
        }catch(Exception e){System.err.println(e);}
        sec_tab.setModel(ma);
   }
   public void deplace(int i) {
         try{
            Connect(); 
            String table_click = (sec_tab.getModel().getValueAt(i, 0).toString());
            String sql = "select * from rdv where Numero_de_RDV ='"+table_click+"' ";
            stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              
             int selectioner =sec_tab.getSelectedRow();
             DefaultTableModel model = (DefaultTableModel) sec_tab.getModel();
             num_rdv.setText(model.getValueAt(selectioner, 0).toString());
             txtprenom1.setText(model.getValueAt(selectioner, 1).toString());
             txtprenom3.setText(model.getValueAt(selectioner, 2).toString());
             txtprenom2.setText(model.getValueAt(selectioner, 3).toString());
             if(Rs.next()){
              Date add4= Rs.getDate("Date_RDV");
              txtdaterdv1.setDate(add4);
             }
             txtcom1.setText(model.getValueAt(selectioner, 5).toString());
        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sec_tab = new javax.swing.JTable();
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
        jPanel22 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        rdv = new javax.swing.JTextField();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1210, 2225));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1217, 2776));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(946, 541));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1306, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Acceuil", new javax.swing.ImageIcon(getClass().getResource("/img/icons8-top-menu-80.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sec_tab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 153, 255))); // NOI18N
        sec_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        sec_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sec_tabMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(sec_tab);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 750, 127));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel34.setText("Date RDV");
        jPanel19.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        txtdaterdv1.setBackground(new java.awt.Color(255, 255, 255));
        txtdaterdv1.setDateFormatString("yyyy-MM-dd ");
        txtdaterdv1.setMinSelectableDate(new java.util.Date(-62135769481000L));
        jPanel19.add(txtdaterdv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 180, 29));

        txtcom1.setColumns(20);
        txtcom1.setRows(5);
        jScrollPane9.setViewportView(txtcom1);

        jPanel19.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 180, 120));

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
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 20));

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setText("Téléphone");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 184, -1, 20));

        jLabel36.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel36.setText("Commentaire");
        jPanel19.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        jPanel19.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 180, 20));
        jPanel19.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, 30));

        txtprenom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom2KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 180, 28));

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel23.setText("                      Nom  ");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, -1));
        jPanel19.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 20));

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel24.setText(" Prenom ");
        jPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        txtprenom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom3KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 180, 28));

        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 390, 430));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel22.setLayout(null);

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
        jPanel22.add(jButton21);
        jButton21.setBounds(10, 20, 136, 35);

        jButton26.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen.png"))); // NOI18N
        jButton26.setText("Modifier");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton26);
        jButton26.setBounds(320, 20, 136, 35);

        jButton27.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        jButton27.setText("Annuler");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton27);
        jButton27.setBounds(160, 20, 136, 35);

        jPanel2.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 470, 76));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_xmag_8826.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 40, 32));

        jButton8.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton8.setText("Actualiser");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 136, 35));

        rdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdvActionPerformed(evt);
            }
        });
        rdv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdvKeyPressed(evt);
            }
        });
        jPanel6.add(rdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 32));

        buttonGroup1.add(jRadioButton11);
        jRadioButton11.setText("Nom");
        jRadioButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton11MouseClicked(evt);
            }
        });
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));

        buttonGroup1.add(jRadioButton12);
        jRadioButton12.setText("Date de naissance");
        jRadioButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton12MouseClicked(evt);
            }
        });
        jPanel6.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        buttonGroup1.add(jRadioButton13);
        jRadioButton13.setText("Numéro de téléphone");
        jRadioButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton13MouseClicked(evt);
            }
        });
        jPanel6.add(jRadioButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 150, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Date de rendez-vous");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 150, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 520, 90));

        jTabbedPane1.addTab("Gestion de Rendez-vous", new javax.swing.ImageIcon(getClass().getResource("/img/icons8-clock-30.png")), jPanel2); // NOI18N

        jMenu1.setText("Général");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jMenuItem1.setText("Nouveau  RDV");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico.png"))); // NOI18N
        jMenuItem5.setText("Changer le mots passe");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-log-out-32.png"))); // NOI18N
        jMenuItem4.setText("Déconnecter");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1327, 685));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
      
        ajouterRdv r= new ajouterRdv();
        r.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        login meconnecter = new login();
        meconnecter.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        try{  Connect();
            int i=0;
            String in = (sec_tab.getModel().getValueAt(i, 0).toString());
   if(sec_tab.getSelectedRowCount()==1){
            if(JOptionPane.showConfirmDialog(null,"voulez vous annuler réellement ce rendez-vous "
                ,"Annuler un Rendez-vous",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
              stm.executeUpdate("Delete From rdv where Numero_de_RDV='"+num_rdv.getText()+"'");
            afficher_rdv();
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtprenom2.setText("");
            txtprenom3.setText("");
            txtdaterdv1.setDate(null);
            txtcom1.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le rendez-vous à annuler");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de supprimer\n"+e.getMessage());
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        try{

            Connect();
            if(sec_tab.getSelectedRowCount()==1){  
             if(JOptionPane.showConfirmDialog(null,"êtes-vous sûr de modifier ce Rendez-vous "
                ,"Modifier un Rendez-vous",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                
            pst = conn.prepareStatement("UPDATE rdv SET Nom= ?,prenom=?,telephone=?,Date_RDV=?,Commentaire=? WHERE Numero_de_RDV=?");
            pst.setString(1,txtprenom1.getText());
            pst.setString(2,txtprenom3.getText());
            pst.setString(3,txtprenom2.getText());
            pst.setString(4, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
            pst.setString(5,txtcom1.getText());
            pst.setString(6,num_rdv.getText());
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,  "Le rendez-vous est bien modifier");
            afficher_rdv();
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtdaterdv1.setDate(null);
            txtcom1.setText("");}else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le rendez-vous à modifier");
        }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erreur \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        try{

            Connect();
            String id= txtprenom2.getText();//tlf
            String nom= txtprenom1.getText();
            String prenom= txtprenom3.getText();
            String  d= ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();

            String com = txtcom1.getText();
            if(id.length()!=0&& nom.length()!=0&& prenom.length()!=0&& com.length()!=0 ){
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
                    afficher_rdv();
                    num_rdv.setText("Auto Générer");
                    txtprenom2.setText("");
                    txtprenom1.setText("");
                    txtdaterdv1.setDate(null);

                    txtcom1.setText("");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Veuillez vous remplir votr champs ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

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

    private void txtprenom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom1KeyReleased
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel13.setText(null);
        }else{
            jLabel13.setText("Entrer seleument des alphabets ");
            jLabel13.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtprenom1KeyReleased

    private void sec_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sec_tabMouseClicked
        // TODO add your handling code here:
        try{
            int i=sec_tab.getSelectedRow();
            deplace(i);

        }catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_sec_tabMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try{
            ma.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("SELECT * FROM rdv WHERE Nom='"+rdv.getText()+"'or Date_RDV='"+rdv.getText()+ "' or telephone='"+rdv.getText()+"'");
            }while(Rs.next()){
                Object[] rdv ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                    ,Rs.getTime(6),Rs.getTime(7),Rs.getString(8)};
                ma.addRow(rdv);
            }if(ma.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun rendez-vous ");

            }
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtprenom2.setText("");
            txtprenom3.setText("");
            txtdaterdv1.setDate(null);
             txtcom1.setText("");

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        afficher_rdv();
        num_rdv.setText("Auto Générer");
        //id_pat_rdv.setText("");
        txtprenom1.setText("");
        txtprenom2.setText("");
        txtprenom3.setText("");
        txtdaterdv1.setDate(null);
        txtcom1.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void rdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdvActionPerformed

    private void rdvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdvKeyPressed
        // TODO add your handling code here:
        /* if(evt.getKeyCode()==KeyEvent.VK_ENTER)//tu click sur entrer et il va commencer
        {
            try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE Nom='"+rdv.getText()+"'or Date_RDV='"+rdv.getText()+ "' or telephone='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                        ,Rs.getTime(6),Rs.getTime(7),Rs.getString(8)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }*/
    }//GEN-LAST:event_rdvKeyPressed

    private void jRadioButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton11MouseClicked
        // TODO add your handling code here:
        if(rdv.getText().length()!=0){
            try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE Nom='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                        ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton11MouseClicked

    private void jRadioButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton12MouseClicked
        // TODO add your handling code here:
        if(rdv.getText().length()!=0){
            try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  Date_RDV='"+rdv.getText()+ "'");
                }while(Rs.next()){
                   Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                        ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton12MouseClicked

    private void jRadioButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton13MouseClicked
        // TODO add your handling code here:
        if(rdv.getText().length()!=0){
            try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  telephone='"+rdv.getText()+"'");
                }while(Rs.next()){
                   Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                        ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton13MouseClicked

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        ChangePassword f= new  ChangePassword();
        f.setVisible(true);
        f.pack();
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
         if(rdv.getText().length()!=0){
        try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  Date_RDV='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                                      ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
             JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
        }
    }//GEN-LAST:event_jRadioButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Secretaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField num_rdv;
    private javax.swing.JTextField rdv;
    private javax.swing.JTable sec_tab;
    private javax.swing.JTextArea txtcom1;
    private com.toedter.calendar.JDateChooser txtdaterdv1;
    private javax.swing.JTextField txtprenom1;
    private javax.swing.JTextField txtprenom2;
    private javax.swing.JTextField txtprenom3;
    // End of variables declaration//GEN-END:variables
}
