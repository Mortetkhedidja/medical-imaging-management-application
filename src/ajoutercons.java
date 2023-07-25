import com.sun.glass.events.KeyEvent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
public class ajoutercons extends javax.swing.JFrame {
Connection conn;
 Statement stm;
 ResultSet Rs;
 PreparedStatement pst ;
 PreparedStatement pt ;
 DefaultTableModel m = new DefaultTableModel();
 DefaultTableModel mode = new DefaultTableModel();
 DefaultTableModel pict = new DefaultTableModel();
  String name, prenom,date,telephone;
   public ajoutercons() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\plus.png"));
       recuper();
       dci();
    afficher_dci();
    pict.addColumn("images");
    //pic_tab.setModel(pict);
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

public ajoutercons(String val1, String val2, String val3,String val4){
    initComponents();
    this.name= val1;
    this.prenom= val2;
    this.date= val3;
    this.telephone= val4;
    
    
    initComponents();
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\cabinet02\\src\\img\\plus.png"));
       recuper();
       dci();
       add();
    afficher_dci();
     pict.addColumn("images");
    //pic_tab.setModel(pict);
}
void add(){
    txtid_pat1.setText(name);
    txtmotif1.setText(prenom);
    txtmotif.setText(date);
    nomprenom1.setText(name);
    nomprenom.setText(prenom);
    txtnumcons.setText(telephone);
}
public void dci(){
        mode.addColumn("DENOMINATION");
        mode.addColumn("FORME");
        mode.addColumn("DOSAGE");
          try{
            Connect();
             stm = conn.createStatement();
         ResultSet Rs= stm.executeQuery("Select * from dci");
        while(Rs.next()){
              mode.addRow(new Object[]{Rs.getString("DENOMINATION"),Rs.getString("FORME"),Rs.getString("DOSAGE")});
            }
        }catch(Exception e){System.err.println(e);}
        table.setModel(mode); 
    }
public void afficher_dci(){
       try{
            Connect();
             mode.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from dci ");
            while(Rs.next()){
                mode.addRow(new Object[]{Rs.getString("DENOMINATION"),Rs.getString("FORME"),Rs.getString("DOSAGE")});
            
            }
       }catch(Exception e){
           System.err.println(e);
       }
       table.setModel(mode);
    }

  public void deplace_dci(int i){
      try{ Connect();
             int selectioner =table.getSelectedRow();
             DefaultTableModel mode = (DefaultTableModel) table.getModel();
             ord.append(mode.getValueAt(selectioner, 0).toString()+" ");
             ord.append(mode.getValueAt(selectioner, 1).toString()+" ");
             ord.append(mode.getValueAt(selectioner, 2).toString()+"\n");
        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
    }
public void afficher_image(int i) throws SQLException{
    /*int selectioner =pic_tab.getSelectedRow();
    //DefaultTableModel pict = (DefaultTableModel) pic_tab.getModel();
       TableModel pict = pic_tab.getModel();
       String imageName= pict.getValueAt(selectioner, 0).toString();
       ImageIcon icon = new ImageIcon(imageName);
       java.awt.Image ff = icon.getImage().getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(),java.awt.Image.SCALE_SMOOTH );
         jLabel12.setIcon(new ImageIcon(ff));
            //jLabel12.setIcon((Icon) pict.getValueAt(selectioner, 0));
           /* if(Rs.next()){
            String imagedata = Rs.getString("images");
                format = new ImageIcon(imagedata);
                java.awt.Image in= format.getImage();
                java.awt.Image ff = in.getScaledInstance(image.getWidth(), image.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg = new ImageIcon(ff);
                jLabel12.setIcon(format);
            }*/
}

private void jSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                      
   /* 
   int value = jSlider.getValue();

    if(value==55) {
        ImageIcon myImage = (ImageIcon) image.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(image.getWidth()+10, image.getHeight()+10,Image.SCALE_SMOOTH);
        image.setIcon( new ImageIcon(newImg) );
    }*/
}
 public void recuper(){
   /* doctor dc = new doctor();
    dc.deplace();
    try{
        String rec= dc.gettableresult();
         String sql = "select nom, prenom,date_naiss from medecin2 where id='"+rec+"' ";
             pst = conn.prepareStatement(sql);
             Rs = stm.executeQuery(sql);
              if(Rs.next()){
                  String ad1= Rs.getString("nom");
                  txtid_pat1.setText(ad1);
                   String ad2= Rs.getString("prenom");
                  txtmotif.setText(ad2);
                   Date ad4= Rs.getDate("date_naiss");
                  txtdate_cons1.setDate(ad4);
                  
              }
    }catch(Exception e ){
        System.out.println("heyyyyy"+e);
    }*/
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consultation = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        cons = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtmotif = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtdate_cons = new com.toedter.calendar.JDateChooser();
        txtnumcons = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtid_pat1 = new javax.swing.JTextField();
        txtmotif1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtarea1 = new javax.swing.JTextArea();
        txtimage3 = new javax.swing.JTextField();
        txtimage1 = new javax.swing.JTextField();
        txtimage4 = new javax.swing.JTextField();
        txtimage5 = new javax.swing.JTextField();
        txtimage6 = new javax.swing.JTextField();
        txtimage7 = new javax.swing.JTextField();
        txtimage8 = new javax.swing.JTextField();
        txtimage9 = new javax.swing.JTextField();
        txtimage10 = new javax.swing.JTextField();
        txtimage11 = new javax.swing.JTextField();
        txtimage12 = new javax.swing.JTextField();
        txtimage13 = new javax.swing.JTextField();
        txtimage14 = new javax.swing.JTextField();
        txtimage15 = new javax.swing.JTextField();
        txtimage16 = new javax.swing.JTextField();
        txtimage2 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        pic = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l10 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        l12 = new javax.swing.JLabel();
        l13 = new javax.swing.JLabel();
        l14 = new javax.swing.JLabel();
        l15 = new javax.swing.JLabel();
        l16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel12 = new javax.swing.JLabel();
        v_ord = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pSearchField = new javax.swing.JTextField();
        rechercheMedicaments = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ord = new javax.swing.JTextArea();
        nomprenom = new javax.swing.JTextField();
        nomprenom1 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nouveaux Consultation");

        consultation.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        jButton3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton3.setText(" Consultation ");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(900, 900));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton13.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton13.setText("L'image Médicale");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMaximumSize(new java.awt.Dimension(900, 900));
        jButton13.setPreferredSize(new java.awt.Dimension(255, 35));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton13);

        jButton2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton2.setText("Ordonnance");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jPanel12.setLayout(new java.awt.CardLayout());

        cons.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 204, 255))); // NOI18N
        jPanel13.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel26.setText("                         Date");
        jPanel13.add(jLabel26);
        jLabel26.setBounds(20, 230, 110, 14);

        txtmotif.setEditable(false);
        jPanel13.add(txtmotif);
        txtmotif.setBounds(150, 120, 240, 26);

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel19.setText(" Telephone");
        jPanel13.add(jLabel19);
        jLabel19.setBounds(50, 170, 80, 26);

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel27.setText("Prénom");
        jPanel13.add(jLabel27);
        jLabel27.setBounds(70, 80, 51, 14);

        txtdate_cons.setBackground(new java.awt.Color(255, 255, 255));
        txtdate_cons.setDateFormatString("yyyy-MM-dd");
        jPanel13.add(txtdate_cons);
        txtdate_cons.setBounds(150, 220, 240, 27);

        txtnumcons.setEditable(false);
        jPanel13.add(txtnumcons);
        txtnumcons.setBounds(150, 170, 240, 26);

        jLabel30.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel30.setText("Nom");
        jPanel13.add(jLabel30);
        jLabel30.setBounds(90, 30, 30, 26);

        jButton1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1);
        jButton1.setBounds(1140, 510, 136, 35);
        jPanel13.add(jLabel6);
        jLabel6.setBounds(150, 120, 190, 20);

        jLabel28.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel28.setText("Date de naissance");
        jPanel13.add(jLabel28);
        jLabel28.setBounds(10, 130, 120, 14);

        txtid_pat1.setEditable(false);
        txtid_pat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtid_pat1KeyReleased(evt);
            }
        });
        jPanel13.add(txtid_pat1);
        txtid_pat1.setBounds(150, 30, 240, 26);

        txtmotif1.setEditable(false);
        jPanel13.add(txtmotif1);
        txtmotif1.setBounds(150, 70, 240, 26);

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(51, 204, 255))); // NOI18N

        txtarea1.setColumns(20);
        txtarea1.setRows(5);
        jScrollPane6.setViewportView(txtarea1);

        jPanel13.add(jScrollPane6);
        jScrollPane6.setBounds(10, 270, 400, 240);

        txtimage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtimage3MouseClicked(evt);
            }
        });
        txtimage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage3ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage3);
        txtimage3.setBounds(600, 110, 210, 30);

        txtimage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtimage1MouseClicked(evt);
            }
        });
        txtimage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage1ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage1);
        txtimage1.setBounds(600, 30, 210, 30);

        txtimage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtimage4MouseClicked(evt);
            }
        });
        txtimage4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage4ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage4);
        txtimage4.setBounds(600, 150, 210, 30);

        txtimage5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage5ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage5);
        txtimage5.setBounds(600, 190, 210, 30);

        txtimage6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage6ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage6);
        txtimage6.setBounds(600, 230, 210, 30);

        txtimage7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage7ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage7);
        txtimage7.setBounds(600, 270, 210, 30);

        txtimage8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage8ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage8);
        txtimage8.setBounds(600, 320, 210, 30);

        txtimage9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage9ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage9);
        txtimage9.setBounds(960, 30, 210, 30);

        txtimage10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage10ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage10);
        txtimage10.setBounds(960, 70, 210, 30);

        txtimage11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage11ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage11);
        txtimage11.setBounds(960, 110, 210, 30);

        txtimage12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage12ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage12);
        txtimage12.setBounds(960, 150, 210, 30);

        txtimage13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage13ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage13);
        txtimage13.setBounds(960, 190, 210, 30);

        txtimage14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage14ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage14);
        txtimage14.setBounds(960, 230, 210, 30);

        txtimage15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage15ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage15);
        txtimage15.setBounds(960, 270, 210, 30);

        txtimage16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage16ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage16);
        txtimage16.setBounds(960, 320, 210, 30);

        txtimage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtimage2MouseClicked(evt);
            }
        });
        txtimage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimage2ActionPerformed(evt);
            }
        });
        jPanel13.add(txtimage2);
        txtimage2.setBounds(600, 70, 210, 30);

        jButton15.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton15.setText("inser image ");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton15);
        jButton15.setBounds(470, 150, 120, 30);

        jButton16.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton16.setText("inser image ");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton16);
        jButton16.setBounds(470, 30, 120, 30);

        jButton17.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton17.setText("inser image ");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton17);
        jButton17.setBounds(470, 70, 120, 30);

        jButton18.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton18.setText("inser image ");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton18);
        jButton18.setBounds(470, 190, 120, 30);

        jButton19.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton19.setText("inser image ");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton19);
        jButton19.setBounds(470, 230, 120, 30);

        jButton20.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton20.setText("inser image ");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton20);
        jButton20.setBounds(830, 230, 120, 30);

        jButton21.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton21.setText("inser image ");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton21);
        jButton21.setBounds(470, 110, 120, 30);

        jButton22.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton22.setText("inser image ");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton22);
        jButton22.setBounds(470, 270, 120, 30);

        jButton23.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton23.setText("inser image ");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton23);
        jButton23.setBounds(470, 320, 120, 30);

        jButton24.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton24.setText("inser image ");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton24);
        jButton24.setBounds(830, 30, 120, 30);

        jButton25.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton25.setText("inser image ");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton25);
        jButton25.setBounds(830, 70, 120, 30);

        jButton26.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton26.setText("inser image ");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton26);
        jButton26.setBounds(830, 190, 120, 30);

        jButton27.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton27.setText("inser image ");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton27);
        jButton27.setBounds(830, 110, 120, 30);

        jButton28.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton28.setText("inser image ");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton28);
        jButton28.setBounds(830, 320, 120, 30);

        jButton29.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton29.setText("inser image ");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton29);
        jButton29.setBounds(830, 150, 120, 30);

        jButton30.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton30.setText("inser image ");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton30);
        jButton30.setBounds(830, 270, 120, 30);

        javax.swing.GroupLayout consLayout = new javax.swing.GroupLayout(cons);
        cons.setLayout(consLayout);
        consLayout.setHorizontalGroup(
            consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1363, Short.MAX_VALUE))
        );
        consLayout.setVerticalGroup(
            consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 365, Short.MAX_VALUE))
        );

        jPanel12.add(cons, "card2");

        pic.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrption textuelle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(51, 204, 255))); // NOI18N

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane7.setViewportView(txtarea);

        jPanel4.add(jScrollPane7);
        jScrollPane7.setBounds(910, 0, 420, 500);

        jPanel1.setLayout(null);

        l7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l7MouseClicked(evt);
            }
        });
        jPanel1.add(l7);
        l7.setBounds(0, 0, 100, 100);

        l8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l8MouseClicked(evt);
            }
        });
        jPanel1.add(l8);
        l8.setBounds(100, 0, 100, 100);

        l9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l9MouseClicked(evt);
            }
        });
        jPanel1.add(l9);
        l9.setBounds(200, 0, 100, 100);

        l10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l10MouseClicked(evt);
            }
        });
        jPanel1.add(l10);
        l10.setBounds(300, 0, 100, 100);

        l11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l11MouseClicked(evt);
            }
        });
        jPanel1.add(l11);
        l11.setBounds(400, 0, 100, 100);

        l12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l12MouseClicked(evt);
            }
        });
        jPanel1.add(l12);
        l12.setBounds(500, 0, 100, 100);

        l13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l13MouseClicked(evt);
            }
        });
        jPanel1.add(l13);
        l13.setBounds(600, 0, 100, 100);

        l14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l14MouseClicked(evt);
            }
        });
        jPanel1.add(l14);
        l14.setBounds(700, 0, 100, 100);

        l15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l15MouseClicked(evt);
            }
        });
        jPanel1.add(l15);
        l15.setBounds(800, 0, 100, 100);

        l16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l16MouseClicked(evt);
            }
        });
        jPanel1.add(l16);
        l16.setBounds(900, 0, 100, 100);

        jPanel4.add(jPanel1);
        jPanel1.setBounds(100, 500, 1000, 100);

        jPanel2.setLayout(null);

        l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        jPanel2.add(l1);
        l1.setBounds(0, 0, 100, 100);

        l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l2MouseClicked(evt);
            }
        });
        jPanel2.add(l2);
        l2.setBounds(0, 100, 100, 100);

        l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l3MouseClicked(evt);
            }
        });
        jPanel2.add(l3);
        l3.setBounds(0, 200, 100, 100);

        l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4MouseClicked(evt);
            }
        });
        jPanel2.add(l4);
        l4.setBounds(0, 300, 100, 100);

        l5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l5MouseClicked(evt);
            }
        });
        jPanel2.add(l5);
        l5.setBounds(0, 400, 100, 100);

        l6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l6MouseClicked(evt);
            }
        });
        jPanel2.add(l6);
        l6.setBounds(0, 500, 100, 100);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(0, 0, 100, 600);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6);
        jPanel6.setBounds(1240, 840, 50, 150);

        jLabel12.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel12MouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel4.add(jDesktopPane1);
        jDesktopPane1.setBounds(100, 0, 800, 500);

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.add(pic, "card4");

        v_ord.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medicaments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DENOMINATION", "FORME", "DOSAGE"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 620, 110));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel23.setLayout(null);

        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel23.add(jLabel14);
        jLabel14.setBounds(195, 22, 0, 26);

        pSearchField.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        pSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSearchFieldActionPerformed(evt);
            }
        });
        pSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pSearchFieldKeyPressed(evt);
            }
        });
        jPanel23.add(pSearchField);
        pSearchField.setBounds(10, 10, 292, 30);

        rechercheMedicaments.setBackground(new java.awt.Color(255, 255, 255));
        rechercheMedicaments.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rechercheMedicaments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_xmag_8826.png"))); // NOI18N
        rechercheMedicaments.setBorder(null);
        rechercheMedicaments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rechercheMedicaments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechercheMedicamentsMouseClicked(evt);
            }
        });
        rechercheMedicaments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheMedicamentsActionPerformed(evt);
            }
        });
        rechercheMedicaments.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rechercheMedicamentsKeyPressed(evt);
            }
        });
        jPanel23.add(rechercheMedicaments);
        rechercheMedicaments.setBounds(310, 10, 40, 30);

        jPanel5.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 360, 50));

        jToggleButton1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jToggleButton1.setText("Actualiser");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(136, 35));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 136, 35));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Ordonnance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Georgia", 2, 25)); // NOI18N
        jLabel31.setText("Cabinet Médical - Neurochirurgie .");
        panel.add(jLabel31);
        jLabel31.setBounds(83, 5, 395, 39);

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel3.setText("  Dr.Miroud M.N");
        panel.add(jLabel3);
        jLabel3.setBounds(10, 76, 134, 17);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panel.add(jSeparator2);
        jSeparator2.setBounds(10, 50, 505, 15);

        jLabel8.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel8.setText("Neurochirurgien.");
        panel.add(jLabel8);
        jLabel8.setBounds(20, 99, 109, 15);

        jLabel9.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel9.setText("Consultation sur RDV");
        panel.add(jLabel9);
        jLabel9.setBounds(10, 132, 147, 17);

        jLabel10.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel10.setText("MOB : 0667-970-412");
        panel.add(jLabel10);
        jLabel10.setBounds(20, 155, 131, 15);

        jLabel11.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel11.setText(" Cité 05 juillet, Bt A 8 N11 Mostaganem");
        panel.add(jLabel11);
        jLabel11.setBounds(197, 533, 256, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Mostaganem, Le");
        panel.add(jLabel13);
        jLabel13.setBounds(200, 180, 95, 16);

        Date.setBorder(null);
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });
        panel.add(Date);
        Date.setBounds(300, 170, 153, 40);

        age.setText("Age");
        age.setBorder(null);
        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageMouseClicked(evt);
            }
        });
        panel.add(age);
        age.setBounds(457, 220, 30, 14);

        jLabel1.setText("ans");
        panel.add(jLabel1);
        jLabel1.setBounds(490, 220, 40, 14);

        ord.setColumns(20);
        ord.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        ord.setRows(5);
        ord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ord.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(ord);

        panel.add(jScrollPane2);
        jScrollPane2.setBounds(0, 267, 570, 246);

        nomprenom.setBorder(null);
        nomprenom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomprenomMouseClicked(evt);
            }
        });
        nomprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomprenomActionPerformed(evt);
            }
        });
        panel.add(nomprenom);
        nomprenom.setBounds(320, 210, 90, 30);

        nomprenom1.setBorder(null);
        nomprenom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomprenom1MouseClicked(evt);
            }
        });
        nomprenom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomprenom1ActionPerformed(evt);
            }
        });
        panel.add(nomprenom1);
        nomprenom1.setBounds(230, 210, 90, 30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-print-30.png"))); // NOI18N
        jButton6.setText("Imprimer");
        jButton6.setMaximumSize(new java.awt.Dimension(136, 35));
        jButton6.setPreferredSize(new java.awt.Dimension(136, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 35));

        javax.swing.GroupLayout v_ordLayout = new javax.swing.GroupLayout(v_ord);
        v_ord.setLayout(v_ordLayout);
        v_ordLayout.setHorizontalGroup(
            v_ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(v_ordLayout.createSequentialGroup()
                .addGroup(v_ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(v_ordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(v_ordLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        v_ordLayout.setVerticalGroup(
            v_ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(v_ordLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(826, Short.MAX_VALUE))
            .addGroup(v_ordLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.add(v_ord, "card4");

        javax.swing.GroupLayout consultationLayout = new javax.swing.GroupLayout(consultation);
        consultation.setLayout(consultationLayout);
        consultationLayout.setHorizontalGroup(
            consultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        consultationLayout.setVerticalGroup(
            consultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1072, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1332, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(consultation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(consultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1348, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel12.removeAll();
        jPanel12.repaint();
        jPanel12.revalidate();
        jPanel12.add(cons);
        jPanel12.repaint();
        jPanel12.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         jPanel12.removeAll();
        jPanel12.repaint();
        jPanel12.revalidate();
        jPanel12.add(pic);
        jPanel12.repaint();
        jPanel12.revalidate();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{

            Connect();
            String id = txtid_pat1.getText();
            String motif = txtmotif.getText();
            String area= txtarea1.getText();
            String date = ((JTextField)txtdate_cons.getDateEditor().getUiComponent()).getText();
            String image1= txtimage1.getText();
            image1=image1.replace("\\","\\\\") ;
            String image2= txtimage2.getText();
            image2=image2.replace("\\","\\\\") ;
            String image3= txtimage3.getText();
            image3=image3.replace("\\", "\\\\") ;
            String image4= txtimage4.getText();
            image4=image4.replace("\\", "\\\\") ;
            String image5= txtimage5.getText();
            image5=image5.replace("\\", "\\\\") ;
            String image6= txtimage6.getText();
            image6=image6.replace("\\", "\\\\") ;
            String image7= txtimage7.getText();
            image7=image7.replace("\\", "\\\\") ;
            String image8= txtimage8.getText();
            image8=image8.replace("\\","\\\\") ;
            String image9= txtimage9.getText();
            image9=image9.replace("\\","\\\\") ;
            String image10= txtimage10.getText();
            image10=image10.replace("\\","\\\\") ;
            String image11= txtimage11.getText();
            image11=image11.replace("\\","\\\\") ;
            String image12= txtimage12.getText();
            image12=image12.replace("\\","\\\\") ;
            String image13= txtimage13.getText();
            image13=image13.replace("\\", "\\\\") ;
            String image14= txtimage14.getText();
            image14=image14.replace("\\",  "\\\\") ;
            String image15= txtimage15.getText();
            image15=image15.replace("\\", "\\\\") ;
            String image16= txtimage16.getText();
            image16=image16.replace("\\", "\\\\") ;
            
            if(id.length()!=0 &&motif.length()!=0 &&area.length()!=0 &&date.length()!=0 && age.getText().length()!=0){
                pst = conn.prepareStatement("INSERT INTO consultation (nom,prenom,date_naissance,age,date,consultation,description,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15,image16,ordonnance) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                // pst.setString(1,txtnumcons.getText());
                pst.setString(1,txtid_pat1.getText());
                pst.setString(2,txtmotif1.getText());
                pst.setString(3, txtmotif.getText());
                pst.setString(4,age.getText());
                pst.setString(5, ((JTextField)txtdate_cons.getDateEditor().getUiComponent()).getText());
                pst.setString(6,txtarea1.getText());
                pst.setString(7,txtarea.getText());
                pst.setString(8,image1);
                pst.setString(9,image2);
                pst.setString(10,image3);
                pst.setString(11,image4);
                pst.setString(12,image5);
                pst.setString(13,image6);
                pst.setString(14,image7);
                pst.setString(15,image8);
                pst.setString(16,image9);
                pst.setString(17,image10);
                pst.setString(18,image11);
                pst.setString(19,image12);
                pst.setString(20,image13);
                pst.setString(21,image14);
                pst.setString(22,image15);
                pst.setString(23,image16);      
                pst.setString(24,ord.getText());
                pst.executeUpdate();
                conn.close();

                JOptionPane.showMessageDialog(null,  "Votre informaton sont bien ajouter");
                //afficher_cons();
                //txtnumcons.setText("Auto Générer");
                /*txtdate_cons.setDate(null);
                txtid_pat1.setText("");
                txtmotif.setText("");
                txtarea.setText("");*/
            }else{
               JOptionPane.showMessageDialog(null," Vous veuillez remplir tous les champs  ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct!! \n"+ e.getMessage());
            e.printStackTrace();
        }
        try{
            String id = txtid_pat1.getText();
            String motif = txtmotif.getText();
            String area= txtarea1.getText();
            String date = ((JTextField)txtdate_cons.getDateEditor().getUiComponent()).getText();
            if(id.length()!=0 &&motif.length()!=0 && area.length()!=0 &&date.length()!=0 && age.getText().length()!=0 ){
            Connect();
             pt = conn.prepareStatement("INSERT INTO ordonnance (nom,prenom,telephone,date_naissance,age,date,ordonnance) VALUES (?,?,?,?,?,?,?) ") ;
            pt.setString(1,txtid_pat1.getText());
            pt.setString(2,txtmotif1.getText());
            pt.setString(3, txtnumcons.getText());
            pt.setString(4, txtmotif.getText());
            pt.setString(5,age.getText());
            pt.setString(6, ((JTextField)txtdate_cons.getDateEditor().getUiComponent()).getText());
            pt.setString(7,ord.getText());
            pt.executeUpdate();
            conn.close();
            //JOptionPane.showMessageDialog(null,  "ordonnoance est bien ajouter");
            //afficher_ordonnance();
            
            ord.setText("");
            }else{
                //JOptionPane.showMessageDialog(null," Vous veuillez remplir tous les champs  ");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtid_pat1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_pat1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_pat1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         jPanel12.removeAll();
        jPanel12.repaint();
        jPanel12.revalidate();
        jPanel12.add(v_ord);
        jPanel12.repaint();
        jPanel12.revalidate();
       // Date2.setText(txtdate_cons.getDateFormatString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try{
            int i=table.getSelectedRow();
            deplace_dci(i);

        }catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void pSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pSearchFieldActionPerformed

    private void pSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pSearchFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)//tu click sur entrer et il va commencer
        {try{  mode.setRowCount(0);//pour vider la list des etudient
            { Rs = stm.executeQuery("Select * From dci WHERE DENOMINATION= '"+pSearchField.getText()+ "'");
            }while(Rs.next()){
                Object[] dci ={Rs.getString(3),Rs.getString(5),Rs.getString(6)};
                mode.addRow(dci);
            }if(mode.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun médicament ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}
    }//GEN-LAST:event_pSearchFieldKeyPressed

    private void rechercheMedicamentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechercheMedicamentsMouseClicked

    }//GEN-LAST:event_rechercheMedicamentsMouseClicked

    private void rechercheMedicamentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheMedicamentsActionPerformed
        try{
            mode.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From dci WHERE DENOMINATION= '"+pSearchField.getText()+ "'");
            }while(Rs.next()){
                Object[] dci ={Rs.getString(3),Rs.getString(5),Rs.getString(6)};
                mode.addRow(dci);
            }if(mode.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun médicament ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }//GEN-LAST:event_rechercheMedicamentsActionPerformed

    private void rechercheMedicamentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheMedicamentsKeyPressed

    }//GEN-LAST:event_rechercheMedicamentsKeyPressed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        afficher_dci();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DateActionPerformed

    private void ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseClicked
        // TODO add your handling code here:
        age.setText("");
    }//GEN-LAST:event_ageMouseClicked

    private void nomprenomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomprenomMouseClicked
        nomprenom.setText("");
    }//GEN-LAST:event_nomprenomMouseClicked

    private void nomprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomprenomActionPerformed

    private void nomprenom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomprenom1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nomprenom1MouseClicked

    private void nomprenom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomprenom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomprenom1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable (new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum){
                if (pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                panel.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false)
        return;

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtimage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage3ActionPerformed

    private void txtimage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage1ActionPerformed

    private void txtimage4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage4ActionPerformed

    private void txtimage5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage5ActionPerformed

    private void txtimage6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage6ActionPerformed

    private void txtimage7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage7ActionPerformed

    private void txtimage8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage8ActionPerformed

    private void txtimage9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage9ActionPerformed

    private void txtimage10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage10ActionPerformed

    private void txtimage11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage11ActionPerformed

    private void txtimage12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage12ActionPerformed

    private void txtimage13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage13ActionPerformed

    private void txtimage14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage14ActionPerformed

    private void txtimage15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage15ActionPerformed

    private void txtimage16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage16ActionPerformed

    private void txtimage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimage2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimage2ActionPerformed

    private void txtimage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtimage1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtimage1MouseClicked

    private void txtimage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtimage2MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtimage2MouseClicked

    private void txtimage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtimage3MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtimage3MouseClicked

    private void txtimage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtimage4MouseClicked
      
    }//GEN-LAST:event_txtimage4MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l4.getWidth(),l4.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l4.setIcon(finalimg);
                  txtimage4.setText(path);
                  save4= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l1.getWidth(),l1.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l1.setIcon(finalimg);
                  txtimage1.setText(path);
                  save1= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l2.getWidth(),l2.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l2.setIcon(finalimg);
                  txtimage2.setText(path);
                  save2= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l5.getWidth(),l5.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l5.setIcon(finalimg);
                  txtimage5.setText(path);
                  save5= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l6.getWidth(),l6.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l6.setIcon(finalimg);
                  txtimage6.setText(path);
                  save6= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l14.getWidth(),l14.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l14.setIcon(finalimg);
                  txtimage14.setText(path);
                  save14= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l3.getWidth(),l3.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l3.setIcon(finalimg);
                  txtimage3.setText(path);
                  save3= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l7.getWidth(),l7.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l7.setIcon(finalimg);
                  txtimage7.setText(path);
                  save7= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l8.getWidth(),l8.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l8.setIcon(finalimg);
                  txtimage8.setText(path);
                  save8= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l9.getWidth(),l9.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l9.setIcon(finalimg);
                  txtimage9.setText(path);
                  save9= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l10.getWidth(),l10.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l10.setIcon(finalimg);
                  txtimage10.setText(path);
                  save10= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l13.getWidth(),l13.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l13.setIcon(finalimg);
                  txtimage13.setText(path);
                  save13= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l11.getWidth(),l11.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l11.setIcon(finalimg);
                  txtimage11.setText(path);
                  save11= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l16.getWidth(),l16.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l16.setIcon(finalimg);
                  txtimage16.setText(path);
                  save16= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l12.getWidth(),l12.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l12.setIcon(finalimg);
                  txtimage12.setText(path);
                  save12= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        try{
             JFileChooser filechooser= new JFileChooser();
             filechooser.setCurrentDirectory(new File("C:\\Users\\Clinic PC\\Desktop"));
             FileNameExtensionFilter f = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              filechooser.addChoosableFileFilter(f);
              int result = filechooser.showSaveDialog(null) ;
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedfile = filechooser.getSelectedFile();
                  String path =selectedfile.getAbsolutePath();
                  ImageIcon myimage = new ImageIcon(path);
                  java.awt.Image img = myimage.getImage();
                  java.awt.Image newimage = img.getScaledInstance(l15.getWidth(),l15.getHeight(), java.awt.Image.SCALE_SMOOTH);
                  ImageIcon finalimg = new ImageIcon(newimage);
                  l15.setIcon(finalimg);
                  txtimage15.setText(path);
                  save15= path;
              }else{
                  if(result== JFileChooser.CANCEL_OPTION){
                      JOptionPane.showMessageDialog(null, "t'as rien choisi ");
                  }
              }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void l8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l8MouseClicked
        ImageIcon myimage = new ImageIcon(save8);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l8MouseClicked

    private void l9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l9MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save9);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l9MouseClicked

    private void l10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l10MouseClicked
        ImageIcon myimage = new ImageIcon(save10);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l10MouseClicked

    private void l11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l11MouseClicked
        ImageIcon myimage = new ImageIcon(save11);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l11MouseClicked

    private void l12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l12MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save12);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l12MouseClicked

    private void l13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l13MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save13);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l13MouseClicked

    private void l14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l14MouseClicked
        ImageIcon myimage = new ImageIcon(save14);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l14MouseClicked

    private void l7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save7);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l7MouseClicked

    private void l15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l15MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save15);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l15MouseClicked

    private void l16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l16MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save16);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l16MouseClicked

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save1);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l1MouseClicked

    private void l5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save5);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l5MouseClicked

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked
        ImageIcon myimage = new ImageIcon(save2);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l2MouseClicked

    private void l6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l6MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save6);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l6MouseClicked

    private void l4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(save4);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l4MouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
        ImageIcon myimage = new ImageIcon(save3);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l3MouseClicked

    private void jLabel12MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel12MouseWheelMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel12MouseWheelMoved

    /**tab
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
            java.util.logging.Logger.getLogger(ajoutercons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajoutercons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajoutercons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajoutercons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajoutercons().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JTextField age;
    private javax.swing.JPanel cons;
    private javax.swing.JPanel consultation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l13;
    private javax.swing.JLabel l14;
    private javax.swing.JLabel l15;
    private javax.swing.JLabel l16;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JTextField nomprenom;
    private javax.swing.JTextField nomprenom1;
    private javax.swing.JTextArea ord;
    private javax.swing.JTextField pSearchField;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pic;
    private javax.swing.JButton rechercheMedicaments;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextArea txtarea1;
    private com.toedter.calendar.JDateChooser txtdate_cons;
    private javax.swing.JTextField txtid_pat1;
    private javax.swing.JTextField txtimage1;
    private javax.swing.JTextField txtimage10;
    private javax.swing.JTextField txtimage11;
    private javax.swing.JTextField txtimage12;
    private javax.swing.JTextField txtimage13;
    private javax.swing.JTextField txtimage14;
    private javax.swing.JTextField txtimage15;
    private javax.swing.JTextField txtimage16;
    private javax.swing.JTextField txtimage2;
    private javax.swing.JTextField txtimage3;
    private javax.swing.JTextField txtimage4;
    private javax.swing.JTextField txtimage5;
    private javax.swing.JTextField txtimage6;
    private javax.swing.JTextField txtimage7;
    private javax.swing.JTextField txtimage8;
    private javax.swing.JTextField txtimage9;
    private javax.swing.JTextField txtmotif;
    private javax.swing.JTextField txtmotif1;
    private javax.swing.JTextField txtnumcons;
    private javax.swing.JPanel v_ord;
    // End of variables declaration//GEN-END:variables
private ImageIcon format=null;
 String filename=null;
 int s=0;
 byte[] pers_img =null;
 private String save1,save2,save3,save4,save5,save6,save7,save8,save9,save10,save11,save12,save13,save14,save15,save16;
 
 
 byte[] image5;
}
